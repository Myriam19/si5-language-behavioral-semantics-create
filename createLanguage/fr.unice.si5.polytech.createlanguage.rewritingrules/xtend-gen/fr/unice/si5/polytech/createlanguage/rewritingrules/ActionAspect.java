package fr.unice.si5.polytech.createlanguage.rewritingrules;

import fr.inria.diverse.k3.al.annotationprocessor.Abstract;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.Action;
import fr.unice.si5.polytech.createlanguage.rewritingrules.ActionAspectActionAspectProperties;
import fr.unice.si5.polytech.createlanguage.rewritingrules.InstructionAspect;

@Aspect(className = Action.class)
@SuppressWarnings("all")
public abstract class ActionAspect extends InstructionAspect {
  @Step
  @OverrideAspectMethod
  @Abstract
  public static void execute(final Action _self) {
    final fr.unice.si5.polytech.createlanguage.rewritingrules.ActionAspectActionAspectProperties _self_ = fr.unice.si5.polytech.createlanguage.rewritingrules.ActionAspectActionAspectContext.getSelf(_self);
    	// BeginInjectInto fr.unice.si5.polytech.createlanguage.rewritingrules.ActionAspect#void execute() from fr.unice.si5.polytech.createlanguage.rewritingrules.GoForwardAspect
    		if (_self instanceof fr.unice.si5.polytech.createlanguage.abstractsyntax.GoForward){
    			fr.unice.si5.polytech.createlanguage.rewritingrules.GoForwardAspect.execute((fr.unice.si5.polytech.createlanguage.abstractsyntax.GoForward)_self);
    		} else
    		// EndInjectInto fr.unice.si5.polytech.createlanguage.rewritingrules.ActionAspect#void execute() from fr.unice.si5.polytech.createlanguage.rewritingrules.GoForwardAspect
    // #DispatchPointCut_before# void execute()
    if (_self instanceof fr.unice.si5.polytech.createlanguage.abstractsyntax.Action){
    	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand command = new fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand() {
    		@Override
    		public void execute() {
    			fr.unice.si5.polytech.createlanguage.rewritingrules.ActionAspect._privk3_execute(_self_, (fr.unice.si5.polytech.createlanguage.abstractsyntax.Action)_self);
    		}
    	};
    	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager stepManager = fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry.getInstance().findStepManager(_self);
    	if (stepManager != null) {
    		stepManager.executeStep(_self, new Object[] {_self}, command, "Action", "execute");
    	} else {
    		command.execute();
    	}
    	;
    };
  }
  
  protected static void _privk3_execute(final ActionAspectActionAspectProperties _self_, final Action _self) {
    throw new java.lang.RuntimeException("Not implemented");
  }
}
