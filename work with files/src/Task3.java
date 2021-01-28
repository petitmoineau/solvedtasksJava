import java.io.*;

public class Task3 {
    public static void main(String[] args) throws Exception{
        File file = new File("exam2.txt");
        FileWriter writer1 = new FileWriter("odd");
        FileWriter writer2 = new FileWriter("even");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        for (int i = 1; (str = br.readLine()) != null; i++) {
            if (i%2==0) {
                writer2.write(str);
                writer2.write('\n');
            }
            else {
                writer1.write(str);
                writer1.write('\n');
            }
        }
        writer1.close();
        writer2.close();
    }
}
