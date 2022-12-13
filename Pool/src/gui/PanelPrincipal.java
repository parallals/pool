package gui;

import java.awt.event.MouseMotionListener;
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
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import pool.MediadorJuego;

/** 
 * JPanel Principal que llama a las principales clases del Pool para hacerlas funcionar y relacionarse, ademas de agregar botones y forma de interactuar con el programa.
 * @author Francy Jelvez
 * @author Diego Venegas
 * @version versión  1.2, 08 de diciembre de 2022*/
class PanelPrincipal extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
    //PROPIEDADES
    private final MediadorJuego Mediador;
    private final Timer timer;
    
    //METODOS
    /**
     * Metodo que actualiza el programa de acuerdo a los ticks del timer
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        Mediador.ActionPerformed();
        repaint();
    }
    /**
     * Metodo paint de PanelPrincipal
     * @param g
     */
    @Override
    public void paint(Graphics g){
        setBackground(Color.black);
        //Image i1 = new ImageIcon(this.getClass().getResource("../Textures/Fondo.jpeg")).getImage();
        //g.drawImage(i1,0,0,1519,864,this);
        super.paint(g);
        Mediador.paint(g, this);
    }
    /**
     * Metodo que crea  botones
     */
    private void Botones(){
        
        //Boton de Reinicio
        JButton botonReset = new JButton("Reset");
        botonReset.setBounds(100, 650, 110,40);
        botonReset.setEnabled(true);
        botonReset.setForeground(Color.black);
        botonReset.setBackground(Color.white);
        ActionListener oyenteBotonReset = (ActionEvent e) -> {
            Mediador.ReiniciarJuego();
        };
        botonReset.addActionListener(oyenteBotonReset);        
        this.add(botonReset);
        
        //Botones para aumentar cantidad de bolas
        JButton botonSumaBola = new JButton("+");
        botonSumaBola.setBounds(165, 700, 45,45);
        botonSumaBola.setEnabled(true);
        botonSumaBola.setForeground(Color.black);
        botonSumaBola.setBackground(Color.white);
        ActionListener oyenteBotonSumaBola = (ActionEvent e) -> {
            Mediador.AgregarBolas();
        };
        botonSumaBola.addActionListener(oyenteBotonSumaBola);
        this.add(botonSumaBola);
        
        //Botones para disminuir cantidad de bolas
        JButton botonRestaBola = new JButton("-");
        botonRestaBola.setBounds(100, 700, 45,45);
        botonRestaBola.setEnabled(true);
        botonRestaBola.setForeground(Color.black);
        botonRestaBola.setBackground(Color.white);
        ActionListener oyenteBotonRestaBola = (ActionEvent e) -> {            
            Mediador.RetirarBolas();
        };
        botonRestaBola.addActionListener(oyenteBotonRestaBola);
        this.add(botonRestaBola);
        
        //Boton de 1 jugador
        JRadioButton boton1Player = new JRadioButton("1 Player", true);
        boton1Player.setBounds(300, 650, 100,20);
        boton1Player.setForeground(Color.black);
        boton1Player.setBackground(Color.white);
        ActionListener oyenteBoton1Player = (ActionEvent e) -> {
            Mediador.CambiarJugadores(1);
        };
        boton1Player.addActionListener(oyenteBoton1Player);
        this.add(boton1Player);
        
        //Boton de 2 jugadores
        JRadioButton boton2Players = new JRadioButton("2 Players", false);
        boton2Players.setBounds(300, 675, 100,20);
        boton2Players.setForeground(Color.black);
        boton2Players.setBackground(Color.white);
        ActionListener oyenteBoton2Players = (ActionEvent e) -> {
            Mediador.CambiarJugadores(2);
        };
        boton2Players.addActionListener(oyenteBoton2Players);
        this.add(boton2Players);
        
        //Boton de 3 jugadores
        JRadioButton boton3Players = new JRadioButton("3 Players", false);
        boton3Players.setBounds(300, 700, 100,20);
        boton3Players.setForeground(Color.black);
        boton3Players.setBackground(Color.white);
        ActionListener oyenteBoton3Players = (ActionEvent e) -> {
            Mediador.CambiarJugadores(3);
        };
        boton3Players.addActionListener(oyenteBoton3Players);
        this.add(boton3Players); 
        
        //Boton de 4 jugadores
        JRadioButton boton4Players = new JRadioButton("4 Players", false);
        boton4Players.setBounds(300, 725, 100,20);
        boton4Players.setForeground(Color.black);
        boton4Players.setBackground(Color.white);
        ActionListener oyenteBoton4Players = (ActionEvent e) -> {
            Mediador.CambiarJugadores(4);
        };
        boton4Players.addActionListener(oyenteBoton4Players);
        this.add(boton4Players);
        
        //Enlazamiento de RadioButtons de jugadores
        ButtonGroup Players = new ButtonGroup();
        Players.add(boton1Player);
        Players.add(boton2Players);
        Players.add(boton3Players);
        Players.add(boton4Players);
    }
    /**
     * Metodo que detecta movimientos del mouse
     * @param me Mouse Event.
     */
    @Override
    public void mouseMoved(MouseEvent me) {
        Mediador.MovimientoMouse(me.getX(), me.getY());
    }
    /**
     * Metodo mousePressed
     * @param me Mouse Event.
     */
    @Override
    public void mousePressed(MouseEvent me){
        Mediador.PulsarMouse(me.getPoint());
    }
    /**
     * Metodo que detecta el movimiento del mouse cuando el click esta presionado
     * @param m Mouse Event.
     */
    @Override
    public void mouseDragged(MouseEvent me) {
        Mediador.MovimientoMouse(me.getX(), me.getY());
        Mediador.SoltarMouse(me.getPoint());
    }
    /**
     * Metodo mouseClicked
     * @param me Mouse Event.
     */
    @Override
    public void mouseClicked(MouseEvent me) { 
    }
    /**
     * Metodo mouseReleased
     * @param me Mouse Event.
     */
    @Override
    public void mouseReleased(MouseEvent me) {
        Mediador.SoltarMouse(me.getPoint());
        Mediador.GolpearBola();
    }
    /**
     * Metodo mouseEntered
     * @param me Mouse Event.
     */
    @Override
    public void mouseEntered(MouseEvent me) {
    }
    /**
     * Metodo mouseExited
     * @param me Mouse Event.
     */
   @Override
    public void mouseExited(MouseEvent me) {
    }
    /**
     * Metodo Constructor del PanelPrincipal
     */
    public PanelPrincipal() {
        Mediador = MediadorJuego.getInstancia();
        addMouseListener(this);
        Botones();
        addMouseMotionListener(this);
        timer = new Timer(16,null);
        timer.addActionListener(this);
        timer.start();
    }
}