import java.io.*;

import static org.apache.logging.log4j.MarkerManager.exists;

public class ReadingFromFile {

    public static String read(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        exists("src/main/resources/"+fileName);

        try {
            File file = new File("src/main/resources/"+fileName);
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }
}