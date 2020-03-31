package com.kodilla.tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Tutorial28Properties extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("thenewboston");

        Tutorial28Persona przemo = new Tutorial28Persona();
        przemo.firstNameProperty().addListener((v, oldValue, newValue)->{
            System.out.println("Name changed to "+newValue);
            System.out.println("firstNameProperty():" + przemo.firstNameProperty());
            System.out.println("getFirstName():" + przemo.getFirstName());
        });

        button = new Button("Submit");
        button.setOnAction(e->przemo.setFirstName("Przemon"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }


}