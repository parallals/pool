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