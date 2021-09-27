package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        int randomNumber = new Random().nextInt(100);

        boolean guessedNumber = false;
        int attempts = 0;
        int userGuess;

        long startTime = System.currentTimeMillis();

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
        long endTime = System.currentTimeMillis();
        int timeDeltaSeconds = (int)(endTime-startTime)/1000;

        int minutes = timeDeltaSeconds/60;
        int seconds = timeDeltaSeconds%60;

        System.out.println("You guessed correctly in " + minutes + " minutes, " + seconds + " seconds and " + attempts + " attempts. Well done");
        storeResults(scanner, timeDeltaSeconds, attempts);
    }

    public static boolean storeResults(Scanner scanner, int timeSecs, int attempts) {
        System.out.println("Storing your results. Type your initials:");
        String initals = scanner.next();

        FileOutputStream resultsFile;

        String toWrite = initals + "," + attempts + "," + timeSecs;
        System.out.println(toWrite);

        try {
            resultsFile = new FileOutputStream("guess_the_number_results.csv");
            resultsFile.write(toWrite.getBytes(StandardCharsets.UTF_8));
            resultsFile.close();
        } catch (IOException e) {
            System.out.println("Oops, sorry something went wrong storing your results :(  :");
            e.printStackTrace();
        } finally {
            System.out.println("Thanks for playing, goodbye!");
        }

        return true;
    }
}
