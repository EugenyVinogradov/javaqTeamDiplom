package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGameOne() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");


        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Гонки Онлайн", "Гонки");


        assertTrue(store.containsGame(game));
        assertTrue(store.containsGame(game1));
    }

    @Test
    public void shouldNotContainsGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Гонки Онлайн", "Гонки");
        Game game2 = null;

        assertFalse(store.containsGame(game2));

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

    @Test
    public void shouldGetSumPlayedTimeOldPlayer() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Гонки Онлайн", "Гонки");
        Player player = new Player("Anton");
        Player player1 = new Player("Alex");
        player.installGame(game);
        player1.installGame(game1);
        player.play(game, 2);
        player1.play(game1, 4);
        player.play(game, 3);
        int expected = 9;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);

    }

    @Test
    public void shouldGetMostPlayer() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Гонки Онлайн", "Гонки");
        Player player = new Player("Anton");
        Player player1 = new Player("Alex");
        player.installGame(game);
        player1.installGame(game1);
        player.play(game, 2);
        player1.play(game1, 4);
        String expected = "Alex";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);


    }

    @Test
    public void shouldGetMostOnePlayer() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Гонки Онлайн", "Гонки");
        Player player = new Player("Anton");
        player.installGame(game);
        player.play(game, 2);
        String expected = "Anton";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);


    }

    @Test
    public void shouldGetMostPlayerNull() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Гонки Онлайн", "Гонки");
        Player player = new Player("Anton");
        Player player1 = new Player("Alex");
        player.installGame(game);
        player1.installGame(game1);
        String actual = store.getMostPlayer();

        assertEquals(null, actual);

    }
}
