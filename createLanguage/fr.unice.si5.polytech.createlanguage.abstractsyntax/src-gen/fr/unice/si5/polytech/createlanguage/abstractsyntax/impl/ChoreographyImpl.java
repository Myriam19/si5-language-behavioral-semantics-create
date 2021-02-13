/**
 */
package fr.unice.si5.polytech.createlanguage.abstractsyntax.impl;

import fr.unice.si5.polytech.createlanguage.abstractsyntax.AbstractsyntaxPackage;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.Choreography;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.Instruction;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.Interruption;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choreography</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.ChoreographyImpl#getInterruptions <em>Interruptions</em>}</li>
 *   <li>{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.ChoreographyImpl#getInstructions <em>Instructions</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ChoreographyImpl extends NamedElementImpl implements Choreography {
	/**
	 * The cached value of the '{@link #getInterruptions() <em>Interruptions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterruptions()
	 * @generated
	 * @ordered
	 */
	protected EList<Interruption> interruptions;

	/**
	 * The cached value of the '{@link #getInstructions() <em>Instructions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstructions()
	 * @generated
	 * @ordered
	 */
	protected EList<Instruction> instructions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoreographyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AbstractsyntaxPackage.Literals.CHOREOGRAPHY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interruption> getInterruptions() {
		if (interruptions == null) {
			interruptions = new EObjectContainmentEList<Interruption>(Interruption.class, this,
					AbstractsyntaxPackage.CHOREOGRAPHY__INTERRUPTIONS);
		}
		return interruptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Instruction> getInstructions() {
		if (instructions == null) {
			instructions = new EObjectContainmentEList<Instruction>(Instruction.class, this,
					AbstractsyntaxPackage.CHOREOGRAPHY__INSTRUCTIONS);
		}
		return instructions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case AbstractsyntaxPackage.CHOREOGRAPHY__INTERRUPTIONS:
			return ((InternalEList<?>) getInterruptions()).basicRemove(otherEnd, msgs);
		case AbstractsyntaxPackage.CHOREOGRAPHY__INSTRUCTIONS:
			return ((InternalEList<?>) getInstructions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case AbstractsyntaxPackage.CHOREOGRAPHY__INTERRUPTIONS:
			return getInterruptions();
		case AbstractsyntaxPackage.CHOREOGRAPHY__INSTRUCTIONS:
			return getInstructions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case AbstractsyntaxPackage.CHOREOGRAPHY__INTERRUPTIONS:
			getInterruptions().clear();
			getInterruptions().addAll((Collection<? extends Interruption>) newValue);
			return;
		case AbstractsyntaxPackage.CHOREOGRAPHY__INSTRUCTIONS:
			getInstructions().clear();
			getInstructions().addAll((Collection<? extends Instruction>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case AbstractsyntaxPackage.CHOREOGRAPHY__INTERRUPTIONS:
			getInterruptions().clear();
			return;
		case AbstractsyntaxPackage.CHOREOGRAPHY__INSTRUCTIONS:
			getInstructions().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case AbstractsyntaxPackage.CHOREOGRAPHY__INTERRUPTIONS:
			return interruptions != null && !interruptions.isEmpty();
		case AbstractsyntaxPackage.CHOREOGRAPHY__INSTRUCTIONS:
			return instructions != null && !instructions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ChoreographyImpl
