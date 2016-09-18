package jammazwan.replaceme;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class Routes extends RouteBuilder {
	@Autowired
	ProjectFiles projectFiles;
	@Autowired
	Rules rules;

	@Override
	public void configure() throws Exception {
		if (null==projectFiles||null==rules){
			throw new RuntimeException();
		}
		from("file://.?noop=true").process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				String fileName = "" + exchange.getIn().getHeader("CamelFileName");
				System.err.println("found file named: "+fileName);
				projectFiles.processFileName(fileName);
				rules.insertUpdate(projectFiles);
				rules.printGlobalSet();
			}
		}
	);
	}
}
