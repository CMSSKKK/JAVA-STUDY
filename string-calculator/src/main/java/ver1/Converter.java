package ver1;

public class Converter {

    private String input;

    Converter(String input) {
        this.input = input;
    }

    String[] splitString() {
        String[] values = input.split(" ");
        return values;
    }

    boolean checkNull() {
        if(input == null) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
