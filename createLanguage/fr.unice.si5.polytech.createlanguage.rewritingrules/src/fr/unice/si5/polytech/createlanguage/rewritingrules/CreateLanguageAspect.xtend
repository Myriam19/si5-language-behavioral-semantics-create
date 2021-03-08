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

/**
 * Sample aspect that gives java.io.File the ability to store Text content and save it to disk
 */
@Aspect(className=CreateProgram)
class CreateProgramAspect {
	public static PolyCreateControler controler = new PolyCreateControler();
	public static Double step = 0.32;
	
	@Main
	def void entryPoint(){
		for(ReferenceChoreography c : _self.starting_choreo){
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

@Aspect(className = ReferenceChoreography)
abstract class ReferenceChoreographyAspect extends InstructionAspect{
	@OverrideAspectMethod
	def void start(){
		_self.isRunning(true)
		_self.choreography.start()
	}
	
	@Step
	@OverrideAspectMethod
	def void doStep(){
		_self.choreography.doStep()
		if(_self.choreography.isRunning() == false){
			_self.isRunning(false)
		}
	}
}

@Aspect(className = FiniteChoreography)
class FiniteChoreographyAspect extends ChoreographyAspect{
	private var Instruction currentInstruction
	private var int currentInstructionIndex = 0;
	
	@OverrideAspectMethod
	def void start(){
		_self.isRunning(true);
		if(_self.instructions.size() > 0){
			_self.currentInstruction = _self.instructions.get(0)
			_self.currentInstruction.start()
			_self.currentInstructionIndex = 0
		}
	}
	
	@Step
	@OverrideAspectMethod
	def void doStep(){
		//CreateProgramAspect.controler.flushIRReceiver();
		//CreateProgramAspect.controler.step(CreateProgramAspect.controler.timestep);
		//CreateProgramAspect.controler.passiveWait(CreateProgramAspect.controler.timestep);
		//Check interruptions
		if(!_self.interruptions.isEmpty()){
			for(Interruption i : _self.interruptions){
				if(i.isConditionsValid()){
					i.execute()
				}
			}
		}
		
		if(_self.instructions.size() > 0){
			if(_self.currentInstruction.isRunning()){
				_self.currentInstruction.doStep()
			} else {
				CreateProgramAspect.controler.step(CreateProgramAspect.controler.timestep);	
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

@Aspect(className = GoForward)
class GoForwardAspect extends ActionAspect{
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
			CreateProgramAspect.controler.goForward();
			CreateProgramAspect.controler.passiveWait(Math.min(_self.time, CreateProgramAspect.step));
			_self.time = _self.time - Math.min(_self.time, CreateProgramAspect.step);
			
			if(_self.time <= 0){
				_self.isRunning(false);
			}
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
	
	@OverrideAspectMethod
	def void start(){
		_self.isRunning(true)
		_self.stopped = false;
		_self.turned = false;
		_self.opened = false;
		_self.wentBackward = false;
		_self.closed = false;
	}
	
	@OverrideAspectMethod
	def void doStep(){
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
		} else {
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
	
	/*@Step
	@OverrideAspectMethod
	def void execute(){
		
		CreateProgramAspect.controler.stop();
		CreateProgramAspect.controler.passiveWait(0.5);
		
		CreateProgramAspect.controler.openGripper();
		CreateProgramAspect.controler.passiveWait(0.5);
		
		CreateProgramAspect.controler.goBackward();
		CreateProgramAspect.controler.passiveWait(0.5);
		
		CreateProgramAspect.controler.stop();
		CreateProgramAspect.controler.passiveWait(0.5);
		
		CreateProgramAspect.controler.closeGripper();
		CreateProgramAspect.controler.passiveWait(0.5);
		
		CreateProgramAspect.controler.flushIRReceiver();
		CreateProgramAspect.controler.step(CreateProgramAspect.controler.timestep);
	}*/
}

@Aspect(className = ReleaseInFront)
class ReleaseInFrontAspect extends ActionAspect{
	/*@Step
	@OverrideAspectMethod
	def void execute(){
		
		CreateProgramAspect.controler.stop();
		CreateProgramAspect.controler.passiveWait(0.5);
		
		CreateProgramAspect.controler.openGripper();
		CreateProgramAspect.controler.passiveWait(0.5);
		
		CreateProgramAspect.controler.goForward();
		CreateProgramAspect.controler.passiveWait(0.5);
		
		CreateProgramAspect.controler.stop();
		CreateProgramAspect.controler.passiveWait(0.5);
		
		CreateProgramAspect.controler.closeGripper();
		CreateProgramAspect.controler.passiveWait(0.5);
		
		CreateProgramAspect.controler.flushIRReceiver();
		CreateProgramAspect.controler.step(CreateProgramAspect.controler.timestep);
	}*/
}

@Aspect(className = Interruption)
class InterruptionAspect{
	@Step
	def boolean isConditionsValid(){
		var isConditionsValid = true;
		var i = 0;
		while(isConditionsValid && i < _self.conditions.size()){
			_self.conditions.get(i).check();
			if(!_self.conditions.get(i).isValid()){
				isConditionsValid = false;
			}
			i++;
		}
		return isConditionsValid;
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

@Aspect(className = ObjectFound)
class ObjectFoundAspect extends ConditionAspect{
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
		if(pos !== null){
			var double distance = _self.distance(robotPos.get(0), robotPos.get(1), pos.get(0), pos.get(1));
			var double distanceCm  = distance * 100-5; 
			System.out.println("object found : " + distanceCm);
			if(distanceCm < _self.distance){
				_self.isValid(true);
			}
		}
		
	}
}

/* 

@Aspect(className = GoToClosestObject)
class GoToClosestObjectAspect extends ActionAspect{
	
	def double sqr(double a) {
        return a*a;
    }
 
    def double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(_self.sqr(y2 - y1) + _self.sqr(x2 - x1));
    }
	
	@Step
	@OverrideAspectMethod
	def void execute(){
		
		CreateProgramAspect.controler.stop();
		CreateProgramAspect.controler.passiveWait(0.5);
		
		if (CreateProgramAspect.controler.frontCamera.getCameraRecognitionObjects().length > 0) {
			val double[] frontObjPos = CreateProgramAspect.controler.frontCamera.getCameraRecognitionObjects().get(0).getPosition();
			val double[] frontObjOri = CreateProgramAspect.controler.frontCamera.getCameraRecognitionObjects().get(0).getOrientation();
			
			System.out.println("I saw an object on front Camera at : "+ frontObjPos.get(0) +","+ frontObjPos.get(1));
			System.out.println("Object orientation : "+ frontObjOri.get(0) +","+ frontObjOri.get(1));
			
			CreateProgramAspect.controler.turn(frontObjOri.get(0));
			
			val double[] robotPos =  CreateProgramAspect.controler.getPosition();
			val distance = _self.distance(robotPos.get(0), robotPos.get(1), frontObjPos.get(0), frontObjPos.get(1));
			val time = distance / PolyCreateControler.MAX_SPEED;
			
			CreateProgramAspect.controler.goForward();
			CreateProgramAspect.controler.passiveWait(time);
		}
		
		
		CreateProgramAspect.controler.flushIRReceiver();
		CreateProgramAspect.controler.step(CreateProgramAspect.controler.timestep);
	}
}*/
