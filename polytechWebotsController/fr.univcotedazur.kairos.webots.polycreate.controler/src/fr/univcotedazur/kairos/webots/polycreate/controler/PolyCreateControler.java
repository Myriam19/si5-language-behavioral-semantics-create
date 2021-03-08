/*******************************************************************************
 * Copyright (c) 2017 I3S and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     UCA - I3S Laboratory - julien.deantoni@univ-cotedazur.fr -> initial API
 *******************************************************************************/

package fr.univcotedazur.kairos.webots.polycreate.controler;

import java.util.Random;

import com.cyberbotics.webots.controller.Camera;
import com.cyberbotics.webots.controller.CameraRecognitionObject;
import com.cyberbotics.webots.controller.Compass;
import com.cyberbotics.webots.controller.DistanceSensor;
import com.cyberbotics.webots.controller.GPS;
import com.cyberbotics.webots.controller.LED;
import com.cyberbotics.webots.controller.Motor;
import com.cyberbotics.webots.controller.Node;
import com.cyberbotics.webots.controller.Pen;
import com.cyberbotics.webots.controller.PositionSensor;
import com.cyberbotics.webots.controller.Receiver;
import com.cyberbotics.webots.controller.Robot;
import com.cyberbotics.webots.controller.Supervisor;
import com.cyberbotics.webots.controller.TouchSensor;

public class PolyCreateControler extends Robot {

	public static int MAX_SPEED = 16;
	public static int NULL_SPEED = 0;
	public static int HALF_SPEED = 3;
	public static int MIN_SPEED = -16;

	public static double WHEEL_RADIUS = 0.023;
	public static double AXLE_LENGTH = 0.271756;
	public static double ENCODER_RESOLUTION = 507.9188;

	/**
	 * the inkEvaporation parameter in the WorldInfo element of the robot scene may be interesting to access
	 */
	public Pen pen = null;
	
	public Compass compass = null;

	public Pen getPen() {
		return pen;
	}


	public Motor[] gripMotors = new Motor[2];
	public DistanceSensor gripperSensor = null;

	public Motor leftMotor = null;
	public Motor rightMotor = null;

	public PositionSensor leftSensor = null;
	public PositionSensor rightSensor = null;

	public LED ledOn = null;
	public LED ledPlay = null;
	public LED ledStep = null;

	public TouchSensor leftBumper = null;
	public TouchSensor rightBumper = null;

	public DistanceSensor leftCliffSensor = null;
	public DistanceSensor rightCliffSensor = null;
	public DistanceSensor frontLeftCliffSensor = null;
	public DistanceSensor frontRightCliffSensor = null;

	public Camera frontCamera = null;
	public Camera backCamera = null;

	public Receiver receiver = null;

	public GPS gps = null;
	
	public 	int timestep = Integer.MAX_VALUE;
	public 	Random random = new Random();



	public PolyCreateControler() {
		timestep = (int) Math.round(this.getBasicTimeStep());

		pen = createPen("pen");

		gripMotors[0] = createMotor("7");
		gripMotors[1] = createMotor("7 left");
		gripperSensor = createDistanceSensor("gripper middle distance sensor");
		gripperSensor.enable(timestep);

		leftMotor = createMotor("left wheel motor");
		rightMotor = createMotor("right wheel motor");
		leftMotor.setPosition(Double.POSITIVE_INFINITY);
		rightMotor.setPosition(Double.POSITIVE_INFINITY);
		leftMotor.setVelocity(0.0);
		rightMotor.setVelocity(0.0);

		leftSensor = createPositionSensor("left wheel sensor");
		rightSensor = createPositionSensor("right wheel sensor");
		leftSensor.enable(timestep);
		rightSensor.enable(timestep);

		ledOn = createLED("led_on");
		ledPlay = createLED("led_play");
		ledStep = createLED("led_step");

		leftBumper = createTouchSensor("bumper_left");
		rightBumper = createTouchSensor("bumper_right");
		leftBumper.enable(timestep);
		rightBumper.enable(timestep);

		leftCliffSensor = createDistanceSensor("cliff_left");
		rightCliffSensor = createDistanceSensor("cliff_right");
		frontLeftCliffSensor = createDistanceSensor("cliff_front_left");
		frontRightCliffSensor = createDistanceSensor("cliff_front_right");
		leftCliffSensor.enable(timestep);
		rightCliffSensor.enable(timestep);
		frontLeftCliffSensor.enable(timestep);
		frontRightCliffSensor.enable(timestep);

		frontCamera = createCamera("frontCamera");
		frontCamera.enable(timestep);
		frontCamera.recognitionEnable(timestep);

		backCamera = createCamera("backCamera");
		backCamera.enable(timestep);
		backCamera.recognitionEnable(timestep);

		receiver = createReceiver("receiver");
		receiver.enable(timestep);

		gps = createGPS("gps");
		gps.enable(timestep);
		
		compass = createCompass("compass");
		compass.enable(timestep);
		
		PolyCreateControler ctrl = this;
		Runtime.getRuntime().addShutdownHook(new Thread()
		{
			@Override
			public void run()
			{
				System.out.println("Shutdown hook ran!");
				ctrl.delete();
			}
		});
	}
	
