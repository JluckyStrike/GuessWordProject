package com.gb.lessons;

import java.util.Scanner;

/*
* Создать массив из слов
String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно можно пользоваться:
String str = "apple";
char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово.
Используем только маленькие буквы.
* */

public class Main {

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int randNum = (int) (Math.random() * words.length);

        String pcWord = words[randNum];
        String humWord;
        char[] result = generateArray(pcWord);

        // System.out.println(pcWord); // для проверки
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введие слово: ");
            humWord = scanner.nextLine();
            int shortLen = (pcWord.length() < humWord.length()) ? pcWord.length() : humWord.length(); // создаем доп. переменную, чтобы издежать ошибки index out of range

            if (humWord.equals(pcWord)) { // если угадали, ты воводим сообщение и покидаем цикл
                System.out.println("Вы угадали!");
                break;
            } else { // в противном случае ищем, есть ли в введённом угаданные буквы, если есть то заполняем массив этими буквами
                for (int i = 0; i < shortLen; i++) {
                    if (pcWord.charAt(i) == humWord.charAt(i))
                        result[i] = humWord.charAt(i);
                }
            }

            System.out.println(result);
        }
    }

    // генерируем массив из #, длина будет равной 15, только в том случае
    // если загаданное слово имеет меньшую длину, в противном случае берем длину переданного слова
    public static char[] generateArray(String word) {
        int size = 15;

        if (word.length() > 15)
            size = word.length();

        char[] res = new char[size];

        for (int i = 0; i < size; i++) {
            res[i] = '#';
        }

        return res;
    }
}
