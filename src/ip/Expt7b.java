package ip;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Expt7b {
    BufferedImage img;
    BufferedImage WAvgFilterAction(BufferedImage image){
        img=image;
        int width = img.getWidth(), height = img.getHeight();
        int filter[][]={{1,2,1}, {2,4,2}, {1,2,1}};
        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                int val[] = new int[3];

                for (int x=-1; x<2; x++){
                    for (int y=-1; y<2; y++){
                        try{
                            Color p = new Color(img.getRGB(j+x, i+y));
                            int r=p.getRed(), g=p.getGreen(), b=p.getBlue();
                            val[0]+=filter[x+1][y+1]*r;
                            val[1]+=filter[x+1][y+1]*g;
                            val[2]+=filter[x+1][y+1]*b;
                        }
                        catch(Exception e){
                            continue;
                        }
                    }
                }
                val[0]=Math.round(val[0]/16);
                val[1]=Math.round(val[1]/16);
                val[2]=Math.round(val[2]/16);
                Color n= new Color(val[0], val[1], val[2]);
                img.setRGB(j, i, n.getRGB());
            }
        }
        return img;
    }

}
