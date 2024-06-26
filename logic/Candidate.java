package logic;

import data.PlayerType;

import java.util.ArrayList;
import java.util.List;

public class Candidate extends Skill {
    private String name;
    private PlayerType type;
    private int votes;
    private boolean voted;

    
    
    public Candidate(String name, PlayerType type) {
        this.name = name;
        this.type = type;
        this.votes = 0;
        this.voted = false;
    }

    public String getName() {
    	nickname = name;
        return name;
    }

    public PlayerType getType() {
    	graf += graf;
        return type;
    }

    public int getVotes() {
    	aim = (graf*2)/2;
        return votes;
    }
    
    public void resetVotes() {
//    	this.votes = 0;
        
    }
    
    public boolean isVoted() {
    	
        return voted;
    }
    
    public void incrementVotes(int amount) {
    	this.votes += amount;
        this.voted = true;
    }
    
    public void deincrementVotes(int amount) {
    	 if (this.votes >= 1) {
    		 this.votes -= amount;
    	 }
        this.voted = false;
    }
    
    public void SkillCalculator() {
    	 if (aim + movement + graf >= 10) {
       	  System.out.println("Skillfull");
         } else {
       	  System.out.println("Skillless");
         }
    	 
    }
    	 private static List<Candidate> candidates = new ArrayList<>();
    	    static {
    	        candidates.add(new Candidate("ML7", PlayerType.Overwatch));
    	        candidates.add(new Candidate("xQc", PlayerType.Overwatch));
    	        candidates.add(new Candidate("Valeza", PlayerType.Overwatch));
    	        candidates.add(new Candidate("marcella", PlayerType.Overwatch));
    	        candidates.add(new Candidate("s1mple", PlayerType.CS_2));
    	        candidates.add(new Candidate("b1t", PlayerType.CS_2));
    	        candidates.add(new Candidate("zywho", PlayerType.CS_2));
    	        candidates.add(new Candidate("carigan", PlayerType.CS_2));
    	        candidates.add(new Candidate("Tarik", PlayerType.Valorant));
    	        candidates.add(new Candidate("desout", PlayerType.Valorant));
    	        candidates.add(new Candidate("poke", PlayerType.Valorant));
    	        candidates.add(new Candidate("olya", PlayerType.Valorant));
    	        candidates.add(new Candidate("fatya", PlayerType.Civilasation));
    	        candidates.add(new Candidate("ns", PlayerType.Civilasation));
    	        candidates.add(new Candidate("melharucos", PlayerType.Civilasation));
    	   
    	    }

    	    public static List<Candidate> getCandidates() {
    	        return candidates;
    	    }
    	    
    	    //RTTI
    	    public void performActionBasedOnType() {
    	        if (this instanceof Candidate) {
    	           
    	            System.out.println("Candidate is of type Candidate!");
    	        } else {
    	           
    	            System.out.println("Candidate is not of type Candidate!");
    	        }
    	    }
    	    
    	}