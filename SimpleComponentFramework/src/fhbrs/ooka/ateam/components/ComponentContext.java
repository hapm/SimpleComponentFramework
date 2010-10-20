package fhbrs.ooka.ateam.components;

/**
 * Allows to access the context, a component runs in.
 * 
 * @author Markus Andree
 */
public class ComponentContext {
	/**
	 * Saves the ComponentManager instance.
	 */
	private ComponentManager manager;

	/**
	 * Initializes a new instance of the ComponentContext class.
	 * 
	 * @param mngr The ComponentManger for this context.
	 */
	ComponentContext(ComponentManager mngr) {
		this.manager = mngr;
	}
	
	/**
	 * Checks if the component identified by the given name is
	 * running or not.
	 * 
	 * @param componentName The name of the component to check.
	 * @return true, if the component doesn't exist or is not running
	 *         at the moment, false otherwise. 
	 */
	public boolean isRunning(String componentName) {
		IComponent cmp = this.manager.findByName(componentName);
		if (cmp == null)
			return false;
		
		return (cmp.getState() == ComponentState.Running);
	}
	
	/**
	 * Gets informations about a given component name.
	 * 
	 * @param componentName The name of the component to get informations for.
	 * @return The ComponentInfo about the given component if it was loaded, 
	 *         null otherwise.
	 */
	public ComponentInfo getInformation(String componentName) {
		IComponent cmp = this.manager.findByName(componentName);
		if (cmp == null)
			return null;
		
		return cmp.getInformation();	
	}
}
