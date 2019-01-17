/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.subsystems.Shooter;

public class RunIntake extends InstantCommand {

  private boolean mOn;

  public RunIntake(boolean on) {
    super();
    requires(Shooter.getInstance());
    mOn = on;
  }

  @Override
  protected void initialize() {
    Shooter.getInstance().turnOnIntake(mOn);
  }

}
