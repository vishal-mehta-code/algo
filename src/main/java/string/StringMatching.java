package string;

public class StringMatching {

    private static Character STAR_WILDCARD = '*';
    private static Character QUESTION_WILDCARD = '?';

    public static void main(String[] args) {

        System.out.println("strings matched : " + match("geek*", "geekforgeeks"));

        System.out.println("strings matched : " + patternSearching(null, "a*b*te", "aaaabbte"));
    }

    private static boolean patternSearching(String prev, String str1, String str2) {

        if (str1.isEmpty() && str2.isEmpty())
            return true;

        if (str1.charAt(0) == STAR_WILDCARD && str1.length() == 1)
            return true;

        if (str1.length() > 1 && str2.isEmpty())
            return false;

        if (str1.charAt(0) == QUESTION_WILDCARD)
            return patternSearching(null, str1.substring(1), str2.substring(1));

        if (str1.charAt(0) == str2.charAt(0)) {
            return patternSearching(str1.substring(0, 1), str1.substring(1), str2.substring(1));
        }

        if (str1.charAt(0) == STAR_WILDCARD) {

            if (prev == null) {
                System.out.println("invalid pattern");
                return false;
            }

            if (!prev.equals(str2.substring(0, 1))) {
                return patternSearching(null, str1.substring(1), str2);
            }

            return patternSearching(prev, str1, str2.substring(1)) || patternSearching(null, str1.substring(1), str2);

        }

        return false;
    }

    private static boolean match(String str1, String str2) {

        if (str1.isEmpty() && str2.isEmpty())
            return true;

        // base case for last *
        if (str1.charAt(0) == STAR_WILDCARD && str1.length() == 1)
            return true;

        if (!str1.isEmpty() && str2.isEmpty())
            return false;

        if (str1.charAt(0) == QUESTION_WILDCARD || str1.charAt(0) == str2.charAt(0))
            return match(str1.substring(1), str2.substring(1));

        if (str1.charAt(0) == STAR_WILDCARD)
            return match(str1, str2.substring(1)) || match(str1.substring(1), str2);

        return false;
    }

}
