import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    private Utils() {}

    private static final String dev = "cruly1";
    private static final String version = "1.22";

    private static final String imageName = System.getProperty("sun.java.command").split(" ")[1];
    private static final String fileName = imageName.substring(0, imageName.lastIndexOf(".")+1) + "txt";

    public static void help() {
        System.out.println("Options:");
        System.out.println("  --help, -h         Displays the options.");
        System.out.println("  --version, -v      Displays the current version and the developer.");
        System.out.println("  imagename.png      Converts an existing image to an ASCII txt file.");
    }

    public static void version() {
        System.out.println("Image to ASCII");
        System.out.println("-".repeat(17));
        System.out.printf("Version: %s\n", version);
        System.out.printf("Developer: %s\n", dev);
    }

    public static void writeLines(String ascii) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(ascii);
            writer.close();
        } catch (IOException e) {
            System.err.println("Error: Couldn't write file: " + fileName);
            System.exit(4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(3);
        }
    }
}
