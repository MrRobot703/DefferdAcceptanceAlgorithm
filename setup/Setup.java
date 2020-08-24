package setup;

import models.Candidate;
import models.Hospital;
import models.Participant;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Setup {
    private static final int DEFAULT_NUMBER_OF_PARTICIPANTS = 10;
    private int numberOfParticipants;
    private List<Candidate> candidates;
    private List<Hospital> hospitals;

    public Setup() {
        this(DEFAULT_NUMBER_OF_PARTICIPANTS);
    }

    public Setup(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
        setParticipants(numberOfParticipants);
    }

    private void setParticipants(int numberOfParticipants) {
        this.candidates = new ArrayList<>(numberOfParticipants);
        this.hospitals = new ArrayList<>(numberOfParticipants);
        setNames();
        setRankingFor(candidates);
        setRankingFor(hospitals);
    }

    private void setNames() {
        for (int i = 0; i < numberOfParticipants; i++) {
            candidates.add(new Candidate("Candidate " + i , i));
            hospitals.add(new Hospital("Hospital " + i, i));
        }
    }

    private void setRankingFor(List<? extends Participant> participants) {
        for (Participant participant: participants) {
            List<Integer> dummyRanking = IntStream
                    .range(0, numberOfParticipants)
                    .boxed()
                    .collect(Collectors.toList());
            Collections.shuffle(dummyRanking);
            participant.setRankingList(dummyRanking);
        }
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }
}
