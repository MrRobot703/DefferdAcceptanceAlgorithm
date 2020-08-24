package core;

import models.Participant;

import java.util.*;

public class GaleShapleyAlgorithm {
    public static <H extends Participant,K extends Participant> Map<H, K> createMatching(List<H> hs, List<K> ks) {
        Map<H, K> matching = new HashMap<>(hs.size());

        int initialHsSize = hs.size();
        int numberOfBounds = 0;
        List<H> exhaustedHospitals = new LinkedList<>();
        Iterator<H> hsIterator = hs.iterator();
        while(numberOfBounds + exhaustedHospitals.size() < initialHsSize) {
            if(hsIterator.hasNext()) {
                H h = hsIterator.next();

                if(h.getCurrentChoice() != null) {
                    continue;
                }
                if (h.getRankingList().isEmpty()) {
                    exhaustedHospitals.add(h);
                    hsIterator.remove();
                    continue;
                }

                K k = ks.get(h.getRankingList().remove(0));
                if (k.getCurrentChoice() == null) {
                    k.setCurrentChoice(h);
                    h.setCurrentChoice(k);
                    numberOfBounds++;
                } else if (k.getRankingList().get(h.getIndex()) < k.getRankingList().get(k.getCurrentChoice().getIndex())) {
                    k.getCurrentChoice().setCurrentChoice(null);
                    k.setCurrentChoice(h);
                    h.setCurrentChoice(k);
                }
            } else {
                hsIterator = hs.iterator();
            }
        }

        //? what to do with the leftover candidates?
        for(H h: hs) {
            matching.put(h, (K)h.getCurrentChoice());
        }
        for (H h: exhaustedHospitals) {
            matching.put(h, (K)h.getCurrentChoice());
        }

        return matching;
    }
}
