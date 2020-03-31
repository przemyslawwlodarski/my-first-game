package com.kodilla.tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Tutorial7 extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Title of the Window");

        window.setOnCloseRequest(e-> {
            e.consume();
            closeProgram();
        });

        button = new Button("zamknij se");
        button.setOnAction(e-> closeProgram());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 400, 500);
        window.setScene(scene);
        window.show();
    }
    private void closeProgram(){
        boolean answer = Tutorial7ConfirmBox.display("potwierdź", "czy jesteś pewien?");
        if (answer)
            window.close();
    }
}
