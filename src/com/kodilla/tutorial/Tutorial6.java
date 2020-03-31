package com.kodilla.tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Tutorial6 extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Title of the Window");
        button = new Button("kliknij se");
        button.setOnAction(e->{
            boolean result = Tutorial6ConfirmBox.display("Jestęś pewien?", "zwariowałeś?");
            System.out.println(result);
        });
 
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 400, 500);
        window.setScene(scene);
        window.show();
    }
}
