package ip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

public class GUIDesign{
    private JButton upload;
    private JButton save;
    private JPanel rootpanel;
    private JLabel label1;
    private JLabel label2;
    private JButton greyscale;
    private JButton negative;
    private JButton intensity;
    private JTextField fromTextField;
    private JTextField toTextField;
    private JTextField valueTextField;
    private JButton bitslicing;
    private JTextField bitSlicingTextField;
    private JButton contrast;
    private JButton wtAveragingFilterButton;
    private JButton medianFilterButton;
    private JButton boxFilterButton;
    private JButton prewitFilterButton;
    private JButton laplacianFilterButton;
    private JButton sobelFilterButton;
    private JButton histogramButton;
    private JButton histogramEquilizationButton;
    private JButton optimalThresholdingButton;
    private JButton greyScaleErosionButton;


    BufferedImage image = null;

    BufferedImage image1 = null;
    File f = null;

    public GUIDesign() {
        upload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uploadAction(e);
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAction(e);
            }
        });
        greyscale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expt2 obj1 = new Expt2();
                image1 = obj1.convertGrey(image);
                displayImage();

            }
        });
        negative.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expt3 obj2 = new Expt3();
                image1 = obj2.convertNeg(e,f,image);
                displayImage();

            }
        });
        intensity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Scanner sc= new Scanner(System.in);
                String st = fromTextField.getText();
                String st1 = toTextField.getText();
                String st2 = valueTextField.getText();
                int a = Integer.parseInt(st);
                int d = Integer.parseInt(st1);
                int v = Integer.parseInt(st2);

                Expt4 obj3  = new Expt4();
                image1= obj3.greyScaLing(image,a,d,v);
                displayImage();
            }
        });
        bitslicing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expt5 obj4 = new Expt5();
                String s1=bitSlicingTextField.getText();
                int a = Integer.parseInt(s1);
                image1 = obj4.BitPlanes(image,a);
                displayImage();
            }
        });
        contrast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expt6 obj5 = new Expt6();
                image1 = obj5.ContrastStretchingAction(image);
                displayImage();
            }
        });
        boxFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expt7a obj6 = new Expt7a();
                image1 = obj6.BoxFilterAction(image);
                displayImage();

            }
        });
        medianFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expt7c obj7 = new Expt7c();
                image1 = obj7.MedianFilterAction(image);
                displayImage();
            }
        });
        wtAveragingFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expt7b obj8 = new Expt7b();
                image1 = obj8.WAvgFilterAction(image);
                displayImage();

            }
        });
        laplacianFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expt8a obj9 = new Expt8a();
                image1 = obj9.LaplacianFilterAction(image);
                displayImage();
            }
        });
        sobelFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expt8b obj10 = new Expt8b();
                image1 = obj10.SobelFilterAction(image);
                displayImage();
            }

        });

        prewitFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expt8c obj11 = new Expt8c();
                image1 = obj11.PrewitFilterAction(image);
                displayImage();
            }
        });
        histogramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expt9 obj12 = new Expt9();
                image1 = obj12.HistogramAction(image);
                displayImage();
            }
        });
        histogramEquilizationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expt10 obj13 = new Expt10();
                int height = image.getHeight();
                int width = image.getWidth();
                int m = height*width;
                image1 = obj13.HistogramEquiAction(image,m);
                displayImage();
            }

        });
        optimalThresholdingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int width = image.getWidth();
                int height = image.getHeight();
                int intensity=0;
                for(int i=0;i<height;i++){
                    for(int j=0;j<width;j++){
                        Color c = new Color(image.getRGB(j, i)); intensity+=c.getRed();
                    }
                }
                int res = width*height;
                float thresh = intensity/res;

                Expt11 obj14 = new Expt11();
                image1 = obj14.optimalThresh(image,thresh);
                displayImage();
            }
        });
        greyScaleErosionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expt12 obj15 = new Expt12();
                image1 = obj15.grayScaleErode(image);
                displayImage();
            }
        });
    }


    private void uploadAction(ActionEvent evt){
        int width = 500;
        int height = 300;

        JFileChooser j = new JFileChooser();

        j.showSaveDialog(null);
        f = new File(j.getSelectedFile().getAbsolutePath());
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        try {
            image = ImageIO.read(f);


        } catch (IOException ex) {
            Logger.getLogger(GUIDesign.class.getName()).log(Level.SEVERE, null, ex);
        }

        Image img = image.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(img);
        label1.setIcon(icon);
    }



    private void saveAction(java.awt.event.ActionEvent evt) {
        try {
            int width = 500;
            int height = 300;
            JFileChooser j = new JFileChooser();
            j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            //Open the Save Dialog
            j.showSaveDialog(null);


            ImageIO.write(image, "png", new File(j.getSelectedFile().getAbsolutePath()));  }
        catch (IOException ex) {
            Logger.getLogger(GUIDesign.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void displayImage(){
        Image img = image1.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(img);
        label2.setIcon(icon);
    }
    public static void main(String[] args){
        JFrame frame = new JFrame("GUIDesign");
        frame.setContentPane(new GUIDesign().rootpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1480,680);
        frame.setVisible(true);

    }
}
