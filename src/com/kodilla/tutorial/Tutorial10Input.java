package com.kodilla.tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tutorial10Input extends Application {

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

        TextField txtInput = new TextField();
        button = new Button ("click me");
//        button.setOnAction(e-> System.out.println(txtInput.getText()));
        button.setOnAction(e-> isInt(txtInput, txtInput.getText()));

        //Layout
        VBox layout = new VBox();
        layout.setPadding(new Insets( 25,325,25,25));
        layout.getChildren().addAll(txtInput, button);

        Scene scene = new Scene(layout, 500, 500);
        window.setScene(scene);
        window.show();
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
