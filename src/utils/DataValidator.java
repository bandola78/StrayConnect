package utils;

import java.util.Set;

public class DataValidator {

    private static final Set<String> VALID_COLORS = Set.of("BLACK", "WHITE", "BROWN", "GREY", "ORANGE", "OTHER");
    private static final Set<String> INVALID_NAMES = Set.of("ME", "I", "YOU", "NONE");

    public static String formatName(String input) {
        if (input == null || INVALID_NAMES.contains(input.toUpperCase().trim())) {
            return null;
        }
        String[] words = input.trim().split("\\s+");
        StringBuilder formattedName = new StringBuilder();
        for (String word : words) {
            formattedName.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");
        }
        return formattedName.toString().trim();
    }

    public static String mapGender(String input) {
        if ("M".equalsIgnoreCase(input)) return "MALE";
        if ("F".equalsIgnoreCase(input)) return "FEMALE";
        return null;
    }

    public static boolean validateColor(String color) {
        return VALID_COLORS.contains(color.toUpperCase());
    }

    public static boolean validateContactNumber(String contact) {
        if ("NONE".equalsIgnoreCase(contact)) return true;
        return contact.matches("\\+63\\d{10}");
    }

    public static boolean validateNumberRange(int number, int min, int max) {
        return number >= min && number <= max;
    }

    public static boolean validateYesNo(String input) {
        return "YES".equalsIgnoreCase(input) || "NO".equalsIgnoreCase(input);
    }
}
