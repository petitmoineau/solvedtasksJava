import java.util.regex.Pattern;

public class expression1 {
    public static void main(String[] args) {
        String [][] addTwo = {{"", ".||"}};
        String [][] toDec = {{"a||||||||||", "|a"}, {"a|||||||||", "9"}, {"a||||||||", "8"},
                {"a|||||||", "7"}, {"a||||||", "6"}, {"a|||||", "5"}, {"a||||", "4"}, {"a|||", "3"}, {"a||", "2"},
                {"a|", "1"}, {"|a", "|0"}, {"a9", ".9"}, {"a8", ".8"}, {"a7", ".7"}, {"a6", ".6"}, {"a5", ".5"}, {"a4", ".4"},
                {"a3", ".3"}, {"a2", ".2"}, {"a1", ".1"}, {"", "a"}};
        String y = "|";
        String x = "||||";
        y = nam(nam(y, addTwo), toDec);
        x = nam(x, toDec);
        String [][] subtractOne = {{"0b", "b9"}, {"1b", ".0"}, {"2b", ".1"}, {"3b", ".2"}, {"4b", ".3"}, {"5b", ".4"},
                {"6b", ".5"}, {"7b", ".6"}, {"8b", ".7"}, {"9b", ".8"}, {"b", ".1"},{"a0", "0a"}, {"a1", "1a"},
                {"a2", "2a"}, {"a3", "3a"}, {"a4", "4a"}, {"a5", "5a"}, {"a6", "6a"}, {"a7", "7a"}, {"a8", "8a"},
                {"a9", "9a"}, {"0a", "0b"}, {"1a", "1b"}, {"2a", "2b"}, {"3a", "3b"}, {"4a", "4b"}, {"5a", "5b"},
                {"6a", "6b"}, {"7a", "7b"}, {"8a", "8b"}, {"9a", "9b"}, {"", "a"}};
        while(!x.equals("0") && !y.equals("0")) {
            y = nam(y, subtractOne);
            x = nam(x, subtractOne);
        }
        if (x.equals("0")) System.out.println(y);
        else System.out.println(x);
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