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

@Aspect(className = Rotate)
class RotateAspect extends ActionAspect{
	@Step
	@OverrideAspectMethod
	def void execute(){
		CreateProgramAspect.controler.turn(_self.angle as double * Math.PI / 180);
		CreateProgramAspect.controler.passiveWait(0.5);
		CreateProgramAspect.controler.flushIRReceiver();
		CreateProgramAspect.controler.step(CreateProgramAspect.controler.timestep);
	}
}