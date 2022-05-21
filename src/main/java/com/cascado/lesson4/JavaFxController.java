package com.cascado.lesson4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class JavaFxController {

    @FXML
    public Button btnClick;
    @FXML
    public Label labelText;

    public void click(ActionEvent actionEvent) {
        System.out.println("Button clicked");
        labelText.setText("Hello JavaFx");
        btnClick.setText("Clicked");
        btnClick.setScaleX(2);
        btnClick.setScaleY(2);
    }
}
