import java.util.regex.Pattern;

public class divide3Quatient {
    public static void main(String[] args) {
        String [][] toDec = {{"a||||||||||", "|a"}, {"a|||||||||", "9"}, {"a||||||||", "8"},
                {"a|||||||", "7"}, {"a||||||", "6"}, {"a|||||", "5"}, {"a||||", "4"}, {"a|||", "3"}, {"a||", "2"},
                {"a|", "1"}, {"|a", "|0"}, {"a9", ".9"}, {"a8", ".8"}, {"a7", ".7"}, {"a6", ".6"}, {"a5", ".5"}, {"a4", ".4"},
                {"a3", ".3"}, {"a2", ".2"}, {"a1", ".1"}, {"", "a"}};
        String x = "######";
        String [][] divide = {{"###", "|"}, {"##", "."}, {"#", "."}};
        System.out.println(nam(nam(x, divide), toDec));
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



