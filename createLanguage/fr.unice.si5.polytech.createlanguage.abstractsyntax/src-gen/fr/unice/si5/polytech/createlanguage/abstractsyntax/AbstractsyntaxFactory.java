/**
 */
package fr.unice.si5.polytech.createlanguage.abstractsyntax;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.AbstractsyntaxPackage
 * @generated
 */
public interface AbstractsyntaxFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AbstractsyntaxFactory eINSTANCE = fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Create Program</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Program</em>'.
	 * @generated
	 */
	CreateProgram createCreateProgram();

	/**
	 * Returns a new object of class '<em>Loop Choreography</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Choreography</em>'.
	 * @generated
	 */
	LoopChoreography createLoopChoreography();

	/**
	 * Returns a new object of class '<em>Finite Choreography</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Finite Choreography</em>'.
	 * @generated
	 */
	FiniteChoreography createFiniteChoreography();

	/**
	 * Returns a new object of class '<em>Go Forward</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Go Forward</em>'.
	 * @generated
	 */
	GoForward createGoForward();

	/**
	 * Returns a new object of class '<em>Interruption</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interruption</em>'.
	 * @generated
	 */
	Interruption createInterruption();

	/**
	 * Returns a new object of class '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition</em>'.
	 * @generated
	 */
	Condition createCondition();

	/**
	 * Returns a new object of class '<em>Object Found</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Found</em>'.
	 * @generated
	 */
	ObjectFound createObjectFound();

	/**
	 * Returns a new object of class '<em>Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instruction</em>'.
	 * @generated
	 */
	Instruction createInstruction();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AbstractsyntaxPackage getAbstractsyntaxPackage();

} //AbstractsyntaxFactory
