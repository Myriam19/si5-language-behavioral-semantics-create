/*
 * generated by Xtext 2.14.0
 */
package fr.unice.si5.polytech


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class CreateLanguageStandaloneSetup extends CreateLanguageStandaloneSetupGenerated {

	def static void doSetup() {
		new CreateLanguageStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}