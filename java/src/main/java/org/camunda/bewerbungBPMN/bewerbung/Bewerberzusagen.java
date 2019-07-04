package org.camunda.bewerbungBPMN.bewerbung;

import java.util.List;

import javax.mail.MessagingException;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;

public class Bewerberzusagen implements JavaDelegate {

	public static void mailzubewerber (String subject, String content, String email) throws MessagingException {
		SendEmail.sendEmail(subject, content, email);
	}

  public void execute(DelegateExecution execution) throws Exception {
	  	String name = (String) execution.getVariable("Name");
	  
	  
		String email = "yuriy.shyshlin@gmail.com";
		String subject = "Zusage";
		String content = "Hallo " +name+
						"\n\n ihr Assesmentcenter-Ergebnis, sowie Ihre Persönlichkeit haben uns überzeugt!"
						+ "\n\n Wir wären sehr an einer Zusammenarbeit interessiert und möchten Sie im weiteren Schritt gerne telefonisch dazu kontaktieren. "
						+ "\n\n Mit freundlichen Grüßen XYZ GmbH";
		
		
		mailzubewerber(subject, content, email);
		
		RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
		List<MessageCorrelationResult> results = runtimeService
				  .createMessageCorrelation("Zusage")
				  .correlateAllWithResult();
	
  }

    
	  
  }


