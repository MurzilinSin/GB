package Lesson2;

// создать поля
// создать массив
// прописать в нем незадействованные ячейки
// прописать нумерацию полей




import java.util.Random;
import java.util.Scanner;

public class HomeWork_4 {

    public static final int SIZE = 7;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_HUMAN = 'X';
    public static final char DOT_AI = 'O';

    public static final String HEADER = "♥";
    public static final String EMPTY = " ";

    public static final Scanner enter = new Scanner(System.in);
    public static final Random random = new Random();

    public static  char[][] map = new char[SIZE][SIZE];

    public static int RowNumber = 0;
    public static int ColumnNumber = 0;
    public static int aIRowNumber = 0;
    public static int aIColumnNumber = 0;
    private static int DOT_TO_WIN = 3;
    public static int FULL_FILL_CELL = 0;
    public static int aiMove = 0;

    public static void main(String[] args) {
        mapTicTacToe();
        turnGame();
    }


    private static void mapTicTacToe() {
        createMap();
        printMap();
    }

    private static void printMap() {
        printHeaderMap();
        printMapRow();
    }

    private static void printMapRow() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumbers(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + EMPTY);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printMapNumbers(int i) {
        System.out.print(i + 1 + EMPTY);
    }

    private static void printHeaderMap() {
        System.out.print(HEADER + EMPTY);
        for (int i = 0; i < SIZE; i++) {
            printMapNumbers(i);
        }
        System.out.println();
    }

