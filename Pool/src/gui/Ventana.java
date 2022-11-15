package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Ventana extends JFrame {
    // METODOS
    public Ventana(){
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("Pool");
        setResizable(true);
        this.setVisible(true); 
        this.add(new PanelPrincipal());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1280,720);      
        setLocationRelativeTo(null);
   }   
}
// Resolucion: < w = 1264  y  h = 681 >