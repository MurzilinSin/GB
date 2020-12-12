package Lesson2;

public class HomeWork_5 {
    public static final int MIN_AGE = 28;
    // Молодой коллектив, поэтому снизил с 40 до 28 )
    public static void main(String[] args) {
        Worker worker_1 = new Worker("Валера Петров","Директор", "petrov@mail.ru","4-23-21", 200000, 46);
        Worker worker_2 = new Worker("Максим Волков","Тим лид", "ubivashka91@mail.ru","4-23-22", 150000, 32);
        Worker worker_3 = new Worker("Ваня","младший программист", 200000, 21);
        Worker worker_4 = new Worker("Рома","программист",  200000, 29);
        Worker worker_5 = new Worker("Олег","младший программист", 200000, 24);

        Worker[] workers = {worker_1, worker_2, worker_3, worker_4, worker_5};
        for (int i = 0; i < workers.length; i++) {
            if(workers[i].getAge() < MIN_AGE) {
                System.out.print("Молодой сотрудник: ");
                workers[i].printInfo();
            }
        }


    }


}
