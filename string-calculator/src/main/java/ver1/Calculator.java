package ver1;

public class Calculator {
    private String[] input;

    Calculator(String[] input) {
        this.input = input;
    }


    int calculateLoop() {

        Operator2 currentOperator = Operator2.PLUS;
        int result = 0;

        for (String val : input) {
            if (Converter.checkInput(val)) {
                result = currentOperator.operate(result, Integer.parseInt(val));
                continue;
            }
            currentOperator = Operator2.findOperator(val);

        }
        return result;
    }
}
