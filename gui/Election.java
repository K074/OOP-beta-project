package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;
import logic.Candidate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.UserDatabase;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;




public class Election extends Application {
    private List<Candidate> candidates;
    private Button submitButton;
    private Candidate selectedCandidate; 
    private Map<String, Candidate> userVotes = new HashMap<>();

    @Override
    public  void start(Stage primaryStage) {
    	
    	    	
    	 LoginScreen loginScreen = new LoginScreen(primaryStage);
    	 primaryStage.setScene(new Scene(loginScreen, 400, 200));
    	    primaryStage.setTitle("Login");
    	    primaryStage.show();
    	    
    	}
    	

    private void castVote(String username, Candidate candidate) {
    	UserDatabase.setSelectedCandidate(username, candidate);
        updateCandidateVotes();

    }
    
  
         
    private void updateCandidateVotes() {
      
//        for (Candidate candidate : candidates) {
//            candidate.resetVotes();
//        }
        
        for (Candidate candidate : candidates) {
            for (Map.Entry<String, Candidate> entry : userVotes.entrySet()) {
                if (entry.getValue() == candidate) {
                    candidate.incrementVotes(0);
                    
                }
            }
        }
    }

    
    public void showMainScreen(Stage primaryStage, String username) {     
    	candidates = Candidate.getCandidates();
       
    	  VBox playerPaneContainer = new VBox(10);
          for (Candidate candidate : Candidate.getCandidates()) {
              PlayerPane playerPane = new PlayerPane(candidate);
              playerPaneContainer.getChildren().add(playerPane);
          }

       
          submitButton = new Button("Vote");
          submitButton.setOnAction(event -> 

          {
              castVote(username, ((PlayerPane) playerPaneContainer.getChildren().get(0)).getCandidate());
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Success");
              alert.setHeaderText(null);
              alert.setContentText("Your vote has been cast successfully!");              
              alert.showAndWait();
              updateCandidateVotes();
              ResultsScreen.show(primaryStage, Candidate.getCandidates(), username, selectedCandidate);
          });
          
          
          
    
          HBox buttonPane = new HBox(submitButton);
          buttonPane.setAlignment(Pos.CENTER);

     
          VBox root = new VBox(10);
          root.setAlignment(Pos.CENTER);
          root.setPadding(new Insets(20));
          root.getChildren().addAll(playerPaneContainer, buttonPane);
       
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setTitle("Election Voting");
        primaryStage.show();
        
    
        Candidate previousVote = userVotes.get(username);
        if (previousVote != null) {
            // nabuduce
        }
    }
    
    
    
public static void main(String[] args) {
    launch(args);
}
}










