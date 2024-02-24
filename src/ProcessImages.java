import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProcessImages {

    private static final String imageName = System.getProperty("sun.java.command").split(" ")[1];

    public static void process() {
        try {
            BufferedImage img = ImageIO.read(new File(imageName));
            String ascii = buildAscii(img);
            Utils.writeLines(ascii);
        } catch (IOException e) {
            System.err.printf("Error: Couldn't open %s. Please provide an existing image!", imageName);
            System.exit(2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(3);
        }
    }

    public static String buildAscii(BufferedImage img) {
        StringBuilder sb = new StringBuilder();
        double luminance;
        int increment = 1;

        while (increment * 126 < img.getHeight() || increment * 126 < img.getWidth()) {
            increment++;
        }

        for (int i = 0; i < img.getHeight(); i+=increment) {
            for (int j = 0; j < img.getWidth(); j+=increment) {
                int color = img.getRGB(j, i);
                int red = (color >>> 16) & 0xFF;
                int green = (color >>>  8) & 0xFF;
                int blue = (color) & 0xFF;
                luminance = (red + green + blue) / 3.0;

                if (luminance > 150) {
                    sb.append("#");
                } else if (luminance > 100) {
                    sb.append("o");
                } else if (luminance > 50) {
                    sb.append(".");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
