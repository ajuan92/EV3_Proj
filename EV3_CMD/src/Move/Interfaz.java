package Move;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
	Declarar firma de métodos que serán sobrescritos
*/
public interface Interfaz extends Remote {
    int Fordware() throws RemoteException;
    int Backward() throws RemoteException;
    int TurnLeft() throws RemoteException;
    int TurnRight() throws RemoteException;
    int SpinLeft() throws RemoteException;
    int SpinRight() throws RemoteException;
    int StopMove() throws RemoteException;
    float ReadUltraSonic() throws RemoteException;
    float ReadTouch() throws RemoteException;
}