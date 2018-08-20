package bracketchecker;

import java.util.LinkedList;

/**
 * The Bracket checker.
 */
public class BracketChecker {

    /**
     * Main check method.
     * First checking quantity of brackets.
     * If correct, then checking its balance.
     * @param st the checking string
     * @return boolean
     */
    public boolean check(String st) {
        boolean isCorrect = false;
        if (checkQuantity(st)) {
            isCorrect = checkBalance(st);
        }
        return isCorrect;
    }

    /**
     * Checks string for proper quantity of brackets.
     *
     * @param st the string should be checked
     * @return if is ok or not
     */
    public boolean checkQuantity(String st) {
        int openedBrackets = 0;
        int openedSquareBrackets = 0;
        int openedBraces = 0;
        int closedBrackets = 0;
        int closedSquareBrackets = 0;
        int closedBraces = 0;

        for (char ch : st.toCharArray()) {
            switch (ch) {
                case '(':
                    openedBrackets++;
                    break;
                case ')':
                    closedBrackets++;
                    break;
                case '[':
                    openedSquareBrackets++;
                    break;
                case ']':
                    closedSquareBrackets++;
                    break;
                case '{':
                    openedBraces++;
                    break;
                case '}':
                    closedBraces++;
                    break;
                default:
                    break;
            }
        }
        return (openedBrackets == closedBrackets
                && openedSquareBrackets == closedSquareBrackets
                && openedBraces == closedBraces);
    }

    /**
     * Check balance of brackets.
     *
     * @param st the string should be checked
     * @return if is ok or not
     */
    public boolean checkBalance(String st) {
        boolean isCorrect = true;

        LinkedList<Character> stack = new LinkedList<>();

        for (char ch : st.toCharArray()) {
            if (!isBracket(ch)) {
                continue;
            }
            if (isOpeningBracket(ch)) {
                stack.push(ch);
            } else {
                char lastBracket = stack.pop();
                if (!possibleToClose(lastBracket, ch)) {
                    isCorrect = false;
                    break;
                }
            }
        }

        return isCorrect;
    }


    /**
     * Checking possibility of closing (balance) two chars.
     * @param open first char
     * @param closing second char
     * @return if is ok or not
     */
    private boolean possibleToClose(char open, char closing) {
        return (open == '(' & closing == ')')
                || (open == '[' & closing == ']')
                || (open == '{' & closing == '}');
    }

    /**
     * Is bracket char.
     * @param ch checking char
     * @return true if it is
     */
    private boolean isBracket(char ch) {
        return (ch == '(' || ch == ')' || ch == '[' || ch == ']' || ch == '{' || ch == '}');
    }

    /**
     * Is opening bracket or not.
     * @param ch checking char
     * @return true if it is
     */
    private boolean isOpeningBracket(char ch) {
        if (ch == '(' || ch == '[' || ch == '{') {
            return true;
        } else if (ch == ')' || ch == ']' || ch == '}') {
            return false;
        } else {
            throw new RuntimeException("Char is not a bracket!");
        }
    }

}
