package com.kodilla.tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Tutorial21Menu extends Application {

    Stage window;
    Scene scene;
    BorderPane layout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Input se coś");

        //File Menu
        Menu fileMenu = new Menu("File");

        //Menu Items
        MenuItem newFile = new MenuItem("New...");
        newFile.setOnAction(e->System.out.println("Create a new File"));
        fileMenu.getItems().add(newFile);

        fileMenu.getItems().add(new MenuItem("New Project..."));
        fileMenu.getItems().add(new MenuItem("New Module..."));
        fileMenu.getItems().add(new MenuItem("Import Project.."));
        fileMenu.getItems().add(new MenuItem("Open Project..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit"));

        //EditMenu
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Copy"));
        editMenu.getItems().add(new SeparatorMenuItem());
        editMenu.getItems().add(new MenuItem("Paste"));

        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu);

        //Layout
        layout = new BorderPane();
        layout.setTop(menuBar);
        layout.getChildren().addAll();

        Scene scene = new Scene(layout, 700, 500);
        window.setScene(scene);
        window.show();
    }
}
