package fhbrs.ooka.ateam.components;

/**
 * Gives informations about a component loaded by the framework.
 * 
 * @author Markus Andree
 */
public class ComponentInfo {
	/**
	 * Saves the name of the component.
	 */
	private String name;
	
	/**
	 * Saves the description of the component.
	 */
	private String description;
	
	/**
	 * Saves the version of the component.
	 */
	private float version;
	
	/**
	 * Initializes a new instance of the ComponentInfo class.
	 * @param name The name of the component.
	 * @param version The version of the component.
	 * @param description The description of the component.
	 */
	public ComponentInfo(String name, float version, String description) {
		this.name = name;
		this.description = description;
		this.version = version;
	}

	/**
	 * Gets the name readable name of this component, that
	 * can be used to represent the component in the user
	 * interface.
	 * 
	 * This method can be called regardless to the state of 
	 * the component. So it should only return the name and 
	 * do no other actions. 
	 * 
	 * @return The human readable name of the component.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the version number of this component.
	 * 
	 * The integer part of the number is the major version
	 * and the fractional digits are the minor version. There
	 * are two decimal places for the minor version. So the 
	 * version number 1.1 means 1.10, what is the first major
	 * version and the 10s minor version. This is to allow easy 
	 * comparing of different versions.
	 * 
	 * @return The number of the version of the component.
	 */
	public float getVersion() {
		return this.version;
	}

	/**
	 * Gets a description of the component with detailed
	 * information of what the component does.
	 * 
	 * @return A description (can be multilined).
	 */
	public String getDescription() {
		return this.description;
	}
}
