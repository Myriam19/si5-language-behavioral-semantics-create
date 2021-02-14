package fr.unice.si5.polytech.createlanguage.rewritingrules;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.Main;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.CreateProgram;
import fr.unice.si5.polytech.createlanguage.rewritingrules.CreateProgramAspectCreateProgramAspectProperties;
import fr.univcotedazur.kairos.webots.polycreate.controler.PolyCreateControler;

/**
 * Sample aspect that gives java.io.File the ability to store Text content and save it to disk
 */
@Aspect(className = CreateProgram.class)
@SuppressWarnings("all")
public class CreateProgramAspect {
  public static PolyCreateControler controler = new PolyCreateControler();
  
  @Main
  public static void entryPoint(final CreateProgram _self) {
    final fr.unice.si5.polytech.createlanguage.rewritingrules.CreateProgramAspectCreateProgramAspectProperties _self_ = fr.unice.si5.polytech.createlanguage.rewritingrules.CreateProgramAspectCreateProgramAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void entryPoint()
    if (_self instanceof fr.unice.si5.polytech.createlanguage.abstractsyntax.CreateProgram){
    	fr.unice.si5.polytech.createlanguage.rewritingrules.CreateProgramAspect._privk3_entryPoint(_self_, (fr.unice.si5.polytech.createlanguage.abstractsyntax.CreateProgram)_self);
    };
  }
  
  protected static void _privk3_entryPoint(final CreateProgramAspectCreateProgramAspectProperties _self_, final CreateProgram _self) {
  }
}
