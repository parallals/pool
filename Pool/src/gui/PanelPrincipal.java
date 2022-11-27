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
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;


class PanelPrincipal extends JPanel implements ActionListener {
    //PROPIEDADES
    MesaBillar mesaBillar;
    Taco taco;
    private final Timer timer;
    
    //METODOS
    /**
     * Funcion paint de PanelPrincipal
     * @param g 
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.setBackground(Color.gray);
        mesaBillar.paint(g, this);
        taco.paint(g, this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        mesaBillar.getCb().Movimiento();
        repaint();        
    }
    /**
     * Funcion que crea los botones
     */
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
    /**
     * 
     */
    private class EscuchaRaton implements MouseListener{
        /**
         * Funcion mousePressed
         * @param me 
         */
        @Override
        public void mousePressed(MouseEvent me){
            if(mesaBillar.getCb().TurnoAcabado() == true){
                taco.golpearBola();                
                repaint();
            }
        }
        /**
         * funcion mouseClicked
         * @param me 
         */
        @Override
        // w: 1064 h: 481, w - 15: 1045 h-15: 466
        public void mouseClicked(MouseEvent me) { 
            /*System.out.println("click");
            bolaBlanca.moveBola(1, 0);
            if(bolaBlanca.getX() > mesaBillar.getX()+1049 || bolaBlanca.getX() < mesaBillar.getX()){
                bolaBlanca.moveBola(1, 1);
            }
            if(bolaBlanca.getY() > mesaBillar.getY()+466 || bolaBlanca.getX() < mesaBillar.getY()){
                bolaBlanca.moveBola(1, 2);
            }
            repaint();*/
        }
        /**
         * funcion mouseReleased
         * @param me 
         */
        @Override
        public void mouseReleased(MouseEvent me) {
        }
        /**
         * funcion mouseEntered
         * @param me 
         */
        @Override
        public void mouseEntered(MouseEvent me) {
        }
        @Override
        public void mouseExited(MouseEvent me) {
        }
    }
    
    private class EscuchaRaton1 extends MouseInputAdapter {
        float angle = 0f;
        Bola bolaBlanca = mesaBillar.getCb().getBolaBlanca();    
        
        @Override
        public void mousePressed(MouseEvent me){
        }
        
        @Override
        public void mouseClicked(MouseEvent me) {
        }
        
        @Override
        public void mouseMoved(MouseEvent me) {
            Point pointBola = new Point((int)bolaBlanca.getX()+15, (int)bolaBlanca.getY()+15);
            Point pointMouse = new Point(me.getX(), me.getY());        
            angle = anguloPI(pointBola, pointMouse);
            taco.setCosSen((float) Math.cos(angle), (float) Math.sin(angle));
            taco.setXY((int)bolaBlanca.getX()+15, (int)bolaBlanca.getY()+15);
            repaint();
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
    /**
     * Constructor del Panel Principal
     */
    public PanelPrincipal() { 
        mesaBillar = new MesaBillar();
        taco = new Taco(0, 0, mesaBillar.getCb().getBolaBlanca());
        EscuchaRaton er = new EscuchaRaton();
        EscuchaRaton1 er1 = new EscuchaRaton1();
        this.addMouseListener(er); 
        this.addMouseMotionListener(er1);
        Botones();
        timer = new Timer(16,null);
        timer.addActionListener(this);
        timer.start();
    }
}