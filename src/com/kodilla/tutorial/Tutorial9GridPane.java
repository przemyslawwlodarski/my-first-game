package com.kodilla.tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Tutorial9GridPane extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("GridPane");

        GridPane newGrid = new GridPane();
        newGrid.setPadding(new Insets(50,50,50,50));
        newGrid.setVgap(10);
        newGrid.setHgap(125);

        //Name Label
        Label nameLabel = new Label("Username");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name Input
        TextField nameInput = new TextField("TXT na sztywno");
        GridPane.setConstraints(nameInput, 1,0);

        //Password Label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel,0,1);

        //Password Input
        TextField passInput = new TextField();
        passInput.setPromptText("Password");
        GridPane.setConstraints(passInput, 1,1);

        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1,2);

        newGrid.getChildren().addAll(nameLabel,nameInput, passInput, passLabel, loginButton);

        Scene scene = new Scene(newGrid, 500, 500);
        window.setScene(scene);
        window.show();
    }
}
