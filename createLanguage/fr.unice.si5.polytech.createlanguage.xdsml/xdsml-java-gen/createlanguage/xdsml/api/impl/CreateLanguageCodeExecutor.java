/* GENERATED FILE, do not modify manually                                                    *
 * If you need to modify it, disable the generation in the BuildOptions of the project.xdsml */
package createlanguage.xdsml.api.impl;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dsa.executors.CodeExecutorDispatcher;
public class CreateLanguageCodeExecutor extends CodeExecutorDispatcher 
		implements org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.dsa.api.IK3DSAExecutorClassLoader  {
	public CreateLanguageCodeExecutor(){
	    // add Melange or K3 DSA specific executors
		addExecutor(new org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.dsa.impl.K3DSLCodeExecutor(this,
			"fr.unice.si5.polytech.createlanguage.CreateLanguage"));
		// fall back executor : search classic java method
		addExecutor(new org.eclipse.gemoc.execution.concurrent.ccsljavaengine.dsa.executors.JavaCodeExecutor());
	}
	public String getDSAProjectName(){
		//TODO please implement
		return "";
	}
   @Override
	public Class<?> getClassForName(String className) throws ClassNotFoundException {
		return Class.forName(className);
	}
	@Override
	public java.io.InputStream getResourceAsStream(String resourceName) {
		//this.getClass().getResourceAsStream(resourceName);
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName);
	}
}