package ip;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Expt9 {
    BufferedImage h;
    BufferedImage HistogramAction(BufferedImage image) {
        Expt2 gimg = new Expt2();
        BufferedImage img = gimg.convertGrey(image);
        int height=img.getHeight(),width=img.getWidth();
        int max=-1;
        int level[] = new int[256];

        for(int i=0;i<256;i++)
        {
            level[i]=0;
        }

        for(int i=0;i<width;i++)
        {
            for(int j=0;j<height;j++){
                Color c= new Color(img.getRGB(i,j));
                int r= c.getRed();

                level[r]+=1;
                if(level[r]>max)
                    max=level[r];
            }
        }
        int nw = 256+10,nh=max+10;
        h=new BufferedImage(nw,nh,BufferedImage.TYPE_INT_ARGB);

        Color white = new Color(255,255,255);
        Color black = new Color(0,0,0);

        for(int i=0;i<nw;i++){
            for(int j=0;j<nh;j++){
                h.setRGB(i,j,white.getRGB());

            }
        }
        for(int i=0;i<256;i++){
            for(int j=max-level[i];j<max;j++){
                h.setRGB(i,j,black.getRGB());

            }
        }
     return h;

    }

}