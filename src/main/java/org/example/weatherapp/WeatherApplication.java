package org.example.weatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class WeatherApplication extends Application {

    Image pic = new Image(Objects.requireNonNull(getClass().getResourceAsStream("cat.jpg")));

    DatabaseService databaseService = new DatabaseService();
    String fxmlFile;

    @Override
    public void start(Stage stage) throws IOException {

        fxmlFile = databaseService.hasCityRecord() ? "MainScene.fxml" : "CitySearchScene.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);

        stage.setTitle("Погода");
        stage.getIcons().add(pic);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}