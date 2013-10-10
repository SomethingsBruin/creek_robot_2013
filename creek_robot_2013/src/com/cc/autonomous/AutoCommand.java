/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.autonomous;

import com.cc.systems.Chassis;
import com.cc.systems.Mechanism;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Adam Bryant
 */
public abstract class AutoCommand
{
    
    Chassis chassis = null; //Chassis object
    Mechanism mechanism = null; //Mechanism object

    public AutoCommand()//Creates the objects for the Chassis and Mechanism
    {
        chassis = Chassis.getInstance();
        mechanism = Mechanism.getInstance();
    }

    public abstract void doAuto();//A function that every AUTO function will have, but changes for each
    
    public void doArm()//Dumps the mechanism arm
    {
        mechanism.driveArm( 0.640 );
        Timer.delay( 0.55 );
        mechanism.stopArm();
        Timer.delay( 0.2 );
        mechanism.driveArm( -0.25 );
        Timer.delay( 1 );
        mechanism.stopArm();
    }
}
