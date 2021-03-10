package fr.unice.si5.polytech.createlanguage.rewritingrules;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import java.io.PrintWriter
import java.util.ArrayList

import fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.*
import fr.univcotedazur.kairos.webots.polycreate.controler.PolyCreateControler

import static extension fr.unice.si5.polytech.createlanguage.rewritingrules.InstructionAspect.*;
import static extension fr.unice.si5.polytech.createlanguage.rewritingrules.ActionAspect.*;
import static extension fr.unice.si5.polytech.createlanguage.rewritingrules.ChoreographyAspect.*;
import static extension fr.unice.si5.polytech.createlanguage.rewritingrules.FiniteChoreographyAspect.*;
import static extension fr.unice.si5.polytech.createlanguage.rewritingrules.InterruptionAspect.*;
import static extension fr.unice.si5.polytech.createlanguage.rewritingrules.ConditionAspect.*;
import static extension fr.unice.si5.polytech.createlanguage.rewritingrules.GrabInFrontAspect.*;
import static extension fr.unice.si5.polytech.createlanguage.rewritingrules.ReleaseInFrontAspect.*;

import fr.inria.diverse.k3.al.annotationprocessor.Main
import fr.inria.diverse.k3.al.annotationprocessor.Step
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import com.cyberbotics.webots.controller.CameraRecognitionObject
import fr.inria.diverse.k3.al.annotationprocessor.ReplaceAspectMethod

/**
 * Sample aspect that gives java.io.File the ability to store Text content and save it to disk
 */
@Aspect(className=CreateProgram)
class CreateProgramAspect {
	public static PolyCreateControler controler = new PolyCreateControler();
	public static Double step = 0.32;
	
	@Main
	def void entryPoint(){
		controler.pen.write(true);
		controler.ledOn.set(1);
		
		for(ChoreoToRun c : _self.starting_choreo){
			//System.out.println("Dans le entrypoint");
			c.start()
			while(c.isRunning()){
				c.doStep()
			}
			controler.flushIRReceiver();
			controler.step(controler.timestep);
		}
	}
	
}

@Aspect(className = Instruction)
abstract class InstructionAspect{
	public var Boolean isRunning = false;
	@Step
	abstract def void doStep()
	
	def void start(){
		_self.isRunning(true);
	}
}

@Aspect(className = Action)
abstract class ActionAspect extends InstructionAspect{
	protected var double time = 0.0;
}

@Aspect(className = Choreography)
abstract class ChoreographyAspect extends InstructionAspect{
}

@Aspect(className = ChoreoToRun)
abstract class ChoreoToRunAspect extends InstructionAspect{
}

@Aspect(className = ReferenceChoreography)
abstract class ReferenceChoreographyAspect extends ChoreoToRunAspect{
	@OverrideAspectMethod
	@ReplaceAspectMethod
	def void start(){
		_self.isRunning(true)
		_self.choreography.start()
	}
	
	@Step
	@OverrideAspectMethod
	@ReplaceAspectMethod
	def void doStep(){
		_self.choreography.doStep()
		if(_self.choreography.isRunning() == false){
			_self.isRunning(false)
		}
	}
}

@Aspect(className = ParalleleChoreo)
abstract class ParalleleChoreoAspect extends ChoreoToRunAspect{
	private var Instruction currentReferenceChoreo
	private var int currentReferenceChoreoIndex = 0;
	
	@OverrideAspectMethod
	def void start(){
		_self.isRunning(true)
		if(_self.referenceChoreographies.size() > 0){
			_self.currentReferenceChoreo = _self.referenceChoreographies.get(0)
			_self.currentReferenceChoreo.start()
			_self.currentReferenceChoreoIndex = 0
		}
	}
	
	@Step
	@OverrideAspectMethod
	def void doStep(){
		if(_self.referenceChoreographies.size() > 0){
			if(_self.currentReferenceChoreo.isRunning()){
				_self.currentReferenceChoreo.doStep()
			} else {
				//CreateProgramAspect.controler.step(CreateProgramAspect.controler.timestep);	
				if(_self.currentReferenceChoreoIndex < _self.referenceChoreographies.size()-1){
					_self.currentReferenceChoreo = _self.referenceChoreographies.get(_self.currentReferenceChoreoIndex+1)
					_self.currentReferenceChoreo.start()
					_self.currentReferenceChoreoIndex = _self.currentReferenceChoreoIndex+1
				} else {
					_self.isRunning(false)
				}
			}
		}
	}
}

