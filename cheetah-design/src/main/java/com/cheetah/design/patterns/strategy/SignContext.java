package com.cheetah.design.patterns.strategy;

public class SignContext {

    private SignStrategy strategy;

    public SignContext(SignStrategy strategy) {
        this.strategy = strategy;
    }

    public double getResult(double money) {
        return strategy.acceptSign(money);
    }

}
