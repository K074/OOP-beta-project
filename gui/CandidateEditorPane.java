package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.Candidate;
import data.PlayerType;
import data.UserDatabase;
import javafx.stage.Stage;


public class CandidateEditorPane extends VBox {
    private TextField nameField;
    private TextField typeField;

    public CandidateEditorPane() {
        Label titleLabel = new Label("Create a new candidate:");
        titleLabel.setStyle("-fx-font-weight: bold");

        Label nameLabel = new Label("Name:");
        nameField = new TextField();

        Label typeLabel = new Label("Type:");
        typeField = new TextField();

        Button addButton = new Button("Add Candidate");
        addButton.setOnAction(event -> addCandidate());

        setSpacing(10);
        setPadding(new Insets(10));
        setAlignment(Pos.CENTER);

        getChildren().addAll(
                titleLabel,
                new HBox(10, nameLabel, nameField),
                new HBox(10, typeLabel, typeField),
                addButton
        );
    }

    private void addCandidate() {
        String name = nameField.getText();
        String typeString = typeField.getText();

        if (!name.isEmpty() && !typeString.isEmpty()) {
            PlayerType type = PlayerType.valueOf(typeString);
            Candidate newCandidate = new Candidate(name, type);
            Candidate.getCandidates().add(newCandidate);
            // Очищаємо поля після додавання кандидата
            nameField.clear();
            typeField.clear();
            
            VBox root = (VBox) getParent();
            Stage stage = (Stage) getScene().getWindow();
            Election election = new Election();
            election.showMainScreen(stage, "admin"); 
        }
    }
}

