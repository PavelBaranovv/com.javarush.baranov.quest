package com.javarush.baranov.quest;

import com.javarush.baranov.quest.gameLogic.GameService;
import com.javarush.baranov.quest.gameLogic.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameServiceTest {
    private GameService gameService;

    @BeforeEach
    public void setUp() {
        gameService = new GameService();
    }

    @Test
    public void shouldReturnCorrectStateAfterCorrectQuestion1() {
        GameState newState = gameService.handlePlayerChoice(GameState.QUESTION_1, "4");
        assertEquals(GameState.QUESTION_2, newState);
    }

    @Test
    public void shouldReturnLoseStateAfterIncorrectQuestion1() {
        GameState newState = gameService.handlePlayerChoice(GameState.QUESTION_2, "2");
        assertEquals(GameState.LOSE, newState);
    }

    @Test
    public void shouldReturnCorrectStateAfterCorrectQuestion2() {
        GameState newState = gameService.handlePlayerChoice(GameState.QUESTION_2, "Токио");
        assertEquals(GameState.BRIDGE, newState);
    }

    @Test
    public void shouldReturnLoseStateAfterIncorrectQuestion2() {
        GameState newState = gameService.handlePlayerChoice(GameState.QUESTION_2, "Париж");
        assertEquals(GameState.LOSE, newState);
    }

    @Test
    public void shouldReturnCorrectStateAfterBridgeAgreement() {
        GameState newState = gameService.handlePlayerChoice(GameState.BRIDGE, "Подняться на мостик");
        assertEquals(GameState.COME_ON_BRIDGE, newState);
    }

    @Test
    public void shouldReturnCorrectStateAfterBridgeRefuse() {
        GameState newState = gameService.handlePlayerChoice(GameState.BRIDGE, "Остаться в каюте");
        assertEquals(GameState.STAY_IN_ROOM, newState);
    }

    @Test
    public void shouldThrowWhenInvalidBridgeChoiceGot() {
        assertThrows(IllegalArgumentException.class, () ->
                gameService.handlePlayerChoice(GameState.BRIDGE, "фижма"));
    }

    @Test
    public void shouldReturnCorrectStateAfterCrewmateMeeting() {
        GameState newState = gameService.handlePlayerChoice(GameState.COME_ON_BRIDGE, "Кто ты?");
        assertEquals(GameState.CREWMATE_ASKING, newState);

        newState = gameService.handlePlayerChoice(GameState.STAY_IN_ROOM, "Кто ты?");
        assertEquals(GameState.CREWMATE_ASKING, newState);
    }

    @Test
    public void shouldReturnCorrectStateAfterCrewmateAskingAboutMission() {
        GameState newState = gameService.handlePlayerChoice(GameState.CREWMATE_ASKING, "Миссия?");
        assertEquals(GameState.MISSION, newState);
    }

    @Test
    public void shouldReturnCorrectStateAfterCrewmateAskingAboutSleeping() {
        GameState newState = gameService.handlePlayerChoice(GameState.CREWMATE_ASKING, "Проснешься?");
        assertEquals(GameState.SLEEPING, newState);
    }

    @Test
    public void shouldThrowWhenInvalidCrewmateAskingChoiceGot() {
        assertThrows(IllegalArgumentException.class, () ->
                gameService.handlePlayerChoice(GameState.BRIDGE, "Кто ты?"));
    }

    @Test
    public void shouldReturnCorrectStateAfterShipComingAgreement() {
        GameState newState = gameService.handlePlayerChoice(GameState.SLEEPING, "Проверить шлюз");
        assertEquals(GameState.ALIENS_MEETING, newState);
    }

    @Test
    public void shouldReturnLoseStateAfterShipComingRefuse() {
        GameState newState = gameService.handlePlayerChoice(GameState.SLEEPING, "Ничего не делать");
        assertEquals(GameState.LOSE, newState);
    }

    @Test
    public void shouldReturnCorrectStateAfterAlienMeetingAgreement() {
        GameState newState = gameService.handlePlayerChoice(GameState.ALIENS_MEETING, "Привет?");
        assertEquals(GameState.ALIENS_PARTY, newState);
    }

    @Test
    public void shouldReturnLoseStateAfterAlienMeetingRefuse() {
        GameState newState = gameService.handlePlayerChoice(GameState.ALIENS_MEETING, "Закрыть люк и улететь");
        assertEquals(GameState.LOSE, newState);
    }

    @Test
    public void shouldReturnVictoryAfterAlienMeetingRefuse() {
        GameState newState = gameService.handlePlayerChoice(GameState.ALIENS_PARTY, "Вернуться домой");
        assertEquals(GameState.VICTORY, newState);
    }

    @Test
    public void shouldReturnLoseStateAfterAlienStayAgreement() {
        GameState newState = gameService.handlePlayerChoice(GameState.ALIENS_PARTY, "Остаться с инопланетянами");
        assertEquals(GameState.LOSE, newState);
    }
}
