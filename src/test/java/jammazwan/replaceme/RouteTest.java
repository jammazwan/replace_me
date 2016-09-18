package jammazwan.replaceme;

import java.util.Set;

import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.drools.compiler.compiler.xml.RulesSemanticModule;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jammazwan.replaceme.ProjectFiles;
import jammazwan.replaceme.Rules;

public class RouteTest extends CamelSpringTestSupport {

//	@Autowired
//	ProjectFiles projectFiles;
//	@Autowired
//	Rules rules;

	@Override
	protected AbstractXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
	}


	@Test
	public void testXbq() throws Exception {
		ProjectFiles projectFiles = (ProjectFiles)this.applicationContext.getBean("projectFiles");
		Rules rules = (Rules)this.applicationContext.getBean("rules");
		HoldContextOpenUntilDone.go(context);
		rules.printGlobalSet();
		Set<String> globalSet = rules.insertUpdate(projectFiles);
		assertTrue(globalSet.contains("README"));
		assertTrue(globalSet.contains("pom"));
		assertTrue(globalSet.contains("NOTES"));
		assertFalse(globalSet.contains("EXTRA"));
		assertFalse(globalSet.contains("Jenkins"));
		assertTrue(globalSet.contains("adequatelyDocumented"));
	}

}
