package org.camunda.bewerbungBPMN.bewerbung;

import javax.mail.MessagingException;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.Execution;

public class ErgebnisTest implements JavaDelegate {

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
		String subject = "Testergebnisse";
		String content = "Anbei die Ergebnisse des Assesmentcenters von";
			
		
		
		mailzubewerber(subject, content, email);
	
		
  }

    
	  
  }


