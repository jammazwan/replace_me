package jammazwan.xbq;

import java.util.HashSet;
import java.util.Set;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

public class Rules {
	private KieSession ruleSession;
	private FactHandle thisHandle;

	public KieSession getRuleSession() {
		if (ruleSession == null) {
			ruleSession = KieServices.Factory.get().getKieClasspathContainer().getKieBase().newKieSession();
			Set<String> globalControlSet = new HashSet<String>();
			ruleSession.setGlobal("controlSet", globalControlSet);
			thisHandle = ruleSession.insert(this);
		}
		return ruleSession;
	}
	
	
}
