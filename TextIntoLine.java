import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Scanner;

public class TextIntoLine {
    public TextIntoLine() {

    }



    // all the words without returns will be here
    String all = "";


    public void loadingData(String fileName) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileInputStream(fileName));
        // while loop around text
        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            // if the line isnt empty and doesnt have a return then add that to the string
            if (!line.isEmpty() && !line.contains("\n")) {
                all = all + line + " ";
            }

        }
        // prints them out for safety
        System.out.println(all);
    }

    // writes the text to file
    private void writeToFile() throws IOException {
        Path file = Paths.get("text_without_breaks.txt");
        Files.write(file, Collections.singleton(all));
    }

    public static void main(String[] args) throws IOException {
        TextIntoLine textIntoLine = new TextIntoLine();
        textIntoLine.loadingData("text.txt");
        textIntoLine.writeToFile();
    }


}
