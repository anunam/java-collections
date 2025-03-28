package managementsystem;

import java.util.*;

public class VotingSystem {
    private final Map<String, Integer> voteCount = new HashMap<>(); // Stores candidate votes
    private final Map<String, Integer> voteOrder = new LinkedHashMap<>(); // Maintains vote order

    // Cast a vote for a candidate
    public void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteCount.get(candidate)); // Update order
    }

    // Display results in sorted order (Candidate name ascending)
    public void displaySortedResults() {
        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteCount);
        System.out.println("Sorted Results: " + sortedResults);
    }

    // Display results in voting order
    public void displayVotingOrder() {
        System.out.println("Voting Order Results: " + voteOrder);
    }

    public static void main(String[] args) {
        VotingSystem voting = new VotingSystem();

        // Casting votes
        voting.castVote("Alice");
        voting.castVote("Bob");
        voting.castVote("Alice");
        voting.castVote("Charlie");
        voting.castVote("Bob");
        voting.castVote("Alice");

        // Display results
        voting.displaySortedResults();  // Sorted by candidate name
        voting.displayVotingOrder();    // Maintains voting order
    }
}

