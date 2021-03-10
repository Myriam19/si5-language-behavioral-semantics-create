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
    	} else if(instruction instanceof Rotate) {
    		return ((Rotate)instruction).getAngle() + " degrees";
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
    
    public List<ReferenceChoreography> getRefChoreo(CreateProgram prog){
    	List<ReferenceChoreography> refs = new ArrayList<>();
    	
    	for (ChoreoToRun c : prog.getStarting_choreo()) {
			if(c instanceof ReferenceChoreography) {
				refs.add(((ReferenceChoreography) c));
			} else {
				ParalleleChoreo p = (ParalleleChoreo) c;
				for (ReferenceChoreography referenceChoreography : p.getReferenceChoreographies()) {
					refs.add(referenceChoreography);
				}
			}
		}
    	
    	return refs;
    }
    
    public List<Interruption> getInterruptions(CreateProgram prog){
    	List<Interruption> interruptions = new ArrayList<>();
    	List<ReferenceChoreography> choreos = getRefChoreo(prog);
    	
    	for (ReferenceChoreography c : choreos) {
    		for (Interruption i : c.getChoreography().getInterruptions()) {
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
    
    private String getAndCondition(AndCondition c) {
    	String conditionString = "(";
    	
    	if(c.getAndConditions().get(0) instanceof ObjectFound) {
    		ObjectFound of = (ObjectFound) c.getAndConditions().get(0);
			conditionString += "Object found at " + of.getDistance() + " cm";
		} else if(c.getAndConditions().get(0) instanceof ObstacleFoundLeft) {
			conditionString += "Left obstacle found";
		} else if(c.getAndConditions().get(0) instanceof ObstacleFoundRight) {
			conditionString += "Right obstacle found";
		} else if(c.getAndConditions().get(0) instanceof VirtualWallFound) {
			conditionString += "Virtual wall found";
		} else if(c.getAndConditions().get(0) instanceof AndCondition) {
			conditionString += getAndCondition((AndCondition) c.getAndConditions().get(0));
		} else if(c.getAndConditions().get(0) instanceof OrCondition) {
			conditionString += getOrCondition((OrCondition) c.getAndConditions().get(0));
		}
    	
    	for (int i=1; i<c.getAndConditions().size(); i++) {
    		if(c.getAndConditions().get(i) instanceof ObjectFound) {
    			ObjectFound of = (ObjectFound) c.getAndConditions().get(i);
    			conditionString += " && Object found at " + of.getDistance() + " cm";
    		} else if(c.getAndConditions().get(i) instanceof ObstacleFoundLeft) {
    			conditionString += " && Left obstacle found";
    		} else if(c.getAndConditions().get(i) instanceof ObstacleFoundRight) {
    			conditionString += " && Right obstacle found";
    		} else if(c.getAndConditions().get(i) instanceof VirtualWallFound) {
    			conditionString += " && Virtual wall found";
    		} else if(c.getAndConditions().get(i) instanceof AndCondition) {
    			conditionString += " && "+getAndCondition((AndCondition) c.getAndConditions().get(i));
    		} else if(c.getAndConditions().get(i) instanceof OrCondition) {
    			conditionString += " && "+getOrCondition((OrCondition) c.getAndConditions().get(i));
    		}
		}
    	
    	conditionString += ")";
    	return conditionString;
    }
    
    private String getOrCondition(OrCondition c) {
    	String conditionString = "(";
    	
    	if(c.getOrConditions().get(0) instanceof ObjectFound) {
    		ObjectFound of = (ObjectFound) c.getOrConditions().get(0);
			conditionString += "Object found at " + of.getDistance() + " cm";
		} else if(c.getOrConditions().get(0) instanceof ObstacleFoundLeft) {
			conditionString += "Left obstacle found";
		} else if(c.getOrConditions().get(0) instanceof ObstacleFoundRight) {
			conditionString += "Right obstacle found";
		} else if(c.getOrConditions().get(0) instanceof VirtualWallFound) {
			conditionString += "Virtual wall found";
		} else if(c.getOrConditions().get(0) instanceof AndCondition) {
			conditionString += getAndCondition((AndCondition) c.getOrConditions().get(0));
		} else if(c.getOrConditions().get(0) instanceof OrCondition) {
			conditionString += getOrCondition((OrCondition) c.getOrConditions().get(0));
		}
    	
    	for (int i=1; i<c.getOrConditions().size(); i++) {
    		if(c.getOrConditions().get(i) instanceof ObjectFound) {
    			ObjectFound of = (ObjectFound) c.getOrConditions().get(i);
    			conditionString += " || Object found at " + of.getDistance() + " cm";
    		} else if(c.getOrConditions().get(i) instanceof ObstacleFoundLeft) {
    			conditionString += " || Left obstacle found";
    		} else if(c.getOrConditions().get(i) instanceof ObstacleFoundRight) {
    			conditionString += " || Right obstacle found";
    		} else if(c.getOrConditions().get(i) instanceof VirtualWallFound) {
    			conditionString += " || Virtual wall found";
    		} else if(c.getOrConditions().get(i) instanceof AndCondition) {
    			conditionString += " || "+getAndCondition((AndCondition) c.getOrConditions().get(i));
    		} else if(c.getOrConditions().get(i) instanceof OrCondition) {
    			conditionString += " || "+getOrCondition((OrCondition) c.getOrConditions().get(i));
    		}
		}
    	
    	conditionString += ")";
    	return conditionString;
    }
    
    public String getConditions(Interruption interruption) {
    	String conditionString = "";
    	Condition condition = interruption.getCondition();
    	
    	if(condition instanceof ObjectFound) {
    		ObjectFound of = (ObjectFound) condition;
			conditionString += "Object found at " + of.getDistance() + " cm";
		} else if(condition instanceof ObstacleFoundLeft) {
			conditionString += "Left obstacle found";
		} else if(condition instanceof ObstacleFoundRight) {
			conditionString += "Right obstacle found";
		} else if(condition instanceof VirtualWallFound) {
			conditionString += "Virtual wall found";
		} else if(condition instanceof AndCondition) {
			conditionString += getAndCondition((AndCondition) condition);
		} else if(condition instanceof OrCondition) {
			conditionString += getOrCondition((OrCondition) condition);
		}
    	
    	return conditionString;
    }
    
    public String getConditionString(Condition condition) {
    	String conditionString = "";
    	
    	if(condition instanceof ObjectFound) {
    		ObjectFound of = (ObjectFound) condition;
			conditionString += "Object found at " + of.getDistance() + " cm";
		} else if(condition instanceof ObstacleFoundLeft) {
			conditionString += "Left obstacle found";
		} else if(condition instanceof ObstacleFoundRight) {
			conditionString += "Right obstacle found";
		} else if(condition instanceof VirtualWallFound) {
			conditionString += "Virtual wall found";
		} else if(condition instanceof AndCondition) {
			conditionString += getAndCondition((AndCondition) condition);
		} else if(condition instanceof OrCondition) {
			conditionString += getOrCondition((OrCondition) condition);
		}
    	
    	return conditionString;
    }
    
    public ReferenceChoreography getInterruptionChoreo(Interruption i) {
    	return i.getChoreography();
    }
}
