package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {

    private DoubleSolenoid mDoubleSolenoid;
    private Solenoid mSoleniod;

    // Shouldn't be neccesary if you construct a Solenoid
    private Compressor mCompressor;

    // Singleton constructor (this forces us
    // to only ever have one subsystem; it can
    // be bad if we construct two variables
    // of hardware on the same port, ID, etc.
    public static Pneumatics getInstance() {
        if (mInstance == null)
            mInstance = new Pneumatics();
        return mInstance;
    }

    private static Pneumatics mInstance = null;

    private Pneumatics() {
        int pcmModule = 0;
        int channel = 1;

        // If you construct any solenoid, a compressor should
        // automatically start running provided the pressure switch
        // is wired correctly. if you wanted to manually control the compressor, you
        // could do this.
        mCompressor.start();
        // or
        mCompressor.stop();

        // This constructs a single solenoid on PCM CAN ID 0, channel 1
        // You can configure the CAN ID and update the PCM with the software found at
        // below
        // https://github-production-release-asset-2e65be.s3.amazonaws.com/164143967/f3da0680-31e3-11e9-96ea-c70190f65767?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20190218%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20190218T174459Z&X-Amz-Expires=300&X-Amz-Signature=d45011dc74394cf5eb13a30a42ebe568b7d6bb7cdf2f61ca4b30d072e12e661e&X-Amz-SignedHeaders=host&actor_id=22525060&response-content-disposition=attachment%3B%20filename%3DCTRE.Phoenix.Framework.v5.14.0.0.zip&response-content-type=application%2Foctet-stream
        mSoleniod = new Solenoid(pcmModule, channel);

        // This constructs a double solenoid on PCM CAN ID 0, forward channel 4, reverse
        // channel 5
        mDoubleSolenoid = new DoubleSolenoid(0, 4, 5);
    }

    public void moveSolenoid(boolean on) {
        mSoleniod.set(on);
    }
    
    public void moveDoubleSolenoid(Value value)
    {
        mDoubleSolenoid.set(value);
    }

    @Override
    protected void initDefaultCommand() {
    }

}