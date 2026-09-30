package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FilmsManagerTest {

    @Test
    public void testZero() {
        FilmsManager manager = new FilmsManager();

        String[] actual = manager.findAll();
        String[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddOne() {
        FilmsManager manager = new FilmsManager();

        manager.addFilm("Movie 1");

        String[] actual = manager.findAll();
        String[] expected = {"Movie 1"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddThree() {
        FilmsManager manager = new FilmsManager();

        manager.addFilm("Movie 1");
        manager.addFilm("Movie 2");
        manager.addFilm("Movie 3");

        String[] actual = manager.findAll();
        String[] expected = {
                "Movie 1",
                "Movie 2",
                "Movie 3",
        };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddLast() {
        FilmsManager manager = new FilmsManager();

        manager.addFilm("Movie 1");
        manager.addFilm("Movie 2");
        manager.addFilm("Movie 3");

        String[] actual = manager.findLast();
        String[] expected = {
                "Movie 3",
                "Movie 2",
                "Movie 1",
        };
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testLastLimit() {
        FilmsManager manager = new FilmsManager();

        manager.addFilm("Movie 1");
        manager.addFilm("Movie 2");
        manager.addFilm("Movie 3");
        manager.addFilm("Movie 4");
        manager.addFilm("Movie 5");

        String[] actual = manager.findLast();
        String[] expected = {
                "Movie 5",
                "Movie 4",
                "Movie 3",
                "Movie 2",
                "Movie 1",
        };
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testShouldFindLastWithDefaultLimit() {
        FilmsManager manager = new FilmsManager();

        for (int i = 1; i <= 7; i++) {
            manager.addFilm("Film" + i);
        }
        String[] actual = manager.findLast();
        String[] expected = {
                "Film7",
                "Film6",
                "Film5",
                "Film4",
                "Film3"
        };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testShouldFindLastWhenFilmsLessThanLimit() {
        FilmsManager manager = new FilmsManager(5);
        manager.addFilm("Film1");
        manager.addFilm("Film2");

        String[] actual = manager.findLast();
        String[] expected = {
                "Film2",
                "Film1"
        };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testShouldFindLastWhenExactlyLimit() {
        FilmsManager manager = new FilmsManager(4);

        for (int i = 1; i <= 4; i++) {
            manager.addFilm("Film" + i);
        }
        String[] actual = manager.findLast();
        String[] expected = {
                "Film4",
                "Film3",
                "Film2",
                "Film1"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testEmptyManager() {
        FilmsManager manager = new FilmsManager();

        Assertions.assertArrayEquals(new String[0], manager.findAll());
        Assertions.assertArrayEquals(new String[0], manager.findLast());
    }

    @Test
    public void testFindLastWithZeroLimit() {
        FilmsManager manager = new FilmsManager(0);

        manager.addFilm("X");

        String[] actual = manager.findLast();
        String[] expected = new String[0];

        Assertions.assertArrayEquals(expected, actual);
    }


}
