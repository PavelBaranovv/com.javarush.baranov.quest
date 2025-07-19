package com.javarush.baranov.quest.gameLogic;

public class GameService {
    public GameState handlePlayerChoice(GameState state, String choice) {
        return switch (state) {
            case QUESTION_1 -> handleQuestion1Answer(choice);
            case QUESTION_2 -> handleQuestion2Answer(choice);
            case BRIDGE -> handleBridgeComing(choice);
            case COME_ON_BRIDGE, STAY_IN_ROOM -> handleCrewmateMeeting();
            case CREWMATE_ASKING -> handleCrewmateAsking(choice);
            case MISSION, SLEEPING -> handleShipComing(choice);
            case ALIENS_MEETING -> handleAliensMeeting(choice);
            case ALIENS_PARTY -> handleAliensOffer(choice);
            default -> throw new IllegalStateException("Unexpected state: " + state.name());
        };
    }

    private GameState handleQuestion1Answer(String choice) {
        if (choice.equals("4")) {
            return GameState.QUESTION_2;
        } else {
            return GameState.LOSE;
        }
    }

    private GameState handleQuestion2Answer(String choice) {
        if (choice.equals("Токио")) {
            return GameState.BRIDGE;
        } else {
            return GameState.LOSE;
        }
    }

    private GameState handleBridgeComing(String choice) {
        if (choice.equals("Подняться на мостик")) {
            return GameState.COME_ON_BRIDGE;
        } else if (choice.equals("Остаться в каюте")) {
            return GameState.STAY_IN_ROOM;
        }
        throw new IllegalArgumentException("Invalid bridge choice: " + choice);
    }

    private GameState handleCrewmateMeeting() {
        return GameState.CREWMATE_ASKING;
    }

    private GameState handleCrewmateAsking(String choice) {
        if (choice.equals("Проснешься?")) {
            return GameState.SLEEPING;
        } else if (choice.equals("Миссии?")) {
            return GameState.MISSION;
        }
        throw new IllegalArgumentException("Invalid crewmate question: " + choice);

    }

    private GameState handleShipComing(String choice) {
        if (choice.equals("Проверить шлюз")) {
            return GameState.ALIENS_MEETING;
        } else {
            return GameState.LOSE;
        }
    }

    private GameState handleAliensMeeting(String choice) {
        if (choice.equals("Привет?")) {
            return GameState.ALIENS_PARTY;
        } else {
            return GameState.LOSE;
        }
    }

    private GameState handleAliensOffer(String choice) {
        if (choice.equals("Вернуться домой")) {
            return GameState.VICTORY;
        } else {
            return GameState.LOSE;
        }
    }
}
