/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.systems;

import com.cc.outputs.motor.CCTalon;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Henry Haase
 */
public class Mechanism
{

    //The Mechanism object
    private static Mechanism INSTANCE = null;

    //Is the arm up or down
    private int armState = 0;
    
    //The arm motor
    CCTalon armMotor = null;

    private Mechanism()//Mechanism constructor 
    {
        armMotor = new CCTalon( 1, false );
    }

    public static Mechanism getInstance()//Uses singleton to create one object of Mechanism
    {
        if ( INSTANCE == null )
        {
            INSTANCE = new Mechanism();
        }

        return INSTANCE;
    }

    public void moveArm( boolean red, boolean black ) //Moves arm via buttons
    {

        switch ( armState )
        {
            case 0: //Arm Down, Not Moving

                if ( red )
                {
                    armState = 1;
                    armMotor.set( 0.640 );
                }

                break;

            case 1: // Stop Motor

               Timer.delay( 0.55 );

                armState = 2;
                this.stopArm();

                break;

            case 2: // Arm Up, Not Moving

                if ( black )
                {
                    armState = 3;
                    armMotor.set( -0.25 );
                }

                break;

            case 3: // Motor stop

                Timer.delay( 1.0 );

                armState = 0;
                this.stopArm();

                break;

        }

    }

    public void driveArm( double speed ) //Moves arm via left joystick
    {
        armState = 0;
        armMotor.set( speed );
    }

    public void stopArm() //Stops the arm
    {
        armMotor.set( 0.0 );
    }

    private double normalize( double val ) //Normalizes the values going into the arm motor
    {
        if ( val < -1.0 )
        {
            return -1.0;
        }
        else if ( val > 1.0 )
        {
            return 1.0;
        }
        else
        {
            return val;
        }
    }
}
