package jammazwan.replaceme;

import java.util.HashSet;
import java.util.Set;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import org.springframework.stereotype.Component;

@Component
public class Rules {
	private KieSession ruleSession;
	private FactHandle factHandle;
	private Set<String> globalControlSet = new HashSet<String>();

	/*
	 * I would do the init with the constructor but was having some spring
	 * challenges.
	 */
	public Set<String> insertUpdate(ProjectFiles projectFiles) {
		if (ruleSession == null) {
			init(projectFiles);
		}
		fire(projectFiles);
		return globalControlSet;
	}

	private void init(ProjectFiles projectFiles) {
		ruleSession = KieServices.Factory.get().getKieClasspathContainer().getKieBase().newKieSession();
		ruleSession.setGlobal("controlSet", globalControlSet);
		factHandle = ruleSession.insert(projectFiles);

	}

	private void fire(ProjectFiles projectFiles) {
		ruleSession.update(factHandle, projectFiles);
		ruleSession.fireAllRules();
	}

	public Set<String> getGlobalControlSet() {
		return globalControlSet;
	}

	public void printGlobalSet() {
		if (null != globalControlSet && !globalControlSet.isEmpty()) {
			System.err.print("printing global: ");
			for (String val : globalControlSet) {
				System.err.print(val + " ");
			}
			System.err.println();
		}
	}

}
