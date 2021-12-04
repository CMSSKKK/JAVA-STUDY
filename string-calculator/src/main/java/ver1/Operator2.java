package ver1;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator2 {
    PLUS("+",(a1, a2) -> a1 + a2),
    MINUS("-",(a1, a2) -> a1 - a2),
    MULTYPLY("*",(a1, a2) -> a1 * a2),
    DIVIDE("/",(a1, a2) -> {
        if(a2 == 0) {
            throw new IllegalArgumentException();
        }
        return a1 / a2;
    });

    private static final Map<String, Operator2> operatorMap = Stream.of(values()).collect(Collectors.toMap(operater2 -> operater2.getSign(), operater2 -> operater2));
    private String sign;
    private BiFunction<Integer, Integer, Integer> operation;

    Operator2(String sign, BiFunction<Integer,Integer,Integer> operation) {
        this.sign = sign;
        this.operation = operation;
    }

    private String getSign() {
        return this.sign;
    }

    public static Operator2 findOperator(String sign) {

        Operator2 operater2 = operatorMap.get(sign);
        if(operater2 == null) {
            throw new IllegalArgumentException();
        }
        return operater2;
    }


    public int operate(int a1, int a2) {
        return operation.apply(a1,a2);
    }
}
