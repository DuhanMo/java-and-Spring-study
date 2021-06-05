package com.example.test1;

public class Calculator implements ICalculator{
    private ICalculator iCalculator;
    public Calculator(ICalculator iCalculator) {
        this.iCalculator = iCalculator;
    }

    @Override
    public int sum(int x, int y) {
        return 0;
    }

    @Override
    public int minus(int x, int y) {
        return 0;
    }
}
