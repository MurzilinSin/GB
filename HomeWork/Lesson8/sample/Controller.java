package sample;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class Controller {
   private Random random = new Random();
   private int randomNumber = random.nextInt(10) + 1;
   private int tryCount = 1;
   private int maxCount = 4;

    @FXML
    private Button buttonEnter;

    @FXML
    private Button button_yes;

    @FXML
    private Button button_no;

    @FXML
    private TextField textField;

    @FXML
    private Label label;

    @FXML
    private Label label_2;

    @FXML
    private Label label_repeat;

    @FXML
    void doEnter() {
        String userAnswer = textField.getText();
        if(!userAnswer.isEmpty()){
            try {
                Integer.parseInt(userAnswer);
                textField.setText("");
            }
            catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Ошибка. Введите число!");
                alert.show();
                textField.setText("");
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Поле пустое!");
            alert.show();
        }
        int number = Integer.parseInt(userAnswer);
        if(number  == randomNumber) {
            label_2.setText("Победа!");
            endGame();

        }
        else if (number > randomNumber) {
            label_2.setText("Загаднное число меньше!\nОсталось попыток: " + (maxCount - tryCount));
            tryCount++;
        }
        else if (number < randomNumber) {
            label_2.setText("Загаднное число больше!\nОсталось попыток: " + (maxCount - tryCount));
            tryCount++;
        }

        if(tryCount == maxCount) {
            label_2.setText("Попытки кончились вы проиграли!\nПравильный ответ: " + randomNumber);
            endGame();
        }
    }

    @FXML
    void click_yes() {
        tryCount = 1;
        randomNumber = random.nextInt(10) + 1;
        label_2.setText("");
        buttonEnter.setVisible(true);
        label_repeat.setVisible(false);
        button_no.setVisible(false);
        button_yes.setVisible(false);
    }

    @FXML
    void click_no() {
        System.exit(1);
    }

    void endGame(){
        button_no.setVisible(true);
        button_yes.setVisible(true);
        label_repeat.setVisible(true);
        buttonEnter.setVisible(false);
    }

}
