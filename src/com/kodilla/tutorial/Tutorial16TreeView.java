package com.kodilla.tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tutorial16TreeView extends Application {

    Stage window;
    Scene scene;
    Button button;
    TreeView<String> tree;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Input se coś");

        button = new Button("click me");
        TreeItem<String> root, przemo, agusia;

        //Root
        root = new TreeItem<>();
        root.setExpanded(true);

        //przemo
        przemo = makeBranch("Przemo", root);
        makeBranch("gaming", przemo);
        makeBranch("spanie", przemo);
        makeBranch("czytanie", przemo);
        //agusia
        agusia = makeBranch("Agusia", root);
        makeBranch("spa", agusia);
        makeBranch("troskliwość", agusia);
        makeBranch("troska", agusia);

        //Tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)->{
            if (newValue != null)
                System.out.println(newValue.getValue());
        });

        //Layout
        VBox layout = new VBox();
        layout.setPadding(new Insets(25, 25, 25, 25));
        layout.getChildren().add(tree);

        Scene scene = new Scene(layout, 500, 500);
        window.setScene(scene);
        window.show();
    }

    public TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
}
