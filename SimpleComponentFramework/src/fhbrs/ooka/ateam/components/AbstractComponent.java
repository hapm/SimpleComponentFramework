package fhbrs.ooka.ateam.components;

/**
 * Gives a default implementation of the IComponent interface.
 * 
 * @author Markus Andree
 */
public abstract class AbstractComponent implements IComponent {
	/**
	 * Saves the informations about the component.
	 */
	private ComponentInfo information;
	
	/**
	 * Saves the state of the component.
	 */
	protected ComponentState state;

	/**
	 * Saves the context the component runs in.
	 */
	private ComponentContext context;
	
	/**
	 * Initializes a new instance of the AbstractComponent class.
	 * 
	 * @param name The name of the component.
	 * @param version The version of the component.
	 * @param desc The description for the component.
	 */
	public AbstractComponent(String name, float version, String desc) {
		this.information = new ComponentInfo(name, version, desc);
		this.state = ComponentState.Stopped;
	}

	@Override
	@Deprecated
	public String getName() {
		return information.getName();
	}
	
	@Override
	public ComponentInfo getInformation() {
		return information;
	}

	@Override
	@Deprecated
	public float getVersion() {
		return information.getVersion();
	}

	@Override
	@Deprecated
	public String getDescription() {
		return information.getDescription();
	}
	
	@Override
	public ComponentContext getContext() {
		return context;
	}

	@Override
	public ComponentState getState() {
		return state;
	}

	@Override
	public void start(ComponentContext context) throws Exception {
		this.context = context;
		state = ComponentState.Running;
	}

	@Override
	public void stop() throws Exception {
		state = ComponentState.Stopped;
	}
}
