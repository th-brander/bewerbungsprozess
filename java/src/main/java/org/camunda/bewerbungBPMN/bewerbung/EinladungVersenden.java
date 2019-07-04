package org.camunda.bewerbungBPMN.bewerbung;

import java.util.List;

import javax.mail.MessagingException;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;

public class EinladungVersenden implements JavaDelegate {

	public static void mailzubewerber (String subject, String content, String email) throws MessagingException {
		SendEmail.sendEmail(subject, content, email);
	}

  public void execute(DelegateExecution execution) throws Exception {
		
	  String Name = (String) execution.getVariable("Name");
	  
	  String email = "yuriy.shyshlin@gmail.com";
		String subject = "Einladung";
		String content = "Hallo " +Name+ ",\n\n hiermit möchten wir Sie einladen an unserem Vorauswahltest teilzunehmen.\n\n Liebe Grüße XYZ GmbH";
		
		
		mailzubewerber(subject, content, email);
		
		RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
		List<MessageCorrelationResult> results = runtimeService
				  .createMessageCorrelation("Einladung")
				  .correlateAllWithResult();
		
  }
}
