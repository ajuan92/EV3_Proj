package Move;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Move_Client {
	private static final String IP = "192.168.137.69"; // Puedes cambiar a localhost
	private static final int PUERTO = 1100; //Si cambias aquí el puerto, recuerda cambiarlo en el servidor
	
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
        Interfaz interfaz = (Interfaz) registry.lookup("EV3_CMD"); //Buscar en el registro...
       
        Scanner sc = new Scanner(System.in);
        int eleccion;
        float numero1, numero2, resultado = 0;
        String menu = "\n\n------------------\n\n[-1] => Salir\n[0] => Fordware\n[1] => Backward\n[2] => TurnLeft\n[3] => TurnRight\nElige: ";
        do {
            System.out.println(menu);

            try {
                eleccion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                eleccion = -1;
            }

            if(eleccion != -1){

                switch (eleccion) {
	                case 0:
	                    resultado = interfaz.Fordware();
	                    break;
	                case 1:
	                    resultado = interfaz.Backward();
	                    break;
	                case 2:
	                    resultado = interfaz.TurnLeft();
	                    break;
	                case 3:
	                    resultado = interfaz.TurnRight();
	                    break;
	                case 4:
	                	resultado = interfaz.SpinLeft();
	                    break;
	                case 5:
	                    resultado = interfaz.SpinRight();
	                    break;
	                case 6:
	                    resultado = interfaz.SpinRight();
	                    break;
	                case 7:
	                    resultado = interfaz.StopMove();
	                    break;
	                default:
//	                    resultado = interfaz.StopMove();
	                    break;
	                    
	            }

                System.out.println("Resultado => " + String.valueOf(resultado));
                System.out.println("Presiona ENTER para continuar");
//                sc.nextLine();
            }
        } while (eleccion != -1);
    }
}
