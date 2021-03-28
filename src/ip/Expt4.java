package ip;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Expt4 {
    BufferedImage img;
    BufferedImage greyScaLing(BufferedImage image, int a, int d, int v){
        img=image;
        int width = img.getWidth(), height = img.getHeight();
        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                Color c= new Color(img.getRGB(j,i));
                int r = c.getRed(), g=c.getGreen(), b=c.getBlue();
                int gr=(r+g+b)/3;
                if(gr>=a &&gr<=d)
                    gr=v;
               // else
                //    gr=0; // value of D can be taken as text input
                Color n = new Color(gr, gr, gr);
                img.setRGB(j, i, n.getRGB());
            }
        }
        return img;
    }
}



