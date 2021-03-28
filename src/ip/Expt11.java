package ip;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Expt11 {
    BufferedImage optimalThresh(BufferedImage image, float threshVal) {
        int width = image.getWidth();
        int height = image.getHeight();
        float threshBack = 0;
        float threshFore = 0;
        int countFore = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color c = new Color(image.getRGB(j, i));
                if (c.getRed() >= threshVal) {
                    countFore += 1;
                    threshFore += c.getRed();
                } else {
                    threshBack += c.getRed();
                }
            }
        }
        float avgThreshFore = threshFore / countFore;
        float avgThreshBack = threshBack / ((height * width) - countFore);
        float newThreshVal = (avgThreshBack + avgThreshFore) / 2;
        if (newThreshVal == threshVal) {
            System.out.println("The optimal threshold is " + (newThreshVal));
            image=optimalThreshImage(image, newThreshVal);
        } else {
            System.out.println("The intermediate threshold value is  " + (newThreshVal));
            image=optimalThresh(image,newThreshVal);
        }
        return image;
    }

        BufferedImage optimalThreshImage(BufferedImage image,float thresh){
            int width = image.getWidth();
            int height = image.getHeight();

            BufferedImage im=new BufferedImage(width,height,BufferedImage.TYPE_BYTE_BINARY);  int k = 0;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    Color c = new Color(image.getRGB(i, j));
                    if(c.getRed()>=thresh)
                        k=255;
                    else
                        k=0;
                    Color newColor = new Color(k,k,k);
                    im.setRGB(i,j,newColor.getRGB() );
                }
            }
                return im;
        }

    }
