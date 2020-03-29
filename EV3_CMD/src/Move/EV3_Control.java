package Move;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class EV3_Control {
	
	public static void Ctrl(Interfaz interfaz)throws RemoteException, NotBoundException{
		
	     int RunProgram;
	     
	     Scanner sc = new Scanner(System.in);
	     float numero1, numero2, resultado = 0;
	     String menu = "\n\n------------------\n\n[-1] => Salir\n[0] => Fordware\n[1] => Backward\n[2] => TurnLeft\n[3] => TurnRight\nElige: ";
	     do {
	    	 ////////////////////////////////////
	         System.out.println(menu);

	         try {
	             RunProgram = Integer.parseInt(sc.nextLine());
	         } catch (NumberFormatException e) {
	             RunProgram = -1;
	         }

	         if(RunProgram != -1){

	             switch (RunProgram) {
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
		                    resultado = interfaz.StopMove();
		                    break;
		                    
		            }

	             System.out.println("Resultado => " + String.valueOf(resultado));
	             System.out.println("Presiona ENTER para continuar");
	         }
	         
	      //////////////////////////////////   
	     } while (RunProgram != -1);
	}
}
