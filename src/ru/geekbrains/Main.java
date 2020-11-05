package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args) {
        //1.
        guessNumber();

        //2. массив из слов
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        guessWord(words);



    }

    //1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это
    // число. При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или
    // меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить,
    // 0 – нет)

    public static void guessNumber()
    {
        //getting a random number
        Random random = new Random();
        int randomNumber = random.nextInt(9);
        System.out.println(randomNumber);


        int tryCount = 1;
        while (tryCount <= 3)
        {
            //read the user's number
            Scanner scanner = new Scanner(System.in);
            System.out.println("Guess the number from 0 to 9");
            int inputNumber = scanner.nextInt();


            if(tryCount == 3)
            {
                System.out.println("You lost. Try again. Enter 1 - YES or 2 - NO");
                int continueGame = scanner.nextInt();
                if (continueGame == 1)
                {
                    continue;
                }
                else
                {
                    System.out.println("Good luck!");
                    break;
                }
            }
            else if (inputNumber == randomNumber)
            {
                System.out.println("Congrats! You are a real winner!");
                break;

            }
            else if (inputNumber > randomNumber)
            {
                System.out.println("Your number is bigger. This is your " + tryCount + " try");
                tryCount++;
            }
            else if (inputNumber < randomNumber)
            {
                System.out.println("Your number is less. This is your " + tryCount + "try");
                tryCount++;
            }

        }

    }



    //2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    //сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
    //apple – загаданное
    //apricot - ответ игрока
    //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    //Для сравнения двух слов посимвольно, можно пользоваться:
    //String str = "apple";
    //str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    //Играем до тех пор, пока игрок не отгадает слово
    //Используем только маленькие буквы

    public static void guessWord(String[] words)
    {
        //компьютер загадывает слово
        String randomWord = words[new Random().nextInt(words.length)];

        //String to store correct chars
        String correct;

        while (true)
        {
            //запрашивает ответ у пользователя
            Scanner scanner = new Scanner(System.in);
            System.out.println("Guess the word");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equals(randomWord))
            {
                System.out.println("Congrats! " + userAnswer + " is correct.");
                break;
            }
            else
            {

                System.out.println("Try Again");
                correct = "";
                for(int i = 0; i < 15; i++)
                {
                    if (userAnswer.length() > i && randomWord.length() > i && userAnswer.charAt(i) == randomWord.charAt(i))
                    {
                        correct += userAnswer.charAt(i);
                    }
                    else
                    {
                        correct += "#";
                    }
                }

                System.out.println(correct);

            }
        }

    }
}
