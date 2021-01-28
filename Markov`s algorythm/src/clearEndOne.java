import java.util.regex.Pattern;

public class clearEndOne {
    public static void main(String[] args) {
        String [][] states = {{"ca", "ac"}, {"cb", "bc"}, {"c", "."}, {"", "c"}};
        String str = "ababababbbaaa";
        System.out.println(nam(str, states));
    }

    public static String nam(String namEnter, String[][] states) {
        boolean shouldRepeat = true;
        while(shouldRepeat) {
            shouldRepeat = false;
            System.out.println(namEnter);
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
