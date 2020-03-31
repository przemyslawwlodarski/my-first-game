package com.kodilla.tutorial;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tutorial18TableView extends Application {

    Stage window;
    Scene scene;
    Button button;
    TableView<Tutorial17Product> table;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Input se coś");

        //Name Column
        TableColumn<Tutorial17Product, String> nameColumn= new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));

        //PriceColumn
        TableColumn<Tutorial17Product, Double> priceColumn= new TableColumn<>("Price");
        priceColumn.setMinWidth(200);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));

        //QuantityColumn
        TableColumn<Tutorial17Product, Integer> quantityColumn= new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(200);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("Quantity"));

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        button = new Button("click me");
        //Layout
        VBox layout = new VBox();
        layout.getChildren().addAll(table);
        Scene scene = new Scene(layout, 500, 500);
        window.setScene(scene);
        window.show();
    }
    public ObservableList<Tutorial17Product> getProduct(){
        ObservableList<Tutorial17Product> products = FXCollections.observableArrayList();
        products.add(new Tutorial17Product("Ser1", 12.4, 4));
        products.add(new Tutorial17Product("Ser2", 12.4, 4));
        products.add(new Tutorial17Product("Ser3", 12.4, 4));
        products.add(new Tutorial17Product("Ser4", 12.4, 4));
        products.add(new Tutorial17Product("Ser5", 12.4, 4));
        return products;
    }
}
