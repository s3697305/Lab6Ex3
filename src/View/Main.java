package View;

import Model.BtDealHandler;
import Model.Ex3cards;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {
    static String cardNumber1 = "file:src/cards/" + Integer.toString(Ex3cards.pickedCards[0] + 1) + ".png";
    static String cardNumber2 = "file:src/cards/" + Integer.toString(Ex3cards.pickedCards[1] + 1) + ".png";
    static String cardNumber3 = "file:src/cards/" + Integer.toString(Ex3cards.pickedCards[2] + 1) + ".png";

    @Override
    public void start(Stage primaryStage) throws Exception{

        Ex3cards.getRandomCards();
        String cardNumber1 = "file:src/cards/" + Integer.toString(Ex3cards.pickedCards[0] + 1) + ".png";
        String cardNumber2 = "file:src/cards/" + Integer.toString(Ex3cards.pickedCards[1] + 1) + ".png";
        String cardNumber3 = "file:src/cards/" + Integer.toString(Ex3cards.pickedCards[2] + 1) + ".png";

        ImageView card1 = new ImageView(cardNumber1);
        card1.setFitHeight(300);
        card1.setPreserveRatio(true);


        ImageView card2 = new ImageView(cardNumber2);
        card2.setFitHeight(300);
        card2.setPreserveRatio(true);

        ImageView card3 = new ImageView(cardNumber3);
        card3.setFitHeight(300);
        card3.setPreserveRatio(true);

        Button dealButton = new Button("Deal");
        dealButton.setPrefHeight(100);
        dealButton.setPrefWidth(310);
        dealButton.setOnAction(new BtDealHandler());


        Button exitButton = new Button("Exit");
        exitButton.setPrefHeight(100);
        exitButton.setPrefWidth(310);



        HBox upperPane = new HBox();
        upperPane.getChildren().add(card1);
        upperPane.getChildren().add(card2);
        upperPane.getChildren().add(card3);

        HBox lowerPane = new HBox();
        lowerPane.getChildren().add(dealButton);
        lowerPane.getChildren().add(exitButton);

        VBox rootPane = new VBox();
        rootPane.getChildren().addAll(upperPane, lowerPane);


        Scene scene = new Scene(rootPane, 620, 400);
        //scene.widthProperty().bind();
        primaryStage.setTitle("Random Cards");
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
