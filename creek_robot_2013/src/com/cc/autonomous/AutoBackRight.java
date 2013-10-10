/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.autonomous;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Henry Haase
 */
public class AutoBackRight extends AutoCommand
{

    public void doAuto() //In AUTO mode
    {

        chassis.driveDistance( 143, 0.59, false); //Go forward
        Timer.delay( 0.5 );
        chassis.turnAngle( 56.31, 3 ); //Turn Right
        Timer.delay( 0.5 );
        chassis.driveDistance( 81, 0.59, false); //Go forward
        Timer.delay( 0.5 );
        
        doArm(); //Dump arm

    }
}
