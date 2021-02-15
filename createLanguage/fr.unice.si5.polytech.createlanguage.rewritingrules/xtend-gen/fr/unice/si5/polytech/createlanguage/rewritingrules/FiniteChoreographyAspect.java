package fr.unice.si5.polytech.createlanguage.rewritingrules;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.FiniteChoreography;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.Instruction;
import fr.unice.si5.polytech.createlanguage.rewritingrules.ChoreographyAspect;
import fr.unice.si5.polytech.createlanguage.rewritingrules.FiniteChoreographyAspectFiniteChoreographyAspectProperties;
import fr.unice.si5.polytech.createlanguage.rewritingrules.InstructionAspect;
import org.eclipse.emf.common.util.EList;

@Aspect(className = FiniteChoreography.class)
@SuppressWarnings("all")
public class FiniteChoreographyAspect extends ChoreographyAspect {
  @Step
  @OverrideAspectMethod
  public static void execute(final FiniteChoreography _self) {
    final fr.unice.si5.polytech.createlanguage.rewritingrules.FiniteChoreographyAspectFiniteChoreographyAspectProperties _self_ = fr.unice.si5.polytech.createlanguage.rewritingrules.FiniteChoreographyAspectFiniteChoreographyAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void execute()
    if (_self instanceof fr.unice.si5.polytech.createlanguage.abstractsyntax.FiniteChoreography){
    	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand command = new fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand() {
    		@Override
    		public void execute() {
    			fr.unice.si5.polytech.createlanguage.rewritingrules.FiniteChoreographyAspect._privk3_execute(_self_, (fr.unice.si5.polytech.createlanguage.abstractsyntax.FiniteChoreography)_self);
    		}
    	};
    	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager stepManager = fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry.getInstance().findStepManager(_self);
    	if (stepManager != null) {
    		stepManager.executeStep(_self, new Object[] {_self}, command, "FiniteChoreography", "execute");
    	} else {
    		command.execute();
    	}
    	;
    };
  }
  
  protected static void _privk3_execute(final FiniteChoreographyAspectFiniteChoreographyAspectProperties _self_, final FiniteChoreography _self) {
    EList<Instruction> _instructions = _self.getInstructions();
    for (final Instruction i : _instructions) {
      InstructionAspect.execute(i);
    }
  }
}
