import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;

public class Panneau extends JPanel {
    private String form = "Rond";
    private int posX = -50;
    private int posY = -50;

    public void paintComponent(Graphics g) {
        if (form.equals("Rond")) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLUE);
            g.fillOval(posX, posY, 50, 50);
        } else if (form.equals("Carre")) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLUE);
            g.fillRect(posX, posY, 50, 50);
        } else if (form.equals("Triangle")) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            int s1X = posX + 25;
            int s1Y = posY;
            // Le sommet 2 se situe en bas à droite
            int s2X = posX + 50;
            int s2Y = posY + 50;
            // Le sommet 3 se situe en bas à gauche
            int s3X = posX;
            int s3Y = posY + 50;
            // Nous créons deux tableaux de coordonnées
            int[] ptsX = { s1X, s2X, s3X };
            int[] ptsY = { s1Y, s2Y, s3Y };
            
            // Nous utilisons la méthode fillPolygon()
            g.setColor(Color.BLUE);

            g.fillPolygon(ptsX, ptsY, 3);
        } else if (form.equals("Etoile")) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            int s1X = posX + 25;
            int s1Y = posY;
            int s2X = posX + 50;
            int s2Y = posY + 50;
            g.setColor(Color.BLUE);

            g.drawLine(s1X, s1Y, s2X, s2Y);
            int s3X = posX;
            int s3Y = posY + 17;
            g.drawLine(s2X, s2Y, s3X, s3Y);
            int s4X = posX + 50;
            int s4Y = posY + 17;
            g.drawLine(s3X, s3Y, s4X, s4Y);
            int s5X = posX;
            int s5Y = posY + 50;
            g.drawLine(s4X, s4Y, s5X, s5Y);
            g.drawLine(s5X, s5Y, s1X, s1Y);
        }

    }

    public int getPosX() {
        return this.posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public String getForm() {
        return this.form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}
