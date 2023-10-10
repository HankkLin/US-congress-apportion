package sde.virginia.edu.hw3;

public class RepresentationFormatFactory {
    public RepresentationFormat getDefaultFormat(){
        return this.getFormat("alphabet");
    }
    public RepresentationFormat getFormat(String name, DisplayOrder order){
        switch (name){
            case ("alphabet"):
                return new AlphabeticalFormat();
            case ("benefit"):
                return new BenefitFormat(order);
            case ("population"):
                return new PopulationFormat(order);
            default:
                throw new IllegalArgumentException(name + " is not a kind of format. Please input alphabet, benefit, or population.");
        }
    }
    public RepresentationFormat getFormat(String name){
        switch (name){
            case ("alphabet"):
                return new AlphabeticalFormat();
            case ("benefit"):
                return new BenefitFormat();
            case ("population"):
                return new PopulationFormat();
            default:
                throw new IllegalArgumentException(name + " is not a kind of format. Please input alphabet, benefit, or population.");
        }
    }
}
