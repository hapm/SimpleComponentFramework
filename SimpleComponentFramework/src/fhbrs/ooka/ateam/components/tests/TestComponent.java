package fhbrs.ooka.ateam.components.tests;

import static org.junit.Assert.*;

import fhbrs.ooka.ateam.components.ComponentState;
import fhbrs.ooka.ateam.components.IComponent;

public class TestComponent implements IComponent {
	private ComponentState state;
	
	public TestComponent() {
		state = ComponentState.Stopped;
	}

	@Override
	public String getName() {
		return "Test-Component";
	}

	@Override
	public float getVersion() {
		return 1;
	}

	@Override
	public String getDescription() {
		return "Little description here";
	}

	@Override
	public ComponentState getState() {
		return state;
	}

	@Override
	public void start() throws Exception {
		if (state == ComponentState.Running)
			fail("Component was started twice.");
		state = ComponentState.Running;
	}

	@Override
	public void stop() throws Exception {
		if (state != ComponentState.Running)
			fail("Component wasn't started before stop.");
		state = ComponentState.Stopped;
	}

}
