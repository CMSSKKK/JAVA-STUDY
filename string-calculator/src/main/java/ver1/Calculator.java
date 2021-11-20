package ver1;

import java.util.regex.Pattern;

public class Calculator {
    private String[] input;

    Calculator(String[] input) {
        this.input = input;
    }


    int calculateLoop() {
        String regExp = "^[0-9]*$";
        Operator currentOperator = Operator.PLUS;
        int result = 0;

        for (String val : input) {
            if (Pattern.matches(regExp, val)) {
                result = currentOperator.operate(result, Integer.parseInt(val));
                continue;
            }
            for( Operator operator : Operator.values()) {
                if(operator.getSign().equals(val)) {
                    currentOperator = operator;
                }
            }

        }
        return result;
    }
}
