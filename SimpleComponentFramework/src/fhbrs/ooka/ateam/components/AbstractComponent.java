package fhbrs.ooka.ateam.components;

public abstract class AbstractComponent implements IComponent {
	/**
	 * Saves the name of the component.
	 */
	private String name;
	
	/**
	 * Saves the version of the component.
	 */
	private float version;
	
	/**
	 * Saves the desciption of the component.
	 */
	private String description;
	
	/**
	 * Saves the state of the component.
	 */
	protected ComponentState state;
	
	/**
	 * Initializes a new instance of the AbstractComponent class.
	 * 
	 * @param name The name of the component.
	 * @param version The version of the component.
	 * @param desc The description for the component.
	 */
	public AbstractComponent(String name, float version, String desc) {
		this.name = name;
		this.version = version;
		this.description = desc;
		this.state = ComponentState.Stopped;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public float getVersion() {
		return version;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public ComponentState getState() {
		// TODO Auto-generated method stub
		return state;
	}

	@Override
	public void start() throws Exception {
		state = ComponentState.Running;
	}

	@Override
	public void stop() throws Exception {
		state = ComponentState.Stopped;
	}

}
