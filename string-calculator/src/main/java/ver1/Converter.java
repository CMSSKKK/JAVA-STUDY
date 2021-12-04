package ver1;

import java.util.regex.Pattern;

public class Converter {
    private static final String REGEXP = "^[0-9]*$";
    private String input;

    Converter(String input) {
        this.input = input;
    }

    public static boolean checkInput(String val) {
        if(Pattern.matches(REGEXP,val)) {
            return true;
        }
        return false;
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
