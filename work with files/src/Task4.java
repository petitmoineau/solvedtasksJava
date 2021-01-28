import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Task4 {
    public static void main(String[] args) throws Exception {
        File file = new File("exam.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        String res = "";
        char[] strChars;
        while ((str = br.readLine()) != null) {
            strChars = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                strChars[i] += (i+1)*3;
                res += strChars[i];
            }
            res += '\n';
        }
        FileWriter myFile = new FileWriter(file);
        myFile.write(res);
        myFile.close();

        res = "";
        br = new BufferedReader(new FileReader(file));
        while ((str = br.readLine()) != null) {
            strChars = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                strChars[i] -= (i+1)*3;
                res += strChars[i];
            }
            res += '\n';
        }
        myFile = new FileWriter("decodedExam.txt");
        myFile.write(res);
        myFile.close();
    }
}
