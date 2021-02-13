/**
 * generated by Xtext 2.14.0
 */
package fr.unice.si5.polytech.formatting2;

import com.google.inject.Inject;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.CreateProgram;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.Instruction;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.Interruption;
import fr.unice.si5.polytech.createlanguage.abstractsyntax.LoopChoreography;
import fr.unice.si5.polytech.services.CreateLanguageGrammarAccess;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class CreateLanguageFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private CreateLanguageGrammarAccess _createLanguageGrammarAccess;
  
  protected void _format(final CreateProgram createProgram, @Extension final IFormattableDocument document) {
    EList<Instruction> _instructions = createProgram.getInstructions();
    for (final Instruction instruction : _instructions) {
      document.<Instruction>format(instruction);
    }
  }
  
  protected void _format(final LoopChoreography loopChoreography, @Extension final IFormattableDocument document) {
    EList<Interruption> _interruptions = loopChoreography.getInterruptions();
    for (final Interruption interruption : _interruptions) {
      document.<Interruption>format(interruption);
    }
    EList<Instruction> _instructions = loopChoreography.getInstructions();
    for (final Instruction instruction : _instructions) {
      document.<Instruction>format(instruction);
    }
  }
  
  public void format(final Object loopChoreography, final IFormattableDocument document) {
    if (loopChoreography instanceof LoopChoreography) {
      _format((LoopChoreography)loopChoreography, document);
      return;
    } else if (loopChoreography instanceof XtextResource) {
      _format((XtextResource)loopChoreography, document);
      return;
    } else if (loopChoreography instanceof CreateProgram) {
      _format((CreateProgram)loopChoreography, document);
      return;
    } else if (loopChoreography instanceof EObject) {
      _format((EObject)loopChoreography, document);
      return;
    } else if (loopChoreography == null) {
      _format((Void)null, document);
      return;
    } else if (loopChoreography != null) {
      _format(loopChoreography, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(loopChoreography, document).toString());
    }
  }
}