@Aspect(className = FiniteChoreography)
class FiniteChoreographyAspect extends ChoreographyAspect{
	private var Instruction currentInstruction
	private var int currentInstructionIndex = 0;
	private var Boolean firstInterruptionChecked = true;
	
	@OverrideAspectMethod
	def void start(){
		//System.out.println("Dans le FiniteChoreo start");
		_self.isRunning(true);
		_self.firstInterruptionChecked(true);
		if(_self.instructions.size() > 0){
			_self.currentInstruction = _self.instructions.get(0)
			_self.currentInstruction.start()
			_self.currentInstructionIndex = 0
		}
	}
	
	@Step
	@OverrideAspectMethod
	def void doStep(){
		//System.out.println("Dans le FiniteChoreo dostep");
		//CreateProgramAspect.controler.flushIRReceiver();
		//CreateProgramAspect.controler.step(CreateProgramAspect.controler.timestep);
		//CreateProgramAspect.controler.passiveWait(CreateProgramAspect.controler.timestep);
		//Check interruptions
		if(!_self.interruptions.isEmpty()){
			if(_self.firstInterruptionChecked){
				_self.firstInterruptionChecked(false)
			} else {
				for(Interruption i : _self.interruptions){
					if(i.isConditionValid()){
						i.execute()
					}
				}
			}
		}
		
		if(_self.instructions.size() > 0){
			if(_self.currentInstruction.isRunning()){
				_self.currentInstruction.doStep()
			} else {
				//CreateProgramAspect.controler.step(CreateProgramAspect.controler.timestep);	
				if(_self.currentInstructionIndex < _self.instructions.size()-1){
					_self.currentInstruction = _self.instructions.get(_self.currentInstructionIndex+1)
					_self.currentInstruction.start()
					_self.currentInstructionIndex = _self.currentInstructionIndex+1
				} else {
					_self.isRunning(false)
				}
			}
		}
	}
}

@Aspect(className = LoopChoreography)
class LoopChoreographyAspect extends ChoreographyAspect{
	private var Instruction currentInstruction
	private var int currentInstructionIndex = 0;
	private var Boolean firstInterruptionChecked = true;
	
	@OverrideAspectMethod
	def void start(){
		System.out.println("Dans le LoopChoreo start");
		_self.isRunning(true);
		_self.firstInterruptionChecked(true);
		if(_self.instructions.size() > 0){
			_self.currentInstruction = _self.instructions.get(0)
			_self.currentInstruction.start()
			_self.currentInstructionIndex = 0
		}
	}
	
	@Step
	@OverrideAspectMethod
	def void doStep(){
		System.out.println("Dans le LoopChoreo dostep");
		//CreateProgramAspect.controler.flushIRReceiver();
		//CreateProgramAspect.controler.step(CreateProgramAspect.controler.timestep);
		//CreateProgramAspect.controler.passiveWait(CreateProgramAspect.controler.timestep);
		//Check interruptions
		if(!_self.interruptions.isEmpty()){
			if(_self.firstInterruptionChecked){
				_self.firstInterruptionChecked(false)
			} else {
				for(Interruption i : _self.interruptions){
					if(i.isConditionValid()){
						i.execute()
					}
				}
			}
		}
		
		/*_self.outCondition.check();
		if (_self.outCondition.isValid()){
			_self.isRunning(false);						
			return;
		}*/
		
		if(_self.instructions.size() > 0){
			if(_self.currentInstruction.isRunning()){
				_self.currentInstruction.doStep()
			} else {
				//CreateProgramAspect.controler.step(CreateProgramAspect.controler.timestep);	
				if(_self.currentInstructionIndex < _self.instructions.size()-1){
					_self.currentInstruction = _self.instructions.get(_self.currentInstructionIndex+1)
					_self.currentInstruction.start()
					_self.currentInstructionIndex = _self.currentInstructionIndex+1
				} else {
					_self.start()
				}
			}
		}
		
		// _self.isRunning(false)	
		_self.outCondition.check();
		if (_self.outCondition.isValid()){			
			_self.isRunning(false)
		}
	}
}

@Aspect(className = GoForward)
class GoForwardAspect extends ActionAspect{
	@OverrideAspectMethod
	def void start(){
		//System.out.println("Dans le GoForwardAspect start");
		_self.isRunning(true);
		if(_self.distance != -1){
			_self.time = _self.distance / PolyCreateControler.MAX_SPEED;
		} else if(_self.duration != -1){
			_self.time = _self.duration;
		}
	}
	
