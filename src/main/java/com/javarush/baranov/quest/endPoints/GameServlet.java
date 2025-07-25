package com.javarush.baranov.quest.endPoints;

import com.javarush.baranov.quest.gameLogic.GameService;
import com.javarush.baranov.quest.gameLogic.GameState;
import com.javarush.baranov.quest.gameLogic.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "GameServlet", urlPatterns = {"/game"})
public class GameServlet extends HttpServlet {
    private final GameService gameService = new GameService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GameState gameState = (GameState) session.getAttribute("gameState");
        if (gameState == null) {
            session.setAttribute("gameState", GameState.QUESTION_1);
        }
        req.getRequestDispatcher("game.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GameState oldState = (GameState) session.getAttribute("gameState");
        Player player = (Player) session.getAttribute("player");
        if (oldState == null || player == null) {
            throw new IllegalArgumentException("Invalid session");
        }

        String choice = req.getParameter("choice");

        if (choice == null || choice.isEmpty()) {
            throw new IllegalArgumentException("Invalid choice request");
        }

        if (choice.equals("restart")) {
            session.removeAttribute("gameState");
            player.incrementGamesCount();
            resp.sendRedirect(req.getContextPath() + "/home");
            return;
        }

        GameState newState = gameService.handlePlayerChoice(oldState, choice);
        session.setAttribute("gameState", newState);

        if (newState == GameState.VICTORY) {
            req.getRequestDispatcher("result.jsp").forward(req, resp);
        } else if (newState == GameState.LOSE) {
            newState.setCustomLoseMessage(oldState);
            req.getRequestDispatcher("result.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("game.jsp").forward(req, resp);
        }
    }
}
