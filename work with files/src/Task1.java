import java.io.*;

public class Task1 {
    public static void main (String[] args) {
        File file = new File("exam1.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String stringToFind = "Vitalii Kozlovskyi";
            String changeToString = "THE NAME IS CENSORED";
            String str;
            String res = "";
            while ((str = br.readLine()) != null) {
                if (str.contains(stringToFind)) {
                    str = str.replace(stringToFind, changeToString);
                }
                res += str + '\n';
            }
            FileWriter myFile = new FileWriter(file);
            myFile.write(res);
            myFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
