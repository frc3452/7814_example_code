package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drive;

public class DriveTele extends Command {

    private Joystick mJoy;

    public DriveTele(Joystick joy) {
        requires(Drive.getInstance());

        mJoy = joy;
    }

    public void initalize() {
    }

    //this code will run when no other command is using the drive
    public void execute() {
        // Drive.getInstance().tank(-mJoy.getRawAxis(1), -mJoy.getRawAxis(5));
        Drive.getInstance().arcade(-mJoy.getRawAxis(1),.4* mJoy.getRawAxis(2));
    }

    public void end() {
        Drive.getInstance().stop();
    }

    public void interrupted() {
        end();
    }

    protected boolean isFinished() {
        return false;
    }

}