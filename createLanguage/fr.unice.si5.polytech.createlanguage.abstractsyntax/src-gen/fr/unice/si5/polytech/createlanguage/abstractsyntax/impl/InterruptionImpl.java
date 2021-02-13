/**
 */
package fr.unice.si5.polytech.createlanguage.abstractsyntax.impl;

import fr.unice.si5.polytech.createlanguage.abstractsyntax.AbstractsyntaxPackage;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.Choreography;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.Condition;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.Interruption;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interruption</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.InterruptionImpl#getConditions <em>Conditions</em>}</li>
 *   <li>{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.InterruptionImpl#getChoreography <em>Choreography</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InterruptionImpl extends MinimalEObjectImpl.Container implements Interruption {
	/**
	 * The cached value of the '{@link #getConditions() <em>Conditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<Condition> conditions;

	/**
	 * The cached value of the '{@link #getChoreography() <em>Choreography</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChoreography()
	 * @generated
	 * @ordered
	 */
	protected Choreography choreography;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterruptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AbstractsyntaxPackage.Literals.INTERRUPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Condition> getConditions() {
		if (conditions == null) {
			conditions = new EObjectContainmentEList<Condition>(Condition.class, this,
					AbstractsyntaxPackage.INTERRUPTION__CONDITIONS);
		}
		return conditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choreography getChoreography() {
		if (choreography != null && choreography.eIsProxy()) {
			InternalEObject oldChoreography = (InternalEObject) choreography;
			choreography = (Choreography) eResolveProxy(oldChoreography);
			if (choreography != oldChoreography) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							AbstractsyntaxPackage.INTERRUPTION__CHOREOGRAPHY, oldChoreography, choreography));
			}
		}
		return choreography;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choreography basicGetChoreography() {
		return choreography;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChoreography(Choreography newChoreography) {
		Choreography oldChoreography = choreography;
		choreography = newChoreography;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractsyntaxPackage.INTERRUPTION__CHOREOGRAPHY,
					oldChoreography, choreography));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case AbstractsyntaxPackage.INTERRUPTION__CONDITIONS:
			return ((InternalEList<?>) getConditions()).basicRemove(otherEnd, msgs);
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
		case AbstractsyntaxPackage.INTERRUPTION__CONDITIONS:
			return getConditions();
		case AbstractsyntaxPackage.INTERRUPTION__CHOREOGRAPHY:
			if (resolve)
				return getChoreography();
			return basicGetChoreography();
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
		case AbstractsyntaxPackage.INTERRUPTION__CONDITIONS:
			getConditions().clear();
			getConditions().addAll((Collection<? extends Condition>) newValue);
			return;
		case AbstractsyntaxPackage.INTERRUPTION__CHOREOGRAPHY:
			setChoreography((Choreography) newValue);
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
		case AbstractsyntaxPackage.INTERRUPTION__CONDITIONS:
			getConditions().clear();
			return;
		case AbstractsyntaxPackage.INTERRUPTION__CHOREOGRAPHY:
			setChoreography((Choreography) null);
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
		case AbstractsyntaxPackage.INTERRUPTION__CONDITIONS:
			return conditions != null && !conditions.isEmpty();
		case AbstractsyntaxPackage.INTERRUPTION__CHOREOGRAPHY:
			return choreography != null;
		}
		return super.eIsSet(featureID);
	}

} //InterruptionImpl
