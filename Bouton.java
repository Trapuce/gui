import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Bouton extends JButton implements MouseListener {
    private String name;
    private Image img;
    

    public Bouton(String name) {
        super(name);
        this.name = name;
        try {
            img = ImageIO.read(new File("vert.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20,
                Color.cyan, true);
        g2d.setPaint(gp);
        g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),
                this);
        g2d.setColor(Color.black);
        g2d.setColor(Color.white);
        g2d.drawString(this.name, this.getWidth() / 2 -
                (this.getWidth() / 2 / 4), (this.getHeight() / 2) + 5);
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        try {
            img = ImageIO.read(new File("rouge.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        try {
            img = ImageIO.read(new File("vert.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        try {
            img = ImageIO.read(new File("jaune.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        try {
            img = ImageIO.read(new File("vert.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
