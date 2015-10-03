package us.wsu.knoesis.tutorial;


import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import us.wsu.knoesis.tutorial.events.SmokeSensorEvent;
import us.wsu.knoesis.tutorial.events.TemperatureSensorEvent;
import us.wsu.knoesis.tutorial.listeners.SimpleListener;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

public class FireSensing {

	public static void main(String[] args) {
		
		ConsoleAppender appender = new ConsoleAppender(new SimpleLayout());
		Logger.getRootLogger().addAppender(appender);
		Logger.getRootLogger().setLevel((Level) Level.INFO);

		
		
		Configuration cepConfig = new Configuration();
		
		// Events registration is explicit!
		// We can specify a name, each of these identifies a stream
		cepConfig.addEventType("SmokeSensorEvent", SmokeSensorEvent.class.getName());
		cepConfig.addEventType("TemperatureSensorEvent", TemperatureSensorEvent.class.getName());
		cepConfig.addEventType("FireEvent", SmokeSensorEvent.class.getName());
		
		
		EPServiceProvider cep = EPServiceProviderManager.getProvider(
				"Web 3.0 Tutorial", cepConfig);

		// Through the EP administrator API we can manage the EPL Statement registration
		EPAdministrator cepAdm = cep.getEPAdministrator();
		
		String q1 = "select * from TemperatureSensorEvent where temperature > 50";
		
		EPStatement s1 = cepAdm.createEPL(q1);
		
		s1.addListener(new SimpleListener());
		
		// the EP runtime API allows to send events into different streams
		EPRuntime cepRT = cep.getEPRuntime();
		
		
		cepRT.sendEvent(new SmokeSensorEvent("S1",false));
		cepRT.sendEvent(new TemperatureSensorEvent("S1", 30D));

		cepRT.sendEvent(new SmokeSensorEvent("S1",true));
		cepRT.sendEvent(new TemperatureSensorEvent("S1", 40D));

		cepRT.sendEvent(new SmokeSensorEvent("S2",false));
		cepRT.sendEvent(new TemperatureSensorEvent("S1", 55D));

		cepRT.sendEvent(new SmokeSensorEvent("S1",true));
		cepRT.sendEvent(new TemperatureSensorEvent("S1", 55D));

		cepRT.sendEvent(new SmokeSensorEvent("S1",true));
		cepRT.sendEvent(new TemperatureSensorEvent("S1", 55D));
		
		
	}

}
