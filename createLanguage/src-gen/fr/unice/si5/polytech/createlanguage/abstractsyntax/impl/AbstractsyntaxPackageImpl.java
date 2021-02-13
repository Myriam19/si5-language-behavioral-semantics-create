/**
 */
package fr.unice.si5.polytech.createlanguage.abstractsyntax.impl;

import fr.unice.si5.polytech.createlanguage.abstractsyntax.AbstractsyntaxFactory;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.AbstractsyntaxPackage;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.Action;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.Choreography;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.Condition;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.CreateProgram;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.FiniteChoreography;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.GoForward;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.Instruction;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.Interruption;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.LoopChoreography;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.NamedElement;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.ObjectFound;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractsyntaxPackageImpl extends EPackageImpl implements AbstractsyntaxPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createProgramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choreographyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopChoreographyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass finiteChoreographyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass goForwardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interruptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectFoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instructionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.AbstractsyntaxPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AbstractsyntaxPackageImpl() {
		super(eNS_URI, AbstractsyntaxFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link AbstractsyntaxPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AbstractsyntaxPackage init() {
		if (isInited)
			return (AbstractsyntaxPackage) EPackage.Registry.INSTANCE.getEPackage(AbstractsyntaxPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredAbstractsyntaxPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		AbstractsyntaxPackageImpl theAbstractsyntaxPackage = registeredAbstractsyntaxPackage instanceof AbstractsyntaxPackageImpl
				? (AbstractsyntaxPackageImpl) registeredAbstractsyntaxPackage
				: new AbstractsyntaxPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theAbstractsyntaxPackage.createPackageContents();

		// Initialize created meta-data
		theAbstractsyntaxPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAbstractsyntaxPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AbstractsyntaxPackage.eNS_URI, theAbstractsyntaxPackage);
		return theAbstractsyntaxPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute) namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateProgram() {
		return createProgramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateProgram_Instructions() {
		return (EReference) createProgramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoreography() {
		return choreographyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoreography_Interruptions() {
		return (EReference) choreographyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoreography_Instructions() {
		return (EReference) choreographyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopChoreography() {
		return loopChoreographyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFiniteChoreography() {
		return finiteChoreographyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGoForward() {
		return goForwardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterruption() {
		return interruptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterruption_Conditions() {
		return (EReference) interruptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterruption_Choreography() {
		return (EReference) interruptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCondition() {
		return conditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectFound() {
		return objectFoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstruction() {
		return instructionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractsyntaxFactory getAbstractsyntaxFactory() {
		return (AbstractsyntaxFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		createProgramEClass = createEClass(CREATE_PROGRAM);
		createEReference(createProgramEClass, CREATE_PROGRAM__INSTRUCTIONS);

		choreographyEClass = createEClass(CHOREOGRAPHY);
		createEReference(choreographyEClass, CHOREOGRAPHY__INTERRUPTIONS);
		createEReference(choreographyEClass, CHOREOGRAPHY__INSTRUCTIONS);

		actionEClass = createEClass(ACTION);

		loopChoreographyEClass = createEClass(LOOP_CHOREOGRAPHY);

		finiteChoreographyEClass = createEClass(FINITE_CHOREOGRAPHY);

		goForwardEClass = createEClass(GO_FORWARD);

		interruptionEClass = createEClass(INTERRUPTION);
		createEReference(interruptionEClass, INTERRUPTION__CONDITIONS);
		createEReference(interruptionEClass, INTERRUPTION__CHOREOGRAPHY);

		conditionEClass = createEClass(CONDITION);

		objectFoundEClass = createEClass(OBJECT_FOUND);

		instructionEClass = createEClass(INSTRUCTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		createProgramEClass.getESuperTypes().add(this.getNamedElement());
		choreographyEClass.getESuperTypes().add(this.getNamedElement());
		choreographyEClass.getESuperTypes().add(this.getInstruction());
		actionEClass.getESuperTypes().add(this.getInstruction());
		loopChoreographyEClass.getESuperTypes().add(this.getChoreography());
		finiteChoreographyEClass.getESuperTypes().add(this.getChoreography());
		goForwardEClass.getESuperTypes().add(this.getAction());
		objectFoundEClass.getESuperTypes().add(this.getCondition());

		// Initialize classes, features, and operations; add parameters
		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createProgramEClass, CreateProgram.class, "CreateProgram", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCreateProgram_Instructions(), this.getInstruction(), null, "instructions", null, 0, -1,
				CreateProgram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(choreographyEClass, Choreography.class, "Choreography", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoreography_Interruptions(), this.getInterruption(), null, "interruptions", null, 0, -1,
				Choreography.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChoreography_Instructions(), this.getInstruction(), null, "instructions", null, 0, -1,
				Choreography.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionEClass, Action.class, "Action", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loopChoreographyEClass, LoopChoreography.class, "LoopChoreography", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(finiteChoreographyEClass, FiniteChoreography.class, "FiniteChoreography", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(goForwardEClass, GoForward.class, "GoForward", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(interruptionEClass, Interruption.class, "Interruption", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterruption_Conditions(), this.getCondition(), null, "conditions", null, 0, -1,
				Interruption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterruption_Choreography(), this.getChoreography(), null, "choreography", null, 0, 1,
				Interruption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionEClass, Condition.class, "Condition", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(objectFoundEClass, ObjectFound.class, "ObjectFound", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(instructionEClass, Instruction.class, "Instruction", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //AbstractsyntaxPackageImpl
