package ver1;

public class Main {

    public static void main(String[] args) {
        String input = "2 + 3 * 4 / 2";
        Converter converter = new Converter(input);
        String[] arr = null;
        if (converter.checkNull()) {
            arr = converter.splitString();
        }
        Calculator calculator = new Calculator(arr);
        System.out.println(calculator.calculateLoop());
    }
}
