package gui;

import data.UserDatabase;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import logic.Candidate;


public class LoginScreen extends GridPane {
	private GridPane gridPane;
    private TextField usernameField;
    private PasswordField passwordField;
    private Candidate selectedCandidate;
    private Election election;
    
    private UserDatabase userDatabase = UserDatabase.getInstance();

    public LoginScreen(Stage primaryStage) {
    
    	 gridPane = new GridPane();
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(20));

        
        
        Label usernameLabel = new Label("Username:");
        usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");

        
        
        add(usernameLabel, 0, 0);
        add(usernameField, 1, 0);
        add(passwordLabel, 0, 1);
        add(passwordField, 1, 1);
        add(loginButton, 1, 2);

        usernameLabel.getStyleClass().add("label");
        usernameField.getStyleClass().add("text-field");
        passwordLabel.getStyleClass().add("label");
        passwordField.getStyleClass().add("text-field");
        loginButton.getStyleClass().add("button");
        registerButton.getStyleClass().add("button");
        System.out.println("userDatabase "+ userDatabase);

        
       
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

         
            if (UserDatabase.login(username, password)) {
            	 Candidate previousVote = UserDatabase.getSelectedCandidate(username);
            	
            	Election election = new Election();
            	UserDatabase.setSelectedCandidate(username, selectedCandidate);
                election.showMainScreen(primaryStage, username);
                
                if (previousVote != null) {
                	
//                    election.setSelectedCandidate(previousVote);
                }
                
            	 
            } else {
            	 clearErrorLabels();
            	 Alert alert = new Alert(Alert.AlertType.ERROR);
            	 alert.setTitle("Login Error");
                 alert.setHeaderText(null);
                 alert.setContentText("Invalid username or password");
                 alert.showAndWait();
                passwordField.clear();
            }          
        });
        
        registerButton.setOnAction(event -> {
        	
            RegisterScreen registerScreen = new RegisterScreen(primaryStage);
            primaryStage.getScene().setRoot(registerScreen);
        });
        
        add(registerButton, 1, 3);
       
    }
    
    private void clearErrorLabels() {
        getChildren().removeIf(node -> node.getStyleClass().contains("error-label"));
    }
}


