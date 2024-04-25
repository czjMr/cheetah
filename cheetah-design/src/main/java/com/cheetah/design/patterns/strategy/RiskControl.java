package com.cheetah.design.patterns.strategy;

public class RiskControl extends SignStrategy {

    @Override
    public double acceptSign(double money) {
        return 10;
    }
}
