package com.kodilla.tutorial;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tutorial19EditTable extends Application {

    Stage window;
    Scene scene;
    Button addButton;
    Button deleteButton;
    TableView<Tutorial17Product> table;
    TextField nameInput, priceInput, quanityInput;


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

        //NameInput
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        //PriceInput
        priceInput = new TextField();
        priceInput.setPromptText("Price");
        priceInput.setMinWidth(100);

        //QuantityInput
        quanityInput = new TextField();
        quanityInput.setPromptText("Quantity");
        quanityInput.setMinWidth(100);

        addButton = new Button("Add new");
        addButton.setOnAction(e->addButtonClicked());
        deleteButton = new Button ("Delete old");
        deleteButton.setOnAction(e->deleteButtonClicked());


        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);


        //Layout
        HBox layout = new HBox();
        layout.setPadding(new Insets(25,25,25,25));
        layout.setSpacing(10);
        layout.getChildren().addAll(nameInput, priceInput, quanityInput, addButton, deleteButton);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, layout);

        Scene scene = new Scene(vBox, 700, 500);


        window.setScene(scene);
        window.show();
    }

    private void deleteButtonClicked() {
        ObservableList<Tutorial17Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();
        productSelected.forEach(allProducts::remove);
    }

    private void addButtonClicked() {
        Tutorial17Product product = new Tutorial17Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quanityInput.getText()));
        table.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        quanityInput.clear();
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
