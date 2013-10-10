/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.inputs.driver;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Adam Bryant
 */
public class Driver
{

    private static Driver INSTANCE = null;
    private final Joystick joy;
    private static final double XCENTER = 0.000;
    private static final double YCENTER = 0.016;
    private static final double ROTCENTER = 0.039;
    private static final double XMIN = -0.711;
    private static final double XMAX = 0.803;
    private static final double YMIN = -0.586 - YCENTER;
    private static final double YMAX = 0.685 - YCENTER;
    private static final double ZMIN = -1.0;
    private static final double ZMAX = 1.0;
    private static final double ROTMIN = -0.734 - ROTCENTER;
    private static final double ROTMAX = 0.882 - ROTCENTER;
    private static final double XEXPO = 0.8;
    private static final double YEXPO = 0.4;
    private static final double ROTEXPO = 0.0;
    private static final double XSCALE = 1.3;
    private static double maxSpeed = 0.95;
    private static double minSpeed = -0.95;
    //Left hand y-axis max 0.843
    //left hand y-axis min -0.406
    //Left switch facing away: false
    //Right switch facing away: false

    private Driver()//Driver constructor
    {
        this.joy = new Joystick( 1 );
    }

    public static Driver getInstance()//Makes driver a singleton, so that there is only one
    {
        if ( INSTANCE == null )
        {
            INSTANCE = new Driver();
        }

        return INSTANCE;
    }

    public double reduceSpeed( double speed, boolean xAxis )
    {
 
        if ( xAxis )//If the joystick has inverted axis
        {
            maxSpeed = 1.0;
            minSpeed = -1.0;
        }
        else
        {
            if ( joy.getRawButton( 2 ) ) //Gets right switch value which determines max speed
            {
                maxSpeed = 1.0;//High speed
                minSpeed = -1.0;
            }
            else
            {
                maxSpeed = 0.55;//Low speed
                minSpeed = -0.55;
            }
        }

        if ( speed < minSpeed ) //Makes sure that current speed is under or above a certain value
        {
            return minSpeed;
        }
        else if ( speed > maxSpeed )
        {
            return maxSpeed;
        }
        else
        {
            return speed;
        }
    }

    public double getY()//Gets the y-value of the right joystick
    {
        double y = normalize( joy.getAxis( Joystick.AxisType.kY ) - YCENTER, YMIN, YMAX ) * -1.0;
        y = reduceSpeed( y, false );
        y = expo( y, YEXPO );

        return y;
    }

    public double getX()//Gets the x-value of the right joystick
    {

        double x = normalize( joy.getAxis( Joystick.AxisType.kX ) - XCENTER, XMIN, XMAX );
        x = reduceSpeed( x, true );
        x = expo( x, XEXPO );

        return x * XSCALE;
    }

    public double getRot()//Gets the y-value of the left joystick
    {
        double rot = normalize( joy.getRawAxis( 5 ), ROTMIN, ROTMAX );
        rot = expo( rot, ROTEXPO );

        return rot;
    }

    private double normalize( double joyVal, double min, double max )// Normalize input values to -1.0 to 1.0
    {

        double retVal = 0.0;

        if ( joyVal < 0.0 )
        {
            retVal = Math.abs( joyVal ) / min;
        }
        else if ( joyVal > 0.0 )
        {
            retVal = Math.abs( joyVal ) / max;
        }

        if ( retVal < -1.0 )
        {
            retVal = -1.0;
        }
        else if ( retVal > 1.0 )
        {
            retVal = 1.0;
        }

        return retVal;
    }

    private double expo( double x, double a )//Expo function
    {
        return (a * (x * x * x) + (1 - a) * x);
    }

    public void getRawAxis() //Gets teh raw value of an zxis
    {
        for ( int i = 1; i <= 6; i++ )
        {
            print( "" + i + "", joy.getRawAxis( i ) );
        }
        System.out.println();
    }

    private void print( String str, double val )//Prints value of axis
    {
        System.out.print( " " + str + ":" + val );
    }
    
    private void print( String str, boolean val )//Prints value of axis
    {
        System.out.print( " " + str + ":" + val );
    }

    public void getRawButton()//Gets the value of buttons on the controller
    {
        for ( int i = 1; i <= 12; i++ )
        {
            print( "" + i + "", joy.getRawButton( i ) );
        }
        System.out.println();
    }

    //1=red 4=black 
    public boolean getRedButton() //returns true if red button is pressed
    {
        return joy.getRawButton( 1 );
    }

    public boolean getBlackButton() //returns true if black button is pressed
    {
        return joy.getRawButton( 4 );
    }

    public boolean getLeftSwitch() //returns true if left switch towards driver
    {
        return joy.getRawButton( 2 );
    }

    public boolean getRightSwitch() //returns true is right switch towards driver
    {
        return joy.getRawButton( 3 );
    }
}
