package com.kodilla.finalGame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TestApplication extends Application {
    Stage window;
    Button button;

    private Image backgroundWhite = new Image("file:resources/backgroundWhite.png");

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Title of the Window");
        button = new Button();
        button.setText("move a soldier");

        Board board = new Board();
        board.setElement(2,5, new Soldier(PlayerColor.WHITE, true));
        System.out.println(board);

        button.setOnAction(e->{
            board.moveElement(2,5, 2,4);
            System.out.println(board);
        });

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(25,25,25,25));
        layout.setHgap(10);
        layout.setVgap(10);
        layout.add(new ImageView(backgroundWhite), 0, 0);
        layout.add(new ImageView(backgroundWhite), 1, 0);
        layout.add(new ImageView(backgroundWhite), 1, 1);
//        layout.add(new ImageView(backgroundWhite), 0, 1);

        Scene scene = new Scene(layout, 1000, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
