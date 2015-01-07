/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package version1;

import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author HHK
 */
public class FigureUtil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame jf=new JFrame();
        jf.setSize(500,500);
        jf.setLayout(new FlowLayout());
        JPanel jp=new FigurePanel();
        jf.add(jp);
        jf.setVisible(true);
    }
}
