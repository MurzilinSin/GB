package Lesson6;

import java.util.Random;
import java.util.Scanner;

public class  Animal {
    private String name;
    protected int runMax;
    protected int swimMax;
    protected double jumpMax;
    protected String type;
    public Random random = new Random();


    public Animal(String name){this.name = name;}

     void run(int distance){
        if(runMax >= distance){
            System.out.println(this.name + ", пробежал " + distance);
        }
        else{
            System.out.println(this.name + ", не может столько пробежать.");
        }

    }

     void swim(int distance){
         if(swimMax >= distance){
             System.out.println(this.name + ", проплыл " + distance);
         }
         else{
             System.out.println(this.name + ", не может столько проплыть.");
         }
     }

     void jump(double height){
         if(jumpMax >= height){
             System.out.println(this.name + ", прыгнул " + height);
         }
         else{
             System.out.println(this.name + ", не может так высоко прыгнуть.");
         }
     }

    void printInfo() {
        System.out.println(this);
    }

    public String toString() {
        return "Это " + name + ", он - "+ type + ", максимально он может пробежать " + runMax + ", прыгнуть " + jumpMax + " и плыть " + swimMax;
    }

}
