package ip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Expt7c {
    BufferedImage img;
    BufferedImage MedianFilterAction(BufferedImage image){
        img=image;
        int width = img.getWidth(), height = img.getHeight();
        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                int val[]= new int[9];
                int xi=0;
                for(int x=i-1; x<i+2; x++){
                    for(int y=j-1; y<j+2; y++){
                        try{
                            Color p = new Color(img.getRGB(y,x));
                            int r=p.getRed();
                            val[xi]=r;
                        }
                        catch (Exception e){
                            val[xi]=0;
                        }
                        xi++;
                    }
                }
                Arrays.sort(val);
                int med=val[Math.round(xi/2)];
                Color n = new Color(med,med,med);
                img.setRGB(j,i, n.getRGB());
            }
        }
        return img;
    }

}
