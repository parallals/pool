package gui;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;


class PanelPrincipal extends JPanel{
    
    @Override
    public void paint(Graphics g){
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