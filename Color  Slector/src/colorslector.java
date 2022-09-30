import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class colorslector extends JFrame {
    public  static void main(String[] args) {
        new colorslector();
    }
    JSlider r, g, b, r1, g1, b1;
    colorslector() {
        JFrame f = new JFrame("Color Selector");
        JLabel l1 = new JLabel();
        l1.setText("#000000");
        JLabel l2 = new JLabel();
        l2.setText("#000000");
        element c = new element();

        //Background R
        JPanel p = new JPanel(new BorderLayout(2, 1));
        r = new JSlider(JSlider.VERTICAL, 0, 255, 0);
        JLabel rl = new JLabel();
        rl.setText(String.valueOf(r.getValue()));
        r.addChangeListener(e -> {
            JSlider bgr = (JSlider) e.getSource();
            int red12 = bgr.getValue();
            rl.setText(String.valueOf(bgr.getValue()));
            l1.setText("#"+Hex());
            c.setR(red12);
            c.repaint();
        });
        p.setBorder(new TitledBorder("R"));
        p.add(r, BorderLayout.CENTER);
        p.add(rl, BorderLayout.SOUTH);

        //Background G
        JPanel p1 = new JPanel(new BorderLayout(2, 1));
        g = new JSlider(JSlider.VERTICAL, 0, 255, 0);
        JLabel gl = new JLabel();
        gl.setText(String.valueOf(g.getValue()));
        g.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider bgg = (JSlider) e.getSource();
                int green = bgg.getValue();
                gl.setText(String.valueOf(bgg.getValue()));
                l1.setText("#"+Hex());
                c.setG(green);
                c.repaint();
            }
        });
        p1.setBorder(new TitledBorder("G"));
        p1.add(g, BorderLayout.CENTER);
        p1.add(gl, BorderLayout.SOUTH);

        //Background B
        JPanel p2 = new JPanel(new BorderLayout(2, 1));
        b = new JSlider(JSlider.VERTICAL, 0, 255, 0);
        JLabel bl = new JLabel();
        bl.setText(String.valueOf(b.getValue()));
        b.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider bg = (JSlider) e.getSource();
                int blue = bg.getValue();
                bl.setText(String.valueOf(bg.getValue()));
                l1.setText("#"+Hex());
                c.setB(blue);
                c.repaint();
            }
        });
        p2.setBorder(new TitledBorder("B"));
        p2.add(b, BorderLayout.CENTER);
        p2.add(bl, BorderLayout.SOUTH);

        //Background
        JPanel pan = new JPanel(new BorderLayout(2, 3));
        l1.setBorder(new TitledBorder("Hex"));
        pan.setBorder(new TitledBorder("Background"));
        pan.add(p, BorderLayout.WEST);
        pan.add(p1, BorderLayout.CENTER);
        pan.add(p2, BorderLayout.EAST);
        pan.add(l1, BorderLayout.SOUTH);

        //Foreground R
        JPanel pf1 = new JPanel(new BorderLayout(2, 1));
        r1 = new JSlider(JSlider.VERTICAL, 0, 255, 0);
        JLabel re = new JLabel();
        re.setText(String.valueOf(r1.getValue()));
        r1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider fgr = (JSlider) e.getSource();
                int red1 = fgr.getValue();
                re.setText(String.valueOf(fgr.getValue()));
                l2.setText("#"+Hex1());
                c.setR1(red1);
                c.repaint();

            }
        });
        pf1.setBorder(new TitledBorder("R"));
        pf1.add(r1, BorderLayout.CENTER);
        pf1.add(re, BorderLayout.SOUTH);

        //Foreground G
        JPanel pf2 = new JPanel(new BorderLayout(2, 1));
        g1 = new JSlider(JSlider.VERTICAL, 0, 255, 0);
        JLabel ge = new JLabel();
        ge.setText(String.valueOf(g1.getValue()));
        g1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider fgg = (JSlider) e.getSource();
                int green1 = fgg.getValue();
                ge.setText(String.valueOf(fgg.getValue()));
                l2.setText("#"+Hex1());
                c.setG1(green1);
                c.repaint();

            }
        });
        pf2.setBorder(new TitledBorder("G"));
        pf2.add(g1, BorderLayout.CENTER);
        pf2.add(ge, BorderLayout.SOUTH);

        //Foreground B
        JPanel pf3 = new JPanel(new BorderLayout(2, 1));
        b1 = new JSlider(JSlider.VERTICAL, 0, 255, 0);
        JLabel be = new JLabel();
        be.setText(String.valueOf(b1.getValue()));
        b1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider fgb = (JSlider) e.getSource();
                int blue1 = fgb.getValue();
                be.setText(String.valueOf(fgb.getValue()));
                l2.setText("#"+Hex1());
                c.setB1(blue1);
                c.repaint();

            }
        });
        pf3.setBorder(new TitledBorder("B"));
        pf3.add(b1, BorderLayout.CENTER);
        pf3.add(be, BorderLayout.SOUTH);

        //Foreground
        JPanel p01 = new JPanel(new BorderLayout(2, 3));
        l2.setBorder(new TitledBorder("Hex"));
        p01.setBorder(new TitledBorder("Foreground"));
        p01.add(pf1, BorderLayout.WEST);
        p01.add(pf2, BorderLayout.CENTER);
        p01.add(pf3, BorderLayout.EAST);
        p01.add(l2, BorderLayout.SOUTH);

        f.add(pan, BorderLayout.WEST);
        f.add(p01, BorderLayout.EAST);
        f.add(c, BorderLayout.CENTER);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);

    }


    private String Hex()
    {
        int red = r.getValue();
        int green = g.getValue();
        int blue = b.getValue();
        Color c = new Color(red,green,blue);
        String hex = Integer.toHexString(c.getRGB() & 0xffffff);
        return hex;
    }
    private String Hex1()
    {
        int red = r1.getValue();
        int green = g1.getValue();
        int blue = b1.getValue();
        Color c = new Color(red,green,blue);
        String hex1 = Integer.toHexString(c.getRGB() & 0xffffff);
        return hex1;
    }


}

class element extends JPanel {
    int r;
    int g;
    int b;
    int r1, g1, b1;

    public void setR(int r) {
        this.r = r;
    }
    public void setG(int g) {
        this.g = g;
    }
    public void setB(int b) {
        this.b = b;
    }
    public void setR1(int r1) {
        this.r1 = r1;
    }

    public void setG1(int g1) {
        this.g1 = g1;
    }

    public void setB1(int b1) {
        this.b1 = b1;
    }
    public void paint(Graphics gr) {
        super.paint(gr);
        Color c = new Color(r, g, b);
        this.setBackground(c);
        Color c1 = new Color(r1, g1, b1);
        this.setForeground(c1);
        int cX = getWidth() / 2;
        int cY = getHeight() / 2;
        int r = getWidth() / 5;
        int r1 = getWidth() / 4;
        int r2 = getWidth() / 3;
        gr.fillOval(cX - r, cY - r, r * 2, r * 2);
        gr.drawOval(cX - r1, cY - r1, r1 * 2, r1 * 2);
        gr.drawString("GUIProject03, 12-06-21, 5:00pm", cX - r2, cY - r2);

    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

}



