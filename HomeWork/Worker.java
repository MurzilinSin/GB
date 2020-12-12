package Lesson2;

import java.util.Locale;

public class Worker {
     String name;
     String post;
     String mail;
     String phone;
     int profit;
     int age;

    public Worker(String name, String post, String mail, String phone, int profit, int age){
        this.name = name != null ? name : "Неизвестно";
        this.post = post != null ? post.toUpperCase() : "Неизвестно";;
        this.mail = mail != null ? mail : "Неизвестно";;
        this.phone = phone != null ? phone : "Неизвестно";;
        this.profit = profit;
        this.age = age;
    }

    public Worker(String name, String post, int profit, int age) {
        this.name = name;
        this.post = post;
        this.profit = profit;
        this.age = age;
    }

    void printInfo() {
        System.out.println(this);
    }

    public int getAge(){
        return age;
    }

    public String toString() {
        return "Это " + name + ", он наш " + post + ", и ему " + age;
    }

}
