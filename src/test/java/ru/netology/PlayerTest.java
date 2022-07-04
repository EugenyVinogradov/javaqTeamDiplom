package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void TestSumGenreTwoGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Тестовая игра 2", "Гонки");
        Game game3 = store.publishGame("Нетология Баттл Офлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.installGame(game3);
        player.play(game, 3);
        player.play(game1, 2);
        player.play(game3, 1);

        int expected = 4;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void checkInstallingGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game);
        Assertions.assertTrue(player.getPlayedTime().containsKey(game));
    }

    @Test
    public void checkAddDoubleGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Player player = new Player("Vasya");
        player.installGame(game);
        player.play(game, 3);
        player.installGame(game);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void checkPlayNotInstalledGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Player player = new Player("Petya");
        Assertions.assertThrows(RuntimeException.class, () -> player.play(game, 3));
    }

    @Test
    public void shouldSumGenreMoreOneGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Тестовая игра 2", "Аркады");
        Game game3 = store.publishGame("Тестовая игра 3", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 1);
        player.play(game2, 5);
        player.play(game3, 2);
        int expected = 8;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void checkMostPlayerByGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Тестовая игра 2", "Гонки");
        Game game3 = store.publishGame("Тестовая игра 3", "Гонки");
        Game game4 = store.publishGame("Тестовая игра 4", "Гонки");
        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);
        player.play(game1, 1);
        player.play(game1, 2);
        player.play(game2, 8);
        player.play(game3, 3);
        player.play(game4, 1);
        Game expected = game2;
        Game actual = player.mostPlayerByGenre("Гонки");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMostPlayerByGenreNoInstallGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Тестовая игра 2", "Гонки");
        Game game3 = store.publishGame("Тестовая игра 3", "Гонки");

        Player player = new Player("Petya");
        player.installGame(game2);
        player.installGame(game3);
        player.play(game2, 3);
        player.play(game3, 2);

        Game actual = player.mostPlayerByGenre("Аркады");
        assertEquals(null, actual);


    }

    @Test
    public void addPlayGameNegativeValue() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);


        assertThrows(Exception.class, () -> {
            player.play(game, -1);
        });
    }

    @Test
    public void checkMostPlayerByGenreIfNotPlayedThisGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Тестовая игра 2", "Гонки");
        Game game3 = store.publishGame("Тестовая игра 3", "RPG");
        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 1);
        player.play(game2, 8);
        Game expected = null;
        Game actual = player.mostPlayerByGenre("RPG");
        assertEquals(expected, actual);
    }

    // другие ваши тесты
}

