package ip;

import java.awt.*;
import java.awt.image.BufferedImage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

public class Expt10 {
    BufferedImage HistogramEquiAction(BufferedImage image, int anzpixel)
    {
        int intensity[] = new int[256];
        for(int y=0;y<image.getHeight();y++){
            for(int x=0;x<image.getWidth();x++){
                Color c = new Color(image.getRGB(x, y));
                int a = c.getAlpha();
                int r = c.getRed();
                int b = c.getBlue();
                int g = c.getGreen();
                int valueBefore = (r+g+b)/3;
                intensity[valueBefore]++;
            }
        }
        int sum=0;
        float[] lut = new float[anzpixel];
        for(int i=0;i<255;i++){
            sum+=intensity[i];
            lut[i]=sum*255/anzpixel;
        }

        for(int y=0;y< image.getHeight();y++){
            for(int x=0;x<image.getWidth();x++){
                Color c = new Color(image.getRGB(x, y));
                int a = c.getAlpha();
                int r = c.getRed();
                int b = c.getBlue();
                int g = c.getGreen();
                int valueBefore = (r+g+b)/3;

                int valueAfter = (int) lut[valueBefore];
                intensity[valueAfter]++;

                Color n = new Color(valueAfter,valueAfter,valueAfter);
                image.setRGB(x, y, n.getRGB());
            }
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(int i=0;i<256;i++) {
            dataset.setValue(intensity[i],"intensity",String.valueOf(i));

        }
        JFreeChart p = ChartFactory.createBarChart("Histogram of image","Intensity Range","Frequency",dataset);
        CategoryPlot plot = p.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        ChartFrame barframe = new ChartFrame("Histogram",p);
        barframe.setVisible(true);
        barframe.setSize(450,400);

        return image;
    }
}
