package main;

public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    @Override
    public double add(double x, double y) {
        //在测试异常通知时，可以故意制造异常。
        int result = 1 / 0;
        return x + y;
    }

    @Override
    public double subtract(double x, double y) {
        return x - y;
    }

    @Override
    public double multiply(double x, double y) {
        return x * y;
    }

    @Override
    public double divide(double x, double y) {
        return x / y;
    }
}