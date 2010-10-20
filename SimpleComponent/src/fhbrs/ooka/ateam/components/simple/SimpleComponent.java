package fhbrs.ooka.ateam.components.simple;

import fhbrs.ooka.ateam.components.AbstractComponent;
import fhbrs.ooka.ateam.components.ComponentContext;

/**
 * A simple component implementation of the IComponent interface, that doesn't do much.
 * 
 * @author Markus Andree
 */
public class SimpleComponent extends AbstractComponent {
	/**
	 * Initializes a new instance of the SimpleComponent class.
	 */
	public SimpleComponent() {
		super("Simple Component", 1, "Doesn't do very much else than saying, that it was started and stopped.");
	}
	
	@Override
	public void start(ComponentContext context) throws Exception {
		super.start(context);
		System.out.println(getInformation().getName() + " was started successfully.");
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		System.out.println(getInformation().getName() + " was stopped successfully.");
	}

}
