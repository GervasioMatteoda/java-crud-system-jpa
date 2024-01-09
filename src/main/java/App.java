import gui.MenuForm;
import javax.swing.JFrame;

public class App {

    public static void main(String[] args) {
        inicializarGUI();
    }
    
    public static void inicializarGUI() {
        JFrame pantalla;
        pantalla = new MenuForm();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
    }
}
