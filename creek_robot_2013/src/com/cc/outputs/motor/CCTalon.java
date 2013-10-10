/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.outputs.motor;

import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author Henry Haase
 */
public class CCTalon extends Talon
{
    
    private boolean reversed = false; //If the motor is turned around
    
    public CCTalon ( int channel, boolean reversed ) //Talon constructor
    {
        super( channel );
        this.reversed = reversed;
    }
    
    public void set( double speed ) //Sets the speed of the motor
    {
        if( reversed ) //If the motor is turned around
        {
            super.set ( speed * -1.0 );
        }
        else //If the motor is facing forward
        {
            super.set( speed );
        }
    }
}
