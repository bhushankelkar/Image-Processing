package ip;
import java.awt.*;
import java.awt.image.BufferedImage;



public class Expt5{
    BufferedImage img;
    int v;
    BufferedImage BitPlanes(BufferedImage image,  int x){
        v=x;
        int width = image.getWidth(), height=image.getHeight();
        img=image;
        for(int i=0; i<height; i++){
            for(int j =0; j<width; j++){
                Color c = new Color(img.getRGB(j,i));
                int r=c.getRed();
                int a = r;
                int bin[];
                bin = convertBin(a);
                int m= getValue(bin[x]);
                Color n = new Color(m, m, m);
                img.setRGB(j, i, n.getRGB());
            }
        }
        return img;
    }

    private int getValue(int i) {
        if (i==1)
            return 255;
        return 0;
    }

    private int[] convertBin(int x) {
        String bin = Integer.toBinaryString(x);
        int b[]= new int[8];
        int i=0;
        int k = bin.length();
        for(int j=k-1; j>=0; j--){
            b[i]=Integer.parseInt(String.valueOf(bin.charAt(j)));
            i++;
        }
        if(i<8){
            for(int j=i; j<8; j++)
                b[j]=0;
        }
        return b;
    }
}
