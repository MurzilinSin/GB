package Lesson2;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork_3 {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static int count = 0;

    public static void main(String[] args) {
        //game();
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        guessWord(words);
    }

    //Задание 1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю
    // дается 3 попытки угадать это число. При каждой попытке компьютер должен сообщить больше
    // ли указанное пользователем число чем загаданное, или меньше. После победы или проигрыша
    // выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

    private static void game() {
        startGameNumber();
        int randomNumber = random.nextInt(10); // сделал, чтобы число не менялось, чтобы могли отгадать после окончания попыток.
        System.out.println(randomNumber);
        while (true) {
            noMoreCount();
            compareAnswer(randomNumber);
       }
    }

    private static void startGameNumber() {
        System.out.println("Регрессор. Пролог. \n ...(спустя несколько абзацев)...\nЭто был рядовой рейд по зачистке низкоуровневых монстров, но накануне я поссорился со своими друзья и поэтому вошел в подземелье один. " +
                "\nВо время изучения подземелья перед мной появился он: монстр, так сильно похожий на человека в черном фраке и большой шляпе цилиндр, но этот оскал и глаза, прожигающие насквозь, не оставляли сомнений, что это не человек. ");
        System.out.println("Монст: Приветствую тебя, дорогой авантюрист. Я хочу сыграть с тобой в одну очень простую игру. Поверь тебе понравится." +
                " Все очень просто: тебе нужно лишь угадать число от 0 до 9, которое я загадал.\nНо, предупреждаю тебя, у тебя есть всего 3 попытки.");
        System.out.println("Вы: Кто ты ?");
        System.out.println("Система:*Вы ощущаете невероятное давление, страх и ужас. Вы не можете пошевелиться.*");
        System.out.println("Монстр: Мой друг, это неважно как и то, что будет с тобой. Давай уже начнем игру! *зловещая улыбка поглотила лицо монстра*\nКакое число я загадал ?");

    }

    public static void noMoreCount() {
        if (count == 3) {
            System.out.println("Хм, я думал, что попал именно в тот мир. Ладно, что до тебя, боюсь для тебя это конец, мой дорогой авантюрист.  *Монстр наносит удар. Вы не успеваете отреагировать. Ваши глаза закрываются, вам хочется спать. Похоже это конец или...");
            rebirth();
        }
    }

    private static void compareAnswer(int randomNumber) {
        System.out.println("Введите число:");
        int userAnswer = scanner.nextInt();
        if (userAnswer == randomNumber) {
            System.out.println("Монстр: Отлично, ты смог угадать.*Чудовище посмотрело на неизвестный артефакт и тихо засмеялось, но этот смех раздался эхом в вашем разуме и навсегда впечаталось в ваш разум, как нечто ужасающие.");
            rebirth(2);
        }
        else if (userAnswer > randomNumber) System.out.println("Я загадал число меньше.");
        else if (userAnswer < randomNumber) System.out.println("Я загадал число больше.");
        count++;
    }

    private static void rebirth() {
        System.out.println("Система запрашивает Вас: хотите ли вы попробывать еще раз ? y/n");
        switch (scanner.next()) {
            case "y":
            case "yes":
            case "н":
            case "да":
            case "д":
            case "+":
                count = 0;
                System.out.println("*Вы открываете глаза и...*\nМонстр: Давай уже начнем игру! Какое число я загадал ?\nВы: Что произошло ? Я..\nМонстр: Ну же не тяни - отвечай!");
                break;
            case "n":
            case "no":
            case "т":
            case "нет":
            case "-":
                System.out.println("Ты еще дышишь !? Удивительно, очень похвально, молодой человек. И все же вы не тот, кто мне нужен. Прощайте!\n*Монстр наносит удар. Вы не успеваете отреагировать. Ваши глаза закрываются, вам хочется спать. Похоже это конец.");
                System.exit(0);
            default:
                System.out.println("*Система не может распознать ваш ответ. Введите еще раз.*");
                rebirth();
        }
    }

    private static void rebirth(int mistake) {
         // я тупой и не смог придумать, как перегрузить этот метод. все из - за моего интерактива :0
         // но очень хотел сделать перегрузку, чтобы усвоить материал
         // у меня вроде как старая версия и не получается сделать case ... -> ... так бы сделал case "y", ... -> sout ...
        System.out.println("Система запрашивает Вас: хотите ли вы попробывать еще раз ? y/n");
        switch (scanner.next()) {
            case "y":
            case "yes":
            case "н":
            case "да":
            case "д":
            case "+":
                count = 0;
                System.out.println("Монстр: Еще раз ? А ты странный! Ну хорошо. Какое число я загадал ?");
                break;
            case "n":
            case "no":
            case "т":
            case "нет":
            case "-":
                System.out.println("Монстр: Похоже, что ты более занятный. *Злобно улыбается*\nПока я уйду, но мы с тобой скоро еще раз встретимся. Пока пока\n*Вы снова можете дышать спокойно*\nКонец.");
                System.exit(0);
            default:
                System.out.println("*Система не может распознать ваш ответ.*");
                rebirth(2);
        }
    }


    //Задание 2. Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    //сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
    //apple – загаданное
    //apricot - ответ игрока
    //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    //Для сравнения двух слов посимвольно, можно пользоваться:
    //String str = "apple";
    //str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    //Играем до тех пор, пока игрок не отгадает слово
    //Используем только маленькие буквы

    private static void guessWord (String[] words){
        char[] computerChoise = words[random.nextInt(words.length)].toCharArray();

        while(true) {
            System.out.println("Попытайтесь угадать слово: ");
            char[] userChoise = scanner.next().toLowerCase().toCharArray();
            String result ="";
            if(!Arrays.equals(computerChoise,userChoise)) {
                for (int i = 0; i < computerChoise.length && i < userChoise.length; i++) {
                    if(userChoise[i] == computerChoise[i]) result += computerChoise[i];
                }
                for (int j = result.length(); j < 15; j++) result += "#";
                System.out.println(result);
            }
            else {
                System.out.println("Угадал!");
                break;
            }
        }
    }

}
