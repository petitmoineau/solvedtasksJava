import java.io.*;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws Exception{
        File file = new File("exam2.txt");
        System.out.print("Write a name of a file: ");
        Scanner scanner = new Scanner(System.in);
        FileWriter writer = new FileWriter(scanner.nextLine()+".bak");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        while ((str = br.readLine()) != null) {
            writer.write(str);
            writer.write('\n');
        }
        writer.close();
    }
}
