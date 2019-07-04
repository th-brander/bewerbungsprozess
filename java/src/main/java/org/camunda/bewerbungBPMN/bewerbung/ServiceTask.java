package org.camunda.bewerbungBPMN.bewerbung;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.Execution;

public class ServiceTask implements JavaDelegate {

  public void execute(DelegateExecution execution) throws Exception {
  try {
	  
	  String Name = (String) execution.getVariable("Name");
	  String Unterlagen = (String) execution.getVariable ("Unterlagen");
	  String bildungsgrad = (String) execution.getVariable ("bildungsgrad");
	  double Abschlussnote_Studium = (Double) execution.getVariable ("Abschlussnote_Studium");
	  String Abschlussnote_Ausbildung = (String) execution.getVariable ("Abschlussnote_Ausbildung");
	  boolean Auslandserfahrung = (Boolean) execution.getVariable ("Auslandserfahrung");
	  long Berufserfahrung_Jahre = (Long) execution.getVariable("Berufserfahrung_Jahre");
	  
          // Create new file
          String content = "Bewerberdaten: \\n\\n"
        		  	+ "Name: "+Name+"\n"
        			+ "Unterlagen: "+Unterlagen+"\n"
        			+ "Bildungsgrad: " +bildungsgrad+"\n"
        			+ "Abschlussnote Studium: " +Abschlussnote_Studium+"\n"
        			+ "Abschlussnote Ausbildung: " +Abschlussnote_Ausbildung+"\n"
        			+ "Berufserfahrung: " +Berufserfahrung_Jahre+" Jahren"+"\n"
        			+ "Auslandserfahrung: " +Auslandserfahrung+"\n";
          
          String path="C:\\Users\\jenni\\Documents\\Bewerberdaten.txt";
          
          File file = new File(path);

          // If file doesn't exists, then create it
          if (!file.exists()) {
              file.createNewFile();
          }

          FileWriter fw = new FileWriter(file.getAbsoluteFile());
          BufferedWriter bw = new BufferedWriter(fw);

          // Write in file
          bw.write(content);

          // Close connection
          bw.close();
      }
      catch(Exception e){
          System.out.println(e);
      }
  }

}
