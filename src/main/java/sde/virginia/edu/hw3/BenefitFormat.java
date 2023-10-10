package sde.virginia.edu.hw3;

import java.util.ArrayList;
import java.util.Comparator;
public class BenefitFormat implements RepresentationFormat{
    private DisplayOrder displayOrder;
    public BenefitFormat() {this(DisplayOrder.DESCENDING); }
    public BenefitFormat(DisplayOrder displayOrder) {
        setDisplayOrder(displayOrder);
    }
    public DisplayOrder getDisplayOrder() {
        return displayOrder;
    }
    public void setDisplayOrder(DisplayOrder displayOrder) {
        if (displayOrder == null) {
            throw new IllegalArgumentException("The display order cannot be null!");
        }
        this.displayOrder = displayOrder;
    }

    @Override
    public String getFormattedString(Representation representation) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("State           | Reps| Benefit\n");
        var states = new ArrayList<>(representation.getStates());
        states.sort(getBenefitFactorComparator(displayOrder, representation));
        for (State state : states) {
            var stateString = getBenefitFactorStringForState(representation, state);
            stringBuilder.append(stateString);
        }
        return stringBuilder.toString();
    }

    private static String getBenefitFactorStringForState(Representation representation, State state) {

        double benefitFactor = calculateBenefitFactor(state, representation);
        return String.format("%-16s|%5d|%8.3f\n",state.name(), representation.getRepresentativesFor(state), benefitFactor);
    }

    private static Comparator<State> getBenefitFactorComparator(DisplayOrder displayOrder, Representation representation) {
        return (state1, state2) -> {
            double benefitFactor1 = calculateBenefitFactor(state1, representation);
            double benefitFactor2 = calculateBenefitFactor(state2, representation);

            return (displayOrder == DisplayOrder.DESCENDING) ? Double.compare(benefitFactor2, benefitFactor1)
                    : Double.compare(benefitFactor1, benefitFactor2);
        };
    }

    private static double calculateBenefitFactor(State state, Representation representation) {
        double quota = (double)state.population()/representation.getTotalPopulation();
        quota *= representation.getAllocatedRepresentatives();
        //System.out.println(representation);
        return representation.getRepresentativesFor(state)-quota;
    }
}
