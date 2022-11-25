package gui;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import pool.MesaBillar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.event.MouseInputAdapter;
import pool.Taco;
import pool.Bola;
import static angular.Angular.anguloPI;
import static angular.Angular.distEntre2Puntos;
import java.awt.Point;
import static java.lang.Math.*;


class PanelPrincipal extends JPanel implements ActionListener {
    //PROPIEDADES
    MesaBillar mesaBillar = new MesaBillar();
    Taco taco = new Taco(0,0);
    private Timer timer;
    
    //METODOS
    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.setBackground(Color.gray);
        mesaBillar.paint(g, this);
        taco.paint(g, this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
    private void Botones(){
        JButton Boton = new JButton();
        Boton.setBounds(100, 500, 100,50);
        Boton.setEnabled(true);
        this.add(Boton);
    }
    
    private class EscuchaRaton implements MouseListener{
        
        @Override
        public void mousePressed(MouseEvent me){
        }
        @Override
        public void mouseClicked(MouseEvent me) { 
            System.out.println("click");
        }    
        @Override
        public void mouseReleased(MouseEvent me) {
        }
        @Override
        public void mouseEntered(MouseEvent me) {
        }
        @Override
        public void mouseExited(MouseEvent me) {
        }
    }
    private class EscuchaRaton1 extends MouseInputAdapter {
    float angle = 0f;
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        taco.setXY(me.getX(),me.getY());
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        Bola bolaBlanca = mesaBillar.getCb().getConjunto().get(0);
        Point pointBola = new Point((int)bolaBlanca.getX()+15, (int)bolaBlanca.getY()+15);
        Point pointMouse = new Point(me.getX(), me.getY());        
        angle = anguloPI(pointBola,pointMouse);
        taco.setCosSen((float) cos(angle), (float) sin(angle));
        taco.setXY((int)bolaBlanca.getX()+15, (int)bolaBlanca.getY()+15);
        repaint();
    }
        
    }
    
    public PanelPrincipal() { 
        EscuchaRaton er = new EscuchaRaton();
        EscuchaRaton1 er1 = new EscuchaRaton1();
        this.addMouseListener(er); 
        this.addMouseMotionListener(er1);
        Botones();
        timer = new Timer(100,null);
        timer.addActionListener(this);
        timer.start();
    }
}