	@Step
	@OverrideAspectMethod
	def void doStep(){
		//System.out.println("Dans le GoForwardAspect dostep");
		if(_self.isRunning && _self.time > 0){
			//System.out.println("Dans le GoForwardAspect if running and time start, time : "+ _self.time);
			CreateProgramAspect.controler.goForward();
			//System.out.println("Dans le GoForwardAspect goForward ok");
			CreateProgramAspect.controler.passiveWait(Math.min(_self.time, CreateProgramAspect.step));
			//System.out.println("Dans le GoForwardAspect passiveWait ok");
			_self.time = _self.time - Math.min(_self.time, CreateProgramAspect.step);
			
			if(_self.time <= 0){
				_self.isRunning(false);
			}
			//System.out.println("Dans le GoForwardAspect if running and time end");
		}
	}
}

@Aspect(className = GoBackward)
class GoBackwardAspect extends ActionAspect{
	@OverrideAspectMethod
	def void start(){
		_self.isRunning(true);
		if(_self.distance != -1){
			_self.time = _self.distance / PolyCreateControler.MAX_SPEED;
		} else if(_self.duration != -1){
			_self.time = _self.duration;
		}
	}
	
	@Step
	@OverrideAspectMethod
	def void doStep(){
		if(_self.isRunning && _self.time > 0){
			CreateProgramAspect.controler.goBackward();
			CreateProgramAspect.controler.passiveWait(Math.min(_self.time, CreateProgramAspect.step));
			_self.time = _self.time - Math.min(_self.time, CreateProgramAspect.step);
			
			if(_self.time <= 0){
				_self.isRunning(false);
			}
		}
	}
}

@Aspect(className = Stop)
class StopAspect extends ActionAspect{
	@OverrideAspectMethod
	def void start(){
		_self.isRunning(true);
		_self.time = _self.duration;
	}
	
	@Step
	@OverrideAspectMethod
	def void doStep(){
		if(_self.isRunning && _self.time > 0){
			CreateProgramAspect.controler.stop();
			CreateProgramAspect.controler.passiveWait(Math.min(_self.time, CreateProgramAspect.step));
			_self.time = _self.time - Math.min(_self.time, CreateProgramAspect.step);
			
			if(_self.time <= 0){
				_self.isRunning(false);
			}
		}
	}
}

@Aspect(className = Rotate)
class RotateAspect extends ActionAspect{
	private var Boolean right = false;
	private var Double realAngle;
	@OverrideAspectMethod
	def void start(){
		_self.isRunning(true);
		if(_self.angle < 0){
			_self.right = true;
			_self.realAngle = -_self.angle;
		} else {
			_self.realAngle = _self.angle;
		}
		_self.time = _self.realAngle / (PolyCreateControler.HALF_SPEED*12.1);
	}
	
	@Step
	@OverrideAspectMethod
	def void doStep(){
		if(_self.isRunning && _self.time > 0){
			CreateProgramAspect.controler.turnDuringCertainTime( Math.min(_self.time, CreateProgramAspect.step), _self.right);
			if(_self.time < CreateProgramAspect.step){
				_self.isRunning(false);
			} else {
				_self.time = _self.time - Math.min(_self.time, CreateProgramAspect.step);
			}
		}
	}
}

@Aspect(className = GrabInFront)
class GrabInFrontAspect extends ActionAspect{
	private var Boolean stopped = false;
	private var Boolean turned = false;
	private var Boolean opened = false;
	private var Boolean wentBackward = false;
	private var Boolean closed = false;
	private var Boolean wentForward = false;
	
	@OverrideAspectMethod
	def void start(){
		//System.out.println("Dans le grabinfront strat");
		_self.isRunning(true)
		_self.stopped = false;
		_self.turned = false;
		_self.opened = false;
		_self.wentBackward = false;
		_self.closed = false;
		_self.wentForward = false;
	}
	
	@OverrideAspectMethod
	def void doStep(){
		//System.out.println("Dans le grabinfront dostep");
		if(!_self.stopped){
			_self.stop()
		} else if(!_self.turned){
			_self.turn()
		} else if(!_self.opened){
			_self.openGripper()
		} else if(!_self.wentBackward){
			_self.goBackward()
		} else if(!_self.closed){
			_self.closeGripper()
		} //else if(!_self.wentForward){
			//_self.goForward()
		//} 
		else {
			_self.isRunning(false);
		}
	}
	
