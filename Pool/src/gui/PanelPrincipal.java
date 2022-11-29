package gui;

import javax.swing.event.MouseInputAdapter;
import static angular.Angular.anguloPI;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import pool.MesaBillar;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseMotionListener;
import pool.Taco;


class PanelPrincipal extends JPanel implements ActionListener, MouseMotionListener {
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
    /**
     * 
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        mesaBillar.getConjunto().Movimiento();
        taco.setTurnoAcabado(mesaBillar.getConjunto().TurnoAcabado());
        repaint();
    }
    /**
     * Funcion que crea los botones
     */
    public void Botones(){
        
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

    @Override
    public void mouseDragged(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        float angulo;
        Point pointMouse = new Point(arg0.getX(), arg0.getY());
        Point pointBola = new Point((int)mesaBillar.getBola(0).getX()+15, (int)mesaBillar.getBola(0).getY()+15);   
        angulo = anguloPI(pointBola, pointMouse);
        taco.setCosSen((float) Math.cos(angulo), (float) Math.sin(angulo));
        taco.setXY(pointBola.x, pointBola.y);
    }
    /**
     * Clase EscuchaRaton1
     */
    private class EscuchaRaton1 implements MouseListener{
        /**
         * Funcion mousePressed
         * @param me 
         */
        @Override
        public void mousePressed(MouseEvent me){
            taco.golpearBola();                
            repaint();
        }
        /**
         * funcion mouseClicked
         * @param me 
         */
        @Override
        public void mouseClicked(MouseEvent me) { 
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
        /**
         * funcion mouseExited
         * @param me 
         */
        @Override
        public void mouseExited(MouseEvent me) {
        }
    }
    /**
     * Constructor del PanelPrincipal
     */
    public PanelPrincipal() { 
        mesaBillar = new MesaBillar();
        taco = new Taco(0, 0, mesaBillar.getBola(0));
        EscuchaRaton1 er1 = new EscuchaRaton1();
        this.addMouseListener(er1); 
        Botones();
        addMouseMotionListener(this);
        timer = new Timer(16,null);
        timer.addActionListener(this);
        timer.start();
    }
}