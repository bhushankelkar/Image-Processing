package ip;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Expt8a {
    BufferedImage LaplacianFilterAction(BufferedImage image) {
        int width = image.getWidth(), height = image.getHeight();
        BufferedImage im1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        int filter[][] = {{1, 1, 1}, {1, -8, 1}, {1, 1, 1}};
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int val[] = new int[3];

                for (int x = -1; x < 2; x++) {
                    for (int y = -1; y < 2; y++) {
                        try {
                            Color p = new Color(image.getRGB(j + x, i + y));
                            int r = p.getRed(), g = p.getGreen(), b = p.getBlue();
                            val[0] += filter[x + 1][y + 1] * r;
                            val[1] += filter[x + 1][y + 1] * g;
                            val[2] += filter[x + 1][y + 1] * b;
                        } catch (Exception e) {
                            continue;
                        }
                    }
                }


                for (int valColor = 0; valColor < 3; valColor++) {
                    if (val[valColor] < 0)
                        val[valColor] = 0;
                    if (val[valColor] > 255)
                        val[valColor] = 255;
                }
                Color n = new Color(val[0], val[1], val[2]);
                im1.setRGB(j, i, n.getRGB());
            }
        }


        return im1;
    }
}
