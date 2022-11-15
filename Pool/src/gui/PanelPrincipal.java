package gui;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import pool.Bola1;
import pool.Bola2;
import pool.Bola3;
import pool.Mesa;


class PanelPrincipal extends JPanel{
    //PROPIEDADES
    Mesa m = new Mesa();
    Bola1 b1 = new Bola1(400, 400);
    
    Bola2 b2 = new Bola2(400, 500);
    
    Bola3 b3 = new Bola3(500, 400);
    
    
    //METODOS
    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.setBackground(Color.gray);
        m.paint(g, this);
        b1.paint(g, this);
        b2.paint(g, this);
        b3.paint(g, this);
    }
           
    private class EscuchaRaton implements MouseListener{
        
        @Override
        public void mousePressed(MouseEvent me){
        }
        // Eventos del Mouse que no ocuparemos
        @Override
        public void mouseClicked(MouseEvent me) { 
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
    
    public PanelPrincipal() { 
        EscuchaRaton er = new EscuchaRaton();
        this.addMouseListener(er);
    }
}