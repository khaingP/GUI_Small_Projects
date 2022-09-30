import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Khaings23840 extends JPanel{
    public static void main(String[] args) {
        JFrame f= new JFrame("Resizable Square");
        JSlider s= new JSlider(0,100);
        JLabel l=new JLabel();
        s.setMajorTickSpacing(20);
        s.setMinorTickSpacing(10);
        s.setPaintTicks(true);
        s.setPaintLabels(true);
        s.setBorder(new TitledBorder("Size of Square"));
        Square sq=new Square();
        s.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider s2 = (JSlider) e.getSource();
                    int w2=s2.getValue();
                    int h2=s2.getValue();
                    sq.setWidth(w2);
                    sq.setHeight(h2);
                    sq.repaint();

            }
        });
        f.add(s,BorderLayout.SOUTH);
        f.add(sq);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);

    }

}
class Square extends JPanel{
    int w;
    int h;

    public void setWidth(int w) {
        this.w = w;
    }

    public void setHeight(int h) {
        this.h = h;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        int x = this.getWidth() / 2 - w / 2;
        int y = this.getHeight() / 2 - h / 2;
        g.fillRect(x, y, w, h);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
    }






