package fhbrs.ooka.ateam.components.tests;

import static org.junit.Assert.*;

import fhbrs.ooka.ateam.components.AbstractComponent;
import fhbrs.ooka.ateam.components.ComponentContext;
import fhbrs.ooka.ateam.components.ComponentState;

public class TestComponent extends AbstractComponent {
	private ComponentState state;
	
	public TestComponent() {
		super("Test-Component", 1, "Little description here");
		state = ComponentState.Stopped;
	}

	@Override
	public void start(ComponentContext context) throws Exception {
		if (state == ComponentState.Running)
			fail("Component was started twice.");
		super.start(context);
	}

	@Override
	public void stop() throws Exception {
		if (state != ComponentState.Running)
			fail("Component wasn't started before stop.");
		super.stop();
	}
}
