package org.camunda.bewerbungBPMN.bewerbung;

import java.util.List;

import javax.mail.MessagingException;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;

public class BewerberabsagenAssesment implements JavaDelegate {

	public static void mailzubewerber (String subject, String content, String email) throws MessagingException {
		SendEmail.sendEmail(subject, content, email);
	}

  public void execute(DelegateExecution execution) throws Exception {
	  String Name = (String) execution.getVariable("Name");
	  
	    String email = "yuriy.shyshlin@gmail.com";
		String subject = "Assesmentfehlgeschlagen";
		String content = "Hallo " +Name+ ",\n\nLeider m�ssen wir Ihnen mitteilen, dass wir Sie f�r den weiteren Prozess nicht weiter ber�cksichtigen k�nnen.\n\n Mit freundlichen Gr��en XYZ GmbH";
		
		mailzubewerber(subject, content, email);
		
		RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
		List<MessageCorrelationResult> results = runtimeService
				  .createMessageCorrelation("Assesmentfehlgeschlagen")
				  .correlateAllWithResult();
		
  }

    
	  
  }


