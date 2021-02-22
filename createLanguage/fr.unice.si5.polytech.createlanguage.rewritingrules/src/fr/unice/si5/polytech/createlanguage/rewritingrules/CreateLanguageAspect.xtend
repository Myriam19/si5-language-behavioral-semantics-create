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
	
	@Main
	def void entryPoint(){
		for(Choreography c : _self.starting_choreo){
			c.execute()
		}
	}
	
}

@Aspect(className = Instruction)
abstract class InstructionAspect{
	@Step
	abstract def void execute()
}

@Aspect(className = Action)
abstract class ActionAspect extends InstructionAspect{
	@Step
	@OverrideAspectMethod
	abstract def void execute()
}

@Aspect(className = Choreography)
abstract class ChoreographyAspect extends InstructionAspect{
	@Step
	@OverrideAspectMethod
	abstract def void execute()
}

@Aspect(className = FiniteChoreography)
class FiniteChoreographyAspect extends ChoreographyAspect{
	@Step
	@OverrideAspectMethod
	def void execute(){
		for(Instruction i : _self.instructions){
			i.execute()
		}
	}
}

@Aspect(className = GoForward)
class GoForwardAspect extends ActionAspect{
	@Step
	@OverrideAspectMethod
	def void execute(){
		var time = 0 as int
		if(_self.distance != -1){
			time = _self.distance / PolyCreateControler.MAX_SPEED;
		} else if(_self.duration != -1){
			time = _self.duration;
		}
		CreateProgramAspect.controler.goForward();
		CreateProgramAspect.controler.passiveWait(time);
		CreateProgramAspect.controler.flushIRReceiver();
		CreateProgramAspect.controler.step(CreateProgramAspect.controler.timestep);
	}
}

@Aspect(className = GoBackward)
class GoBackwardAspect extends ActionAspect{
	@Step
	@OverrideAspectMethod
	def void execute(){
		var time = 0 as int
		if(_self.distance != -1){
			time = _self.distance / PolyCreateControler.MAX_SPEED;
		} else if(_self.duration != -1){
			time = _self.duration;
		}
		CreateProgramAspect.controler.goBackward();
		CreateProgramAspect.controler.passiveWait(time);
		CreateProgramAspect.controler.flushIRReceiver();
		CreateProgramAspect.controler.step(CreateProgramAspect.controler.timestep);
	}
}

@Aspect(className = Stop)
class StopAspect extends ActionAspect{
	@Step
	@OverrideAspectMethod
	def void execute(){
		var time = _self.duration as int;
		CreateProgramAspect.controler.stop();
		CreateProgramAspect.controler.passiveWait(time);
		CreateProgramAspect.controler.flushIRReceiver();
		CreateProgramAspect.controler.step(CreateProgramAspect.controler.timestep);
	}
}

@Aspect(className = Rotate)
class RotateAspect extends ActionAspect{
	@Step
	@OverrideAspectMethod
	def void execute(){
		// CreateProgramAspect.controler.turn(_self.angle as double * Math.PI / 180);
		CreateProgramAspect.controler.turn((_self.angle as float / 100) * 2.11);
		CreateProgramAspect.controler.passiveWait((_self.angle as float / 100) * 2.11 / 2.5);
		CreateProgramAspect.controler.flushIRReceiver();
		CreateProgramAspect.controler.step(CreateProgramAspect.controler.timestep);
	}
}

@Aspect(className = GrabInFront)
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
}

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
}