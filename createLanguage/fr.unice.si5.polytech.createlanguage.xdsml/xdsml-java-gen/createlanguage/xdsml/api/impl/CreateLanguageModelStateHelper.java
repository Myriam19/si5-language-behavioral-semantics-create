/* GENERATED FILE, do not modify manually                                                    *
 * If you need to modify it, copy it first */
package createlanguage.xdsml.api.impl;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.ElementState;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelState;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.k3ModelState.K3ModelStateFactory;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.dsa.helper.IK3ModelStateHelper;import org.eclipse.gemoc.executionframework.engine.commons.K3DslHelper;


public class CreateLanguageModelStateHelper implements IK3ModelStateHelper{
	private static class AttributeNameToValue implements Serializable{

		private static final long serialVersionUID = 0;		String name;
		Object value;
		public AttributeNameToValue(String n, Object v) {
			name = n;
			value = v;
		}


		@Override
		public boolean equals(Object obj) {
			if (! (obj instanceof AttributeNameToValue)) {
				return false;
			}
			AttributeNameToValue a2n = (AttributeNameToValue)obj;
			if (this.name.compareTo(a2n.name) != 0) {
				return false;
			}
			if (this.value == null) {
				return a2n.value == null;
			}
			if (!this.value.equals(a2n.value)) {
				return false;
			}
			return true;
		}	}
		K3ModelStateFactory theFactory = K3ModelStateFactory.eINSTANCE; 
	public K3ModelState getK3ModelState(EObject model) {
		K3ModelState res = theFactory.createK3ModelState();

		TreeIterator<EObject> allContentIt = model.eAllContents();
		while (allContentIt.hasNext()) {
			EObject elem = allContentIt.next();

			Class<?> clazz =null;
			clazz = K3DslHelper.getTarget(fr.unice.si5.polytech.createlanguage.rewritingrules.ConditionAspect.class);
			if (clazz.isInstance(elem)) {
				ElementState elemState = theFactory.createElementState();
				elemState.setModelElement(elem);
				res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("isValid", CreateLanguageRTDAccessor.getIsValid((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.Condition)elem));
				elemState.getSavedRTDs().add(n2v0);
			}
			clazz = K3DslHelper.getTarget(fr.unice.si5.polytech.createlanguage.rewritingrules.ActionAspect.class);
			if (clazz.isInstance(elem)) {
				ElementState elemState = theFactory.createElementState();
				elemState.setModelElement(elem);
				res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("time", CreateLanguageRTDAccessor.getTime((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.Action)elem));
				elemState.getSavedRTDs().add(n2v0);
			}
			clazz = K3DslHelper.getTarget(fr.unice.si5.polytech.createlanguage.rewritingrules.RotateAspect.class);
			if (clazz.isInstance(elem)) {
				ElementState elemState = theFactory.createElementState();
				elemState.setModelElement(elem);
				res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("right", CreateLanguageRTDAccessor.getRight((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.Rotate)elem));
				elemState.getSavedRTDs().add(n2v0);
				AttributeNameToValue n2v1 = new AttributeNameToValue("realAngle", CreateLanguageRTDAccessor.getRealAngle((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.Rotate)elem));
				elemState.getSavedRTDs().add(n2v1);
			}
			clazz = K3DslHelper.getTarget(fr.unice.si5.polytech.createlanguage.rewritingrules.ReleaseInFrontAspect.class);
			if (clazz.isInstance(elem)) {
				ElementState elemState = theFactory.createElementState();
				elemState.setModelElement(elem);
				res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("stopped", CreateLanguageRTDAccessor.getStopped((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.ReleaseInFront)elem));
				elemState.getSavedRTDs().add(n2v0);
				AttributeNameToValue n2v1 = new AttributeNameToValue("turned", CreateLanguageRTDAccessor.getTurned((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.ReleaseInFront)elem));
				elemState.getSavedRTDs().add(n2v1);
				AttributeNameToValue n2v2 = new AttributeNameToValue("opened", CreateLanguageRTDAccessor.getOpened((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.ReleaseInFront)elem));
				elemState.getSavedRTDs().add(n2v2);
				AttributeNameToValue n2v3 = new AttributeNameToValue("wentForward", CreateLanguageRTDAccessor.getWentForward((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.ReleaseInFront)elem));
				elemState.getSavedRTDs().add(n2v3);
				AttributeNameToValue n2v4 = new AttributeNameToValue("closed", CreateLanguageRTDAccessor.getClosed((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.ReleaseInFront)elem));
				elemState.getSavedRTDs().add(n2v4);
			}
			clazz = K3DslHelper.getTarget(fr.unice.si5.polytech.createlanguage.rewritingrules.FiniteChoreographyAspect.class);
			if (clazz.isInstance(elem)) {
				ElementState elemState = theFactory.createElementState();
				elemState.setModelElement(elem);
				res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("currentInstruction", CreateLanguageRTDAccessor.getCurrentInstruction((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.FiniteChoreography)elem));
				elemState.getSavedRTDs().add(n2v0);
				AttributeNameToValue n2v1 = new AttributeNameToValue("currentInstructionIndex", CreateLanguageRTDAccessor.getCurrentInstructionIndex((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.FiniteChoreography)elem));
				elemState.getSavedRTDs().add(n2v1);
				AttributeNameToValue n2v2 = new AttributeNameToValue("firstInterruptionChecked", CreateLanguageRTDAccessor.getFirstInterruptionChecked((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.FiniteChoreography)elem));
				elemState.getSavedRTDs().add(n2v2);
			}
			clazz = K3DslHelper.getTarget(fr.unice.si5.polytech.createlanguage.rewritingrules.InstructionAspect.class);
			if (clazz.isInstance(elem)) {
				ElementState elemState = theFactory.createElementState();
				elemState.setModelElement(elem);
				res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("isRunning", CreateLanguageRTDAccessor.getIsRunning((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.Instruction)elem));
				elemState.getSavedRTDs().add(n2v0);
			}
			clazz = K3DslHelper.getTarget(fr.unice.si5.polytech.createlanguage.rewritingrules.GrabInFrontAspect.class);
			if (clazz.isInstance(elem)) {
				ElementState elemState = theFactory.createElementState();
				elemState.setModelElement(elem);
				res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("stopped", CreateLanguageRTDAccessor.getStopped((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.GrabInFront)elem));
				elemState.getSavedRTDs().add(n2v0);
				AttributeNameToValue n2v1 = new AttributeNameToValue("turned", CreateLanguageRTDAccessor.getTurned((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.GrabInFront)elem));
				elemState.getSavedRTDs().add(n2v1);
				AttributeNameToValue n2v2 = new AttributeNameToValue("opened", CreateLanguageRTDAccessor.getOpened((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.GrabInFront)elem));
				elemState.getSavedRTDs().add(n2v2);
				AttributeNameToValue n2v3 = new AttributeNameToValue("wentBackward", CreateLanguageRTDAccessor.getWentBackward((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.GrabInFront)elem));
				elemState.getSavedRTDs().add(n2v3);
				AttributeNameToValue n2v4 = new AttributeNameToValue("closed", CreateLanguageRTDAccessor.getClosed((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.GrabInFront)elem));
				elemState.getSavedRTDs().add(n2v4);
				AttributeNameToValue n2v5 = new AttributeNameToValue("wentForward", CreateLanguageRTDAccessor.getWentForward((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.GrabInFront)elem));
				elemState.getSavedRTDs().add(n2v5);
			}
			clazz = K3DslHelper.getTarget(fr.unice.si5.polytech.createlanguage.rewritingrules.ParalleleChoreoAspect.class);
			if (clazz.isInstance(elem)) {
				ElementState elemState = theFactory.createElementState();
				elemState.setModelElement(elem);
				res.getOwnedElementstates().add(elemState);
				AttributeNameToValue n2v0 = new AttributeNameToValue("currentReferenceChoreo", CreateLanguageRTDAccessor.getCurrentReferenceChoreo((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.ParalleleChoreo)elem));
				elemState.getSavedRTDs().add(n2v0);
				AttributeNameToValue n2v1 = new AttributeNameToValue("currentReferenceChoreoIndex", CreateLanguageRTDAccessor.getCurrentReferenceChoreoIndex((fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.ParalleleChoreo)elem));
				elemState.getSavedRTDs().add(n2v1);
			}
		}
		return res;
		}

	public void restoreModelState(K3ModelState state) {
		for(ElementState elemState : state.getOwnedElementstates()) {
			for(Object o : elemState.getSavedRTDs()) {
				AttributeNameToValue n2v = (AttributeNameToValue)o;
				try {
					if (n2v.value != null) {
						Method m = CreateLanguageRTDAccessor.class.getMethod("set"+n2v.name, EObject.class, n2v.value.getClass());
						m.invoke(null, elemState.getModelElement(), n2v.value);
					}
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					Method m = null;
					for(Class<?> c : n2v.value.getClass().getInterfaces()) {
						
						try {
							m = CreateLanguageRTDAccessor.class.getMethod("set"+n2v.name, EObject.class, n2v.value.getClass().getInterfaces()[0]);
							m.invoke(null, elemState.getModelElement(), n2v.value);
						} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
						}
						if (m == null) {
							throw new RuntimeException("not method found for "+n2v.value.getClass().getName()+"::set"+n2v.name);
						}
					}
				}
			}
		}
	}

};