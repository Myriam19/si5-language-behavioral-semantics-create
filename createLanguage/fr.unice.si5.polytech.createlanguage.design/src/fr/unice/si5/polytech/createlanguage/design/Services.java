package fr.unice.si5.polytech.createlanguage.design;

import org.eclipse.emf.ecore.EObject;

import fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.*;

/**
 * The services class used by VSM.
 */
public class Services {
    
    public String getLabel(Instruction instruction) {
    	if(instruction instanceof GoForward) {
    		return "";
    	}
    	return "";
    }
}
