package Lesson2;

import java.util.Arrays;

public class HomeWork_2 {
    // Выполнил студент: Куклин Максим
    public static void main(String[] args) {
        System.out.println("Первое задание: ");
        arrayReverse();
        System.out.println("\nВторое задание: ");
        arrayIncreaseTriple();
        System.out.println("\nТретье задание: ");
        arrayLessSix();
        System.out.println("\nЧетвертое задание: ");
        arrayDiagonalPicture(9);
        System.out.println("\nПятое задание: ");
        arrayMinMax();
        System.out.println("\nШестое задание: ");
        int[] array = {1, 2, 4, 5, 6, 7, 12, 13};
        arrayEqualSides(array);
        System.out.println("\nСедьмое задание: ");
        int[] array_2 = {1, 2, 4, 5}; //{5,1,2,4}
        arrayShift(array_2, 0);



    }
    

    //Задание 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1,
    //0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    private static void arrayReverse() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) array[i] = 1;
            else array[i] = 0;
            System.out.print(array[i] + " ");
        }
    }

    //Задание 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его
    //значениями 0 3 6 9 12 15 18 21;

    private static void arrayIncreaseTriple() {
        int array[] = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
            System.out.print(array[i] + " ");
        }
    }

    //Задание 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
    //умножить на 2;

    private static void arrayLessSix() {
        int array[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
            System.out.print(array[i] + " ");
        }

    }

    //Задание 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов
    //одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

    private static void arrayDiagonalPicture(int a) {
        int array[][] = new int[a][a];
        int element = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j ) array[i][j] = element;
                array[i][array.length-1-i] = element;
                System.out.print(array[i][j]);
            }
            System.out.println();

        }
    }

    //Задание 5. Задать одномерный массив и найти в нем минимальный и максимальный элементы;

    private static void arrayMinMax() {
        int array[] = {6, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) max = array[i];
            else if (array[i] < min) min = array[i];
        }
        System.out.println("Значение max = " + max);
        System.out.print("Значение min = " + min);
    }

    //Задание 6.  Написать метод, в который передается не пустой одномерный целочисленный массив,
    //метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
    //массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, ||
    //2, 1]) → true, граница показана символами ||, эти символы в массив не входят;

    private static boolean arrayEqualSides(int[] array) {
        int sumGeneral = 0;
        for (int i = 0; i < array.length; i++) {
            sumGeneral += array[i];
        }
        if (sumGeneral % 2 == 0) {
            int sum1 = 0;
            for (int i = 0; i < array.length; i++) {
                sum1 += array[i];
                if (sum1 == sumGeneral/2) {
                    System.out.println("Половины равны");
                    return true;
                }
            }
        }
        System.out.println("Нет совпадений по равенству!");
        return false;

    }

    //Задание 7. Написать метод, которому на вход подается одномерный массив и число n (может быть
    //положительным, или отрицательным), при этом метод должен сместить все элементы
    //массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя
    //пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) ->
    //[ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг
    //можете выбирать сами

    private static void arrayShift(int[] arr, int n){
        // {1, 2, 4, 5}

        if(n == 0){
            System.out.println("Введите корректное число!");
        }
        else {
            System.out.println("Исходный массив: " + Arrays.toString(arr));
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    int temp = arr[arr.length - 1];
                    for (int j = arr.length - 1; j > 0; j--) {
                        arr[j] = arr[j - 1];
                    }
                    arr[0] = temp;
                }
            } else {
                for (int i = 0; i < Math.abs(n); i++) {
                    int temp = arr[0];
                    for (int j = 0; j < arr.length - 1; j++) {
                        arr[j] = arr[j + 1];
                    }
                    arr[arr.length - 1] = temp;
                }
            }
            System.out.println("Измененный массив: " + Arrays.toString(arr));
        }

    }

}
