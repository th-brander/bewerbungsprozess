package org.camunda.bewerbungBPMN.bewerbung;


public class FormblattBewerber {

	
	  protected String name;
	  protected String bildungsgrad;
	  protected boolean auslandserfahrung;
	  protected double Abschlussnote_Studium;
	  protected String Abschlussnote_Ausbildung;
	  protected String Unterlagen;

	  public String getname() {
	    return name;
	  }
	  public void setname(String name) {
	    this.name = name;
	  }
	  public String getbildungsgrad() {
	    return bildungsgrad;
	  }
	  public void setbildungsgrad(String bildungsgrad) {
	    this.bildungsgrad = bildungsgrad;
	  }
	  public boolean auslandserfahrung() {
	    return auslandserfahrung;
	  }
	  public void setauslandserfahrung(boolean auslandserfahrung) {
	    this.auslandserfahrung = auslandserfahrung;
	  }
	  public double getAbschlussnote_Studium() {
	    return Abschlussnote_Studium;
	  }
	  public void setAbschlussnote_Studium(double Abschlussnote_Studium) {
	    this.Abschlussnote_Studium = Abschlussnote_Studium;
	  }
	  public String getAbschlussnote_Ausbildung() {
		    return Abschlussnote_Ausbildung;
		  }
	  public void setAbschlussnote_Ausbildung(String Abschlussnote_Ausbildung) {
		    this.Abschlussnote_Ausbildung = Abschlussnote_Ausbildung;
		  }
	  public String getUnterlagen() {
		    return Unterlagen;
		  }
	  public void setUnterlagen(String Unterlagen) {
		    this.Unterlagen = Unterlagen;
		  }

	  public String toString() {
	    return "BewerberData [name=" + name + ", bildungsgrad=" + bildungsgrad + ", auslandserfahrung=" + auslandserfahrung + ", Abschlussnote_Studium=" + Abschlussnote_Studium + ", Abschlussnote_Ausbildung=" + Abschlussnote_Ausbildung + ", Unterlagen=" + Unterlagen + "]";
	  }
	}
		


