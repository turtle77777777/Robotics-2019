/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class Pneumatics extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static Compressor compressor;

  public boolean solenoidEnabled;


  public Pneumatics() {
    compressor = new Compressor();
    solenoidEnabled = false;
  }
  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new TestPneumatics());
  }
  

  public void start() {
    if (Robot.isReal()) {
      compressor.start();
      compressor.setClosedLoopControl(true);
    }
  }
    
    public boolean getEnabled() {
    	return compressor.enabled();
    }
    public boolean getCurrentFault() {
    	return compressor.getCompressorCurrentTooHighFault();
    }
    public boolean getConnectionFault() {
    	return compressor.getCompressorNotConnectedFault();
    }
    public boolean getShortFault() {
    	return compressor.getCompressorShortedFault();
    }
    public boolean getPressureSwitch() {
    	return compressor.getPressureSwitchValue();
    }
    
/*
* Operation Functions
*/
    
    public void startCompressor() {
    	compressor.start();
    }
    public void stopCompressor() {
    	compressor.stop();
    }

    
}