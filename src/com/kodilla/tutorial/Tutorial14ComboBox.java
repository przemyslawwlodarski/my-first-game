package com.kodilla.tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tutorial14ComboBox extends Application {

    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Input se coś");

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Killer",
        "Killerów dwóch",
        "Diuna"
        );

        comboBox.setPromptText("Wybierz film");

        button = new Button ("click me");
//        button.setOnAction(e-> getChoice(choiceBox));
        button.setOnAction(e->printMovie());

        comboBox.setOnAction(e-> System.out.println("User wybrał: "+comboBox.getValue()));

        //Layout
        VBox layout = new VBox();
        layout.setPadding(new Insets( 25,325,25,25));
        layout.getChildren().addAll(comboBox, button);

        Scene scene = new Scene(layout, 500, 500);
        window.setScene(scene);
        window.show();
    }

    private void printMovie() {
        System.out.println(comboBox.getValue());
    }
}
