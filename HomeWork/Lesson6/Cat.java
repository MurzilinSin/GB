package Lesson6;

public class Cat extends Animal {


    public Cat(String name) {
        super(name);
        this.runMax = random.nextInt(200)+1;
        this.jumpMax = random.nextInt(2)+1;
        this.type = "Кот";
    }


    void swim() {
        System.out.println("Кошки не умеют плавать!");
    }
}
