package geekbrains.Lesson1;

public class Exercises_lesson_1 {
    public static void main (String[] args){
        System.out.println(function (3,2,10,5));
        System.out.println(range (5,5));
        numberPositiveOrNegative (-15);
        System.out.println(numberPositiveOrNegative_2 (0));
        printName("Тимофей");
        year(104);
        System.out.println(yearInOneLine(100));
    }

    // Задание 3
    private static double function (double a, double b, double c, double d){
        return a * (b+(c/d));
    }

    // Задание 4
    private static boolean range (int a, int b){
        int sum = a + b;
        if(sum >= 10 && sum <= 20){
            return true;
        }
        else return false;
    }

    // Задание 5
    private static void numberPositiveOrNegative (int a) {
        if (a >= 0) System.out.println("Число положительное!");
        else System.out.println("Число отрицательное!");
    }

    // Задание 6
    private static boolean numberPositiveOrNegative_2 (int a){
        if (a >= 0) return true;
        else return false;
    }

    // Задание 7
    private static void printName(String s){
        System.out.println("Привет, " + s + "!");
    }

    // Задание 8 первый вариант. Второй вариант делал после вебинара, когда вы попросили в одну строку
    private static void year (int year){
        if(year%400==0 || (year%100!=0 && year%4==0)) System.out.println("Год високосный!");
        else System.out.println("Год НЕвисокосный!");
    }

    // Задание 8 в одну строчку.
    private static boolean yearInOneLine (int year) {
        return (year%400==0 || (year%100!=0 && year%4==0));
    }

    /* Добавляю строку для pull request. 
       Тимофей, добрый день. Пожалуйста, проверьте домашнее задание. надеюсь на критику для дальнейшего развития.
       Понятно, что сейчас только первые задания и особо не видно еще всех косяков. и нормально на гите все сделано ?
       первый раз выложил.*/

}
