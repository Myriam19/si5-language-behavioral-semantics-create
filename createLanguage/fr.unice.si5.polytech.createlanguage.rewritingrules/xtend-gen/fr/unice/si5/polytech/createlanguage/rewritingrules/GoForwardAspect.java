package fr.unice.si5.polytech.createlanguage.rewritingrules;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.GoForward;
import fr.unice.si5.polytech.createlanguage.rewritingrules.ActionAspect;
import fr.unice.si5.polytech.createlanguage.rewritingrules.CreateProgramAspect;
import fr.unice.si5.polytech.createlanguage.rewritingrules.GoForwardAspectGoForwardAspectProperties;

@Aspect(className = GoForward.class)
@SuppressWarnings("all")
public class GoForwardAspect extends ActionAspect {
  @Step
  @OverrideAspectMethod
  public static void execute(final GoForward _self) {
    final fr.unice.si5.polytech.createlanguage.rewritingrules.GoForwardAspectGoForwardAspectProperties _self_ = fr.unice.si5.polytech.createlanguage.rewritingrules.GoForwardAspectGoForwardAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void execute()
    if (_self instanceof fr.unice.si5.polytech.createlanguage.abstractsyntax.GoForward){
    	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand command = new fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand() {
    		@Override
    		public void execute() {
    			fr.unice.si5.polytech.createlanguage.rewritingrules.GoForwardAspect._privk3_execute(_self_, (fr.unice.si5.polytech.createlanguage.abstractsyntax.GoForward)_self);
    		}
    	};
    	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager stepManager = fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry.getInstance().findStepManager(_self);
    	if (stepManager != null) {
    		stepManager.executeStep(_self, new Object[] {_self}, command, "GoForward", "execute");
    	} else {
    		command.execute();
    	}
    	;
    };
  }
  
  protected static void _privk3_execute(final GoForwardAspectGoForwardAspectProperties _self_, final GoForward _self) {
    while (true) {
      CreateProgramAspect.controler.goForward();
    }
  }
}
