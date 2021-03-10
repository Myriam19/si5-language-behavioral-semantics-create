import 'http://www.example.org/createlanguage'
import _'http://www.eclipse.org/emf/2002/Ecore'

ECLimport "platform:/plugin/fr.inria.aoste.timesquare.ccslkernel.model/ccsllibrary/kernel.ccslLib"
ECLimport "platform:/plugin/fr.inria.aoste.timesquare.ccslkernel.model/ccsllibrary/CCSL.ccslLib"

package createlanguage

	 context ReferenceChoreography
	 	def 
	 		if(self.oclAsType(EObject).eContainer().oclIsKindOf(ParalleleChoreo)) : startIt : Event = self.start()
	 		
	 context ReferenceChoreography
	 	def 
	 		if(self.oclAsType(EObject).eContainer().oclIsKindOf(ParalleleChoreo)) : doStepIt : Event = self.doStep()
	 		

 endpackage