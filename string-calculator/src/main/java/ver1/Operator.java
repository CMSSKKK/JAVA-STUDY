package ver1;

import java.util.function.BiFunction;

enum Operator {
    PLUS("+", (before,after) -> before+after),
    MINUS("-", (before,after) -> before-after),
    MULTIPLY("*", (before,after) -> before*after),
    DIVIDE("/", (before,after) -> before/after);

    private String sign;
    private BiFunction<Integer, Integer, Integer> operation;

    Operator(String sign, BiFunction<Integer,Integer,Integer> operation) {
        this.sign = sign;
        this.operation = operation;
    }

    public String getSign() {
        return sign;
    }

    public int operate(int before, int after) {
        return operation.apply(before,after);
    }
}

