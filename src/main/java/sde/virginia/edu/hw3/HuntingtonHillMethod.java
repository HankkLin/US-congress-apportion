package sde.virginia.edu.hw3;
import java.util.*;

public class HuntingtonHillMethod implements ApportionmentMethod {
    @Override
    public Representation getRepresentation(List<State> states, int targetRepresentatives) {
        validateInputs(states, targetRepresentatives);

        Map<State, Integer> stateRepresentatives = new HashMap<>();
        for (State state : states) {
            stateRepresentatives.put(state, 1);
        }
        if(states.size()>targetRepresentatives){
            throw new UnsolvableApportionmentException(this, states, targetRepresentatives);
        }

        int totalRepresentativesAssigned = states.size();
        while (totalRepresentativesAssigned < targetRepresentatives) {
            State stateToAddRepresentative = null;
            double maxPriorityScore = 0;

            for (State state : states) {
                int currentRepresentatives = stateRepresentatives.get(state);
                double priorityScore = state.getPopulation() / Math.sqrt(currentRepresentatives * (currentRepresentatives + 1));

                if (priorityScore > maxPriorityScore) {
                    maxPriorityScore = priorityScore;
                    stateToAddRepresentative = state;
                }
            }
            stateRepresentatives.put(stateToAddRepresentative, stateRepresentatives.get(stateToAddRepresentative) + 1);
            totalRepresentativesAssigned++;
        }
        var representation = new Representation(stateRepresentatives);

        return representation;
    }
}
