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
import java.awt.Point;
import static java.lang.Math.*;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;


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
        JButton Boton1 = new JButton("Reset");
        Boton1.setBounds(100, 700, 100,50);
        Boton1.setEnabled(true);
        Boton1.setForeground(Color.black);
        Boton1.setBackground(Color.LIGHT_GRAY);
        this.add(Boton1);
        
        JRadioButton RadioBoton1 = new JRadioButton("1 Player", true);
        RadioBoton1.setBounds(300, 700, 100,50);
        RadioBoton1.setForeground(Color.black);
        RadioBoton1.setBackground(Color.LIGHT_GRAY);
        this.add(RadioBoton1);
        
        JRadioButton RadioBoton2 = new JRadioButton("2 Players", false);
        RadioBoton2.setBounds(300, 750, 100,50);
        RadioBoton2.setForeground(Color.black);
        RadioBoton2.setBackground(Color.LIGHT_GRAY);
        this.add(RadioBoton2);
        
        ButtonGroup Players = new ButtonGroup();
        Players.add(RadioBoton1);
        Players.add(RadioBoton2);
        
        JRadioButton RadioBoton3 = new JRadioButton("8-Ball", true);
        RadioBoton3.setBounds(500, 700, 100,50);
        RadioBoton3.setForeground(Color.black);
        RadioBoton3.setBackground(Color.LIGHT_GRAY);
        this.add(RadioBoton3);
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