    private static void createMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
        numbDotToWin();
    }

    private static void numbDotToWin(){
        if(SIZE < 6){ DOT_TO_WIN = 3;}
        else if(SIZE < 10){DOT_TO_WIN = 4;}
        else {DOT_TO_WIN = 5;}
    }


    public static void turnGame() {
        while(true){
            humanTurn();
            endGame(DOT_HUMAN);
            //iTurn();
            AiTurnVersion2();
            endGame(DOT_AI);
        }
    }


    private static void humanTurn() {

        System.out.println("Ход человека!");
        do {
            System.out.println("Введите номер строки:");
            if(enter.hasNextInt()){
                RowNumber = enter.nextInt();
            }
            else {
                enter.next();
                System.out.println("Введите число в диапазоне от 1 до " + SIZE + "\n");
                continue;
            }
            System.out.println("Введите номер столбца");
            if(enter.hasNextInt()){
                ColumnNumber = enter.nextInt();
            }
            else {
                enter.next();
                System.out.println("Введите число в диапазоне от 1 до " + SIZE + "\n");
            }

        } while (!cellValid(RowNumber, ColumnNumber));
        map[RowNumber - 1][ColumnNumber - 1] = DOT_HUMAN;
        FULL_FILL_CELL++;
        printMap();
    }

    private static boolean cellValid(int RowNumber, int ColumnNumber){return cellValid(RowNumber, ColumnNumber,false);}

    private static boolean cellValid(int RowNumber, int  ColumnNumber, boolean isAi) {
        if (RowNumber < 1 || RowNumber > SIZE || ColumnNumber < 1 || ColumnNumber > SIZE){
            System.out.println("Проверьте значения ввода!");
            return false;
        }
        if(map[RowNumber-1][ColumnNumber-1] != DOT_EMPTY){
            if (!isAi) {
                System.out.println("\nВы выбрали занятую ячейку");
            }
            return false;
        }
        return true;
    }

    private static void AiTurn() {

        System.out.println("Ход компьютера!");
        do{
            RowNumber = random.nextInt(SIZE) + 1;
            ColumnNumber = random.nextInt(SIZE) + 1;
        }while(!cellValid(RowNumber,ColumnNumber,true));
        FULL_FILL_CELL++;
        map[RowNumber - 1][ColumnNumber - 1] = DOT_AI;
        printMap();

    }


    private static void endGame(char symbol) {
        boolean isEnd = false;
        if(checkWin(symbol)){
            String winMessage;
            if(symbol == DOT_HUMAN){winMessage = "Победа человека!";}
            else {winMessage = "Победил искусственый интеллект!";}
            isEnd = true;
            System.out.println(winMessage);
        }
        if(!isEnd && fullMap(FULL_FILL_CELL)){
            System.out.println("Ничья!");
            isEnd = true;
        }
        if (isEnd) {System.exit(0);}
    }

    private static boolean fullMap(int fullFillCell){return fullFillCell == SIZE*SIZE;}

    // Суть проверок. Мы находим в каждом из методов начальную точку(строки, столбца и диагоналей) Затем проходимся по ним. Если есть выиграш, то игра останавливается.
    private static boolean checkWin(char symbol) {
        // проверка победной комбинации в строке:
        if(rowCheck(symbol)){return true;}
        // проверка победной комбинации в стоблце:
        if(columnCheck(symbol)){return true;}
        // проверка победной комбинации по диагонали с левого верхнего края:
        if(diagonalFromLeftTopCheck(symbol)) {return true;}
        // проверка победной комбинации по диагонали с правого верхнего края:
        if(diagonalFromRightTopCheck(symbol)){return true;}
        return false;
    }

    private static boolean rowCheck(char symbol){
        int count = 0;
        int countWin = DOT_TO_WIN;
        int aiCount = 0;
        int diagonalRowNumber = RowNumber;
        diagonalRowNumber--;

        for (int j = 0; j < SIZE; j++) {
            if(symbol == map[diagonalRowNumber][j]) {
                count++;
                if (count >= countWin) {return true;}
            }

            else {
                aiCount = count;
                count = 0;
            }
        }
        return false;
    }

    private static boolean columnCheck(char symbol) {
        int count = 0;
        int countWin = DOT_TO_WIN;
        int diagonalColumnNumber = ColumnNumber;
        diagonalColumnNumber--;
        for(int i = 0; i < SIZE; i++) {
            if (symbol == map[i][diagonalColumnNumber]) {
                count++;
                if (count >= countWin) {return true;}
            }
            else {count = 0;}
        }
        return false;
    }

    private static boolean diagonalFromLeftTopCheck(char symbol) {
        int count = 0;
        int countWin = DOT_TO_WIN;
        int diagonalRowNumber = RowNumber;
        int diagonalColumnNumber = ColumnNumber;
        diagonalRowNumber--;
        diagonalColumnNumber--;


        while (diagonalRowNumber != 0 && diagonalColumnNumber != 0) {
            diagonalRowNumber--;
            diagonalColumnNumber--;
        }

        for (int i = diagonalRowNumber; i < SIZE; i++) {
            if(diagonalColumnNumber < SIZE) {
                if (map[i][diagonalColumnNumber] == symbol){
                    count++;
                    if (count >= countWin) {return true;}
                }
                else {count = 0;}
                diagonalColumnNumber++;
            }

        }

        return false;
    }

    private static boolean diagonalFromRightTopCheck(char symbol) {
        int count = 0;
        int countWin = DOT_TO_WIN;
        int diagonalRowNumber = RowNumber;
        int diagonalColumnNumber = ColumnNumber;
        diagonalRowNumber--;
        diagonalColumnNumber--;


        while (diagonalRowNumber != 0 && diagonalColumnNumber != SIZE-1) {
            diagonalRowNumber--;
            diagonalColumnNumber++;
        }

        for (int i = diagonalRowNumber; i < SIZE; i++) {
            if(diagonalColumnNumber >= 0) {
                if (map[i][diagonalColumnNumber] == symbol){
                    count++;
                    if (count >= countWin){ return true;}
                }
                else {count = 0;}
                diagonalColumnNumber--;
            }

        }


        return false;
    }

    // В общем максиму чему я смог его научить, это ходить рядом со своим предыдущем ходом. И тем самым в итоге он сможет победить
    // Но, к сожалению, я так и не смог настроить блок и привести аи к победе. Я понимаю, что нужно через мою проверку CheckWIn это делать. но мне получилось
    // Можете подсказать, как тут можно было это сделать. Я знаю, что этот код уже тяжело читается, где то я не разбил по отдельным методом, а где-то наоборот.
    // В основном код работает норм, проверки выполняют. выиграш работает. Ничья тоже. (если вдруг тут не работает, то на обычном ии первой версии точно работает)
    // также меняется значение  выиграшных фишек от значения поля.
    // Проверка на выиграш работает очень хорошо.
    private static void AiTurnVersion2(){
        int diffR, diffC, minR,minC, maxR, maxC;
        System.out.println("Ход компьютера!");
        // Здесь я получаю первое значение хода. Оно просто рандом
        if (aiMove < 1) {
            aIRowNumber = random.nextInt(SIZE) + 1;
            aIColumnNumber = random.nextInt(SIZE) + 1;
        }
        else{
            // Тут делаю так, чтобы ход компьютера был рядом с его предыдущем. Путем прощупывания близких к нему возможных ходов. он рандомно выбирает куда сходить
            do {
                // это для обработки возможны ошибок, когда ии сходил в угол. потому что там явно меньше возможностей куда сходить. и чтобы не получить вылет из массива, делаю проверки.
                if(aIRowNumber == SIZE){
                     minR = aIRowNumber - 1;
                     maxR = aIRowNumber + 1;
                     diffR = maxR - minR;
                }
                else if(aIRowNumber == 1){
                     minR = aIRowNumber;
                     maxR = aIRowNumber + 2;
                     diffR = maxR - minR;
                }
                else {
                     minR = aIRowNumber - 1;
                     maxR = aIRowNumber + 2;
                     diffR = maxR - minR;
                }

                if(aIColumnNumber == SIZE) {
                     minC = aIColumnNumber - 1;
                     maxC = aIColumnNumber + 1;
                     diffC = maxC - minC;
                }
                else if(aIColumnNumber == 1){
                     minC = aIColumnNumber;
                     maxC = aIColumnNumber + 2;
                     diffC = maxC - minC;
                }
                else {
                     minC = aIColumnNumber - 1;
                     maxC = aIColumnNumber + 2;
                     diffC = maxC - minC;
                }

                aIRowNumber = random.nextInt(diffR) + minR;
                aIColumnNumber = random.nextInt(diffC) + minC;
            } while (!cellValid(aIRowNumber, aIColumnNumber, true));
        }
        FULL_FILL_CELL++;
        aiMove++;
        RowNumber = aIRowNumber;
        ColumnNumber = aIColumnNumber;
        map[RowNumber - 1][ColumnNumber - 1] = DOT_AI;
        printMap();
    }



}
