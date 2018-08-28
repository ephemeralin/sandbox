package strings;

/**
 * The Strings transformer.
 */
public class StringsTransformer {
    /**
     * First letters get capital.
     * First split split string into array of strings using 'space'-separator
     * Then construct new string with changing first letter into upper case
     * @param s input string
     * @return result string
     */
    public static String firstLettersGetCapital(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toLowerCase().toCharArray();
            chars[0] = String.valueOf(chars[0]).toUpperCase().charAt(0);
            String word = String.copyValueOf(chars);
            sb.append(word).append(" ");
        }
        return sb.toString().trim();
    }
}
