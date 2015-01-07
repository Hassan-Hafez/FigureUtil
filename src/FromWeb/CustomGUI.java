package FromWeb;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;

public class CustomGUI extends Canvas {

    private Image offscreenImage;
    private Graphics offscreenGraphics;
    private Dimension offscreenDimension;

    int i=10;
    // ...
    @Override
    public void paint(Graphics g) {
        Dimension currentSize = getSize();
        for (int i = 0; i < 100; i++) {

            if (offscreenImage == null || !currentSize.equals(offscreenDimension)) {
                // call the 'java.awt.Component.createImage(...)' method to get an
                // image
                offscreenImage = createImage(currentSize.width, currentSize.height);
                offscreenGraphics = offscreenImage.getGraphics();
                offscreenDimension = currentSize;
            }

            // rendering code here (use offscreenGraphics 'Graphics' object)
            // this algorithm assumes the background will be re-filled because it 
            // reuses the image object (otherwise artifacts will 
            // remain from previous renderings)
            offscreenGraphics.setColor(Color.WHITE);
            offscreenGraphics.fillRect(0, 0, offscreenDimension.width, offscreenDimension.height);
            offscreenGraphics.setColor(Color.BLACK);
            offscreenGraphics.drawLine(0, 0, i, i++); // arbitrary rendering logic

            // paint back buffer to main graphics
            g.drawImage(offscreenImage, 0, 0, this);
        }
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(500, 500);
        //jf.setLayout(new FlowLayout());
        CustomGUI test = new CustomGUI();
        jf.add(test);
        jf.setVisible(true);
    }
}