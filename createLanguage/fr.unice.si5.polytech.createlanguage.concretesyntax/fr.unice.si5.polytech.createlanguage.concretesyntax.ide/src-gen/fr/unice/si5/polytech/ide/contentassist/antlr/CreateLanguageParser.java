/*
 * generated by Xtext 2.14.0
 */
package fr.unice.si5.polytech.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import fr.unice.si5.polytech.ide.contentassist.antlr.internal.InternalCreateLanguageParser;
import fr.unice.si5.polytech.services.CreateLanguageGrammarAccess;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class CreateLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(CreateLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, CreateLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getInstructionAccess().getAlternatives(), "rule__Instruction__Alternatives");
			builder.put(grammarAccess.getConditionAccess().getAlternatives(), "rule__Condition__Alternatives");
			builder.put(grammarAccess.getChoreographyAccess().getAlternatives(), "rule__Choreography__Alternatives");
			builder.put(grammarAccess.getEStringAccess().getAlternatives(), "rule__EString__Alternatives");
			builder.put(grammarAccess.getCreateProgramAccess().getGroup(), "rule__CreateProgram__Group__0");
			builder.put(grammarAccess.getCreateProgramAccess().getGroup_4(), "rule__CreateProgram__Group_4__0");
			builder.put(grammarAccess.getCreateProgramAccess().getGroup_4_3(), "rule__CreateProgram__Group_4_3__0");
			builder.put(grammarAccess.getInstruction_ImplAccess().getGroup(), "rule__Instruction_Impl__Group__0");
			builder.put(grammarAccess.getLoopChoreographyAccess().getGroup(), "rule__LoopChoreography__Group__0");
			builder.put(grammarAccess.getLoopChoreographyAccess().getGroup_4(), "rule__LoopChoreography__Group_4__0");
			builder.put(grammarAccess.getLoopChoreographyAccess().getGroup_4_3(), "rule__LoopChoreography__Group_4_3__0");
			builder.put(grammarAccess.getLoopChoreographyAccess().getGroup_5(), "rule__LoopChoreography__Group_5__0");
			builder.put(grammarAccess.getLoopChoreographyAccess().getGroup_5_3(), "rule__LoopChoreography__Group_5_3__0");
			builder.put(grammarAccess.getFiniteChoreographyAccess().getGroup(), "rule__FiniteChoreography__Group__0");
			builder.put(grammarAccess.getFiniteChoreographyAccess().getGroup_4(), "rule__FiniteChoreography__Group_4__0");
			builder.put(grammarAccess.getFiniteChoreographyAccess().getGroup_4_3(), "rule__FiniteChoreography__Group_4_3__0");
			builder.put(grammarAccess.getFiniteChoreographyAccess().getGroup_5(), "rule__FiniteChoreography__Group_5__0");
			builder.put(grammarAccess.getFiniteChoreographyAccess().getGroup_5_3(), "rule__FiniteChoreography__Group_5_3__0");
			builder.put(grammarAccess.getGoForwardAccess().getGroup(), "rule__GoForward__Group__0");
			builder.put(grammarAccess.getInterruptionAccess().getGroup(), "rule__Interruption__Group__0");
			builder.put(grammarAccess.getInterruptionAccess().getGroup_3(), "rule__Interruption__Group_3__0");
			builder.put(grammarAccess.getInterruptionAccess().getGroup_4(), "rule__Interruption__Group_4__0");
			builder.put(grammarAccess.getInterruptionAccess().getGroup_4_3(), "rule__Interruption__Group_4_3__0");
			builder.put(grammarAccess.getCondition_ImplAccess().getGroup(), "rule__Condition_Impl__Group__0");
			builder.put(grammarAccess.getObjectFoundAccess().getGroup(), "rule__ObjectFound__Group__0");
			builder.put(grammarAccess.getCreateProgramAccess().getNameAssignment_2(), "rule__CreateProgram__NameAssignment_2");
			builder.put(grammarAccess.getCreateProgramAccess().getInstructionsAssignment_4_2(), "rule__CreateProgram__InstructionsAssignment_4_2");
			builder.put(grammarAccess.getCreateProgramAccess().getInstructionsAssignment_4_3_1(), "rule__CreateProgram__InstructionsAssignment_4_3_1");
			builder.put(grammarAccess.getLoopChoreographyAccess().getNameAssignment_2(), "rule__LoopChoreography__NameAssignment_2");
			builder.put(grammarAccess.getLoopChoreographyAccess().getInterruptionsAssignment_4_2(), "rule__LoopChoreography__InterruptionsAssignment_4_2");
			builder.put(grammarAccess.getLoopChoreographyAccess().getInterruptionsAssignment_4_3_1(), "rule__LoopChoreography__InterruptionsAssignment_4_3_1");
			builder.put(grammarAccess.getLoopChoreographyAccess().getInstructionsAssignment_5_2(), "rule__LoopChoreography__InstructionsAssignment_5_2");
			builder.put(grammarAccess.getLoopChoreographyAccess().getInstructionsAssignment_5_3_1(), "rule__LoopChoreography__InstructionsAssignment_5_3_1");
			builder.put(grammarAccess.getFiniteChoreographyAccess().getNameAssignment_2(), "rule__FiniteChoreography__NameAssignment_2");
			builder.put(grammarAccess.getFiniteChoreographyAccess().getInterruptionsAssignment_4_2(), "rule__FiniteChoreography__InterruptionsAssignment_4_2");
			builder.put(grammarAccess.getFiniteChoreographyAccess().getInterruptionsAssignment_4_3_1(), "rule__FiniteChoreography__InterruptionsAssignment_4_3_1");
			builder.put(grammarAccess.getFiniteChoreographyAccess().getInstructionsAssignment_5_2(), "rule__FiniteChoreography__InstructionsAssignment_5_2");
			builder.put(grammarAccess.getFiniteChoreographyAccess().getInstructionsAssignment_5_3_1(), "rule__FiniteChoreography__InstructionsAssignment_5_3_1");
			builder.put(grammarAccess.getInterruptionAccess().getChoreographyAssignment_3_1(), "rule__Interruption__ChoreographyAssignment_3_1");
			builder.put(grammarAccess.getInterruptionAccess().getConditionsAssignment_4_2(), "rule__Interruption__ConditionsAssignment_4_2");
			builder.put(grammarAccess.getInterruptionAccess().getConditionsAssignment_4_3_1(), "rule__Interruption__ConditionsAssignment_4_3_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private CreateLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalCreateLanguageParser createParser() {
		InternalCreateLanguageParser result = new InternalCreateLanguageParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public CreateLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(CreateLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
