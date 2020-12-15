package Lesson7;

import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static int food;


    public static void main(String[] args) {
        Cat cat1 = new Cat("Киви", 7);
        Cat cat2 = new Cat("Рыся", 5);
        Cat[] cats = {cat1,cat2};
        Plate plate = new Plate();

        do {
            System.out.println("Положите еду");
            if(in.hasNextInt()){
                food = in.nextInt();
                plate.addFood(food);
            }
            else {
                in.next();
                System.out.println("Положите еду!");
            }
        } while(!(food > 0));




        for (Cat cat : cats) {
            cat.eat(plate, cat.maxFoodToFullness);
            plate.printInfo();
        }

    }
}
