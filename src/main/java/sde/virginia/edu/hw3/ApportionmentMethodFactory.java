package sde.virginia.edu.hw3;

public class ApportionmentMethodFactory {
    public ApportionmentMethod getDefaultMethod(){
        return this.getMethod("huntington");
    }
    public ApportionmentMethod getMethod(String method){
        switch (method){
            case ("huntington"):
                return new HuntingtonHillMethod();
            case ("adams"):
                return new AdamsMethod();
            case ("jefferson"):
                return new JeffersonMethod();
            default:
                throw new IllegalArgumentException(method + " is not a kind of method. Please input huntington, adams, or jefferson.");

        }
    }
}
