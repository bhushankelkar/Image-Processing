package ip;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Expt8b {
    BufferedImage SobelFilterAction(BufferedImage image) {
        int width = image.getWidth(), height = image.getHeight();
        BufferedImage im1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        int filterX[][] = {{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}};
        int filterY[][] = {{1, 0, -1}, {2, 0, -2}, {1, 0, -1}};
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int valX[] = new int[3];
                int valY[] = new int[3];
                valX[0] = valX[1] = valX[2] = 0;
                valY[0] = valY[1] = valY[2] = 0;
                for (int x = -1; x < 2; x++) {
                    for (int y = -1; y < 2; y++) {
                        try {
                            Color p = new Color(image.getRGB(j + x, i + y));
                            int r = p.getRed(), g = p.getGreen(), b = p.getBlue();
                            valX[0] += filterX[x + 1][y + 1] * r;
                            valX[1] += filterX[x + 1][y + 1] * g;
                            valX[2] += filterX[x + 1][y + 1] * b;
                            valY[0] += filterY[x + 1][y + 1] * r;
                            valY[1] += filterY[x + 1][y + 1] * g;
                            valY[2] += filterY[x + 1][y + 1] * b;
                        } catch (Exception e) {
                            continue;
                        }
                    }
                }

                valX[0] = Math.round(valX[0] / 8);
                valX[1] = Math.round(valX[1] / 8);
                valX[2] = Math.round(valX[2] / 8);
                valY[0] = Math.round(valY[0] / 8);
                valY[1] = Math.round(valY[1] / 8);
                valY[2] = Math.round(valY[2] / 8);

                for (int valColor = 0; valColor < 3; valColor++) {
                    if (valX[valColor] < 0)
                        valX[valColor] = -1 * valX[valColor];

                    if (valY[valColor] < 0)
                        valY[valColor] = -1 * valY[valColor];
                }
                Color n = new Color(valX[0] + valY[0], valX[1] + valY[1], valX[2] + valY[2]);
                im1.setRGB(j, i, n.getRGB());
            }
        }
        return im1;
    }
}


