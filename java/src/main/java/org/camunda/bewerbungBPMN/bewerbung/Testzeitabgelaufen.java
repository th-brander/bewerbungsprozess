package org.camunda.bewerbungBPMN.bewerbung;

import java.util.List;

import javax.mail.MessagingException;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;

public class Testzeitabgelaufen implements JavaDelegate {

	public static void mailzubewerber (String subject, String content, String email) throws MessagingException {
		SendEmail.sendEmail(subject, content, email);
	}

  public void execute(DelegateExecution execution) throws Exception {
	  String Name = (String) execution.getVariable("Name");
	  boolean Zeit = (Boolean) execution.getVariable("Zeit");


	  
	  String email = "yuriy.shyshlin@gmail.com";
		String subject = "Test fehlgeschlagen";
		String content = "Leider wurde der Test von folgendem Bewerber nicht abgeschlossen:\n" 
				
		+"\nName: "+Name+"\n"
		+"Testzeit : "+Zeit+"\n";
			
		
		mailzubewerber(subject, content, email);
		
		RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
		List<MessageCorrelationResult> results = runtimeService
				  .createMessageCorrelation("Testfehl")
				  .correlateAllWithResult();
		
		
  }

    
	  
  }


