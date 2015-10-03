package us.wsu.knoesis.tutorial.listeners;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class SimpleListener implements UpdateListener {

	public void update(EventBean[] incomingEvents, EventBean[] outgoinEvents) {
		
		// The parameter meaning depends on the window kind you have specified in the query
		// sliding window (logical or physical) incomingEvents are the events just entered in the window
		// tumbling window (logical or physical) incomingEvents are the 
		
		//EventBean is a wrapper for the serialized events
		for (EventBean e : incomingEvents) {
			System.out.println(e.getUnderlying());

		}
		
		
	}

}
