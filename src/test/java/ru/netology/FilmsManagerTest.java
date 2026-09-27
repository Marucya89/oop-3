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
    public void testAddMany() {
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
}
