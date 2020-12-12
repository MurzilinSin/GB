package Lesson6;

public class Dog extends Animal{

    public Dog(String name){
        super(name);
        this.runMax = random.nextInt(500) + 1;
        this.swimMax = random.nextInt(10);
        this.jumpMax = Math.round(Math.random() * 100.0) / 100.0;
        this.type = "Собака";
    }


}
