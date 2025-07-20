package com.javarush.baranov.quest.endPoints;

import com.javarush.baranov.quest.gameLogic.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = (Player) session.getAttribute("player");
        if (player == null) {
            session.setAttribute("player", new Player());
        }
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Player player = (Player) session.getAttribute("player");
        if (player.getName() == null) {
            String playerName = req.getParameter("playerName");
            if (playerName != null && !playerName.isBlank() && playerName.trim().length() <= 30) {
                player.setName(playerName.trim());
            } else {
                req.setAttribute("error", "Неверное имя пользователя, попробуйте еще раз");
                req.getRequestDispatcher("home.jsp").forward(req, resp);
            }
        }
        resp.sendRedirect(req.getContextPath() + "/game");
    }
}
