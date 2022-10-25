package frc.robot.commands;

//import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj2.command.Subsystem;
//import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveSubsystem;

public class DriveForward extends CommandBase{
    @SuppressWarnings({"PWS.UnusedPrivateFeild", "PDM.SingularField"})
    private final DriveSubsystem m_Subsystem;
    private long timeStart = 0;
    private long duration = 5000;

    //@param subsystem


    public DriveForward(DriveSubsystem subsystem, long cm){
        //PIDController edu.wpi000..first.wpilibj2.command.PIDCommand.getController();
        m_Subsystem = subsystem;
        addRequirements(subsystem);

        double speed = 0.8;
        duration = (long) (cm / speed);
    }

    @Override
    public void initialize(){

      
        timeStart= System.currentTimeMillis();

    }

    @Override
    public void execute(){
    
        m_Subsystem.arcadeDrive(0.5, 0);
    
    }

    public boolean isFinished(){

        return System.currentTimeMillis() - timeStart >= duration;

    }

    public void end(){

        m_Subsystem.arcadeDrive(0, 0);

    }
}