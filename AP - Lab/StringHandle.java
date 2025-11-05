import java.util.Scanner;

public class StringUtilities {

    // 1. Password Validator
    public static String validatePassword(String password) {
        if (password.length() < 8) return "Invalid Password";
        boolean hasUpper = false, hasDigit = false, hasSpace = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) hasUpper = true;
            if (Character.isDigit(ch)) hasDigit = true;
            if (Character.isWhitespace(ch)) hasSpace = true;
        }
        return (hasUpper && hasDigit && !hasSpace) ? "Valid Password" : "Invalid Password";
    }

    // 2. Email Formatter
    public static String formatEmail(String fullName) {
        return fullName.toLowerCase().replace(" ", ".") + "@company.com";
    }

    // 3. License Plate Checker
    public static String checkPlate(String plate) {
        if (plate.length() != 7) return "Invalid plate";
        for (int i = 0; i < 3; i++) if (!Character.isLetter(plate.charAt(i))) return "Invalid plate";
        for (int i = 3; i < 7; i++) if (!Character.isDigit(plate.charAt(i))) return "Invalid plate";
        return "Valid plate";
    }

    // 4. Chat Filter (beginner-friendly)
    public static String filterChat(String message, String offensiveWord) {
        String[] words = message.split(" "); // split sentence into words
        String result = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(offensiveWord)) {
                String stars = "";
                for (int j = 0; j < words[i].length(); j++) {
                    stars += "*"; // replace each character with *
                }
                result += stars;
            } else {
                result += words[i];
            }
            if (i != words.length - 1) result += " "; // add space between words
        }
        return result;
    }

    // 5. Reverse a String
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) sb.append(str.charAt(i));
        return sb.toString();
    }

    // 6. Count Vowels
    public static int countVowels(String str) {
        int count = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ("aeiou".indexOf(ch) >= 0) count++;
        }
        return count;
    }

    // 7. Check Palindrome
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }

    // 8. Word Count
    public static int countWords(String str) {
        int count = 0; 
        boolean inWord = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ' && !inWord) { count++; inWord = true; }
            else if (str.charAt(i) == ' ') inWord = false;
        }
        return count;
    }

    // 9. Remove Duplicate Characters
    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            boolean found = false;
            for (int j = 0; j < sb.length(); j++) {
                if (str.charAt(i) == sb.charAt(j)) { found = true; break; }
            }
            if (!found) sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    // Menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Password Validator");
            System.out.println("2. Email Formatter");
            System.out.println("3. License Plate Checker");
            System.out.println("4. Chat Filter");
            System.out.println("5. Reverse String");
            System.out.println("6. Count Vowels");
            System.out.println("7. Check Palindrome");
            System.out.println("8. Word Count");
            System.out.println("9. Remove Duplicate Characters");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter password: ");
                    System.out.println(validatePassword(sc.nextLine()));
                }
                case 2 -> {
                    System.out.print("Enter full name: ");
                    System.out.println(formatEmail(sc.nextLine()));
                }
                case 3 -> {
                    System.out.print("Enter license plate: ");
                    System.out.println(checkPlate(sc.nextLine()));
                }
                case 4 -> {
                    System.out.print("Enter message: ");
                    String message = sc.nextLine();
                    System.out.print("Enter offensive word: ");
                    String word = sc.nextLine();
                    System.out.println(filterChat(message, word));
                }
                case 5 -> {
                    System.out.print("Enter string: ");
                    System.out.println(reverseString(sc.nextLine()));
                }
                case 6 -> {
                    System.out.print("Enter string: ");
                    System.out.println(countVowels(sc.nextLine()));
                }
                case 7 -> {
                    System.out.print("Enter string: ");
                    System.out.println(isPalindrome(sc.nextLine()));
                }
                case 8 -> {
                    System.out.print("Enter string: ");
                    System.out.println(countWords(sc.nextLine()));
                }
                case 9 -> {
                    System.out.print("Enter string: ");
                    System.out.println(removeDuplicates(sc.nextLine()));
                }
                case 0 -> { 
                    System.out.println("Exiting..."); 
                    sc.close();
                    return; 
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
