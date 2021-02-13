/**
 */
package fr.unice.si5.polytech.createlanguage.abstractsyntax;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.CreateProgram#getInstructions <em>Instructions</em>}</li>
 * </ul>
 *
 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.AbstractsyntaxPackage#getCreateProgram()
 * @model
 * @generated
 */
public interface CreateProgram extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Instructions</b></em>' containment reference list.
	 * The list contents are of type {@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Instruction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instructions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instructions</em>' containment reference list.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.AbstractsyntaxPackage#getCreateProgram_Instructions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Instruction> getInstructions();

} // CreateProgram
