package org.firstinspires.ftc.teamcode.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * Created by joseph on 10/21/2017.
 */
@Autonomous(name = "ENCTest")

public class ENCtest extends LinearOpMode {
    DcMotor leftwheel;
    DcMotor rightwheel;
    int target = 5000;
    int LstartPosition;
    int RstartPosition;

    @Override
    public void runOpMode() throws InterruptedException {
        leftwheel = hardwareMap.dcMotor.get("leftdrive");
        rightwheel = hardwareMap.dcMotor.get("rightdrive");
        leftwheel.setDirection(DcMotor.Direction.REVERSE);
        leftwheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightwheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LstartPosition = leftwheel.getCurrentPosition();
        RstartPosition = rightwheel.getCurrentPosition();


        waitForStart();
        leftwheel.setPower(1);
        rightwheel.setPower(1);
        leftwheel.setTargetPosition(LstartPosition + target);
        rightwheel.setTargetPosition(RstartPosition + target);
        while (leftwheel.isBusy()&& rightwheel.isBusy()){
            telemetry.addData("text", "run to position");
            telemetry.addData("Power", leftwheel.getPower());
            telemetry.addData("Power", rightwheel.getPower());
            telemetry.addData("position", leftwheel.getCurrentPosition() - LstartPosition);
            telemetry.addData("position", rightwheel.getCurrentPosition() - RstartPosition);

        }
        leftwheel.setPower(0);
        rightwheel.setPower(0);

    }
}

