package Lesson6;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Cat cat1 = new Cat("Рыжик");
        Cat cat2 = new Cat("Черныш");
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");

        dog1.printInfo();
        dog2.printInfo();

        cat1.printInfo();
        cat2.printInfo();

        System.out.println("Введите значение бега для собак: ");
        int dogRun = scanner.nextInt();
        dog1.run(dogRun);
        dog2.run(dogRun);

        System.out.println("Введите значение плавания для собак: ");
        int dogSwim = scanner.nextInt();
        dog1.swim(dogSwim);
        dog2.swim(dogSwim);

        System.out.println("Введите значение прыжка для собак: ");
        double dogJump = scanner.nextDouble();
        dog1.jump(dogJump);
        dog2.jump(dogJump);

        System.out.println("Введите значение бега для котов: ");
        int catRun = scanner.nextInt();
        cat1.run(catRun);
        cat2.run(catRun);

        System.out.println("Введите значение прыжка для котов: ");
        int catJump = scanner.nextInt();
        cat1.jump(catJump);
        cat2.jump(catJump);

        System.out.println("Кошкам нельзя ввести значения для плавания, потому что: ");
        cat1.swim();
        cat2.swim();




    }
}
