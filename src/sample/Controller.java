package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    private int currentNumber;
    private String currentOperation;
    @FXML
    private TextField displayField;

    @FXML
    private TextField textField2;

    @FXML
    private void handleDigitAction(ActionEvent event){

        String digit = ((Button) event.getSource()).getText();
        String oldText = displayField.getText();
        String newText = oldText + digit;
        displayField.setText(newText);
    }

    @FXML
    private void handleOperation(ActionEvent event) {
        String currentText = displayField.getText();
        currentNumber = Integer.parseInt(currentText);
        currentOperation = ((Button) event.getSource()).getText();
        textField2.setText("" +currentNumber + currentOperation.toString());
        displayField.setText("");
    }

    @FXML
    private void handleEqualOperation(ActionEvent event) {
        String newText = displayField.getText();
        int newNumber = Integer.parseInt(newText);
        textField2.appendText(""+newNumber);
        if(currentOperation.equals("+"))
        {
            currentNumber +=newNumber;
        }
        else if(currentOperation.equals("-"))
            currentNumber -=newNumber;
        else if(currentOperation.equals("*"))
            currentNumber *= newNumber;
        else if(currentOperation.equals("/"))
            currentNumber /=newNumber;

        displayField.setText(""+currentNumber);
    }


    @FXML
    private void handleClearAction(ActionEvent event) {
        displayField.clear();
        textField2.clear();
    }

}
