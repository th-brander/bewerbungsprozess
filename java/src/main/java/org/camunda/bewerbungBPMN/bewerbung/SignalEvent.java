package org.camunda.bewerbungBPMN.bewerbung;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.impl.pvm.delegate.ActivityExecution;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.ProcessInstance;

public class SignalEvent {
	public void signal(ActivityExecution execution, String signalEvent, Object signalData) throws Exception {

RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();

	runtimeService
	  .createSignalEvent("Testabgebrochen")
	  .send();
	

}
	
}