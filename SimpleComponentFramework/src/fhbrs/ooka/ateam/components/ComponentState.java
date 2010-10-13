package fhbrs.ooka.ateam.components;

/**
 * The ComponentState enumeration represents
 * the current state of a Component in the
 * SimpleComponentFramework.
 *  
 * @author Markus Andree
 * @see IComponent#getState()
 */
public enum ComponentState {
	/**
	 * A stopped component does nothing, and can be
	 * simply removed without any problems.
	 */
	Stopped,
	
	/**
	 * If a component is in the running state,
	 * it runs its actions and does its job.
	 */
	Running
}
