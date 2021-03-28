package ip;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Expt2 {


     BufferedImage convertGrey(BufferedImage img) {

         int width = img.getWidth();
         int height = img.getHeight();
         for (int y = 0; y < height; y++) {
             for (int x = 0; x < width; x++) {
                 Color c= new Color(img.getRGB(x,y));
                 int r = c.getRed(), g=c.getGreen(), b=c.getBlue();
                 int gray = (int) (0.30 * r + 0.59 * g + 0.11 * b);
                 Color n = new Color(gray, gray, gray);
                 img.setRGB(x, y, n.getRGB());
             }
         }
         return img;
     }
}
