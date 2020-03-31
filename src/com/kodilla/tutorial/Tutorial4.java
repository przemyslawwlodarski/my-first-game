package com.kodilla.tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tutorial4 extends Application {

    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Title of the Window");
        Label label1 = new Label("Witajcie w naszej bajce" );
        Button button1 = new Button("Przejdź do drugiej sceny");
        button1.setOnAction(e->window.setScene(scene2));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 300, 400);

        Button button2 = new Button("Wróć do pierwszej sceny");
        button2.setOnAction(e->window.setScene(scene1));

        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(button2);
        scene2 = new Scene(layout2, 600, 800);

        window.setScene(scene1);
        window.show();
    }
}
