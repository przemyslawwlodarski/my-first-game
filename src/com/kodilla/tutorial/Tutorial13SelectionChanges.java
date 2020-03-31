package com.kodilla.tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tutorial13SelectionChanges extends Application {

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

        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        //getItems
        choiceBox.getItems().add("Apples");
        choiceBox.getItems().add("Bananas");
        choiceBox.getItems().add("Plum");
        choiceBox.getItems().addAll("Strawberry", "Bacon", "Sugar");
        //Set a default Value
        choiceBox.setValue("Apples");

        choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue)-> System.out.println(newValue) );

        button = new Button ("click me");
        button.setOnAction(e-> getChoice(choiceBox));

        //Layout
        VBox layout = new VBox();
        layout.setPadding(new Insets( 25,325,25,25));
        layout.getChildren().addAll(choiceBox, button);

        Scene scene = new Scene(layout, 500, 500);
        window.setScene(scene);
        window.show();
    }

    private void getChoice(ChoiceBox<String> choiceBox) {
        String food = choiceBox.getValue();
        System.out.println(food);
    }
}
