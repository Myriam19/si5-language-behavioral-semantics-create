package fr.unice.si5.polytech.createlanguage.rewritingrules;

import fr.unice.si5.polytech.createlanguage.abstractsyntax.FiniteChoreography;
import fr.unice.si5.polytech.createlanguage.rewritingrules.FiniteChoreographyAspectFiniteChoreographyAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class FiniteChoreographyAspectFiniteChoreographyAspectContext {
  public final static FiniteChoreographyAspectFiniteChoreographyAspectContext INSTANCE = new FiniteChoreographyAspectFiniteChoreographyAspectContext();
  
  public static FiniteChoreographyAspectFiniteChoreographyAspectProperties getSelf(final FiniteChoreography _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.unice.si5.polytech.createlanguage.rewritingrules.FiniteChoreographyAspectFiniteChoreographyAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<FiniteChoreography, FiniteChoreographyAspectFiniteChoreographyAspectProperties> map = new java.util.WeakHashMap<fr.unice.si5.polytech.createlanguage.abstractsyntax.FiniteChoreography, fr.unice.si5.polytech.createlanguage.rewritingrules.FiniteChoreographyAspectFiniteChoreographyAspectProperties>();
  
  public Map<FiniteChoreography, FiniteChoreographyAspectFiniteChoreographyAspectProperties> getMap() {
    return map;
  }
}
