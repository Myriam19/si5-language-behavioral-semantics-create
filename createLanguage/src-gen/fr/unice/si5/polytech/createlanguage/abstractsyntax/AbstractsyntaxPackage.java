/**
 */
package fr.unice.si5.polytech.createlanguage.abstractsyntax;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.AbstractsyntaxFactory
 * @model kind="package"
 * @generated
 */
public interface AbstractsyntaxPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "abstractsyntax";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/abstractsyntax";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "abstractsyntax";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AbstractsyntaxPackage eINSTANCE = fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.NamedElementImpl
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.CreateProgramImpl <em>Create Program</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.CreateProgramImpl
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getCreateProgram()
	 * @generated
	 */
	int CREATE_PROGRAM = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PROGRAM__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PROGRAM__INSTRUCTIONS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Create Program</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PROGRAM_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Create Program</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PROGRAM_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.ChoreographyImpl <em>Choreography</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.ChoreographyImpl
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getChoreography()
	 * @generated
	 */
	int CHOREOGRAPHY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Interruptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY__INTERRUPTIONS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY__INSTRUCTIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Choreography</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Choreography</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.InstructionImpl <em>Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.InstructionImpl
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getInstruction()
	 * @generated
	 */
	int INSTRUCTION = 10;

	/**
	 * The number of structural features of the '<em>Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.ActionImpl
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 3;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = INSTRUCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.LoopChoreographyImpl <em>Loop Choreography</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.LoopChoreographyImpl
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getLoopChoreography()
	 * @generated
	 */
	int LOOP_CHOREOGRAPHY = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_CHOREOGRAPHY__NAME = CHOREOGRAPHY__NAME;

	/**
	 * The feature id for the '<em><b>Interruptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_CHOREOGRAPHY__INTERRUPTIONS = CHOREOGRAPHY__INTERRUPTIONS;

	/**
	 * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_CHOREOGRAPHY__INSTRUCTIONS = CHOREOGRAPHY__INSTRUCTIONS;

	/**
	 * The number of structural features of the '<em>Loop Choreography</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_CHOREOGRAPHY_FEATURE_COUNT = CHOREOGRAPHY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Loop Choreography</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_CHOREOGRAPHY_OPERATION_COUNT = CHOREOGRAPHY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.FiniteChoreographyImpl <em>Finite Choreography</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.FiniteChoreographyImpl
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getFiniteChoreography()
	 * @generated
	 */
	int FINITE_CHOREOGRAPHY = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_CHOREOGRAPHY__NAME = CHOREOGRAPHY__NAME;

	/**
	 * The feature id for the '<em><b>Interruptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_CHOREOGRAPHY__INTERRUPTIONS = CHOREOGRAPHY__INTERRUPTIONS;

	/**
	 * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_CHOREOGRAPHY__INSTRUCTIONS = CHOREOGRAPHY__INSTRUCTIONS;

	/**
	 * The number of structural features of the '<em>Finite Choreography</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_CHOREOGRAPHY_FEATURE_COUNT = CHOREOGRAPHY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Finite Choreography</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_CHOREOGRAPHY_OPERATION_COUNT = CHOREOGRAPHY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.GoForwardImpl <em>Go Forward</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.GoForwardImpl
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getGoForward()
	 * @generated
	 */
	int GO_FORWARD = 6;

	/**
	 * The number of structural features of the '<em>Go Forward</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GO_FORWARD_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Go Forward</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GO_FORWARD_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.InterruptionImpl <em>Interruption</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.InterruptionImpl
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getInterruption()
	 * @generated
	 */
	int INTERRUPTION = 7;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPTION__CONDITIONS = 0;

	/**
	 * The feature id for the '<em><b>Choreography</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPTION__CHOREOGRAPHY = 1;

	/**
	 * The number of structural features of the '<em>Interruption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPTION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Interruption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.ConditionImpl
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 8;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.ObjectFoundImpl <em>Object Found</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.ObjectFoundImpl
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getObjectFound()
	 * @generated
	 */
	int OBJECT_FOUND = 9;

	/**
	 * The number of structural features of the '<em>Object Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_FOUND_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Object Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_FOUND_OPERATION_COUNT = CONDITION_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.CreateProgram <em>Create Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Program</em>'.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.CreateProgram
	 * @generated
	 */
	EClass getCreateProgram();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.CreateProgram#getInstructions <em>Instructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instructions</em>'.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.CreateProgram#getInstructions()
	 * @see #getCreateProgram()
	 * @generated
	 */
	EReference getCreateProgram_Instructions();

	/**
	 * Returns the meta object for class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Choreography <em>Choreography</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choreography</em>'.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.Choreography
	 * @generated
	 */
	EClass getChoreography();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Choreography#getInterruptions <em>Interruptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Interruptions</em>'.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.Choreography#getInterruptions()
	 * @see #getChoreography()
	 * @generated
	 */
	EReference getChoreography_Interruptions();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Choreography#getInstructions <em>Instructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instructions</em>'.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.Choreography#getInstructions()
	 * @see #getChoreography()
	 * @generated
	 */
	EReference getChoreography_Instructions();

	/**
	 * Returns the meta object for class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.LoopChoreography <em>Loop Choreography</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Choreography</em>'.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.LoopChoreography
	 * @generated
	 */
	EClass getLoopChoreography();

	/**
	 * Returns the meta object for class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.FiniteChoreography <em>Finite Choreography</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Finite Choreography</em>'.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.FiniteChoreography
	 * @generated
	 */
	EClass getFiniteChoreography();

	/**
	 * Returns the meta object for class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.GoForward <em>Go Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Go Forward</em>'.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.GoForward
	 * @generated
	 */
	EClass getGoForward();

	/**
	 * Returns the meta object for class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Interruption <em>Interruption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interruption</em>'.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.Interruption
	 * @generated
	 */
	EClass getInterruption();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Interruption#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditions</em>'.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.Interruption#getConditions()
	 * @see #getInterruption()
	 * @generated
	 */
	EReference getInterruption_Conditions();

	/**
	 * Returns the meta object for the reference '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Interruption#getChoreography <em>Choreography</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Choreography</em>'.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.Interruption#getChoreography()
	 * @see #getInterruption()
	 * @generated
	 */
	EReference getInterruption_Choreography();

	/**
	 * Returns the meta object for class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.ObjectFound <em>Object Found</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Found</em>'.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.ObjectFound
	 * @generated
	 */
	EClass getObjectFound();

	/**
	 * Returns the meta object for class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Instruction <em>Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instruction</em>'.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.Instruction
	 * @generated
	 */
	EClass getInstruction();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AbstractsyntaxFactory getAbstractsyntaxFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.NamedElementImpl
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.CreateProgramImpl <em>Create Program</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.CreateProgramImpl
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getCreateProgram()
		 * @generated
		 */
		EClass CREATE_PROGRAM = eINSTANCE.getCreateProgram();

		/**
		 * The meta object literal for the '<em><b>Instructions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_PROGRAM__INSTRUCTIONS = eINSTANCE.getCreateProgram_Instructions();

		/**
		 * The meta object literal for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.ChoreographyImpl <em>Choreography</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.ChoreographyImpl
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getChoreography()
		 * @generated
		 */
		EClass CHOREOGRAPHY = eINSTANCE.getChoreography();

		/**
		 * The meta object literal for the '<em><b>Interruptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOREOGRAPHY__INTERRUPTIONS = eINSTANCE.getChoreography_Interruptions();

		/**
		 * The meta object literal for the '<em><b>Instructions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOREOGRAPHY__INSTRUCTIONS = eINSTANCE.getChoreography_Instructions();

		/**
		 * The meta object literal for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.ActionImpl
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.LoopChoreographyImpl <em>Loop Choreography</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.LoopChoreographyImpl
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getLoopChoreography()
		 * @generated
		 */
		EClass LOOP_CHOREOGRAPHY = eINSTANCE.getLoopChoreography();

		/**
		 * The meta object literal for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.FiniteChoreographyImpl <em>Finite Choreography</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.FiniteChoreographyImpl
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getFiniteChoreography()
		 * @generated
		 */
		EClass FINITE_CHOREOGRAPHY = eINSTANCE.getFiniteChoreography();

		/**
		 * The meta object literal for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.GoForwardImpl <em>Go Forward</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.GoForwardImpl
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getGoForward()
		 * @generated
		 */
		EClass GO_FORWARD = eINSTANCE.getGoForward();

		/**
		 * The meta object literal for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.InterruptionImpl <em>Interruption</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.InterruptionImpl
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getInterruption()
		 * @generated
		 */
		EClass INTERRUPTION = eINSTANCE.getInterruption();

		/**
		 * The meta object literal for the '<em><b>Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERRUPTION__CONDITIONS = eINSTANCE.getInterruption_Conditions();

		/**
		 * The meta object literal for the '<em><b>Choreography</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERRUPTION__CHOREOGRAPHY = eINSTANCE.getInterruption_Choreography();

		/**
		 * The meta object literal for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.ConditionImpl
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.ObjectFoundImpl <em>Object Found</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.ObjectFoundImpl
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getObjectFound()
		 * @generated
		 */
		EClass OBJECT_FOUND = eINSTANCE.getObjectFound();

		/**
		 * The meta object literal for the '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.InstructionImpl <em>Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.InstructionImpl
		 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.impl.AbstractsyntaxPackageImpl#getInstruction()
		 * @generated
		 */
		EClass INSTRUCTION = eINSTANCE.getInstruction();

	}

} //AbstractsyntaxPackage
