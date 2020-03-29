package Move;

import lejos.hardware.motor.Motor;
//import lejos.utility.Delay;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Move_Server {

	private static final int PUERTO = 1100; //Si cambias aquí el puerto, recuerda cambiarlo en el cliente
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Remote remote = UnicastRemoteObject.exportObject(new Interfaz() {

            public int Fordware() throws RemoteException {
            	Motor.A.backward();
            	Motor.B.backward();
            	return 0;
            };
            public int Backward() throws RemoteException {
            	Motor.A.forward();
            	Motor.B.forward();
            	return 0;
            };
            public int TurnLeft() throws RemoteException {
            	Motor.A.stop();
            	Motor.B.backward();
            	return 0;
            };
            public int TurnRight() throws RemoteException {
            	Motor.A.backward();
            	Motor.B.stop();
            	return 0;
            };
            public int SpinLeft() throws RemoteException {
            	Motor.A.forward();
            	Motor.B.backward();
            	return 0;
            };
            public int SpinRight() throws RemoteException {
            	Motor.A.backward();
            	Motor.B.forward();
            	return 0;
            };
            public int StopMove() throws RemoteException {
            	Motor.A.stop();
            	Motor.B.stop();
            	return 0;
            };
            
        }, 0);
        Registry registry = LocateRegistry.createRegistry(PUERTO);
       	System.out.println("Servidor escuchando en el puerto \n" + String.valueOf(PUERTO) + "\nListo para moverse");
        registry.bind("EV3_CMD", remote); // Registrar calculadora
    }
}