	def void stop(){
		CreateProgramAspect.controler.stop();
		CreateProgramAspect.controler.passiveWait(0.5);
		_self.stopped(true)
	}
	
	def void turn(){
		var Double time = 180 / (PolyCreateControler.HALF_SPEED*12.1);
		CreateProgramAspect.controler.turnDuringCertainTime(time, true);
		_self.turned(true)
	}
	
	def void openGripper(){
		CreateProgramAspect.controler.openGripper();
		CreateProgramAspect.controler.passiveWait(0.5);
		_self.opened(true)
	}
	
	def void goBackward(){
		_self.stopped(false)
		CreateProgramAspect.controler.goBackward();
		CreateProgramAspect.controler.passiveWait(1.19);
		_self.wentBackward(true)
	}
	
	def void closeGripper(){
		_self.stopped(false)
		CreateProgramAspect.controler.closeGripper();
		CreateProgramAspect.controler.passiveWait(0.5);
		_self.closed(true)
	}
	
	def void goForward(){
		_self.stopped(false)
		_self.turned(false)
		CreateProgramAspect.controler.goForward();
		CreateProgramAspect.controler.passiveWait(1.19);
		_self.wentForward(true)
	}
}

@Aspect(className = ReleaseInFront)
class ReleaseInFrontAspect extends ActionAspect{
	
	private var Boolean stopped = false;
	//private var Boolean turned = false;
	private var Boolean opened = false;
	private var Boolean wentForward = false;
	private var Boolean closed = false;
	
	@OverrideAspectMethod
	def void start(){
		_self.isRunning(true)
		_self.stopped = false;
		//_self.turned = false;
		_self.opened = false;
		_self.wentForward = false;
		_self.closed = false;
	}
	
	@OverrideAspectMethod
	def void doStep(){
		if(!_self.stopped){
			_self.stop()
		} /*else if(!_self.turned){
			_self.turn()
		} */
		else if(!_self.opened){
			_self.openGripper()
		} else if(!_self.wentForward){
			_self.goForward()
		} else if(!_self.closed){
			_self.closeGripper()
		} else {
			_self.isRunning(false);
		}
	}
	
	def void stop(){
		CreateProgramAspect.controler.stop();
		CreateProgramAspect.controler.passiveWait(0.5);
		_self.stopped(true)
	}
	
	/*def void turn(){
		var Double time = 180 / (PolyCreateControler.HALF_SPEED*12.1);
		CreateProgramAspect.controler.turnDuringCertainTime(time, true);
		_self.turned(true)
	}*/
	
	def void openGripper(){
		CreateProgramAspect.controler.openGripper();
		CreateProgramAspect.controler.passiveWait(0.5);
		_self.opened(true)
	}
	
	def void goForward(){
		_self.stopped(false)
		CreateProgramAspect.controler.goForward();
		CreateProgramAspect.controler.passiveWait(1.19);
		_self.wentForward(true)
	}
	
	def void closeGripper(){
		CreateProgramAspect.controler.closeGripper();
		CreateProgramAspect.controler.passiveWait(0.5);
		_self.closed(true)
	}
}

@Aspect(className = Interruption)
class InterruptionAspect{
	@Step
	def boolean isConditionValid(){
		//System.out.println("Dans le Interruption condition valid strat");
		_self.condition.check()
		//System.out.println("Dans le Interruption condition valid end");
		return _self.condition.isValid();
	}
	@Step
	def void execute(){		
		if(_self.choreography !== null){
			_self.choreography.start()
			while(_self.choreography.isRunning()){
				_self.choreography.doStep()
			}
		}
	}
}

@Aspect(className = Condition)
abstract class ConditionAspect{
	public var Boolean isValid = false
	@Step
	abstract def void check()
}

@Aspect(className = BooleanEvent)
abstract class BooleanEventAspect extends ConditionAspect{
	@Step
	@OverrideAspectMethod
	abstract def void check()
}

@Aspect(className = AndCondition)
class AndConditionAspect extends ConditionAspect{
	@Step
	@OverrideAspectMethod
	def void check(){
		var isConditionsValid = true;
		var i = 0;
		while(isConditionsValid && i < _self.andConditions.size()){
			_self.andConditions.get(i).check();
			if(!_self.andConditions.get(i).isValid()){
				isConditionsValid = false;
			}
			i++;
		}
	}
}

