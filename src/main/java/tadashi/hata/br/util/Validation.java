package tadashi.hata.br.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Validation {

    /**
     * @param value
     * @param minLength Minimum length of the value. Inclusive length.
     * @param maxLength Maximum length of the value. Inclusive length
     * @return Boolean - Returns TRUE if the value is equal or greater than minLength and value if equal or minor than maxLength.
     */
    public static boolean isBetweenRange(String value, Integer minLength, Integer maxLength) {
        return !(isMinorThan(value, minLength) || isGreaterThan(value, maxLength));
    }

    public static Boolean isGreaterThan(String value, Integer maxLength) {
        return value.length() > maxLength;
    }

    public static Boolean isMinorThan(String value, Integer minLength) {
        return value.length() < minLength;
    }
}
