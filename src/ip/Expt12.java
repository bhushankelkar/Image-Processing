package ip;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Expt12 {
    BufferedImage grayScaleErode(BufferedImage image){
        int width = image.getWidth(), height = image.getHeight();
        BufferedImage im1 = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);

        int mask[][]={{1,1,1}, {1,1,1}, {1,1,1}};
        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                int val;
                int min = 255;
                for (int x=-1; x<2; x++){
                    for (int y=-1; y<2; y++){
                        try{
                            Color p = new Color(image.getRGB(j+x, i+y));
                            int r=p.getRed(), g=p.getGreen(), b=p.getBlue();
                            int grayscale = (r+g+b)/3;
                            if(grayscale==0){
                                min=0;

                            }
                            else{
                                val = grayscale - mask[x+1][y+1];

                                if(val<min){
                                    min=val;
                                }}

                        }
                        catch(Exception e){
                            continue;
                        }
                    }
                }
                System.out.println(min);
                Color n= new Color(min, min, min);
                im1.setRGB(j, i, n.getRGB());
            }
        }

        return im1;
    }
}
