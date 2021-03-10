/*
 * generated by Xtext 2.14.0
 */
package fr.unice.si5.polytech.tests

import com.google.inject.Inject
import fr.unice.si5.polytech.createlanguage.abstractsyntax.createlanguage.CreateProgram
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(CreateLanguageInjectorProvider)
class CreateLanguageParsingTest {
	@Inject
	ParseHelper<CreateProgram> parseHelper
	
	@Test
	def void loadModel() {
		val result = parseHelper.parse('''
			Hello Xtext!
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
	}
}