	/**
	 * Compute the relative orientation of an object whose position and orientation matrices are given as parameter, with respect to the robot
	 * 
	 * @param anObjPosition : an object position relative to the world
	 * @param anObjRot: an object rotation matric relative to the world
	 */
		/*private double computeRelativeObjectOrientation(double[] anObjPosition, double[] anObjRot) {
			Node r = this.getFromDef("IROBOT_CREATE");
			// Get the transposed rotation matrix of the robot, so we can calculate poses of
			// everything relative to it.
			// Get orientation of the Node we want as our new reference frame and turn it into
			// a numpy array. Returns 1-dim list of len=9.
			double[] robotRotation = r.getOrientation();
			// reshape into a 3x3 rotation matrix
			Dataset robotRotationMatrix = DatasetFactory.createFromObject(robotRotation);
			robotRotationMatrix = robotRotationMatrix.reshape(3, 3);
			// Transpose the matrix, because we need world relative to the robot, not the
			// robot relative to world.
			robotRotationMatrix = robotRotationMatrix.transpose();
			// Get the translation between the robot and the world (basically where the origin
			// of our new relative frame is).
			// No need to use the reverse vector, as we will subtract instead of add it later.
			double[] robotPosition = r.getPosition();
			Dataset robotPositionMatrix = DatasetFactory.createFromObject(robotPosition);
			Dataset anObj_pos_worldMatrix = DatasetFactory.createFromObject(anObjPosition);
			// Calculate the relative translation between the box and the robot.
			anObj_pos_worldMatrix = anObj_pos_worldMatrix.isubtract(robotPositionMatrix);
			// Matrix multiplication with rotation matrix: object position relative to robot.
			Dataset box_pos_robot = robotRotationMatrix.imultiply(anObj_pos_worldMatrix);
			// Calculate the orientation of the box, relative to the robot, all in one line.
			Dataset anObj_rot_robot = robotRotationMatrix.imultiply( DatasetFactory.createFromObject(anObjRot).reshape(3, 3));
			double relativeOrientation= Math.atan2(anObj_rot_robot.getDouble(0,0), anObj_rot_robot.getDouble(2,2));
			return relativeOrientation;
		}*/


	public void openGripper() {
		gripMotors[0].setPosition(0.5);
		gripMotors[1].setPosition(0.5);
	}

	public void closeGripper() {
		gripMotors[0].setPosition(-0.2);
		gripMotors[1].setPosition(-0.2);
	}
	
	/**
	 * give the obstacle distance from the gripper sensor. max distance (i.e., no obstacle detected) is 1500
	 * @return
	 */
	
	public double[] getOrientation() {
		return compass.getValues();
	}
	public double getObjectDistanceToGripper() {
		return gripperSensor.getValue();
	}

	public boolean isThereCollisionAtLeft() {
		return (leftBumper.getValue() != 0.0);
	}

	public boolean isThereCollisionAtRight() {
		return (rightBumper.getValue() != 0.0);
	}

	public void flushIRReceiver() {
		while (receiver.getQueueLength() > 0)
			receiver.nextPacket();
	}

	public boolean isThereVirtualwall() {
		return (receiver.getQueueLength() > 0);
	}

	public boolean isThereCliffAtLeft() {
		return (leftCliffSensor.getValue() < 100.0 || frontLeftCliffSensor.getValue() < 100.0);
	}

	public boolean isThereCliffAtRight() {
		return (rightCliffSensor.getValue() < 100.0 || frontRightCliffSensor.getValue() < 100.0);
	}

	public boolean isThereCliffAtFront() {
		return (frontLeftCliffSensor.getValue() < 100.0 || frontRightCliffSensor.getValue() < 100.0);
	}

	public void goForward() {
		leftMotor.setVelocity(MAX_SPEED);
		rightMotor.setVelocity(MAX_SPEED);
	}

	public void goBackward() {
		leftMotor.setVelocity(-HALF_SPEED);
		rightMotor.setVelocity(-HALF_SPEED);
	}

	public void stop() {
		leftMotor.setVelocity(NULL_SPEED);
		rightMotor.setVelocity(NULL_SPEED);
	}

	public void passiveWait(double sec) {
		double start_time = getTime();
		do {
			step(timestep);
		} while (start_time + sec > getTime());
	}

	public double randdouble() {
		return  random.nextDouble();
	}
	
