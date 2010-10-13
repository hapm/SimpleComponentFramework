/**
 * This file contains the IComponent interface.
 */
package fhbrs.ooka.ateam.components;

/**
 * By implementing this interface, a class can
 * be used as a component in the SimpleComponentFramework
 *  
 * @author Markus Andree
 */
public interface IComponent {
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
	public String getName();
	
	/**
	 * Gets a description of the component with detailed
	 * information of what the component does.
	 * 
	 * @return A description (can be multilined).
	 */
	public String getDescription();
	
	/**
	 * Gets the current state of the Component. The values are 
	 * documented in {@link ComponentState} enumeration.
	 * 
	 * @return The current state of the Component.
	 * @see ComponentState
	 */
	public ComponentState getState();
	
	/**
	 * This method is called, when the SimpleComponentFramework
	 * was requested to start this component.
	 * 
	 * A component should not start any actions before this method
	 * is called, so don't use the constructor to do anything else 
	 * then simple initializations of member fields.
	 * 
	 * This method should be only called by the SimpleComponentFramework
	 * and never directly!
	 * 
	 * @throws Exception If any Exception is thrown in this
	 * 	       method, the component will not change its state 
	 *         to running.
	 */
	public void start() throws Exception;
	
	/**
	 * This method is called, when the SimpleComponentFramework
	 * was requested to stop this component.
	 * 
	 * When this method is called, a component should stop all
	 * actions and release all resources like, additional threads.
	 * 
	 * This method should be only called by the SimpleComponentFramework
	 * and never directly!
	 * 
	 * @throws Exception If this method throws any Exception, it
	 *         is in a state where it can't be stopped at the 
	 *         moment.
	 */
	public void stop() throws Exception;
}
