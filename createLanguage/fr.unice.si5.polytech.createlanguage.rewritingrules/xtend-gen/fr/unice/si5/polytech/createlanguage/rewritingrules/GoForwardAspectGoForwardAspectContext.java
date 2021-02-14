package fr.unice.si5.polytech.createlanguage.rewritingrules;

import fr.unice.si5.polytech.createlanguage.abstractsyntax.GoForward;
import fr.unice.si5.polytech.createlanguage.rewritingrules.GoForwardAspectGoForwardAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class GoForwardAspectGoForwardAspectContext {
  public final static GoForwardAspectGoForwardAspectContext INSTANCE = new GoForwardAspectGoForwardAspectContext();
  
  public static GoForwardAspectGoForwardAspectProperties getSelf(final GoForward _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.unice.si5.polytech.createlanguage.rewritingrules.GoForwardAspectGoForwardAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<GoForward, GoForwardAspectGoForwardAspectProperties> map = new java.util.WeakHashMap<fr.unice.si5.polytech.createlanguage.abstractsyntax.GoForward, fr.unice.si5.polytech.createlanguage.rewritingrules.GoForwardAspectGoForwardAspectProperties>();
  
  public Map<GoForward, GoForwardAspectGoForwardAspectProperties> getMap() {
    return map;
  }
}
