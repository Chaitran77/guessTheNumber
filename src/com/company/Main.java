package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        int randomNumber = new Random().nextInt(100);

        Boolean guessedNumber = false;
        int attempts = 0;
        int userGuess;


        while (!guessedNumber) {
            attempts++;
            System.out.println("Type your guess: \n");
            userGuess = scanner.nextInt();
            if (userGuess == randomNumber) {
                guessedNumber = true;
            } else {
                if (userGuess < randomNumber) {
                    System.out.println("Guess higher");
                } else {
                    System.out.println("Guess lower");
                }
            }

        }

        System.out.println("You guessed correctly in " + Integer.toString(attempts) + " attempts. Well done");
    }
}
