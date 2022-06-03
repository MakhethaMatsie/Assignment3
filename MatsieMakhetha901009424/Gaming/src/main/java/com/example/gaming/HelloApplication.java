package com.example.gaming;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;

import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        AnchorPane root = new AnchorPane();

        Scene scene = new Scene(root, 700, 500);
        stage.setTitle("Aircraft control game");
        stage.setScene(scene);
        stage.show();

        Image airplane = new Image("airplane.png");
        ImageView airplanev = new ImageView(airplane);
        airplanev.setFitWidth(100);
        airplanev.setFitHeight(50);
        airplanev.setLayoutX(0);
        airplanev.setLayoutY(80);

        BackgroundImage background = new BackgroundImage(new Image("lesotho.jpg",800,700,false,true), BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setBackground(new Background(background));

        ImageView view1 = Control1(scene);
        ImageView view2 = Control2(scene);
        ImageView view3 = Control3(scene);
        ImageView view4 = Control4(scene);
        ImageView view5 = fcoin(scene);
        ImageView view6 = scoin(scene);

        label.setLayoutX(570);
        label.setLayoutY(2);
        label.setStyle(
                "-fx-font-size: 20;"
        );

        AnimationTimer crash = new AnimationTimer() {
            @Override
            public void handle(long l) {
                checkHit(airplanev,view1, stage);
                checkHit(airplanev,view2, stage);
                checkHit(airplanev,view3, stage);
                checkHit(airplanev,view4, stage);
                getCoin(airplanev,view5);
                getCoin(airplanev,view6);
            }
        };
        crash.start();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.UP) {
                    airplanev.setLayoutY(airplanev.getLayoutY() - 12);
                }
                 else if (keyEvent.getCode() == KeyCode.LEFT) {
                        airplanev.setLayoutX(airplanev.getLayoutX()-12);
                    }
                 else if (keyEvent.getCode() == KeyCode.RIGHT) {
                        airplanev.setLayoutX(airplanev.getLayoutX()+12);
                    }
                 else if (keyEvent.getCode() == KeyCode.DOWN) {
                    airplanev.setLayoutY(airplanev.getLayoutY()+12);
                }

            }
        });
        root.getChildren().addAll(airplanev,view1, view2, view3, view4, view5, view6, label);
    }
    Label label = new Label();
    public void checkHit(ImageView airplane, ImageView show1, Stage stage){
        if(airplane.getBoundsInParent().intersects(show1.getBoundsInParent())){
            System.out.println("Oops, You failed");
            Image img = new Image("failed.jpg");
            airplane.setImage(img);
            PauseTransition hold = new PauseTransition(Duration.millis(3000));
            hold.setOnFinished(event -> stage.close());
            hold.play();
        }

    }
    private int score = 1;
    public int getCoin(ImageView planeView, ImageView view5) {
        if (planeView.getBoundsInParent().intersects(view5.getBoundsInParent())) {
            score = score+ 1;
            label.setText("Score = "+score);
            view5.setImage(null);

        }
        else{
            view5.setImage(new Image("coin.png"));
        }
        return score;
    }
    private ImageView Control1(Scene scene){
        Image firstCloud = new Image("cloud.png");
        ImageView cloudView = new ImageView(firstCloud);

        cloudView.setFitHeight(60);
        cloudView.setFitWidth(100);
        cloudView.setX(700);
        cloudView.setY(40);

        TranslateTransition transition = new TranslateTransition(Duration.millis(6000),cloudView);
        transition.setByX(-1200);
        transition.setCycleCount(Integer.MAX_VALUE);
        transition.play();

        return cloudView;
    }
    private ImageView Control2(Scene scene){
        Image secondCloud = new Image("cloud.png");
        ImageView cloudView = new ImageView(secondCloud);

        cloudView.setFitHeight(60);
        cloudView.setFitWidth(100);
        cloudView.setX(800);
        cloudView.setY(200);

        TranslateTransition transition = new TranslateTransition(Duration.millis(7000),cloudView);
        transition.setByX(-1200);
        transition.setCycleCount(Integer.MAX_VALUE);
        transition.play();

        return cloudView;
    }
    private ImageView Control3(Scene scene){
        Image thirdCloud = new Image("cloud.png");
        ImageView cloudView = new ImageView(thirdCloud);

        cloudView.setFitHeight(60);
        cloudView.setFitWidth(100);
        cloudView.setX(1100);
        cloudView.setY(120);

        TranslateTransition transition = new TranslateTransition(Duration.millis(6500),cloudView);
        transition.setByX(-1200);
        transition.setCycleCount(Integer.MAX_VALUE);
        transition.play();

        return cloudView;
    }
    private ImageView Control4(Scene scene){
        Image forthCloud = new Image("cloud.png");
        ImageView cloudView = new ImageView(forthCloud);

        cloudView.setFitHeight(60);
        cloudView.setFitWidth(100);
        cloudView.setX(1100);
        cloudView.setY(350);

        TranslateTransition transition = new TranslateTransition(Duration.millis(4800),cloudView);
        transition.setByX(-1200);
        transition.setCycleCount(Integer.MAX_VALUE);
        transition.play();

        return cloudView;
    }
    public ImageView fcoin(Scene scene){
        Image coin = new Image("coin.png");
        ImageView coinView = new ImageView(coin);

        coinView.setFitHeight(40);
        coinView.setFitWidth(40);
        coinView.setX(1100);
        coinView.setY(40);

        TranslateTransition transition = new TranslateTransition(Duration.millis(5500),coinView);
        transition.setByX(-1200);
        transition.setCycleCount(Integer.MAX_VALUE);
        transition.play();

        return coinView;
    }
    public ImageView scoin(Scene scene){
        Image coin = new Image("coin.png");
        ImageView coinView = new ImageView(coin);

        coinView.setFitHeight(40);
        coinView.setFitWidth(40);
        coinView.setX(1100);
        coinView.setY(260);

        TranslateTransition transition = new TranslateTransition(Duration.millis(5500),coinView);
        transition.setByX(-1200);
        transition.setCycleCount(Integer.MAX_VALUE);
        transition.play();

        return coinView;
    }

    public static void main(String[] args) {
        launch();
    }
}