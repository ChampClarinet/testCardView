package com.example.clarinetmaster.testcardview.Model;

public class Card {

    private String name;
    private int image;
    private int score;

    public Card(String name, int image, int score) {
        this.name = name;
        this.image = image;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getScore() {
        return score;
    }

}
