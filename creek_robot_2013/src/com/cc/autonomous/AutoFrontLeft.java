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
public class AutoFrontLeft extends AutoCommand
{
    public void doAuto() //In AUTO
    {
        chassis.driveDistance(43, 0.59, false); //Go forward
        Timer.delay(0.5);
        chassis.turnAngle(88, 3); //Turn right
        Timer.delay(0.5);
        chassis.driveDistance(174.3, 0.59, false); //Go forward
        Timer.delay(0.5);
        chassis.turnAngle(-31, 3); //Turn left
        Timer.delay(0.5);
        chassis.driveDistance(47, 0.59, false); //Go forward
        Timer.delay(0.5);

        doArm(); //Dump arm
    }
}
