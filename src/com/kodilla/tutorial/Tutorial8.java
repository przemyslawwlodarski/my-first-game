package com.kodilla.tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tutorial8 extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Title of the Window");

        Button buttonA = new Button("Opcja 1");
        Button buttonB = new Button("Opcja 2");
        Button buttonC = new Button("Opcja 3");

        HBox topMenu = new HBox();
        topMenu.getChildren().addAll(buttonA, buttonB, buttonC);

        Button buttonD = new Button("Drzewo 1");
        Button buttonE = new Button("Drzewo 2");
        Button buttonF = new Button("Drzewo 3");

        VBox leftMenu = new VBox();
        leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);
        Scene scene = new Scene(borderPane, 500, 500);
        window.setScene(scene);
        window.show();
    }
}
