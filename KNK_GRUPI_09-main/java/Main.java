package com.example.demo;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Locale;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application { //ndrysho emrin e main ne Onlineshop

    @Override
    public void start(Stage primaryStage) throws IOException, NoSuchAlgorithmException, SQLException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/views/LoginView.fxml")  //forma e loginit
        );

        Parent pane = loader.load();

        Scene scene = new Scene(pane, 640, 400);


    }

    public static void main(String[] args) {
        launch(args);
    }

}