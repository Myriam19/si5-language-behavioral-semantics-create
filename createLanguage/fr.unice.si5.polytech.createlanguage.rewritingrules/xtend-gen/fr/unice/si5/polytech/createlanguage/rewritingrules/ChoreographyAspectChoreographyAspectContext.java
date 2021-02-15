package fr.unice.si5.polytech.createlanguage.rewritingrules;

import fr.unice.si5.polytech.createlanguage.abstractsyntax.Choreography;
import fr.unice.si5.polytech.createlanguage.rewritingrules.ChoreographyAspectChoreographyAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class ChoreographyAspectChoreographyAspectContext {
  public final static ChoreographyAspectChoreographyAspectContext INSTANCE = new ChoreographyAspectChoreographyAspectContext();
  
  public static ChoreographyAspectChoreographyAspectProperties getSelf(final Choreography _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.unice.si5.polytech.createlanguage.rewritingrules.ChoreographyAspectChoreographyAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Choreography, ChoreographyAspectChoreographyAspectProperties> map = new java.util.WeakHashMap<fr.unice.si5.polytech.createlanguage.abstractsyntax.Choreography, fr.unice.si5.polytech.createlanguage.rewritingrules.ChoreographyAspectChoreographyAspectProperties>();
  
  public Map<Choreography, ChoreographyAspectChoreographyAspectProperties> getMap() {
    return map;
  }
}
