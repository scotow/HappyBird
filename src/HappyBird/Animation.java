/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HappyBird;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author debaerdm
 */
public class Animation {
    
    Toolkit toolkit;
    Timer timer;

    public Animation() {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTask(),
                       0,        //initial delay
                       1*1000);  //subsequent rate
    }

    class RemindTask extends TimerTask {
        int numWarningBeeps = 3;
        public void run() {
            if (numWarningBeeps > 0) {
                toolkit.beep();
                System.out.format("Beep!%n");
                numWarningBeeps--;
            } else {
                toolkit.beep(); 
                System.out.format("Time's up!%n");
                //timer.cancel(); //Not necessary because
                                  //we call System.exit
                System.exit(0);   //Stops the AWT thread 
                                  //(and everything else)
            }
        }
    }

   /*private static long milliseconde;
    
    public Animation(long milliseconde) {
        this.milliseconde = milliseconde;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Animation.this.doStuff();
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }, 0, Animation.milliseconde);
    } 
    
    public void doStuff(){
        
    } */
}
