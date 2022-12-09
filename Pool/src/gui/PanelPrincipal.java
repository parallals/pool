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
 * a
 * @author Francy Jelvez
 * @author Diego Venegas
 * @version versión  1.2, 08 de diciembre de 2022*/
class PanelPrincipal extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
    //PROPIEDADES
    private final MesaBillar mesaBillar;
    private final Taco taco;
    private final Timer timer;
    
    //METODOS
    /**
     * Metodo que actualiza el programa de acuerdo a los ticks del timer
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        mesaBillar.getConjunto().Movimiento();
        taco.setTurnoAcabado(mesaBillar.getConjunto().TurnoAcabado());
        taco.setXY(mesaBillar.getBola(0).getX()+15, mesaBillar.getBola(0).getY()+15);
        repaint();
    }
    /**
     * Metodo paint de PanelPrincipal
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
     * Metodo que crea  botones
     */
    private void Botones(){
        
        //Boton de Reinicio
        JButton Boton1 = new JButton("Reset");
        Boton1.setBounds(100, 700, 110,40);
        Boton1.setEnabled(true);
        Boton1.setForeground(Color.black);
        Boton1.setBackground(Color.white);
        ActionListener oyenteDeAccion1 = (ActionEvent e) -> {
            mesaBillar.reiniciarJuego();
        };
        Boton1.addActionListener(oyenteDeAccion1);        
        this.add(Boton1);
        
        //Botones para aumentar cantidad de bolas
        JButton BotonCmas = new JButton("+");
        BotonCmas.setBounds(165, 750, 45,45);
        BotonCmas.setEnabled(true);
        BotonCmas.setForeground(Color.black);
        BotonCmas.setBackground(Color.white);
        ActionListener oyenteDeAccion1a = (ActionEvent e) -> {
            mesaBillar.getConjunto().agregarBolas();
        };
        BotonCmas.addActionListener(oyenteDeAccion1a);
        this.add(BotonCmas);
        
        //Botones para disminuir cantidad de bolas
        JButton BotonCmenos = new JButton("-");
        BotonCmenos.setBounds(100, 750, 45,45);
        BotonCmenos.setEnabled(true);
        BotonCmenos.setForeground(Color.black);
        BotonCmenos.setBackground(Color.white);
        ActionListener oyenteDeAccion1b = (ActionEvent e) -> {            
            mesaBillar.getConjunto().retirarBolas();
        };
        BotonCmenos.addActionListener(oyenteDeAccion1b);
        this.add(BotonCmenos);
        
        //Boton de 1 jugador
        JRadioButton RadioBoton1 = new JRadioButton("1 Player", true);
        RadioBoton1.setBounds(300, 700, 100,20);
        RadioBoton1.setForeground(Color.black);
        RadioBoton1.setBackground(Color.white);
        ActionListener oyenteDeAccion2 = (ActionEvent e) -> {
            if(mesaBillar.getConjunto().getTurnoAcabado()==true){
            mesaBillar.setPlayers(1);            
            }
        };
        RadioBoton1.addActionListener(oyenteDeAccion2);
        this.add(RadioBoton1);
        
        //Boton de 2 jugadores
        JRadioButton RadioBoton2 = new JRadioButton("2 Players", false);
        RadioBoton2.setBounds(300, 725, 100,20);
        RadioBoton2.setForeground(Color.black);
        RadioBoton2.setBackground(Color.white);
        ActionListener oyenteDeAccion3 = (ActionEvent e) -> {
            if(mesaBillar.getConjunto().getTurnoAcabado()==true){
            mesaBillar.setPlayers(2);            
            }
        };
        RadioBoton2.addActionListener(oyenteDeAccion3);
        this.add(RadioBoton2);
        
        //Boton de 3 jugadores
        JRadioButton RadioBoton3 = new JRadioButton("3 Players", false);
        RadioBoton3.setBounds(300, 750, 100,20);
        RadioBoton3.setForeground(Color.black);
        RadioBoton3.setBackground(Color.white);
        ActionListener oyenteDeAccion4 = (ActionEvent e) -> {
            if(mesaBillar.getConjunto().getTurnoAcabado()==true){
            mesaBillar.setPlayers(3);            
            }
        };
        RadioBoton3.addActionListener(oyenteDeAccion4);
        this.add(RadioBoton3); 
        
        //Boton de 4 jugadores
        JRadioButton RadioBoton4 = new JRadioButton("4 Players", false);
        RadioBoton4.setBounds(300, 775, 100,20);
        RadioBoton4.setForeground(Color.black);
        RadioBoton4.setBackground(Color.white);
        ActionListener oyenteDeAccion5 = (ActionEvent e) -> {
            if(mesaBillar.getConjunto().getTurnoAcabado()==true){
            mesaBillar.setPlayers(4);
            }
        };
        RadioBoton4.addActionListener(oyenteDeAccion5);
        this.add(RadioBoton4);
        
        //Enlazamiento de RadioButtons de jugadores
        ButtonGroup Players = new ButtonGroup();
        Players.add(RadioBoton1);
        Players.add(RadioBoton2);
        Players.add(RadioBoton3);
        Players.add(RadioBoton4);
    }
    /**
     * Metodo que detecta movimientos del mouse
     * @param me 
     */
    @Override
    public void mouseMoved(MouseEvent me) {
        taco.setCosSen(anguloPI(mesaBillar.getBola(0).getX()+15, mesaBillar.getBola(0).getY()+15, me.getX(), me.getY()));
    }
    /**
     * Metodo mousePressed
     * @param me 
     */
    @Override
    public void mousePressed(MouseEvent me){
        taco.setPulsado(me.getPoint());
    }
    /**
     * Metodo que detecta el movimiento del mouse cuando el click esta presionado
     * @param m 
     */
    @Override
    public void mouseDragged(MouseEvent me) {
        taco.setCosSen(anguloPI(mesaBillar.getBola(0).getX()+15, mesaBillar.getBola(0).getY()+15, me.getX(), me.getY()));
        taco.setSuelto(me.getPoint());
    }
    /**
     * Metodo mouseClicked
     * @param me 
     */
    @Override
    public void mouseClicked(MouseEvent me) { 
    }
    /**
     * Metodo mouseReleased
     * @param me 
     */
    @Override
    public void mouseReleased(MouseEvent me) {
        taco.setSuelto(me.getPoint());
        taco.golpearBola();
    }
    /**
     * Metodo mouseEntered
     * @param me 
     */
    @Override
    public void mouseEntered(MouseEvent me) {
    }
    /**
     * Metodo mouseExited
     * @param me 
     */
   @Override
    public void mouseExited(MouseEvent me) {
    }
    /**
     * Metodo Constructor del PanelPrincipal
     */
    public PanelPrincipal() { 
        mesaBillar = new MesaBillar();
        taco = new Taco(mesaBillar.getBola(0),mesaBillar);
        addMouseListener(this);
        Botones();
        addMouseMotionListener(this);
        timer = new Timer(16,null);
        timer.addActionListener(this);
        timer.start();
    }
}