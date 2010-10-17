package fhbrs.ooka.ateam.components.tests;

import fhbrs.ooka.ateam.components.ComponentState;
import fhbrs.ooka.ateam.components.IComponent;

public class BadTestComponent implements IComponent {
	private BadTestComponent() {
		
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public float getVersion() {
		return 0;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public ComponentState getState() {
		return ComponentState.Stopped;
	}

	@Override
	public void start() throws Exception {
	}

	@Override
	public void stop() throws Exception {
	}

}
