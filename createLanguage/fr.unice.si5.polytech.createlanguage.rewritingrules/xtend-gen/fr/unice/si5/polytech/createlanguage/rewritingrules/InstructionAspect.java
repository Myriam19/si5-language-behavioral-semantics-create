package fr.unice.si5.polytech.createlanguage.rewritingrules;

import fr.inria.diverse.k3.al.annotationprocessor.Abstract;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.Instruction;
import fr.unice.si5.polytech.createlanguage.rewritingrules.InstructionAspectInstructionAspectProperties;

@Aspect(className = Instruction.class)
@SuppressWarnings("all")
public abstract class InstructionAspect {
  @Step
  @Abstract
  public static void execute(final Instruction _self) {
    final fr.unice.si5.polytech.createlanguage.rewritingrules.InstructionAspectInstructionAspectProperties _self_ = fr.unice.si5.polytech.createlanguage.rewritingrules.InstructionAspectInstructionAspectContext.getSelf(_self);
    	// BeginInjectInto fr.unice.si5.polytech.createlanguage.rewritingrules.InstructionAspect#void execute() from fr.unice.si5.polytech.createlanguage.rewritingrules.ActionAspect
    		if (_self instanceof fr.unice.si5.polytech.createlanguage.abstractsyntax.Action){
    			fr.unice.si5.polytech.createlanguage.rewritingrules.ActionAspect.execute((fr.unice.si5.polytech.createlanguage.abstractsyntax.Action)_self);
    		} else
    		// EndInjectInto fr.unice.si5.polytech.createlanguage.rewritingrules.InstructionAspect#void execute() from fr.unice.si5.polytech.createlanguage.rewritingrules.ActionAspect
    	// BeginInjectInto fr.unice.si5.polytech.createlanguage.rewritingrules.InstructionAspect#void execute() from fr.unice.si5.polytech.createlanguage.rewritingrules.GoForwardAspect
    		if (_self instanceof fr.unice.si5.polytech.createlanguage.abstractsyntax.GoForward){
    			fr.unice.si5.polytech.createlanguage.rewritingrules.GoForwardAspect.execute((fr.unice.si5.polytech.createlanguage.abstractsyntax.GoForward)_self);
    		} else
    		// EndInjectInto fr.unice.si5.polytech.createlanguage.rewritingrules.InstructionAspect#void execute() from fr.unice.si5.polytech.createlanguage.rewritingrules.GoForwardAspect
    // #DispatchPointCut_before# void execute()
    if (_self instanceof fr.unice.si5.polytech.createlanguage.abstractsyntax.Instruction){
    	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand command = new fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand() {
    		@Override
    		public void execute() {
    			fr.unice.si5.polytech.createlanguage.rewritingrules.InstructionAspect._privk3_execute(_self_, (fr.unice.si5.polytech.createlanguage.abstractsyntax.Instruction)_self);
    		}
    	};
    	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager stepManager = fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry.getInstance().findStepManager(_self);
    	if (stepManager != null) {
    		stepManager.executeStep(_self, new Object[] {_self}, command, "Instruction", "execute");
    	} else {
    		command.execute();
    	}
    	;
    };
  }
  
  protected static void _privk3_execute(final InstructionAspectInstructionAspectProperties _self_, final Instruction _self) {
    throw new java.lang.RuntimeException("Not implemented");
  }
}
