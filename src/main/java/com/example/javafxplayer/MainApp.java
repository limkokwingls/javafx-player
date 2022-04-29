package com.example.javafxplayer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();
        String style = getClass().getResource("style.css").toExternalForm();

        String src = getClass().getResource("crushing_snakes.mp4").toExternalForm();
        Media media = new Media(src);
        MediaPlayer player = new MediaPlayer(media);
        MediaView mediaView = new MediaView();
        mediaView.setMediaPlayer(player);

        Label play = new Label("Play");
        Label stop = new Label("Stop");
        Label exit = new Label("Exit");
        exit.setId("exit");
        HBox hBox = new HBox(30, play, stop, exit);
        hBox.setId("player-controls");

        play.setOnMouseClicked(event -> {
            player.play();
        });
        stop.setOnMouseClicked(event -> {
            player.stop();
        });

        exit.setOnMouseClicked(event -> {
            Platform.exit();
        });

        root.getChildren().addAll(hBox, mediaView);

        Scene scene = new Scene(root, 600, 500);
        scene.getStylesheets().add(style);
        stage.setTitle("Multimedia Player");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}