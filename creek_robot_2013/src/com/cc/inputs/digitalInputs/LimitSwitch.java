/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.inputs.digitalInputs;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 * @author Henry Haase
 */
public class LimitSwitch
{
    
    DigitalInput di = null;
    
    public LimitSwitch(int channel)//Creates the object for the limit
    {
        di = new DigitalInput(channel);      
    }
    
    public boolean get()//Gets calue of the limit switch
    {
     return di.get();          
    }
    
}
