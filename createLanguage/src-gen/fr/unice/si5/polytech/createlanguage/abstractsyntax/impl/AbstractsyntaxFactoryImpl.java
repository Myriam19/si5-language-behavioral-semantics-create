/**
 */
package fr.unice.si5.polytech.createlanguage.abstractsyntax.impl;

import fr.unice.si5.polytech.createlanguage.abstractsyntax.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractsyntaxFactoryImpl extends EFactoryImpl implements AbstractsyntaxFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AbstractsyntaxFactory init() {
		try {
			AbstractsyntaxFactory theAbstractsyntaxFactory = (AbstractsyntaxFactory) EPackage.Registry.INSTANCE
					.getEFactory(AbstractsyntaxPackage.eNS_URI);
			if (theAbstractsyntaxFactory != null) {
				return theAbstractsyntaxFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AbstractsyntaxFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractsyntaxFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case AbstractsyntaxPackage.CREATE_PROGRAM:
			return createCreateProgram();
		case AbstractsyntaxPackage.LOOP_CHOREOGRAPHY:
			return createLoopChoreography();
		case AbstractsyntaxPackage.FINITE_CHOREOGRAPHY:
			return createFiniteChoreography();
		case AbstractsyntaxPackage.GO_FORWARD:
			return createGoForward();
		case AbstractsyntaxPackage.INTERRUPTION:
			return createInterruption();
		case AbstractsyntaxPackage.CONDITION:
			return createCondition();
		case AbstractsyntaxPackage.OBJECT_FOUND:
			return createObjectFound();
		case AbstractsyntaxPackage.INSTRUCTION:
			return createInstruction();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateProgram createCreateProgram() {
		CreateProgramImpl createProgram = new CreateProgramImpl();
		return createProgram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopChoreography createLoopChoreography() {
		LoopChoreographyImpl loopChoreography = new LoopChoreographyImpl();
		return loopChoreography;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FiniteChoreography createFiniteChoreography() {
		FiniteChoreographyImpl finiteChoreography = new FiniteChoreographyImpl();
		return finiteChoreography;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoForward createGoForward() {
		GoForwardImpl goForward = new GoForwardImpl();
		return goForward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interruption createInterruption() {
		InterruptionImpl interruption = new InterruptionImpl();
		return interruption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition createCondition() {
		ConditionImpl condition = new ConditionImpl();
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectFound createObjectFound() {
		ObjectFoundImpl objectFound = new ObjectFoundImpl();
		return objectFound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Instruction createInstruction() {
		InstructionImpl instruction = new InstructionImpl();
		return instruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractsyntaxPackage getAbstractsyntaxPackage() {
		return (AbstractsyntaxPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AbstractsyntaxPackage getPackage() {
		return AbstractsyntaxPackage.eINSTANCE;
	}

} //AbstractsyntaxFactoryImpl
