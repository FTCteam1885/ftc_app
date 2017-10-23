
package org.firstinspires.ftc.teamcode.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="tank RC", group="gamepad Opmode")
//@Disabled
public class newtank extends OpMode {
    DcMotor leftwheel;
    DcMotor rightwheel;
    DcMotor midwheel;
    Servo TestServo;
    Servo Testservo;
    double leftwheelpower;
    double rightwheelpower;
    double midwheelpower;

    @Override
    public void init() {
        leftwheel = hardwareMap.dcMotor.get("leftdrive");
        rightwheel = hardwareMap.dcMotor.get("rightdrive");
        midwheel = hardwareMap.dcMotor.get("middrive");
        TestServo = hardwareMap.servo.get("Test Servo");
        Testservo = hardwareMap.servo.get("testservo");
        rightwheel.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void loop() {
        leftwheelpower = gamepad1.left_stick_y;
        rightwheelpower = gamepad1.right_stick_y;
        midwheelpower = gamepad1.right_stick_x;
        leftwheel.setPower(leftwheelpower);
        midwheel.setPower(midwheelpower);
        rightwheel.setPower(rightwheelpower);

        if (gamepad1.right_bumper) {
            TestServo.setPosition(1);
            Testservo.setPosition(1);
        } else {
            TestServo.setPosition(0);
            Testservo.setPosition(0);
        }

    }
}