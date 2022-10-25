package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class GyroTurn extends CommandBase {

    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DriveSubsystem m_subsystem;
    double targetAngle = 90;

    //@param subsystem

    public GyroTurn(DriveSubsystem subsystem){

        m_subsystem = subsystem;

        addRequirements(subsystem);

    }

    @Override
    public void initialize(){

        m_subsystem.zeroHeading();

    }
    
    @Override
    public void execute(){

        m_subsystem.arcadeDrive(0, 0.5);

    }

    public boolean isFinished(){

        System.out.println(m_subsystem.getHeading());
        return m_subsystem.getHeading() >= targetAngle;

    }

    public void end(){

        m_subsystem.arcadeDrive(0, 0);

    }
    
}
