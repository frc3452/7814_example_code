package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

    private VictorSP mShooterMotor, mShooterOther;
    private Relay mIntake;

    private SpeedController mShooterGroup;

    private static Shooter mInstance = null;

    public static Shooter getInstance() {
        if (mInstance == null)
            mInstance = new Shooter();
        return mInstance;
    }

    private Shooter() {
        mShooterMotor = new VictorSP(5);
        mShooterOther = new VictorSP(4);

        mShooterGroup = new SpeedControllerGroup(mShooterMotor, mShooterOther);

        mIntake = new Relay(0);
    }

    public void turnOnIntake(boolean turnOn) {
        if (turnOn)
            mIntake.set(Value.kReverse);
        else
            mIntake.set(Value.kOff);
    }

    // Example
    public double multiply(double a, double b) {
        return a * b;
    }

    // Example
    public int getNegativeOne() {
        return -1;
    }

    // Example
    public void example() {
        int a = 4;
        double b = 4.4;
        boolean c = true;

        b = 5.4;
        if (b == 4.4) {
        } else { // b is not 4.4
        }

        if (a == 4) {

        } else if (a == 5) {

        } else if (a == 6) {

        } else {

        }
    }

    public void print() {
        // Print outs
        System.out.println("Shooter speed: " + mShooterGroup.get());
    }

    public void set(double prcnt) {
        mShooterGroup.set(prcnt);
    }

    public void stop() {
        set(0);
    }

    protected void initDefaultCommand() {
    }
}