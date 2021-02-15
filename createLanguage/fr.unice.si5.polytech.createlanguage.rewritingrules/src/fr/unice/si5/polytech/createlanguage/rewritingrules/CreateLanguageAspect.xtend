package fr.unice.si5.polytech.createlanguage.rewritingrules;

import java.io.PrintWriter
import java.util.ArrayList
import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.Main
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import fr.inria.diverse.k3.al.annotationprocessor.Step

import fr.unice.si5.polytech.createlanguage.abstractsyntax.*

import static extension fr.unice.si5.polytech.createlanguage.rewritingrules.InstructionAspect.*;
import static extension fr.unice.si5.polytech.createlanguage.rewritingrules.ActionAspect.*;
import static extension fr.unice.si5.polytech.createlanguage.rewritingrules.ChoreographyAspect.*;
import static extension fr.unice.si5.polytech.createlanguage.rewritingrules.FiniteChoreographyAspect.*;
import fr.univcotedazur.kairos.webots.polycreate.controler.PolyCreateControler

/**
 * Sample aspect that gives java.io.File the ability to store Text content and save it to disk
 */
@Aspect(className=CreateProgram)
class CreateProgramAspect {
	public static PolyCreateControler controler = new PolyCreateControler();
	
	@Main
	def void entryPoint(){
		for(Choreography c : _self.choreographies){
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
		CreateProgramAspect.controler.goForward();
		CreateProgramAspect.controler.passiveWait(2);
		CreateProgramAspect.controler.step(CreateProgramAspect.controler.timestep);
	}
}