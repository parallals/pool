package gui;

import java.awt.event.MouseMotionListener;
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
import pool.Taco;

/** 
 * @author Francy Jelvez
 * @author Diego Venegas
 * @version versión  1, 03 de diciembre de 2022
 */
class PanelPrincipal extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
    //PROPIEDADES
    private final MesaBillar mesaBillar;
    private final Taco taco;
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
     * Metodo que crea los botones
     */
    private void Botones(){
        
        JButton Boton1 = new JButton("Reset");
        //Boton1
        Boton1.setBounds(100, 700, 100,50);
        Boton1.setEnabled(true);
        Boton1.setForeground(Color.black);
        Boton1.setBackground(Color.LIGHT_GRAY);
        ActionListener oyenteDeAccion1 = (ActionEvent e) -> {
            mesaBillar.reiniciarJuego();
        };
        Boton1.addActionListener(oyenteDeAccion1);
        this.add(Boton1);
        //Boton2
        JRadioButton RadioBoton1 = new JRadioButton("1 Player", true);
        RadioBoton1.setBounds(300, 700, 100,50);
        RadioBoton1.setForeground(Color.black);
        RadioBoton1.setBackground(Color.LIGHT_GRAY);
        ActionListener oyenteDeAccion2 = (ActionEvent e) -> {
            mesaBillar.setPlayers(1);
        };
        RadioBoton1.addActionListener(oyenteDeAccion2);
        this.add(RadioBoton1);
        //Boton3
        JRadioButton RadioBoton2 = new JRadioButton("2 Players", false);
        RadioBoton2.setBounds(300, 750, 100,50);
        RadioBoton2.setForeground(Color.black);
        RadioBoton2.setBackground(Color.LIGHT_GRAY);
        ActionListener oyenteDeAccion3 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                mesaBillar.setPlayers(2);
            }
        };
        RadioBoton2.addActionListener(oyenteDeAccion3);
        this.add(RadioBoton2);
        
        ButtonGroup Players = new ButtonGroup();
        Players.add(RadioBoton1);
        Players.add(RadioBoton2);
        //Boton4
        JRadioButton RadioBoton3 = new JRadioButton("8-Ball", true);
        RadioBoton3.setBounds(500, 700, 100,50);
        RadioBoton3.setForeground(Color.black);
        RadioBoton3.setBackground(Color.LIGHT_GRAY);
        this.add(RadioBoton3);
    }
    /**
     * Metodo que detecta movimientos del mouse
     * @param m 
     */
    @Override
    public void mouseMoved(MouseEvent m) {
        float angulo = (float) anguloPI(mesaBillar.getBola(0).getX()+15, mesaBillar.getBola(0).getY()+15, m.getX(), m.getY());
        taco.setCosSen((float) Math.cos(angulo), (float) Math.sin(angulo));
        taco.setXY(mesaBillar.getBola(0).getX()+15, mesaBillar.getBola(0).getY()+15);
    }

    /**
     * Metodo mousePressed
     * @param me 
     */
    @Override
    public void mousePressed(MouseEvent me){
        taco.golpearBola();                
        repaint();
    }
    /**
     * Metodo que detecta el movimiento del mouse cuando el click esta presionado
     * @param m 
     */
    @Override
    public void mouseDragged(MouseEvent m) {
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
    /**
     * Constructor del PanelPrincipal
     */
    public PanelPrincipal() { 
        mesaBillar = new MesaBillar();
        taco = new Taco(0, 0, mesaBillar.getBola(0),mesaBillar);
        addMouseListener(this);
        Botones();
        addMouseMotionListener(this);
        timer = new Timer(16,null);
        timer.addActionListener(this);
        timer.start();
    }
}