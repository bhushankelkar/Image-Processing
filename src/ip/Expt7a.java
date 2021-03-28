package ip;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Expt7a {
    BufferedImage img;
    BufferedImage BoxFilterAction(BufferedImage image){
        img=image;
        int width = img.getWidth(), height = img.getHeight();
        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                int val []= new int[3];
                for(int x=i-1; x<i+2; x++){
                    for(int y=j-1; y<j+2; y++){
                        try{
                            Color p = new Color(img.getRGB(y,x));
                            int r=p.getRed(), g=p.getGreen(), b=p.getBlue();
                            val[0]+=r;
                            val[1]+=g;
                            val[2]+=b;
                        }
                        catch (Exception e){

                        }
                    }
                }
                val[0]=Math.round(val[0]/9);
                val[1]=Math.round(val[1]/9);
                val[2]=Math.round(val[2]/9);
                Color n= new Color(val[0], val[1], val[2]);
                img.setRGB(j, i, n.getRGB());
            }
        }
        return img;
    }

}
