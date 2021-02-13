/**
 */
package fr.unice.si5.polytech.createlanguage.abstractsyntax.util;

import fr.unice.si5.polytech.createlanguage.abstractsyntax.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.AbstractsyntaxPackage
 * @generated
 */
public class AbstractsyntaxAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AbstractsyntaxPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractsyntaxAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AbstractsyntaxPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractsyntaxSwitch<Adapter> modelSwitch = new AbstractsyntaxSwitch<Adapter>() {
		@Override
		public Adapter caseNamedElement(NamedElement object) {
			return createNamedElementAdapter();
		}

		@Override
		public Adapter caseCreateProgram(CreateProgram object) {
			return createCreateProgramAdapter();
		}

		@Override
		public Adapter caseChoreography(Choreography object) {
			return createChoreographyAdapter();
		}

		@Override
		public Adapter caseAction(Action object) {
			return createActionAdapter();
		}

		@Override
		public Adapter caseLoopChoreography(LoopChoreography object) {
			return createLoopChoreographyAdapter();
		}

		@Override
		public Adapter caseFiniteChoreography(FiniteChoreography object) {
			return createFiniteChoreographyAdapter();
		}

		@Override
		public Adapter caseGoForward(GoForward object) {
			return createGoForwardAdapter();
		}

		@Override
		public Adapter caseInterruption(Interruption object) {
			return createInterruptionAdapter();
		}

		@Override
		public Adapter caseCondition(Condition object) {
			return createConditionAdapter();
		}

		@Override
		public Adapter caseObjectFound(ObjectFound object) {
			return createObjectFoundAdapter();
		}

		@Override
		public Adapter caseInstruction(Instruction object) {
			return createInstructionAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.CreateProgram <em>Create Program</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.CreateProgram
	 * @generated
	 */
	public Adapter createCreateProgramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Choreography <em>Choreography</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.Choreography
	 * @generated
	 */
	public Adapter createChoreographyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.Action
	 * @generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.LoopChoreography <em>Loop Choreography</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.LoopChoreography
	 * @generated
	 */
	public Adapter createLoopChoreographyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.FiniteChoreography <em>Finite Choreography</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.FiniteChoreography
	 * @generated
	 */
	public Adapter createFiniteChoreographyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.GoForward <em>Go Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.GoForward
	 * @generated
	 */
	public Adapter createGoForwardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Interruption <em>Interruption</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.Interruption
	 * @generated
	 */
	public Adapter createInterruptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.Condition
	 * @generated
	 */
	public Adapter createConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.ObjectFound <em>Object Found</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.ObjectFound
	 * @generated
	 */
	public Adapter createObjectFoundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.unice.si5.polytech.createlanguage.abstractsyntax.Instruction <em>Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.unice.si5.polytech.createlanguage.abstractsyntax.Instruction
	 * @generated
	 */
	public Adapter createInstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AbstractsyntaxAdapterFactory
