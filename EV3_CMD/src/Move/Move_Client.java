package Move;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.lang.*;



public class Move_Client {
	private static final String Reg = "EV3_CMD"; // Puedes cambiar a localhost
	private static final String IP = "192.168.137.154"; // Puedes cambiar a localhost
	private static final int PUERTO = 1100; //Si cambias aquí el puerto, recuerda cambiarlo en el servidor
	private static int RunProgram = 0;
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
    

	    do {
	    	
	        EV3_Control.Ctrl((Interfaz) registry.lookup(Reg)); 
	        
	        try 
	        {
	        	Thread.sleep(500);
	        }catch(Exception e)
	        {
	        	System.out.print(e);
	        }
	     } while (RunProgram != -1);

    }
}
