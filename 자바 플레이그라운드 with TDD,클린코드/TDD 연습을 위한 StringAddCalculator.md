# TDD 연습을 위한 StringAddCalculator

## 기능 요구사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

```java
package part1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int ZERO = 0;
    private static final String BASIC_REGEX = "(,)|(:)";
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";
    private static Matcher matcher;


    public static int splitAndSum(String input) {

        if (isNullOrEmpty(input)) return ZERO;

        if (isBasicPattern(input)) {
            return arraySum(input.split(BASIC_REGEX));
        }

        if (isCustomPattern(input)) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);
            return arraySum(tokens);
        }

        return stringToInt(input);
    }

    private static int stringToInt(String token) {
        if (token.matches("(\\D+)")) {
            throw new RuntimeException();
        }
        int value = Integer.parseInt(token);
        if (value < ZERO) {
            throw new RuntimeException();
        }
        return value;
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static boolean isBasicPattern(String text) {
        matcher = Pattern.compile(BASIC_REGEX).matcher(text);
        return matcher.find();
    }

    private static boolean isCustomPattern(String text) {
        matcher = Pattern.compile(CUSTOM_REGEX).matcher(text);
        return matcher.find();
    }

    private static int arraySum(String[] tokens) {
        return Arrays.stream(tokens).mapToInt(StringAddCalculator::stringToInt).sum();
    }

}

```

```java
package stringAddCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import part1.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    void inputNullOrEmpty_return0Test() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    void splitAndSum_구분자_없음() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void splitAndSum_쉼표구분자() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)")
    void splitAndSum_쉼표_또는_클론_구분자() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);

        result = StringAddCalculator.splitAndSum("1:2:3");
        assertThat(result).isEqualTo(6);

        result = StringAddCalculator.splitAndSum("1,2,3");
        assertThat(result).isEqualTo(6);

        result = StringAddCalculator.splitAndSum("1:3");
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)")
    void splitAndSum_커스텀구분자() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외가 발생해야 한다.")
    void splitAndSum_negative() {
        assertThrows(RuntimeException.class,() ->StringAddCalculator.splitAndSum("-1,2,3"));
        assertThrows(RuntimeException.class,() ->StringAddCalculator.splitAndSum("가,2,3"));
        assertThrows(RuntimeException.class,() ->StringAddCalculator.splitAndSum("a,2,3"));
    }
}

```

