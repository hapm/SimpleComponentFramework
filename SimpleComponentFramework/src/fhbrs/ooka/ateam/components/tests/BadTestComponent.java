package fhbrs.ooka.ateam.components.tests;

import fhbrs.ooka.ateam.components.AbstractComponent;
import fhbrs.ooka.ateam.components.ComponentContext;

public class BadTestComponent extends AbstractComponent {
	private BadTestComponent() {
		super(null, 0, null);
	}

	public void start(ComponentContext context) throws Exception {
		super.start(context);
	}

	public void stop() throws Exception {
		super.stop();
	}

}
