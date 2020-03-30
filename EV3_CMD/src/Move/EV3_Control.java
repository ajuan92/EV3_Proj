package Move;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;



public class EV3_Control {
	static final int ST_INIT = 0;
	static final int ST_SEARCH = 1;
	static final int ST_REACH_OBJ = 2;
	static final int ST_STOP = 3;
	static final int ST_RESET = 100;
	
	static private int StCtrl_CurrState = ST_INIT;
	static private int StCtrl_PrevState = ST_INIT;
	
	public static void Ctrl(Interfaz interfaz)throws RemoteException, NotBoundException{
		
		switch(StCtrl_CurrState)
		{
			
		case ST_INIT:
			StCtrl_PrevState = StCtrl_CurrState;
			StCtrl_CurrState = ST_SEARCH;
			break;
		case ST_SEARCH:
			interfaz.SpinLeft();
			if(interfaz.ReadUltraSonic() < 0.3)
			{
				interfaz.StopMove();
				StCtrl_PrevState = StCtrl_CurrState;
				StCtrl_CurrState = ST_REACH_OBJ;
			}
						
			break;
		case ST_REACH_OBJ:
			interfaz.Fordware();
			if(interfaz.ReadTouch() == 1.0)
			{
				interfaz.StopMove();
				StCtrl_PrevState = StCtrl_CurrState;
				StCtrl_CurrState = ST_STOP;
			}
			break;
		case ST_STOP:
			interfaz.StopMove();
			StCtrl_PrevState = StCtrl_CurrState;
			StCtrl_CurrState = ST_RESET;
			break;
		case ST_RESET:
			StCtrl_PrevState = StCtrl_CurrState;
			StCtrl_CurrState = ST_INIT;
			break;
		default:
			break;
		}
		
	    float TestUltraSonic = 0;
	    
    	TestUltraSonic =  interfaz.ReadTouch();
        System.out.println("Resultado => " + String.valueOf(TestUltraSonic));

	}
}
