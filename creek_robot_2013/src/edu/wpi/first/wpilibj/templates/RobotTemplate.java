/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import com.cc.autonomous.AutoCommand;
import com.cc.autonomous.AutoBackLeft;
import com.cc.autonomous.AutoBackRight;
import com.cc.autonomous.AutoDoNothing;
import com.cc.autonomous.AutoFrontLeft;
import com.cc.autonomous.AutoFrontRight;
import com.cc.inputs.driver.Driver;
import com.cc.systems.Chassis;
import com.cc.systems.Mechanism;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot
{

    //Robot Systems:
    Chassis chassis = null; //The chassis object for the robot
    Mechanism mechanism = null; //The mechanism object for the robot
    
    //The controller for the robot
    Driver driver = null; 
    
    //Creates the GUI for choosing the AUTO function
    SendableChooser autoChooser;
    
    //AUTO Methods:
    AutoBackLeft autoBackLeft; //AUTO function for back left of the pyramid
    AutoBackRight autoBackRight; //AUTO function for back right of the pyramid
    AutoFrontLeft autoFrontLeft; //AUTO function for front left of the pyramid
    AutoFrontRight autoFrontRight; //AUTO function for front right of the pyramid
    AutoDoNothing autoDoNothing; //AUTO function for doing nothing

    protected void robotInit()
    {
        //The generic initialize method for the robot
        super.robotInit();
        
        //Creates the controller object (Will only allow one)
        driver = Driver.getInstance();
        
        //Creates the objects of the robot Systems (Will only allow one of each)
        chassis = Chassis.getInstance();
        mechanism = Mechanism.getInstance();
        
        //Creates objects for each AUTO method
        autoBackLeft = new AutoBackLeft();
        autoBackRight = new AutoBackRight();
        autoFrontLeft = new AutoFrontLeft();
        autoFrontRight = new AutoFrontRight();
        autoDoNothing = new AutoDoNothing();
        
        //Creates the GUI for the driver to choose which AUTO method to do
        autoChooser = new SendableChooser();
        
        //Adds each method to the GUI
        autoChooser.addDefault("Back Right Side", autoBackRight);
        autoChooser.addObject("Back Left Side", autoBackLeft);
        autoChooser.addObject("Front Right Side", autoFrontRight);
        autoChooser.addObject("Front Left Side", autoFrontLeft);
        autoChooser.addObject("Do Nothing", autoDoNothing);      
        SmartDashboard.putData("Auto Chooser", autoChooser);

    }

    protected void disabled() //Diables the robot
    {
        super.disabled();
    }

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    
    public void autonomous() //Finds and runs a certain AUTO method
    {
        AutoCommand command = (AutoCommand) autoChooser.getSelected();
        command.doAuto();
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    
    public void operatorControl()//Actually controlling the robot
    {
        System.out.println("In operatorControl()");//Promts the user

        while (isEnabled()) //If the robot is on
        {
            chassis.drive(driver.getX(), driver.getY()); //Drives the chassis of the robot
            
            if (driver.getRightSwitch()) //Speed switch
            {
                mechanism.driveArm(driver.getRot()); //Use left joystick for arm
            } 
            else
            {
                mechanism.moveArm(driver.getRedButton(), driver.getBlackButton()); //Use buttons for arm
            }
        }
    }

    /**
     * This function is called once each time the robot enters test mode.
     */
    
    public void test()//Tests whatever you put in to test little things  
    {
        System.out.println("In test");

    }
}