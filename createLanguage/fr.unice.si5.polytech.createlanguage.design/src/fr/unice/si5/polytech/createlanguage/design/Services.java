package fr.unice.si5.polytech.createlanguage.design;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.eclipse.emf.ecore.EObject;

import fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.*;

/**
 * The services class used by VSM.
 */
public class Services {
    
    public String getLabel(Instruction instruction) {
    	if(instruction instanceof GoForward) {
    		GoForward gf = (GoForward)instruction;
    		
    		if(gf.getDistance() != -1) {
    			return gf.getDistance() + " cm";
    		} else {
    			return gf.getDuration() + " s";
    		}
    	} else if(instruction instanceof Choreography) {
    		return ((Choreography)instruction).getName();
    	}
    	return ""; 
    }
    
    /*public ReferenceChoreography getNextChoreo(ReferenceChoreography ref) {
    	CreateProgram prog = (CreateProgram) ref.eContainer();
    	List<ReferenceChoreography> startingChoreo = prog.getStarting_choreo();
    	
    	int position = startingChoreo.indexOf(ref);
    	
    	if(position == startingChoreo.size()-1) {
    		return null;
    	} else {
    		return startingChoreo.get(position+1);
    	}
    }*/
    
    public List<Choreography> getChoreo(CreateProgram prog){
    	List<Choreography> refs = new ArrayList<>();
    	
    	for (ChoreoToRun c : prog.getStarting_choreo()) {
			if(c instanceof ReferenceChoreography) {
				refs.add(((ReferenceChoreography) c).getChoreography());
			} else {
				ParalleleChoreo p = (ParalleleChoreo) c;
				for (ReferenceChoreography referenceChoreography : p.getReferenceChoreographies()) {
					refs.add(referenceChoreography.getChoreography());
				}
			}
		}
    	
    	return refs;
    }
    
    public List<Interruption> getInterruptions(CreateProgram prog){
    	List<Interruption> interruptions = new ArrayList<>();
    	List<Choreography> choreos = getChoreo(prog);
    	
    	for (Choreography c : choreos) {
    		for (Interruption i : c.getInterruptions()) {
    			interruptions.add(i);
			}
		}
    	
    	return interruptions;
    }
    
    public boolean hasInterruption(ReferenceChoreography ref) {
    	if(ref.getChoreography().getInterruptions() != null && ref.getChoreography().getInterruptions().size()>0) {
    		return true;
    	}
    	return false;
    }
    
    public String getConditions(Interruption interruption) {
    	String stringConditions = "";
    	List<Condition> conditions = interruption.getConditions();
    	
    	if(conditions != null && conditions.size() > 0) {
    		if(conditions.get(0) instanceof ObjectFound) {
				stringConditions += "Object found";
			}
    		for (int i=1; i<conditions.size(); i++) {
				if(conditions.get(i) instanceof ObjectFound) {
					stringConditions += "\nand Object found";
				}
			}
    	}
    	
    	return stringConditions;
    }
    
    public ReferenceChoreography getInterruptionChoreo(Interruption i) {
    	return i.getChoreography();
    }
}
