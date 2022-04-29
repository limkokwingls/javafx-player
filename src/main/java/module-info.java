module com.example.javafxplayer {
    requires javafx.controls;
    requires javafx.media;


    opens com.example.javafxplayer to javafx.fxml;
    exports com.example.javafxplayer;
}