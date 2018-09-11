import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.Scanner;

public class RandomGeneration {

    static final String AB = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";
    static final String ab = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
    static SecureRandom rnd = new SecureRandom();

     static String intRandomNumber(int maxValue) {
        int random_number = (int)(Math.random()*(maxValue - 1) + 1);
        return String.valueOf( random_number );
    }

    static String doubleRandomNumber(double maxValue){
        double random_number = (Math.random()*(maxValue - 0.1)) + 0.1;
        return String.valueOf( random_number );
    }

    public String ProductName() throws FileNotFoundException {
        Scanner sc = new Scanner(new File( RandomGeneration.class.getResource("/ProductName.txt").getFile()), "cp1251");

        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            sb.append(sc.nextLine());
        }
        sc.close();

        String str1 = sb.toString().replaceAll("\"", "");
        String[] str = str1.toString().split(", ");

        int n = (int) Math.floor(Math.random() * str.length);

        return str[n];
    }

    String randomStringBig(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    String randomStringLittle(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(ab.charAt(rnd.nextInt(ab.length())));
        return sb.toString();
    }
}
