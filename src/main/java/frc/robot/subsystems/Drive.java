/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.OI;
import frc.robot.commands.drive.DriveTele;

public class Drive extends Subsystem {

  VictorSP L1, L2, R1, R2;

  SpeedControllerGroup left;
  SpeedControllerGroup right;
  DifferentialDrive drive;

  private static Drive mInstance = null;

  public static Drive getInstance() {
    if (mInstance == null)
      mInstance = new Drive();
    return mInstance;
  }

  private Drive() {
    L1 = new VictorSP(0); // PWM PORTS
    // L2 = new VictorSP(1);
    R1 = new VictorSP(1);
    // R2 = new VictorSP(6);

    left = new SpeedControllerGroup(L1);
    right = new SpeedControllerGroup(R1);
    drive = new DifferentialDrive(left, right);
  }

  public void arcade(double fwd, double rotate) {
    drive.arcadeDrive(fwd, rotate, false);
  }

  public void tank(double left, double right) {
    drive.tankDrive(left, right, false);
  }

  public void stop() {
    drive.arcadeDrive(0, 0, false);
  }

  public void initDefaultCommand() {
    setDefaultCommand(new DriveTele(OI.driver));
  }
}
