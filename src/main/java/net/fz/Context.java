package net.fz;

public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void effectuerOperation(){
        System.out.println("****************");
        strategy.operationStragtey();
        System.out.println("================");
    }
}
