package org.camunda.bewerbungBPMN.bewerbung;

import java.util.List;

import javax.mail.MessagingException;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;

public class Testergebnisse implements JavaDelegate {

	public static void mailzubewerber (String subject, String content, String email) throws MessagingException {
		SendEmail.sendEmail(subject, content, email);
	}

  public void execute(DelegateExecution execution) throws Exception {
	  String Name = (String) execution.getVariable("Name");
	  String Fachwissen = (String) execution.getVariable("Fachwissen");
	  String Kommunikationsfaehigkeiten = (String) execution.getVariable("Kommunikationsfaehigkeiten");
	  String Auffassungsgabe = (String) execution.getVariable("Auffassungsgabe");
	  boolean Zeit = (Boolean) execution.getVariable("Zeit");
	  long Selbstdarstellung_Aufsatz = (Long) execution.getVariable("Selbstdarstellung_Aufsatz");
	  long Programmieraufgabe = (Long) execution.getVariable("Programmieraufgabe");
	  long Fallstudie = (Long) execution.getVariable("Fallstudie");


	  
	  String email = "yuriy.shyshlin@gmail.com";
		String subject = "Test";
		String content = "Anbei die Ergebnisse des Assesmentcenters von\n" 
				
		+"Name: "+Name+"\n"
		+"Fachwissen: "+Fachwissen+"\n"
		+"Kommunikationsfaehigkeiten: "+Kommunikationsfaehigkeiten+"\n"
		+"Auffassungsgabe: "+Auffassungsgabe+"\n"
		+"Zeit: "+Zeit+"\n"
		+"Selbstdarstellung Aufsatz: "+Selbstdarstellung_Aufsatz+"\n"
		+"Fallstudie: "+Fallstudie+"\n"
		+"Programmieraufgabe: "+Programmieraufgabe+"\n";
			
		
		mailzubewerber(subject, content, email);
		
		RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
		List<MessageCorrelationResult> results = runtimeService
				  .createMessageCorrelation("Test")
				  .correlateAllWithResult();
		
		
  }

    
	  
  }


