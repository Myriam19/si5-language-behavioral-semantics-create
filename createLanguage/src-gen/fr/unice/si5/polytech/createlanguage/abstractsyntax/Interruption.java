/**
 */
package fr.unice.si5.polytech.createlanguage.abstractsyntax;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interruption</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Interruption#getConditions <em>Conditions</em>}</li>
 *   <li>{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Interruption#getChoreography <em>Choreography</em>}</li>
 * </ul>
 *
 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.AbstractsyntaxPackage#getInterruption()
 * @model
 * @generated
 */
public interface Interruption extends EObject {
	/**
	 * Returns the value of the '<em><b>Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Condition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditions</em>' containment reference list.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.AbstractsyntaxPackage#getInterruption_Conditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Condition> getConditions();

	/**
	 * Returns the value of the '<em><b>Choreography</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Choreography</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choreography</em>' reference.
	 * @see #setChoreography(Choreography)
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.AbstractsyntaxPackage#getInterruption_Choreography()
	 * @model
	 * @generated
	 */
	Choreography getChoreography();

	/**
	 * Sets the value of the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Interruption#getChoreography <em>Choreography</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Choreography</em>' reference.
	 * @see #getChoreography()
	 * @generated
	 */
	void setChoreography(Choreography value);

} // Interruption
