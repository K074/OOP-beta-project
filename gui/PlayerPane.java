package gui;

import data.UserDatabase;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.Candidate;
import javafx.scene.control.Label;
import logic.Skill;

public class PlayerPane extends VBox {
	private Candidate candidate;
    private Button voteButton;
    private Skill skill;
    
    public boolean isVoted() {
        return voteButton.isDisabled();
    }
    
    
    public PlayerPane(Candidate player) {
    	this.candidate = player;;
    	 this.skill = new Skill();

        voteButton = new Button("Vote for " + player.getName());
        voteButton.setOnAction(event -> voteForPlayer());
       

        setAlignment(Pos.CENTER);
        setSpacing(1);
        setPadding(new Insets(10));
        getChildren().addAll(
            createPlayerInfoPane(),
            voteButton
            
        );
        
        
        voteButton = new Button("abadon for " + player.getName());
        voteButton.setOnAction(event -> votenoPlayer());
       

        setAlignment(Pos.CENTER);
        setSpacing(1);
        setPadding(new Insets(10));
        getChildren().addAll(
           
            voteButton
            );
    }

    private HBox createPlayerInfoPane() {
    	Label nameLabel = new Label(candidate.getName());
    	System.out.println("Candidate name: " + candidate.getName());
        Label typeLabel = new Label(candidate.getType().toString());
       int votes = 0;
        Candidate selectedCandidate = UserDatabase.getSelectedCandidate(candidate.getName());
        if (selectedCandidate != null) {
//            votes = selectedCandidate.getVotes();
        }
        Label votesLabel = new Label("Votes: "  +  candidate.getVotes());
        
        HBox infoPane = new HBox(10);
        infoPane.setAlignment(Pos.CENTER);
        infoPane.getChildren().addAll(nameLabel, typeLabel, votesLabel);
        return infoPane;
    }

    private void voteForPlayer() {
    	 candidate.incrementVotes(1);
        voteButton.setText("Voted");
        voteButton.setDisable(true);
        skill.SkillCalculator();
    }
    
    private void votenoPlayer() {
   	 candidate.deincrementVotes(1);
       voteButton.setText("abadon");
       voteButton.setDisable(true);
       candidate.SkillCalculator();
   }
    
    public Candidate getCandidate() {
        return candidate;
    }
}
