package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {

    public static void main(String[] args) {
        String filename = "test.ext";

        byte[] inputBytes = {0};
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            String outputString = ""; 
            for (byte b : inputBytes) {
                outputString += (char) b;
            }
            endTime = System.currentTimeMillis();
            System.out.println("In " + (endTime - startTime) + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
