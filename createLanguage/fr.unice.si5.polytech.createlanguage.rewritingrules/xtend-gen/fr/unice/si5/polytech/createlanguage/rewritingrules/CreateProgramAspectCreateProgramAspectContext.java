package fr.unice.si5.polytech.createlanguage.rewritingrules;

import fr.unice.si5.polytech.createlanguage.abstractsyntax.CreateProgram;
import fr.unice.si5.polytech.createlanguage.rewritingrules.CreateProgramAspectCreateProgramAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class CreateProgramAspectCreateProgramAspectContext {
  public final static CreateProgramAspectCreateProgramAspectContext INSTANCE = new CreateProgramAspectCreateProgramAspectContext();
  
  public static CreateProgramAspectCreateProgramAspectProperties getSelf(final CreateProgram _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.unice.si5.polytech.createlanguage.rewritingrules.CreateProgramAspectCreateProgramAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<CreateProgram, CreateProgramAspectCreateProgramAspectProperties> map = new java.util.WeakHashMap<fr.unice.si5.polytech.createlanguage.abstractsyntax.CreateProgram, fr.unice.si5.polytech.createlanguage.rewritingrules.CreateProgramAspectCreateProgramAspectProperties>();
  
  public Map<CreateProgram, CreateProgramAspectCreateProgramAspectProperties> getMap() {
    return map;
  }
}
