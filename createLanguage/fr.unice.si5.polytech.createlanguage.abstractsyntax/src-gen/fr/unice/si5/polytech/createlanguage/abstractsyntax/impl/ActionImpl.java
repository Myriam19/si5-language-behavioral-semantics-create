/**
 */
package fr.unice.si5.polytech.createlanguage.abstractsyntax.impl;

import fr.unice.si5.polytech.createlanguage.abstractsyntax.AbstractsyntaxPackage;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.Action;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ActionImpl extends InstructionImpl implements Action {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AbstractsyntaxPackage.Literals.ACTION;
	}

} //ActionImpl
