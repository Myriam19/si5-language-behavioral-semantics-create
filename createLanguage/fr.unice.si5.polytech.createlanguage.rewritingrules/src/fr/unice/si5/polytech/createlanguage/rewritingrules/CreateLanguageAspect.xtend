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
		for(Choreography c : _self.starting_choreo){
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
				CreateProgramAspect.controler.flushIRReceiver();
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
	@OverrideAspectMethod
	def void start(){
		_self.isRunning(true);
		if(_self.angle < 0){
			_self.right = true;
			_self.angle = -_self.angle;
		}
		_self.time = _self.angle / (PolyCreateControler.HALF_SPEED*12.2);
	}
	
	@Step
	@OverrideAspectMethod
	def void doStep(){
		if(_self.isRunning && _self.time > 0){
			System.out.println("here : "+_self.time)
			CreateProgramAspect.controler.turnDuringCertainTime( Math.min(_self.time, CreateProgramAspect.step), _self.right);
			System.out.println("next here : "+_self.time)
			if(_self.time < CreateProgramAspect.step){
				_self.isRunning(false);
			} else {
				_self.time = _self.time - Math.min(_self.time, CreateProgramAspect.step);
			}
		}
	}
}

/*@Aspect(className = GrabInFront)
class GrabInFrontAspect extends ActionAspect{
	@Step
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
	}
}

@Aspect(className = ReleaseInFront)
class ReleaseInFrontAspect extends ActionAspect{
	@Step
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
	}
}*/

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
				CreateProgramAspect.controler.flushIRReceiver();
				CreateProgramAspect.controler.step(CreateProgramAspect.controler.timestep);
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
	@Step
	@OverrideAspectMethod
	def void check(){
		_self.isValid(false);
		
		var double[] pos = CreateProgramAspect.controler.getFrontObjectPosition();
		if(pos !== null){
			System.out.println("object found : "+pos.get(0) + " / " + pos.get(1));
		} else {
			System.out.println("no object found");
		}
	}
}