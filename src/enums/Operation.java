package enums;

public enum Operation {
    ADD("+") {
        public double apply(double x, double y) { return x + y; }
    },
    SUBTRACT("-") {
        public double apply(double x, double y) { return x - y; }
    },
    MULTIPLY("*") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override public String toString() {
        return symbol;
    }

    public abstract double apply(double x, double y);
}