@Aspect(className = OrCondition)
class OrConditionAspect extends ConditionAspect{
	@Step
	@OverrideAspectMethod
	def void check(){
		var isConditionsValid = false;
		var i = 0;
		while(!isConditionsValid && i < _self.orConditions.size()){
			_self.orConditions.get(i).check();
			if(_self.orConditions.get(i).isValid()){
				isConditionsValid = true;
			}
			i++;
		}
	}
}

@Aspect(className = ObjectFound)
class ObjectFoundAspect extends BooleanEventAspect{
	def double sqr(double a) {
        return a*a;
    }
 
    def double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(_self.sqr(y2 - y1) + _self.sqr(x2 - x1));
    }
	
	@Step
	@OverrideAspectMethod
	def void check(){
		_self.isValid(false);
		var double[] robotPos = CreateProgramAspect.controler.getPosition();
		var double[] pos = CreateProgramAspect.controler.getFrontObjectPosition();
		System.out.println("robot : " + robotPos.get(0)+"/"+robotPos.get(1)+"/"+robotPos.get(2));
		if(pos !== null){
			var double distance = _self.distance(0, 0, pos.get(1), pos.get(2));
			var double distanceCm  = distance * 20; 
			System.out.println("object found : " + distanceCm);
			if(distanceCm < _self.distance){
				_self.isValid(true);
			}
		}
		
	}
}

@Aspect(className = ObstacleFoundLeft)
class ObstacleFoundLeftAspect extends BooleanEventAspect{
	@Step
	@OverrideAspectMethod
	def void check(){
		_self.isValid(false);
		if (CreateProgramAspect.controler.isThereCollisionAtLeft() || CreateProgramAspect.controler.isThereCliffAtLeft()) {
			System.out.println("Left obstacle detected\n");
			_self.isValid(true);
		}
	}
}

@Aspect(className = ObstacleFoundRight)
class ObstacleFoundRightAspect extends BooleanEventAspect{
	@Step
	@OverrideAspectMethod
	def void check(){
		_self.isValid(false);
		if (CreateProgramAspect.controler.isThereCollisionAtRight() || CreateProgramAspect.controler.isThereCliffAtRight() || CreateProgramAspect.controler.isThereCliffAtFront()) {
			System.out.println("Right obstacle detected\n");
			_self.isValid(true);
		}
	}
}

@Aspect(className = VirtualWallFound)
class VirtualWallFoundAspect extends BooleanEventAspect{
	@Step
	@OverrideAspectMethod
	def void check(){
		_self.isValid(false);
		if (CreateProgramAspect.controler.isThereVirtualwall()) {
			System.out.println("Virtual wall detected\n");
			_self.isValid(true);
		}
	}
}
 

@Aspect(className = GoToClosestObject)
class GoToClosestObjectAspect extends ActionAspect{
	private double travelTime = 0.0;
	private double angleTime = 0.0;
	private var Boolean turned = false;
	private var Boolean wentForward = false;
	
	def double sqr(double a) {
        return a*a;
    }
 
