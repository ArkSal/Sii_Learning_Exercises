package com.asalega;

import java.util.Random;
import java.util.Scanner;

public class Exercise_1 {

    public static void main(String[] args) {

        guessingGame();

    }

    public static void guessingGame() {
        System.out.print("Type range for random numbers generator." + "\n" + "First number:");
        int firstNumber = getIntegerFromScanner();
        System.out.print("Type border number:");
        int secondNumber = getIntegerFromScanner();

        int randomNumber = getRandomNumberInRange(firstNumber, secondNumber);
        String finalMessage = (guessingMethod(randomNumber)) ? "You guessed it!" : "Sorry you didn't guess the " +
                "number, the answer was: " + randomNumber;
        System.out.println(finalMessage);
    }

    private static boolean guessingMethod(int numberToGuess) {
        System.out.print("Please try to guess the drawn number:");
        int numberGivenByUser = getIntegerFromScanner();
        for (int i = 0; i < 5; i++) {
            if (i > 0) {
                System.out.print("Type another number:");
                numberGivenByUser = getIntegerFromScanner();
            }
            if (numberGivenByUser == numberToGuess) {
                return true;
            } else if (i == 4) break;

            else if (numberGivenByUser > numberToGuess) {
                System.out.println("Your number is GREATER than the one you are trying to guess");
            } else {
                System.out.println("Your number is LOWER than the one you are trying to guess");
            }
            System.out.println("Please try again, you have " + (4 - i) + " remaining attemts");
        }
        return false;
    }

    private static int getRandomNumberInRange(int origin, int bound) {
        return new Random().nextInt(origin, bound + 1);
    }

    private static int getIntegerFromScanner() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.print("It's not integer, please type integer number!: ");
        }
        int result = sc.nextInt();
        sc.nextLine();
        return result;
    }
}

//Gra w zgadywanie polegaj??ca na tym, ??e program losuje liczb??, a u??ytkownik pr??buje j?? odgadn????.

//Wymagania:
//1. Program losuje liczb?? z zakresu 0-99.
//2. Program wy??wietla komunikat z pro??b?? o rozpocz??cie zgadywania liczby ca??kowitej z zakresu 0-99
//3. Program wczytuje liczb?? wpisan?? przez u??ytkownika.
//4. U??ytkownik powinien mie?? maksymalnie 5 pr??b zgadywania.
//5. Zachowanie programu podczas podania niepoprawnej liczby:
//- w przypadku podania zbyt du??ej liczby wypisa?? do konsoli: "Your number is GREATER than the one you are trying to guess"
//- w przypadku podania zbyt ma??ej liczby wypisa?? do konsoli: "Your number is LOWER than the one you are trying to guess"
//- poda?? ile pr??b zosta??o mu do ko??ca.
//- je??eli nie by??a to jego ostatnia pr??ba to wypisa?? tekst: "Please try again"
//6. Je??eli u??ytkownik zgad?? liczb??, program powinien wydrukowa?? tekst "You guessed it!"
//7. Je??eli w ci??gu 5 pr??b nie uda??o si?? odgadn???? liczby u??ytkownik, program ma wydrukowa?? wiadomo????:
//"Sorry you didn't guess the number, the answer was: "
//oraz dopisa?? do niej jaka by??a warto???? liczby kt??rej nie uda??o si?? odgadn????