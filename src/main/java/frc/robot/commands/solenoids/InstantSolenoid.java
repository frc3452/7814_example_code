package frc.robot.commands.solenoids;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.subsystems.Pneumatics;

public class InstantSolenoid extends InstantCommand {

  private boolean mOn;

  public InstantSolenoid(boolean on) {
    //The variable 'on' cannot exist outside of these brackets
    super();
    requires(Pneumatics.getInstance());

    mOn = on;
  }

  //This doesn't work
  //System.out.println(on);
  //This does because that variable was declared outside of the brackets
  //System.out.println(mOn);
    
  protected void initialize() {
    Pneumatics.getInstance().moveSolenoid(mOn);
  }

}