    def double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(_self.sqr(y2 - y1) + _self.sqr(x2 - x1));
    }
    
    // approche avec 3 points (vectorielle bis)
    /*def double getAngle(double point1X, double point1Y, 
        double point2X, double point2Y, 
        double fixedX, double fixedY) {
	
	    val double angle1 = Math.atan2(point1Y - fixedY, point1X - fixedX);
	    val double angle2 = Math.atan2(point2Y - fixedY, point2X - fixedX);
	
	    return angle1 - angle2; 
	}*/
    
    @OverrideAspectMethod
    def void start() {
    	System.out.println("Dans le start du gotoclosest object")
    	_self.turned(false)
    	_self.wentForward(false)
    	if (CreateProgramAspect.controler.frontCamera.getCameraRecognitionObjects().length > 0) {
    		System.out.println("Dans le if du gotoclosest object")
    		
    		// approche naive
    		/*val double[] frontObjPos = CreateProgramAspect.controler.frontCamera.getCameraRecognitionObjects().get(0).getPosition();
			val double[] frontObjOri = CreateProgramAspect.controler.frontCamera.getCameraRecognitionObjects().get(0).getOrientation();
			
			System.out.println("I saw an object on front Camera at : "+ frontObjPos.get(0) +","+ frontObjPos.get(1));
			System.out.println("Object orientation : "+ frontObjOri.get(0) +","+ frontObjOri.get(1));
			
			CreateProgramAspect.controler.turn(frontObjOri.get(0));
			
			//Approche GPS
			val double[] robotPos =  CreateProgramAspect.controler.getPosition();
			val distance = _self.distance(robotPos.get(0), robotPos.get(1), frontObjPos.get(0), frontObjPos.get(1));
			val time = distance / PolyCreateControler.MAX_SPEED;
			
			val int R = 6371000; // metres
			val φ1 = lat1 * Math.PI/180; // φ, λ in radians
			val φ2 = lat2 * Math.PI/180;
			val Δφ = (lat2-lat1) * Math.PI/180;
			val Δλ = (lon2-lon1) * Math.PI/180;
			
			val a = Math.sin(Δφ/2) * Math.sin(Δφ/2) +
			          Math.cos(φ1) * Math.cos(φ2) *
			          Math.sin(Δλ/2) * Math.sin(Δλ/2);
			val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
			
			val double dy = lat2 - lat1;
			val double dx = Math.cos(Math.PI/180*lat1)*(lon2 - lon1);
			val double angle = Math.atan2(dy, dx);*/
						
			
			// approche vectorielle 
			/*
			val double lat1_1 = robotPos.get(0);
			val double lon1_1 = robotPos.get(1);
			
			val double lat2 = frontObjPos.get(0);
			val double lon2 = frontObjPos.get(1);
			
			CreateProgramAspect.controler.goForward();
			CreateProgramAspect.controler.passiveWait(1);
			
			val double[] robotPos2 =  CreateProgramAspect.controler.getPosition();
			
			val double lat1_2 = robotPos2.get(0);
			val double lon1_2 = robotPos2.get(1);
			
			val double xX = lat1_2 - lat1_1
			val double yY = lon1_2 - lon1_1
			
			val ArrayList<Double> robotVect = new ArrayList()
			robotVect.add(xX);
			robotVect.add(yY);
			
			val double XR = lat2 - lat1_2
			val double YR = lon2 - lon1_2
			
			val ArrayList<Double> objetVect = new ArrayList()
			objetVect.add(XR);
			objetVect.add(YR);
		
			val double angle = Math.atan2(objetVect.get(1), objetVect.get(0)) - Math.atan2(robotVect.get(1), robotVect.get(0))
			*/
			
			val double[] frontObjPos = CreateProgramAspect.controler.frontCamera.getCameraRecognitionObjects().get(0).getPosition();
			val double[] robotPos =  CreateProgramAspect.controler.getPosition();
			System.out.println("I saw an object on front Camera at : "+ frontObjPos.get(1) +","+ frontObjPos.get(2));
			System.out.println("My position : "+ robotPos.get(1) +","+ robotPos.get(2));
			
			val double lat1_1 = robotPos.get(1);
			val double lon1_1 = robotPos.get(2);
			
			val double lat2 = frontObjPos.get(1);
			val double lon2 = frontObjPos.get(2);
			
			val double dy = lat2 - lat1_1;
			val double dx = Math.cos(Math.PI/180*lat1_1)*(lon2 - lon1_1);
			val double angle = Math.atan2(dy, dx);
			
			System.out.println("angle obtenu (rad) : "+ angle);
			
			val degreeAngle = angle * 180/Math.PI
			System.out.println("angle obtenu (deg) : "+ ((degreeAngle+360+180) % 360));
			_self.angleTime = (((degreeAngle+360+180) % 360) / (PolyCreateControler.HALF_SPEED*12.1));
			
			val distance = _self.distance(lat1_1, lon1_1, lat2, lon2);
			val time = distance / PolyCreateControler.MAX_SPEED;
			_self.travelTime = time;
	
			_self.isRunning(true);
		}
		
			
    }
    
	
	@OverrideAspectMethod
	def void doStep(){
		//System.out.println("dans le doStep du gotoClosestObject")
		
		if(!_self.turned){
			System.out.println("angleTime : " + _self.angleTime)
			CreateProgramAspect.controler.turnDuringCertainTime(_self.angleTime, true);
			_self.turned(true)
		} else if(!_self.wentForward){
			CreateProgramAspect.controler.goForward();
			CreateProgramAspect.controler.passiveWait(_self.travelTime);
			_self.wentForward(true)
		}
	}
}
