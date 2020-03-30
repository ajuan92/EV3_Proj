package Move;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;



public class EV3_Control {
	Thread t;
	public static void Ctrl(Interfaz interfaz)throws RemoteException, NotBoundException{
		
	    float TestUltraSonic = 0;
	    
    	TestUltraSonic =  interfaz.ReadUltraSonic();
        System.out.println("Resultado => " + String.valueOf(TestUltraSonic));

	}
}
