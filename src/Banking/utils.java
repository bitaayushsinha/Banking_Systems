package Banking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class utils {

    public static String getAccNo(String filePath) {
        File file = new File(filePath);
        BufferedReader reader = null;
        String lastLine = "";
        int lineCount = 0;

        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
            }

            if (lineCount > 0) {
                reader.close();
                reader = new BufferedReader(new FileReader(file));
                for (int i = 0; i < lineCount - 1; i++) {
                    reader.readLine();
                }
                lastLine = reader.readLine();
            }

            if (!lastLine.isEmpty()) {
                return lastLine.substring(0, Math.min(10, lastLine.length()));
            } else {
                return "";
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}