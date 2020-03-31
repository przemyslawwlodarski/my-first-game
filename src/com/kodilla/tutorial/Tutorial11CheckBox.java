package com.kodilla.tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tutorial11CheckBox extends Application {

    Stage window;
    Scene scene;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Input se coś");

        CheckBox checkBox1 = new CheckBox("podwójny ser");
        CheckBox checkBox2 = new CheckBox("oliwki");
        checkBox2.setSelected(true);

        button = new Button ("click me");
        button.setOnAction(e-> handleCheckBox(checkBox1, checkBox2));

        //Layout
        VBox layout = new VBox();
        layout.setPadding(new Insets( 25,325,25,25));
        layout.getChildren().addAll(checkBox1, checkBox2, button);

        Scene scene = new Scene(layout, 500, 500);
        window.setScene(scene);
        window.show();
    }

    private void handleCheckBox(CheckBox checkBox1, CheckBox checkBox2) {
        String orderSummary = "User zamówił:\n";
        if (checkBox1.isSelected()){
            orderSummary += "podwójny ser\n";
        }
        if (checkBox2.isSelected()){
            orderSummary += "oliwki\n";
        }
        System.out.println(orderSummary);
    }

    //Validate age
    private boolean isInt(TextField input, String message){
        try{
            int age = Integer.parseInt(input.getText());
            System.out.println("User is: " + age);
            return true;
        }catch(NumberFormatException e){
            System.out.println("Error: " + message + " is not a number");
            return false;
        }
    }
}
