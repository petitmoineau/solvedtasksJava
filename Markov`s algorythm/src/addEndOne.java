import java.util.regex.Pattern;

public class addEndOne {
    public static void main(String[] args) {
        String str = "ababababbbaaa";
        String empty = "";
        String [][] states = {{"ca", "ac"}, {"cb", "bc"}, {"c", "."}, {"", "c"}};
        System.out.println(nam(str, states));
    }

    public static String nam(String namEnter, String[][] states) {
        if(namEnter.equals("")) return "Unresolved behavior. Empty string entered.";
        boolean shouldRepeat = true;
        while(shouldRepeat) {
            shouldRepeat = false;
            System.out.println(namEnter);
            for(String[] state: states) {
                if(namEnter.contains(state[0])) {
                    shouldRepeat = true;
                    namEnter = namEnter.replaceFirst(Pattern.quote(state[0]), state[1]);
                    if(state[1].contains(".")) {
                        return namEnter.replace(".", Character.toString(namEnter.charAt(0)));
                    }
                    break;
                }
            }
        }
        return namEnter;
    }
}
