package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drive;

public class DriveTime extends Command {

    private final boolean mIsTank;
    private double mValue1, mValue2, mTime;

    public DriveTime(double move, double rotate, double time) {
        mValue1 = move;
        mValue2 = rotate;
        mTime = time;
        mIsTank = false;
    }

    public DriveTime(double left, double right, double time, boolean isTank) {
        mIsTank = true;
        mValue1 = left;
        mValue2 = right;
        mTime = time;
    }

    public void initalize() {
        setTimeout(mTime);
    }

    public void execute() {
        if (mIsTank) {
            Drive.getInstance().arcade(mValue1, mValue2);
        } else {
            Drive.getInstance().tank(mValue1, mValue2);
        }
    }

    public void end() {
        Drive.getInstance().stop();
    }

    public void interrupted() {
        end();
    }

    protected boolean isFinished() {
        return isTimedOut();
    }
}