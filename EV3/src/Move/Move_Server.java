package Move;

import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
//import lejos.utility.Delay;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import lejos.robotics.SampleProvider;
import lejos.hardware.sensor.EV3UltrasonicSensor;


public class Move_Server {

	public static float[] Ussample = new float[5];
	public static float[] Touchsample1 = new float[1];
	public static float[] Touchsample2 = new float[1];
	
	public static EV3UltrasonicSensor USSensor = new EV3UltrasonicSensor(SensorPort.S1);
	public static EV3TouchSensor TSSensor1 = new EV3TouchSensor(SensorPort.S2);
	public static EV3TouchSensor TSSensor2 = new EV3TouchSensor(SensorPort.S3);
	
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
            public float ReadUltraSonic() throws RemoteException {

        		
        		SampleProvider distance= USSensor.getDistanceMode();
              	distance.fetchSample(Ussample, 0);

            	return Ussample[0];
            };
            public float ReadTouch() throws RemoteException {
            	float TouchStatus = 0;
        		SampleProvider Touch1= TSSensor1.getTouchMode();
        		SampleProvider Touch2= TSSensor2.getTouchMode();
        		
            	TSSensor1.fetchSample(Touchsample1, 0);
    			TSSensor2.fetchSample(Touchsample2, 0);
  
    			if((Touchsample1[0] == 1) || (Touchsample2[0] == 1))
    			{
    				TouchStatus = 1;
    			}
    			else
    			{
    				TouchStatus = 0;
    			}
    			
            	return TouchStatus;
            };
            
        }, 0);
        Registry registry = LocateRegistry.createRegistry(PUERTO);
       	System.out.println("Servidor escuchando en el puerto \n" + String.valueOf(PUERTO) + "\nListo para moverse");
        registry.bind("EV3_CMD", remote); // Registrar calculadora
    }
}
