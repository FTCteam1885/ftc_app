
package org.firstinspires.ftc.teamcode.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="tank drive", group="gamepad Opmode")
@Disabled
public class tank extends OpMode {
    DcMotor leftWheel;
    DcMotor rightWheel;
    DcMotor midWheel;
    double leftWheelPower;
    double rightWheelPower;
    double midWheelPower;
    @Override
    public void init() {
        leftWheel = hardwareMap.dcMotor.get("leftdrive");
        rightWheel = hardwareMap.dcMotor.get("rightdrive");
        midWheel = hardwareMap.dcMotor.get("mid drive");
        rightWheel.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void loop() {
        while( gamepad1.dpad_up == true )
        {
            leftWheelPower = 0.1;
            while (leftWheelPower < 1.0)
            {
                if( gamepad1.dpad_up != true )
                {
                    gamepad1.dpad_up = false;
                }
                leftWheelPower *= 1.5;
                leftWheel.setPower(leftWheelPower);
            }
        }
        while ( gamepad1.dpad_down == true )
        {
            leftWheelPower = -0.1;
            while ( leftWheelPower > 1.0 )
            {
                while ( leftWheelPower > -0.1 )
                {
                    if (gamepad1.dpad_down != true)
                    {
                        gamepad1.dpad_down = false;
                    }
                    leftWheelPower *= 1.5;
                    leftWheel.setPower(leftWheelPower);
                }
            }
        }
        rightWheelPower=gamepad1.right_stick_y;
        midWheelPower=gamepad1.right_stick_x;
        midWheel.setPower(midWheelPower);
        leftWheel.setPower(leftWheelPower);
        rightWheel.setPower(rightWheelPower);


    }
}



