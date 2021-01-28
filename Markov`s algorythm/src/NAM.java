import java.util.regex.Pattern;

public class NAM {
    public static boolean indicator = true;
//    public static String [][] changes = {{"a||||||||||", "|a"}, {"a|||||||||", "9"}, {"a||||||||", "8"},
//            {"a|||||||", "7"}, {"a||||||", "6"}, {"a|||||", "5"}, {"a||||", "4"}, {"a|||", "3"}, {"a||", "2"},
//            {"a|", "1"}, {"|a", "|0"}, {"a9", ".9"}, {"a8", ".8"}, {"a7", ".7"}, {"a6", ".6"}, {"a5", ".5"}, {"a4", ".4"},
//            {"a3", ".3"}, {"a2", ".2"}, {"a1", ".1"}, {"", "a"}};
//    public static String [][] changes = {{"a|", "||a"}, {"a", "."}, {"", "a"}};
//    public static String [][] changes = {{"ca", "ac"}, {"cb", "bc"}, {"ac", "."}, {"bc", "."}, {"", "c"}};
    public static String [][] changes = {{"ca", "."}, {"cb", "."}, {"", "c"}};
    public static void main(String[] args) {
        String str = "bb";
        repeating(str);
    }

    public static void repeating (String enteredString) {
        if (indicator) {
            System.out.println(enteredString);
            repeating(replacing(enteredString, 0));
        }
    }

    public static String replacing(String enteredString, int counter) {
        if(enteredString.contains(changes[counter][0])) {
            enteredString = enteredString.replaceFirst(Pattern.quote(changes[counter][0]), changes[counter][1]);
            if(changes[counter][1].contains(".")) {
                System.out.println(enteredString = enteredString.replace(".", ""));
                indicator = false;
                return enteredString;
            }
            return enteredString;
        }
        if (counter <= changes.length - 1) enteredString = replacing(enteredString, ++counter);
        return enteredString;
    }
}