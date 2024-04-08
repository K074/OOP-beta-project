package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import logic.Candidate;

import java.util.List;

import data.UserDatabase;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

public class ResultsScreen {
    public static void show(Stage primaryStage, List<Candidate> candidates, String username, Candidate selectedCandidate) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        Label titleLabel = new Label("Election Results");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        VBox resultsBox = new VBox(10);
        resultsBox.setAlignment(Pos.CENTER);

        for (Candidate candidate : candidates) {
            Label candidateLabel = new Label(candidate.getName() + ": " + candidate.getVotes() + " votes");
            resultsBox.getChildren().add(candidateLabel);
        }

        Button loginButton = new Button("Go to Login Screen");
        loginButton.setOnAction(event -> {
//        	  Candidate selectedCandidate = UserDatabase.setSelectedCandidate(username, primaryStage);
              if (selectedCandidate != null) {
            	  UserDatabase.setSelectedCandidate(username, selectedCandidate);
                  System.out.println(username + " voted for: " + selectedCandidate.getName());
              } else {
                  System.out.println(username + " did not vote.");
              }
        	UserDatabase.printDatabase();
            LoginScreen loginScreen = new LoginScreen(primaryStage);
            primaryStage.setScene(new Scene(loginScreen, 400, 200));
            primaryStage.setTitle("Login");
            primaryStage.show();
        });

        root.getChildren().addAll(titleLabel, resultsBox, loginButton);

        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.setTitle("Election Results");
        primaryStage.show();
    }
}
