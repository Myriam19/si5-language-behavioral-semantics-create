package fr.unice.si5.polytech.createlanguage.rewritingrules;

import fr.unice.si5.polytech.createlanguage.abstractsyntax.Action;
import fr.unice.si5.polytech.createlanguage.rewritingrules.ActionAspectActionAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class ActionAspectActionAspectContext {
  public final static ActionAspectActionAspectContext INSTANCE = new ActionAspectActionAspectContext();
  
  public static ActionAspectActionAspectProperties getSelf(final Action _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.unice.si5.polytech.createlanguage.rewritingrules.ActionAspectActionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Action, ActionAspectActionAspectProperties> map = new java.util.WeakHashMap<fr.unice.si5.polytech.createlanguage.abstractsyntax.Action, fr.unice.si5.polytech.createlanguage.rewritingrules.ActionAspectActionAspectProperties>();
  
  public Map<Action, ActionAspectActionAspectProperties> getMap() {
    return map;
  }
}
