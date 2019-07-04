package org.camunda.bewerbungBPMN.bewerbung;

import javax.mail.MessagingException;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;
import org.camunda.bpm.engine.runtime.ProcessInstance;



public class BewerbungVersenden implements JavaDelegate {
	
	
	public static void mailvombewerber (String subject, String content, String email) throws MessagingException {
		SendEmail.sendEmail(subject, content, email);
	}

  public void execute(DelegateExecution execution) throws Exception {
	  String Name = (String) execution.getVariable("Name");
	  String Unterlagen_Bewerbung = (String) execution.getVariable ("Unterlagen_Bewerbung");
	  String bildungsgrad = (String) execution.getVariable ("bildungsgrad");
	  double Abschlussnote_Studium = (Double) execution.getVariable ("Abschlussnote_Studium");
	  String Abschlussnote_Ausbildung = (String) execution.getVariable ("Abschlussnote_Ausbildung");
	  boolean Auslandserfahrung = (Boolean) execution.getVariable ("Auslandserfahrung");
	  long Berufserfahrung_Jahre = (Long) execution.getVariable("Berufserfahrung_Jahre");
	  
	  String email = "yuriy.shyshlin@gmail.com";
	  String subject = "Bewerbung";
	  String content = "Sehr geehrtes Unternehmen XYZ GmbH, "+
				"\n\nhiermit bewerbe ich mich für Ihre ausgeschriebene Position."+
				"\n\nMit freundlichen Grüßen\n\n\n "

	  	+ "Name: "+Name+"\n"
		+ "Unterlagen: "+Unterlagen_Bewerbung+"\n"
		+ "Bildungsgrad: " +bildungsgrad+"\n"
		+ "Abschlussnote Studium: " +Abschlussnote_Studium+"\n"
		+ "Abschlussnote Ausbildung: " +Abschlussnote_Ausbildung+"\n"
		+ "Berufserfahrung: " +Berufserfahrung_Jahre+" Jahren"+"\n"
		+ "Auslandserfahrung: " +Auslandserfahrung+"\n";
		  
		mailvombewerber(subject, content, email);
		
		RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
		MessageCorrelationResult result = runtimeService.createMessageCorrelation("Bewerbungsschreiben")      	
      		.correlateWithResult();
		
		
  }
	
}