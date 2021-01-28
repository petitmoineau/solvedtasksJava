import java.util.regex.Pattern;

public class expression2 {
    public static void main(String[] args) {
        String x = "29";
        String y = "3";
        String z = "4";
        String [][] subtractOne = {{"0b", "b9"}, {"1b", ".0"}, {"2b", ".1"}, {"3b", ".2"}, {"4b", ".3"}, {"5b", ".4"},
                {"6b", ".5"}, {"7b", ".6"}, {"8b", ".7"}, {"9b", ".8"}, {"b", ".1"},{"a0", "0a"}, {"a1", "1a"},
                {"a2", "2a"}, {"a3", "3a"}, {"a4", "4a"}, {"a5", "5a"}, {"a6", "6a"}, {"a7", "7a"}, {"a8", "8a"},
                {"a9", "9a"}, {"0a", "0b"}, {"1a", "1b"}, {"2a", "2b"}, {"3a", "3b"}, {"4a", "4b"}, {"5a", "5b"},
                {"6a", "6b"}, {"7a", "7b"}, {"8a", "8b"}, {"9a", "9b"}, {"", "a"}};
        String [][] addOne = {{"0b", ".1"}, {"1b", ".2"}, {"2b", ".3"}, {"3b", ".4"}, {"4b", ".5"}, {"5b", ".6"},
                {"6b", ".7"}, {"7b", ".8"}, {"8b", ".9"}, {"9b", "b0"}, {"b", ".1"},{"a0", "0a"}, {"a1", "1a"},
                {"a2", "2a"}, {"a3", "3a"}, {"a4", "4a"}, {"a5", "5a"}, {"a6", "6a"}, {"a7", "7a"}, {"a8", "8a"},
                {"a9", "9a"}, {"0a", "0b"}, {"1a", "1b"}, {"2a", "2b"}, {"3a", "3b"}, {"4a", "4b"}, {"5a", "5b"},
                {"6a", "6b"}, {"7a", "7b"}, {"8a", "8b"}, {"9a", "9b"}, {"", "a"}};
        while(!z.equals("0")) {
            y = nam(y, addOne);
            z = nam(z, subtractOne);
        }
        if (Integer.parseInt(x) > Integer.parseInt(y)) {
            while(!x.equals("0") && !y.equals("0")) {
                y = nam(y, subtractOne);
                x = nam(x, subtractOne);
            }
            System.out.println(x);
        }
        else System.out.println("indefinite behavior");
    }
    public static String nam(String namEnter, String[][] states) {
        boolean shouldRepeat = true;
        while(shouldRepeat) {
            shouldRepeat = false;
            for(String[] state: states) {
                if(namEnter.contains(state[0])) {
                    shouldRepeat = true;
                    namEnter = namEnter.replaceFirst(Pattern.quote(state[0]), state[1]);
                    if(state[1].contains(".")) {
                        return namEnter.replace(".", "");
                    }
                    break;
                }
            }
        }
        return namEnter;
    }
}
