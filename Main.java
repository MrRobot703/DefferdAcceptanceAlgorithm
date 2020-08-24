import core.GaleShapleyAlgorithm;
import models.Candidate;
import models.Hospital;
import setup.Setup;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Setup setup = new Setup(5);
        List<Candidate> candidates = setup.getCandidates();
        List<Hospital> hospitals = setup.getHospitals();

        displayParticipants(hospitals, candidates);

        Map<Hospital, Candidate> matching = GaleShapleyAlgorithm.createMatching(hospitals, candidates);

        displayMatching(matching);
    }

    private static void displayParticipants(List<Hospital> hospitals, List<Candidate> candidates) {
        hospitals.forEach(System.out::println);
        candidates.forEach(System.out::println);
    }

    private static void displayMatching(Map<Hospital, Candidate> matching) {
        matching.keySet().forEach(key -> System.out.println("{" + key.getName() + ", " + matching.get(key).getName() + "}"));
    }
}