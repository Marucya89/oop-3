package ru.netology;

public class FilmsManager {
    private String[] films = new String[0];
    int limit;

    public FilmsManager(){
        this.limit = 5;
    }

    public FilmsManager(int limit){
        this.limit = limit;
    }


    public void addFilm(String film) {
        String[] tmp = new String[films.length +1];
        for (int i =0; i< films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length -1] = film;
        films = tmp;

    }


    public String[] findAll() {
        return films;
    }

    public String[] findLast() {
        int resultLength;
        if (films.length < limit){
            resultLength = films.length;
        } else {
            resultLength = limit;
        }
        String[] resalt = new String[resultLength];
        for (int i = 0; i < resalt.length; i++) {
            resalt[i] = films[films.length - 1 - i];
        }
        return resalt;

    }

}