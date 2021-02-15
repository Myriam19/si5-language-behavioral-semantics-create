package fr.unice.si5.polytech.createlanguage.rewritingrules;

import fr.inria.diverse.k3.al.annotationprocessor.Abstract;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.Choreography;
import fr.unice.si5.polytech.createlanguage.rewritingrules.ChoreographyAspectChoreographyAspectProperties;
import fr.unice.si5.polytech.createlanguage.rewritingrules.InstructionAspect;

@Aspect(className = Choreography.class)
@SuppressWarnings("all")
public abstract class ChoreographyAspect extends InstructionAspect {
  @Step
  @OverrideAspectMethod
  @Abstract
  public static void execute(final Choreography _self) {
    final fr.unice.si5.polytech.createlanguage.rewritingrules.ChoreographyAspectChoreographyAspectProperties _self_ = fr.unice.si5.polytech.createlanguage.rewritingrules.ChoreographyAspectChoreographyAspectContext.getSelf(_self);
    	// BeginInjectInto fr.unice.si5.polytech.createlanguage.rewritingrules.ChoreographyAspect#void execute() from fr.unice.si5.polytech.createlanguage.rewritingrules.FiniteChoreographyAspect
    		if (_self instanceof fr.unice.si5.polytech.createlanguage.abstractsyntax.FiniteChoreography){
    			fr.unice.si5.polytech.createlanguage.rewritingrules.FiniteChoreographyAspect.execute((fr.unice.si5.polytech.createlanguage.abstractsyntax.FiniteChoreography)_self);
    		} else
    		// EndInjectInto fr.unice.si5.polytech.createlanguage.rewritingrules.ChoreographyAspect#void execute() from fr.unice.si5.polytech.createlanguage.rewritingrules.FiniteChoreographyAspect
    // #DispatchPointCut_before# void execute()
    if (_self instanceof fr.unice.si5.polytech.createlanguage.abstractsyntax.Choreography){
    	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand command = new fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand() {
    		@Override
    		public void execute() {
    			fr.unice.si5.polytech.createlanguage.rewritingrules.ChoreographyAspect._privk3_execute(_self_, (fr.unice.si5.polytech.createlanguage.abstractsyntax.Choreography)_self);
    		}
    	};
    	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager stepManager = fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry.getInstance().findStepManager(_self);
    	if (stepManager != null) {
    		stepManager.executeStep(_self, new Object[] {_self}, command, "Choreography", "execute");
    	} else {
    		command.execute();
    	}
    	;
    };
  }
  
  protected static void _privk3_execute(final ChoreographyAspectChoreographyAspectProperties _self_, final Choreography _self) {
    throw new java.lang.RuntimeException("Not implemented");
  }
}
