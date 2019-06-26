# Bewerbungsprozess

Automatisierte Bewerbungsprozess mit der Hilfe von BPMN/DMN--Engine Camunda

## Entwicklungsumgebung

- Eclipse IDE for Java Developers (Version: Oxygen.3a Release (4.7.3a))
- Camunda BPM Tomcat 7.8.0

## Einordnung des Themas

Der Weg zum anvisierten Traumjob: Dieser beginnt im Anschluss an die Stellenauswahl und anknüpfende Stellensuche grundsätzlich mit einer Online-Bewerbung. Mit der Übermittlung der Bewerbungsunterlagen an das Unternehmen haben Bewerber bereits den ersten Schritt getan und den Bewerbungsprozess spätestens zu diesem Zeitpunkt angestoßen. Doch mit dem Versand der Bewerbungsunterlagen ist es längst nicht getan – sowohl Bewerber, als auch Unternehmen müssen sich im Rahmen des  Bewerbungsprozesses nun noch weiteren Aufgaben und Herausforderungen stellen. Der Prozess soll aufzuzeigen, welche Schritte der Bewerber und das Unternehmen durchlaufen. Außerdem soll die Möglichkeit aufgezeigt werden, inwiefern einzelne Schritte technisch gelöst werden können, sodass Arbeitszeit auf Seite des Unternehmens gespart wird und dieses seinen Nutzen daraus ziehen kann.

## Abgrenzung und Beschreibung der Prozesse 

Der Prozess „Bewerbungsprozess“ ist als BPMN (Business Process Model and Notation) modelliert und beinhaltet zwei verschiedene DMN (Decision Model and Notation) zur Eignungsprüfung. 
Der Hauptprozess ist als BPMN modelliert und zeigt den Prozess beginnend mit dem Einreichen der Bewerbungsunterlagen bis hin zur Entscheidung des Unternehmens für oder gegen die Einstellung des Bewerbers.
Der Prozess beinhaltet 2 Pools: Wir betrachten den Prozess aus Sicht des Bewerbers als auch aus Sicht des Unternehmens. Es wird davon ausgegangen, dass der Bewerber sich durchgehend für das Unternehmen entscheidet und nicht zwischenzeitlich absagt. 


![Alt text](/Bewerbungsprozess_BPMN.png?raw=true "Bewerbungsprozess_BPMN")


Sobald der Bewerber die Bewerbung vorbereitet und sich für eine entsprechende Stelle entschieden hat, startet der Bewerbungsprozess, indem der Bewerber das Bewerbungsformular ausfüllt (User Task) und die Bewerbungsunterlagen an das Unternehmen sendet (Send Task). Infolge dessen erhält das Unternehmen die Bewerbung per Mail (Message Event). Die Bewerbungsdaten (Zeugnisse, Anschreiben, Lebenslauf, Zertifikate, Auslandserfahrung, Bildungsgrad, Ausbildungsnote sei es Studium oder Ausbildung, Berufserfahrung) werden anschließend in das System des Unternehmens übertragen (User Task) und auf Vollständigkeit überprüft. Die Daten werden in der DMN Tabelle durch ein Scoring-System evaluiert, sodass die Business Task eine Bewertung über den Bewerber abgibt,


![Alt text](/dmnBewerbung.PNG?raw=true "dmnBewerbung")


Diese wird in der darauffolgenden User Task ausgegeben. Sollte sich rausstellen, dass der Bewerber ungeeignet für die ausgeschriebene Stelle ist, so erfolgt die Absage seitens des Unternehmens (Send Task) bei einem erreichten Scoring von unter 80 Punkten und der Bewerber erhält die Absage (Message Event), wodurch der Prozess in beiden Pools endet.
Ist die Bewerbung jedoch ansprechend bei einer Punktzahl größer als 80, so erstellt das Unternehmen eine Einladung zum Online Test und sendet diese an den Bewerber (Send Task). Der Bewerber erhält die Einladung zum Online-Test (Message Event) und hat die Möglichkeit den Test durchzuführen (Call-Activity).


![Alt text](/Teilprozess_BPMN.PNG?raw=true "Teilprozess_BPMN")


Der Test findet im Subprozess statt. 
Durch Aufrufen die Eingabe der Bewerberdaten wird der Test, bestehend aus Fallstudie, Programmieraufgabe, Selbstdarstellungsaufsatz, Fachwissen, Auffassungsgabe und Kommunikationsfähigkeiten gestartet. Dem Bewerber stehen hierfür 90 Minuten (in unserem Prozess zum Test 1 Minute) zur Verfügung. Nach erfolgreicher Beendigung des Tests bzw. Zeitüberschreitung übermittelt der Bewerber die Testergebnisse an das Unternehmen (Send Task). Sollte das Ergebnis die Zeitüberschreitung enthalten, wird das Unternehmen benachrichtigt und der Bewerber vom weiteren Prozess ausgeschlossen. Seine Daten werden als Datei auf dem Computer abgelegt und der Prozess beendet. 
Bei einem abgeschlossenen Test erhält das Unternehmen die Testergebnisse (Message Event) und trägt die Ergebnisse in das System ein (User Task). Neben den Assessmentergebnissen werden auch die Bewerberqualifikationen (Fachwissen, Kommunikationsfähigkeit, Auffassungsgabe)  bewertet, wodurch weiterhin Bewerber berücksichtigt werden, die den Test nicht in der vorgegebenen Zeit bearbeiten konnten. Mithilfe der DMN wird das Ergebnis evaluiert. 


![Alt text](/dmnassesment.PNG?raw=true "dmnassesment")


Insgesamt liegt auch hier ein Scoring-System zu Grunde. 
Anschließend erfolgt die Prüfung des Ergebnisses. Wurde der Test nicht bestanden, so erfolgt an dieser Stelle die Absage seitens des Unternehmens (Send Task) und der Bewerber erhält die Entscheidung (Message Event). An dieser Stelle endet der Prozess in beiden Pools. Wurde der Test erfolgreich absolviert, versendet das Unternehmen die Zusage an den Bewerber (Send Task), die der Bewerber wiederum erhält (Message Event). Auch hier endet der Prozess in beiden Pools, jedoch erfolgreich.



## Erläuterung fachlicher und technischer Modellierungsentscheidungen

In dem BPMN Prozess wird der Bewerber erst aufgefordert seine Bewerberdaten einzugeben. Dies wird mit Hilfe von Forms dargestellt. Hierzu wurden diese mit html programmiert und in Form Key implementiert. Hier wird ein kleiner Auschnitt aus dem html-Code gezeigt: 




Es soll grundsätzlich dem Unternehmen bei der Sichtung der Unterlagen Arbeit abnehmen. Durch die technische Implementierung mit Java werden diese Daten an das Unternehmen mittels der JavaMail Api von Camunda gesendet. Hierdurch wird der Unternehmensprozess gestartet. 
Um zu überprüfen, ob der Bewerber die Daten richtig in die Forms eingegeben hat, werden diese von der Bewerbungsmail in die für die DMN-Tabelle nötigen Forms übertragen und geprüft. 
Die DMN Tabelle "Bewerbung" evaluiert dann die einzelnen Fähigkeiten und Abschlüsse des Bewerbers mithilfe eines Scoring-Systems. 
