package com.kodilla.finalGame;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class Runner extends Application {
    private Stage window;
    private Button startGameButtonEasyMode, startGameButtonHardMode, exitGameButton;
    private Button buyASoldierButton, endTurnButton;
    private Scene scene1, scene2;
    private HBox layout1;
    private GridPane layout2;
    private TextField buyXInput, buyYInput;
    private ComboBox<String> soldierType;
    private Game game;
    private Board board;
    private IntegerProperty whiteMoney, whiteIncome, whiteUpkeep, whiteRealIncome;
    private IntegerProperty blackMoney, blackIncome, blackUpkeep, blackRealIncome;
    private StringProperty currentPlayer;
    private Label whiteAmountOfMoneyText, whiteAmountOfIncomeText, whiteAmountOfIncomeNextTurnText;
    private Label whiteAmountOfMoney, whiteAmountOfIncome, whiteAmountOfUpkeep, whiteRealIncomeNextTurn;
    private Label blackAmountOfMoney, blackAmountOfIncome, blackAmountOfUpkeep, blackRealIncomeNextTurn;
    private Label whitePlayer, blackPlayer, player, currentPlayerLabel;


    private Image backgroundStart = new Image("file:resources/Medieval-Battle.png");
    private Media media = new Media(new File("resources/theme.wav").toURI().toString());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Scene 1
        window = primaryStage;
        window.setTitle("Lets the war begin");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        //Scene 1 Buttons
        startGameButtonEasyMode = new Button("New Game\nEasy Mode");
        startGameButtonEasyMode.setOnAction(e -> {
            window.setScene(scene2);
            Board board = new Board();
            Game game = new Game(board, layout2);
            game.initGame();
            game.displayBoard();
            calculateAll();
        });
        startGameButtonHardMode = new Button("New Game\nHard Mode");
        startGameButtonHardMode.setOnAction(e -> {
            window.setScene(scene2);
            Board board = new Board();
            Game game = new Game(board, layout2);
            game.initGame();
            game.displayBoard();
            whiteMoney.set(50);
            calculateAll();
        });
        exitGameButton = new Button("Exit Game");
        exitGameButton.setOnAction(e -> closeProgram());

        //Scene 1 Background
        BackgroundSize backgroundSize = new BackgroundSize(620, 330, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(backgroundStart, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        //Scene 1 Layout
        layout1 = new HBox();
        layout1.getChildren().addAll(startGameButtonEasyMode, startGameButtonHardMode, exitGameButton);
        layout1.setAlignment(Pos.TOP_CENTER);
        layout1.setBackground(background);
        layout1.setSpacing(20);

        //Scene 1 Music
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        scene1 = new Scene(layout1, 650, 450);
        primaryStage.setScene(scene1);
        primaryStage.show();

        //Scene 2 Layout
        layout2 = new GridPane();
        layout2.setPadding(new Insets(25, 25, 25, 25));
        layout2.setHgap(10);
        layout2.setVgap(10);

        scene2 = new Scene(layout2, 1600, 900);

        //Scene 2 ComboBox
        soldierType = new ComboBox<>();
        soldierType.setPromptText("Choose soldier type");
        soldierType.getItems().addAll(
                "White Soldier",
                "White Queen",
                "White King",
                "Black Soldier",
                "Black Queen",
                "Black King"
        );
        layout2.add(soldierType, 11, 0);


        //Properties White
        whiteMoney = new SimpleIntegerProperty(100);
        whiteMoney.addListener((v, OldValue, newValue) -> System.out.println(newValue));
        whiteIncome = new SimpleIntegerProperty(0);
        whiteIncome.addListener((v, OldValue, newValue) -> game.calculateIncomeWhite());
        whiteUpkeep = new SimpleIntegerProperty(0);
        whiteUpkeep.addListener((v, oldValue, newValue) -> game.calculateUpkeepWhite());
        whiteRealIncome = new SimpleIntegerProperty(0);
        whiteRealIncome.addListener((v, oldValue, newValue) -> game.calculateRealIncomeWhite());

        //Properties Black
        blackMoney = new SimpleIntegerProperty(100);
        blackMoney.addListener((v, OldValue, newValue) -> System.out.println(newValue));
        blackIncome = new SimpleIntegerProperty(0);
        blackIncome.addListener((v, OldValue, newValue) -> game.calculateIncomeBlack());
        blackUpkeep = new SimpleIntegerProperty(0);
        blackUpkeep.addListener((v, oldValue, newValue) -> game.calculateUpkeepBlack());
        blackRealIncome = new SimpleIntegerProperty(0);
        blackRealIncome.addListener((v, oldValue, newValue) -> game.calculateRealIncomeBlack());

        //Properties
        currentPlayer = new SimpleStringProperty("White");
        currentPlayer.addListener((v, oldValue, newValue)-> System.out.println ("New Turn"));

        //Scene 2 Text Inputs
        buyXInput = new TextField();
        buyXInput.setPromptText("X value");
        buyXInput.setOnAction(e -> isInt(buyXInput));

        buyYInput = new TextField();
        buyYInput.setPromptText("Y value");
        buyXInput.setOnAction(e -> isInt(buyYInput));

        layout2.add(buyXInput, 12, 0);
        layout2.add(buyYInput, 13, 0);

        //Scene 2 Buttons
        buyASoldierButton = new Button("Buy a Soldier");
        buyASoldierButton.setOnAction(e -> {
            boolean x = isInt(buyXInput);
            boolean y = isInt(buyYInput);
            if (x && y)
                buyASoldier();
        });
        layout2.add(buyASoldierButton, 14, 0);

        endTurnButton = new Button("End Turn");
        endTurnButton.setOnAction(e -> endTurn());
        layout2.add(endTurnButton, 11, 7);

        //Labels
        whiteAmountOfMoneyText = new Label("Your money: ");
        layout2.add(whiteAmountOfMoneyText, 11, 3);
        whiteAmountOfIncomeText = new Label("Your income in next turn is:");
        layout2.add(whiteAmountOfIncomeText, 11, 4);
        whiteAmountOfIncomeText = new Label("Your upkeep at the \nbeginning of new round is:");
        layout2.add(whiteAmountOfIncomeText, 11, 5);
        whiteAmountOfIncomeNextTurnText = new Label("You will earn:");
        layout2.add(whiteAmountOfIncomeNextTurnText, 11, 6);
        whitePlayer = new Label("White Player");
        layout2.add(whitePlayer, 12, 2);
        blackPlayer = new Label("Black Payer");
        layout2.add(blackPlayer, 13, 2);
        player = new Label ("Current Player:");
        layout2.add(player, 11, 1);

        //Labels Properties White
        whiteAmountOfMoney = new Label();
        whiteAmountOfMoney.textProperty().bind(whiteMoney.asString());
        layout2.add(whiteAmountOfMoney, 12, 3);

        whiteAmountOfIncome = new Label();
        whiteAmountOfIncome.textProperty().bind(whiteIncome.asString());
        layout2.add(whiteAmountOfIncome, 12, 4);

        whiteAmountOfUpkeep = new Label();
        whiteAmountOfUpkeep.textProperty().bind(whiteUpkeep.asString());
        layout2.add(whiteAmountOfUpkeep, 12, 5);

        whiteRealIncomeNextTurn = new Label();
        whiteRealIncomeNextTurn.textProperty().bind(whiteRealIncome.asString());
        layout2.add(whiteRealIncomeNextTurn, 12, 6);

        //Labels Properties Black
        blackAmountOfMoney = new Label();
        blackAmountOfMoney.textProperty().bind(blackMoney.asString());
        layout2.add(blackAmountOfMoney, 13, 3);

        blackAmountOfIncome = new Label();
        blackAmountOfIncome.textProperty().bind(blackIncome.asString());
        layout2.add(blackAmountOfIncome, 13, 4);

        blackAmountOfUpkeep = new Label();
        blackAmountOfUpkeep.textProperty().bind(blackUpkeep.asString());
        layout2.add(blackAmountOfUpkeep, 13, 5);

        blackRealIncomeNextTurn = new Label();
        blackRealIncomeNextTurn.textProperty().bind(blackRealIncome.asString());
        layout2.add(blackRealIncomeNextTurn, 13, 6);

        currentPlayerLabel = new Label();
        currentPlayerLabel.textProperty().bind(currentPlayer);
        layout2.add(currentPlayerLabel, 12,1);

        //Setup
        board = new Board();
        game = new Game(board, layout2);
        game.initGame();
        game.displayBoard();
        calculateAll();

        //Clicks
        layout2.setOnMouseClicked(e -> {
            System.out.println(e.getX() + ", " + e.getY());
            int x = (int) (e.getX() - 25) / 85;
            int y = (int) (e.getY() - 25) / 85;
            System.out.println(x + ", " + y);
            if ((x <= 9) && (y <= 9))
                game.doClick(x, y);
            calculateAll();
        });
    }

    private void endTurn() {
        // if white
        if (currentPlayer.getValue().equals("White")) {
            if ((whiteMoney.getValue() + whiteRealIncome.getValue() < 0)) {
                game.whiteAllDie();
                whiteMoney.set(0);
                GameAlertBoxInt.display("Bankruptcy", "All your men have left you");
            }
            currentPlayer.setValue("Black");
            game.displayBoard();
            board.blackCanMove();
            board.whiteCanNotMove();
            calculateAll();
            blackMoney.set(blackMoney.getValue() + blackRealIncome.getValue());
            if (whiteIncome.getValue()>=80){
                GameAlertBoxInt.display("Congratulations", "You are winner");
                window.setScene(scene1);
            }
        } else{
            if ((blackMoney.getValue() + blackRealIncome.getValue() < 0)) {
                game.blackAllDie();
                whiteMoney.set(0);
                GameAlertBoxInt.display("Bankruptcy", "All your men have left you");
            }
            currentPlayer.setValue("White");
            game.displayBoard();
            board.whiteCanMove();
            board.blackCanNotMove();
            calculateAll();
            whiteMoney.set(whiteMoney.getValue() + whiteRealIncome.getValue());
            if (blackIncome.getValue()>=80) {
                GameAlertBoxInt.display("Congratulations", "You are winner");
                window.setScene(scene1);
            }
        }
    }

    private void closeProgram() {
        boolean answer = GameExit.display("Confirm Box", "Do you want to exit a game?");
        if (answer)
            window.close();
    }

    private void buyASoldier() {
        try {
            String soldier = soldierType.getValue();
            GameElement gameElement = board.getElement(Integer.parseInt(buyXInput.getText()) - 1, Integer.parseInt(buyYInput.getText()) - 1);
            String player = currentPlayer.getValue();
            if (soldier.equals("White Soldier") && (whiteMoney.getValue() - 5 >= 0)) {
                if ((gameElement.getColor()==PlayerColor.WHITE)&&(gameElement instanceof None)&&(player.equals("White"))) {
                    game.setWhiteSoldier(Integer.parseInt(buyXInput.getText()) - 1, Integer.parseInt(buyYInput.getText()) - 1);
                    game.displayBoard();
                    whiteMoney.set(whiteMoney.getValue() - 5);
                }else
                    GameAlertBoxInt.display("Error", "Set your pawn on your territory, or wait for your turn");
            } else if (soldier.equals("White Queen") && (whiteMoney.getValue() - 10 >= 0)) {
                if((gameElement.getColor()==PlayerColor.WHITE)&&(gameElement instanceof None)&&(player.equals("White"))) {
                    game.setWhiteQueen(Integer.parseInt(buyXInput.getText()) - 1, Integer.parseInt(buyYInput.getText()) - 1);
                    game.displayBoard();
                    whiteMoney.set(whiteMoney.getValue() - 10);
                }else
                    GameAlertBoxInt.display("Error", "Set your pawn on your territory, or wait for your turn");
            } else if (soldier.equals("White King") && (whiteMoney.getValue() - 25 >= 0)) {
                if((gameElement.getColor()==PlayerColor.WHITE)&&(gameElement instanceof None)&&(player.equals("White"))) {
                    game.setWhiteKing(Integer.parseInt(buyXInput.getText()) - 1, Integer.parseInt(buyYInput.getText()) - 1);
                    game.displayBoard();
                    whiteMoney.set(whiteMoney.getValue() - 25);
                }else
                    GameAlertBoxInt.display("Error", "Set your pawn on your territory, or wait for your turn");
            } else if ((soldier.equals("Black Soldier"))&& (blackMoney.getValue() - 5 >= 0)) {
                if((gameElement.getColor()==PlayerColor.BLACK)&&(gameElement instanceof None)&&(player.equals("Black"))) {
                    game.setBlackSoldier(Integer.parseInt(buyXInput.getText()) - 1, Integer.parseInt(buyYInput.getText()) - 1);
                    game.displayBoard();
                    blackMoney.set(blackMoney.getValue() - 5);
                }else
                    GameAlertBoxInt.display("Error", "Set your pawn on your territory, or wait for your turn");
            } else if ((soldier.equals("Black Queen")) && (blackMoney.getValue() - 10 >= 0)) {
                if((gameElement.getColor()==PlayerColor.BLACK)&&(gameElement instanceof None)&&(player.equals("Black"))) {
                    game.setBlackQueen(Integer.parseInt(buyXInput.getText()) - 1, Integer.parseInt(buyYInput.getText()) - 1);
                    game.displayBoard();
                    blackMoney.set(blackMoney.getValue() - 10);
                }else
                    GameAlertBoxInt.display("Error", "Set your pawn on your territory, or wait for your turn");
            } else if ((soldier.equals("Black King")) && (whiteMoney.getValue() - 25 >= 0)){
                if((gameElement.getColor()==PlayerColor.BLACK)&&(gameElement instanceof None)&&(player.equals("Black"))) {
                    game.setBlackKing(Integer.parseInt(buyXInput.getText()) - 1, Integer.parseInt(buyYInput.getText()) - 1);
                    game.displayBoard();
                    blackMoney.set(blackMoney.getValue() - 25);
                }else
                    GameAlertBoxInt.display("Error", "Set your pawn on your territory, or wait for your turn");
            } else {
                GameAlertBoxInt.display("Error", "You don't have enough money");
            }
            calculateAll();
        } catch (Exception e) {
            GameAlertBoxInt.display("Error", "Please select a type of soldier and choose coordinates between 1 and 10");
        }
    }

    private boolean isInt(TextField input) {
        try {
            int x = Integer.parseInt(input.getText());
            if (x >= 1)
                return true;
            else {
                GameAlertBoxInt.display("Error", "Please enter a number greater than 1");
                return false;
            }

        } catch (NumberFormatException e) {
            return false;
        }
    }
    private void calculateAll(){
        whiteIncome.set(game.calculateIncomeWhite());
        whiteUpkeep.set(game.calculateUpkeepWhite());
        whiteRealIncome.set(game.calculateRealIncomeWhite());
        blackIncome.set(game.calculateIncomeBlack());
        blackUpkeep.set(game.calculateUpkeepBlack());
        blackRealIncome.set(game.calculateRealIncomeBlack());
    }
}
