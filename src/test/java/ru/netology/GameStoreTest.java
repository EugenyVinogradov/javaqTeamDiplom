package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldGetSumPlayedTime() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Гонки Онлайн", "Гонки");
        Player player = new Player("Anton");
        Player player1 = new Player("Alex");
        player.installGame(game);
        player1.installGame(game1);
        player.play(game, 2);
        player1.play(game1, 4);
        int expected = 6;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);
    }

    // другие ваши тесты
}
