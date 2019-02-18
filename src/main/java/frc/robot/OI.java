/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.shooter.RunIntake;
import frc.robot.commands.shooter.RunShooter;
import frc.robot.commands.solenoids.InstantSolenoid;

public class OI {
  public static Joystick driver, operator;

  private JoystickButton driverA, driverB, driverX, driverY, driverLB, driverRB, driverBack, driverStart, driverLClick,
      driverRClick;
  private JoystickButton operatorA, operatorB, operatorX, operatorY, operatorLB, operatorRB, operatorBack, operatorStart,
      operatorLClick, operatorRClick;

  public OI() {
    init();

    driverB.whileHeld(new RunShooter(.5));
    driverA.whenPressed(new RunIntake(true));
    driverA.whenReleased(new RunIntake(false));

    operatorA.whenPressed(new InstantSolenoid(false));
    operatorA.whenReleased(new InstantSolenoid(true));
  }

  private void init() {
    driver = new Joystick(0);
    operator = new Joystick(0);

    driverA = new JoystickButton(driver, 1);
    driverB = new JoystickButton(driver, 2);
    driverX = new JoystickButton(driver, 3);
    driverY = new JoystickButton(driver, 4);
    driverLB = new JoystickButton(driver, 5);
    driverRB = new JoystickButton(driver, 6);
    driverBack = new JoystickButton(driver, 7);
    driverStart = new JoystickButton(driver, 8);

    operatorA = new JoystickButton(operator, 1);
    operatorB = new JoystickButton(operator, 2);
    operatorX = new JoystickButton(operator, 3);
    operatorY = new JoystickButton(operator, 4);
    operatorLB = new JoystickButton(operator, 5);
    operatorRB = new JoystickButton(operator, 6);
    operatorBack = new JoystickButton(operator, 7);
    operatorStart = new JoystickButton(operator, 8);
  }

}
