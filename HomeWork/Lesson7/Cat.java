package Lesson7;

public class Cat {
    protected String name;
    protected boolean fullness;
    protected int maxFoodToFullness;

    public Cat(String name, int maxFoodToFullness){
        this.name = name;
        this.maxFoodToFullness = maxFoodToFullness;
    }

    public void eat(Plate plate, int foodAte) {
        if(plate.decreaseFood(foodAte)){
            fullness = true;
            System.out.println(this.name +", поела " + foodAte + " единиц еды. Котик сыт ? " + fullness);
        }
        else {
            fullness = false;
            System.out.println(this.name + " очень голодна! Сытость равна = " + fullness);
        }

    }
}
