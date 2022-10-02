package recursion;

public class ParsingWithSpeed {

    public static void main(String[] args) {
        String str = "***__*_***__****_*";
        System.out.println(parse(str, 0, 1));
    }

    private static boolean parse(String str, int pos, int speed) {

        if (speed == 0 || pos >= str.length() || pos < 0 || str.charAt(pos) == '_') {
            return false;
        }
        if (pos == str.length() - 1) {
            return true;
        }

        return parse(str, pos + speed, speed) || parse(str, pos + speed + 1, speed + 1) || parse(str, pos + speed - 1, speed - 1);
    }
}