	public void turnDuringCertainTime(double time, boolean right) {
		double neg = right ? -1.0 : 1.0;
		leftMotor.setVelocity(neg * HALF_SPEED);
		rightMotor.setVelocity(-neg * HALF_SPEED);
		passiveWait(time);
		stop();
	}

	public void turn(double angle) {
		stop();
		double l_offset = leftSensor.getValue();
		double r_offset = rightSensor.getValue();
		step(timestep);
		double neg = (angle < 0.0) ? -1.0 : 1.0;
		leftMotor.setVelocity(neg * HALF_SPEED);
		rightMotor.setVelocity(-neg * HALF_SPEED);
		double orientation;
		do {
			double l = leftSensor.getValue() - l_offset;
			double r = rightSensor.getValue() - r_offset;
			double dl = l * WHEEL_RADIUS;                 // distance covered by left wheel in meter
			double dr = r * WHEEL_RADIUS;                 // distance covered by right wheel in meter
			orientation = neg * (dl - dr) / AXLE_LENGTH;  // delta orientation in radian
			step(timestep);
		} while (orientation < neg * angle);
		stop();
		step(timestep);
	}

	/**
	 * The values are returned as a 3D-vector, therefore only the indices 0, 1, and 2 are valid for accessing the vector.
	 * The returned vector indicates the absolute position of the GPS device. This position can either be expressed in the 
	 * cartesian coordinate system of Webots or using latitude-longitude-altitude, depending on the value of the 
	 * gpsCoordinateSystem field of the WorldInfo node. The gpsReference field of the WorldInfo node can be used to define
	 * the reference point of the GPS. The wb_gps_get_speed function returns the current GPS speed in meters per second.
	 * @return
	 */
	public double[] getPosition() {
		return gps.getValues();
	}
	
	public double[] getFrontObjectPosition(){
		CameraRecognitionObject[] frontObjs = this.frontCamera.getCameraRecognitionObjects();
		if (frontObjs.length > 0) {
			CameraRecognitionObject obj = frontObjs[0];
			double[] frontObjPos = obj.getPosition();
			System.out.println("I saw an object on front Camera at : "+frontObjPos[0]+","+frontObjPos[1]);
			return frontObjPos;
		}
		return null;
	}
	
	public double[] getBackObjectPosition(){
		CameraRecognitionObject[] backObjs = this.backCamera.getCameraRecognitionObjects();
		if (backObjs.length > 0) {
			CameraRecognitionObject obj = backObjs[0];
			double[] backObjPos = obj.getPosition();
			System.out.println("I saw an object on front Camera at : "+backObjPos[0]+","+backObjPos[1]);
			return backObjPos;
		}
		return null;
	}


	public static void main(String[] args) {
		PolyCreateControler controler = new PolyCreateControler();

		try {
			controler.openGripper();
			controler.pen.write(true);
			controler.ledOn.set(1);
			controler.passiveWait(0.5);

			while (true) {
				/**
				 * The position and orientation are expressed relatively to the camera (the relative position is the one of the center of the object which can differ from its origin) and the units are meter and radian.
				 * https://www.cyberbotics.com/doc/reference/camera?tab-language=python#wb_camera_has_recognition
				 */
				CameraRecognitionObject[] backObjs = controler.backCamera.getCameraRecognitionObjects();
				if (backObjs.length > 0) {
					CameraRecognitionObject obj = backObjs[0];
					double[] backObjPos = obj.getPosition();
					System.out.println("I saw an object on back Camera at : "+backObjPos[0]+","+backObjPos[1]);
				}
				CameraRecognitionObject[] frontObjs = controler.frontCamera.getCameraRecognitionObjects();
				if (frontObjs.length > 0) {
					CameraRecognitionObject obj = frontObjs[0];
					double[] frontObjPos = obj.getPosition();
					System.out.println("I saw an object on front Camera at : "+frontObjPos[0]+","+frontObjPos[1]);
				}
				System.out.println("gripper distance sensor is "+controler.getObjectDistanceToGripper());
				if (controler.isThereVirtualwall()) {
					System.out.println("Virtual wall detected\n");
					controler.turn(Math.PI);
				} else if (controler.isThereCollisionAtLeft() || controler.isThereCliffAtRight()) {
					System.out.println("Left obstacle detected\n");
					controler.goBackward();
					controler.passiveWait(0.5);
					controler.turn(Math.PI * controler.randdouble());
				} else if (controler.isThereCollisionAtRight()|| controler.isThereCliffAtRight() || controler.isThereCliffAtFront()) {
					System.out.println("Right obstacle detected\n");
					controler.goBackward();
					controler.passiveWait(0.5);
					controler.turn(-Math.PI * controler.randdouble());
				} else {
					controler.goForward();
				}
				controler.flushIRReceiver();
				controler.step(controler.timestep);
			}

		}catch (Exception e) {
			controler.delete();
		}



	}


	@Override
	protected void finalize() {
		this.delete();
		super.finalize();
	}

}
