package ip;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Expt6 {
    BufferedImage img;
    BufferedImage ContrastStretchingAction(BufferedImage image) {
        try {
            img = image;
            int width = img.getWidth(), height = img.getHeight();
            double rmin, rmax, gmin, gmax, bmin, bmax;
            rmin = gmin = bmin = 255;
            rmax = gmax = bmax = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(img.getRGB(j, i));
                    int r = c.getRed(), g = c.getGreen(), b = c.getBlue();
                    if (r < rmin)
                        rmin = r;
                    if (r > rmax)
                        rmax = r;
                    if (g < gmin)
                        gmin = g;
                    if (g > gmax)
                        gmax = g;
                    if (b < bmin)
                        bmin = b;
                    if (b > bmax)
                        bmax = b;
                }
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(img.getRGB(j, i));
                    double r = (double) c.getRed(), g = (double) c.getGreen(), b =
                            (double) c.getBlue();
                    double s1 = 0, s2 = 255;
                    r = s1 + ((r - rmin) / (rmax - rmin)) * (s2 - s1);
                    g = s1 + ((g - gmin) / (gmax - gmin)) * (s2 - s1);
                    b = s1 + ((b - bmin) / (bmax - bmin)) * (s2 - s1);
                    Color n = new Color((int) r, (int) g, (int) b);
                    img.setRGB(j, i, n.getRGB());
                }
            }
        } catch (Exception E) {
        }
        return img;
    }
}
