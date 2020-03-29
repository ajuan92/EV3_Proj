package Move;

import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class Move_Driver {

	public static void main(String[] args) {

		for(;;)
		{
			for(int i = 0; i < 500; i++ ){
				Motor.B.forward();
				Motor.A.backward();
				
				Delay.msDelay(10);
			}
			
			for(int i = 0; i < 500; i++ ){
				Motor.A.forward();
				Motor.B.backward();

				Delay.msDelay(10);
			}
			break;
		}

	}
}
