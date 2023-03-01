package com.example.winningstrategy.DataBase;

public class GeneratorOfKeys {
    private final int length = setLength();
    private final StringBuilder GeneratedString = new StringBuilder();

    private int setLength() {
        int randLength = (int) (Math.random() * 20);
        if (randLength > 9 && randLength < 20)
            return randLength;
        return 14;
    }

    private char randomCharacter() {
        int rand = (int) (Math.random() * 62);
        if (rand <= 9) {
            int number = rand + 48;
            return (char) (number);
        } else if (rand <= 35) {
            int uppercase = rand + 55;
            return (char) (uppercase);
        } else {
            int lowercase = rand + 61;
            return (char) (lowercase);
        }
    }

    public StringBuilder getPassword() {
        for (int j = 0; j < length; j++)
            GeneratedString.append(randomCharacter());
        return GeneratedString;
    }
}
