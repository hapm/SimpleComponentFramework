package fhbrs.ooka.ateam.components;

/**
 * This exception is thrown every time someone tries to 
 * load a class as a component, that doesn't implement
 * the IComponent interface.
 * 
 * @author Markus Andree
 */
public class ClassIsNoComponentException extends Exception {
	/**
	 * The serial version uid (needed by any exception)
	 */
	private static final long serialVersionUID = 1803538300882183944L;
	
	/**
	 * Saves the Class instance that caused the exception.
	 */
	private Class<?> cls;

	/**
	 * Initializes a new instance of the ClassIsNoComponentException class.
	 * 
	 * @param cls The Class instance that was tried to be instantiated
	 *                as a component.
	 */
	public ClassIsNoComponentException(Class<?> cls) {
		super("The given class doesn't implement the IComponent interface: " + cls.getName());
		
		this.cls = cls;
	}	
	
	/**
	 * Gets the class that is causing the exception.
	 * 
	 * @return The Class instance of the class.
	 */
	public Class<?> getComponentClass() {
		return cls;
	}
}
