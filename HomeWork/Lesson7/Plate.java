package Lesson7;

public class Plate {
    protected int food;

    public void addFood(int food) {
        if(food > 0){
            this.food += food;
        }
        else{
            System.out.println("Вы что делаете ? Это же минус еда. Странный вы!");
        }
    }

    public void printInfo() {
        System.out.println("В миске " + food + " единицы еды");
    }

    public boolean decreaseFood(int food) {
        if (this.food - food < 0){
            System.out.println("Этого мало!");
            return false;
        }
        else {
            this.food -= food;
            return true;
        }

    }
}
