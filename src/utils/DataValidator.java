package utils;

public class DataValidator {

    /**
     * Validates that a string is not null or empty.
     * 
     * @param input The string to validate.
     * @return True if the string is valid, false otherwise.
     */
    public static boolean validateString(String input) {
        return input != null && !input.trim().isEmpty();
    }

    /**
     * Validates that a number is within a specified range.
     * 
     * @param number The number to validate.
     * @param min The minimum value (inclusive).
     * @param max The maximum value (inclusive).
     * @return True if the number is within range, false otherwise.
     */
    public static boolean validateNumberInRange(int number, int min, int max) {
        return number >= min && number <= max;
    }

    /**
     * Validates that a boolean input is either "true" or "false".
     * 
     * @param input The string to validate.
     * @return True if the input is a valid boolean, false otherwise.
     */
    public static boolean validateBoolean(String input) {
        return "true".equalsIgnoreCase(input) || "false".equalsIgnoreCase(input);
    }
}
