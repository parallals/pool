package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/** 
 * a
 * @author Francy Jelvez
 * @author Diego Venegas
 * @version versión  1, 03 de diciembre de 2022
 */
public class Ventana extends JFrame {
    // METODOS
    /**
     * Contructor de la clase Ventana
     */
    public Ventana(){
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("Pool");
        setResizable(false);
        this.setVisible(true); 
        PanelPrincipal panel = new PanelPrincipal();
        panel.setLayout(null);
        this.add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1264, 864);      
        setLocationRelativeTo(null);
        /* Funcion para ver la Resolucion real de la ventana.
        getContentPane().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component c = (Component)e.getSource();
                int w = c.getWidth();
                int h = c.getHeight();
                System.out.println("w = "+w+ "  y  h = "+h);
            }
        }); */
   }   
}
// Resolucion: < w = 1519  y  h = 816 >