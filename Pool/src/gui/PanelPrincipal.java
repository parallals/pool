package gui;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import pool.ConjuntoBolas;

import pool.Mesa;


class PanelPrincipal extends JPanel{
    //PROPIEDADES
    Mesa m = new Mesa();
    ConjuntoBolas c = new ConjuntoBolas();
    
    
    //METODOS
    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.setBackground(Color.gray);
        m.paint(g, this);
        c.paint(g, this);
    }
           
    private class EscuchaRaton implements MouseListener{
        
        @Override
        public void mousePressed(MouseEvent me){
        }
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