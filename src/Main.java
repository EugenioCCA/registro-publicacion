
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();
        List<Tweet> tweets = new ArrayList<>();
        

        ConexionDB INSERTAR = new ConexionDB();


        int opcion;
        String[] opciones = {"Usuario", "Tweet", "Salir", "mostrarTwitts"};

        do {
            int funcion = JOptionPane.showOptionDialog(null, "Selecciona una opcion", "Twitter", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, 0);

            if (funcion == 0) {
                String nombre = JOptionPane.showInputDialog("Ingrese su nombre ");
                String correo = JOptionPane.showInputDialog("Ingrese su correo electronico ");
                String contraseña = JOptionPane.showInputDialog("Ingrese su contraseña ");
                usuarios.add(new Usuario(nombre, correo, contraseña));

                INSERTAR.insertarUsuario(nombre, contraseña, correo);

            } else if (funcion == 1) {
                String nombreUsuario = JOptionPane.showInputDialog("Indique el usuario");
                String contexto = JOptionPane.showInputDialog("Ingrese el contenido del tweet");
                tweets.add(new Tweet(contexto, nombreUsuario));
                
                INSERTAR.insertarTweet(contexto,nombreUsuario); 
                
            } else if (funcion == 2) {
                break; 

            }else if(funcion == 3) {
                String nombreUsuario = JOptionPane.showInputDialog("ingrese el nombre de usuario");
                INSERTAR.consultarTwetts(nombreUsuario);
                
                
                
            }

            opcion = 1;
        } while (opcion != 0);

    }

}
