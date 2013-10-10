/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.autonomous;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Adam Bryant
 */
public class AutoCenter extends AutoCommand
{

    public void doAuto()
    {
        chassis.driveDistance( 36, -0.59, false);//Go forward
        Timer.delay( 0.5 );
        chassis.turnAngle( 90, 3 );//Turn right
        Timer.delay( 0.5 );
        chassis.driveDistance( 60, 0.59, false);//Go forward
        Timer.delay( 0.5 );
        chassis.turnAngle( -90, 3 );//Turn left
        Timer.delay( 0.5 );
        chassis.driveDistance( 195, 0.59, false);//Go forward
        Timer.delay( 0.5 );
        chassis.turnAngle( 56.31, 3 );//Turn right
        Timer.delay( 0.5 );
        chassis.driveDistance( 90, 0.59, false);//Go forward
        Timer.delay( 0.5 );
        
        doArm();//Dump arm
    }
    
}
