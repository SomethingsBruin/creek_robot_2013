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
public class AutoFrontRight extends AutoCommand
{
    public void doAuto()//In AUTO mode
    {
        chassis.driveDistance( 49, 0.59, false); //Go forward
        Timer.delay( 0.5 );
        chassis.turnAngle( 56.31, 3 ); //Turn right
        Timer.delay( 0.5 );
        chassis.driveDistance( 81, 0.59, false); //Go forward
        Timer.delay( 0.5 );
        
        doArm(); //Dump Arm
    }
}
