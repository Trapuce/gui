import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Fenetre extends JFrame {
    Panneau pan = new Panneau();
    JPanel container = new JPanel();
    // Bouton b = new Bouton("Bouton ");
    JButton b1 = new JButton("GO");
    JButton b2 = new JButton("STOP");
    JLabel lab = new JLabel("choice a form ");
    private JComboBox combo  = new JComboBox();
    private boolean animated = true;
    private Thread t;

    public Fenetre() {
        this.setTitle("Daouda");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setLayout(new BorderLayout());
        JPanel boutonPane = new JPanel();
        b1.addActionListener(new GoListener());
        b1.setEnabled(false);
        b2.addActionListener(new StopListenner());
        JPanel top = new JPanel();
        String [] tabCombo ={"Rond" , "Triangle" , "Carre" , "Etoile"};
        combo = new JComboBox(tabCombo);
        combo.setPreferredSize(new Dimension(100,20));
        
        combo.setSelectedIndex(0);
        combo.addItemListener(new ItemState());
        combo.addActionListener(new ItemAction());
        top.add(lab);
        top.add(combo);
        boutonPane.add(b1);
        boutonPane.add(b2);
        container.add(top, BorderLayout.NORTH);
        container.add(pan, BorderLayout.CENTER);
        container.add(boutonPane, BorderLayout.SOUTH);
        this.setContentPane(container);
        this.setVisible(true);

        go();
    }

    private void go() {
        int x = pan.getPosX(), y = pan.getPosY();
        boolean backX = false;
        boolean backY = false;
        while (this.animated) {
            if (x < 1)
                backX = false;
            if (x > pan.getWidth() - 50)
                backX = true;

            if (y < 1)
                backY = false;
            if (x > pan.getHeight() - 50)
                backY = true;
            pan.repaint();

            if (!backX)
                pan.setPosX(++x);
            else
                pan.setPosX(--x);
            if (!backY)
                pan.setPosY(++y);
            else
                pan.setPosY(--y);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public class GoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            animated = true;
            t = new Thread(new PlayAnimation());
            t.start();
            b1.setEnabled(false);
            b2.setEnabled(true);
        }

    }

    public class StopListenner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            animated = false;
            b1.setEnabled(true);
            b2.setEnabled(false);

        }

    }

    class PlayAnimation implements Runnable {
        public void run() {
            go();
        }
    }
    public class ItemState implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
                            System.out.println("Vous avez change de forme :"+ e.getItem());
        }

    }
    public class ItemAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
                pan.setForm((String) combo.getSelectedItem());            
        }
        
    }
}
