package data;

import java.util.HashMap;
import java.util.Map;

import logic.Candidate;

public class UserDatabase {
    private static Map<String, String> users = new HashMap<>();
    private static Map<String, Candidate> selectedCandidates = new HashMap<>();
    private static Map<String, Candidate> userVotes = new HashMap<>();

    public static boolean register(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, password);
            return true;
        }
        return false;
    }

    public static boolean login(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
    
    public static void setSelectedCandidate(String username, Candidate candidates) {
        selectedCandidates.put(username, candidates);
        userVotes.put(username, candidates);
        System.out.print(", check" + username + " - " + candidates);

    }
    
    public static Candidate getSelectedCandidate(String username) {
        return selectedCandidates.get(username);
    }
    
    public static void printDatabase() {      
    	 for (Map.Entry<String, String> entry : users.entrySet()) {
    	        String username = entry.getKey();
    	        String password = entry.getValue();
    	        Candidate selectedCandidate = selectedCandidates.get(username);
    	        System.out.print(", Username: " + username + ", Password: " + password);
    	        if (selectedCandidate != null) {
    	            System.out.println(", Selected Candidate Name: " + " : ");
    	            for (Map.Entry<String, Candidate> voteEntry : userVotes.entrySet()) {
    	                if (voteEntry.getKey().equals(username)) {
    	                    System.out.print(voteEntry.getValue().getName() + ", ");
    	                }
    	            }
    	        } else {
    	            System.out.println(", No selected candidate");
    	        }
    	    }
    	}       
    }

