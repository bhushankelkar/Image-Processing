package ip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class Expt3 {


      BufferedImage convertNeg(java.awt.event.ActionEvent evt, File f, BufferedImage img) {


          int width = img.getWidth();
          int height = img.getHeight();
          for (int y = 0; y < height; y++)
          {
              for (int x = 0; x < width; x++)
              {
                  Color c= new Color(img.getRGB(x,y));
                  int r = c.getRed(), g=c.getGreen(), b=c.getBlue(), alpha=c.getAlpha();

                  //subtract RGB from 255 (L-1-R)
                  r = 255 - r;
                  g = 255 - g;
                  b = 255 - b;

                  //set new RGB value
                  Color n = new Color(r,g,b);
                  img.setRGB(x, y, n.getRGB());
              }
          }
          return img;
    }
}
