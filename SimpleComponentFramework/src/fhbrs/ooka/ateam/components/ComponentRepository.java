package fhbrs.ooka.ateam.components;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * The ComponentRepository saves the list of sources for components
 * and is capable to load components from this sources.
 * 
 * @author Markus Andree
 */
public class ComponentRepository {
	/**
	 * Saves the list of sources to search in for given components.
	 */
	private SourceList sources;
	
	/**
	 * Initializes a new instance of the ComponentRepository class.
	 */
	public ComponentRepository() {
		this.sources = new SourceList();
	}
	
	/**
	 * Gets the list of all sources, that are used to search for 
	 * a given component.
	 * 
	 * Add new sources to this list to let the SimpleComponentFramework 
	 * search in them.
	 * 
	 * @return The list of all sources.
	 */
	public SourceList getSources() {
		return sources;
	}
	
	/**
	 * Tries to find the given class name in all added sources,
	 * loads it and returns an instance of the class if it is
	 * a valid SimpleComponentFramework component.
	 * 
	 * @param className The class name to search for.
	 * @return The IComponent instance of the given class name.
	 * @throws ClassNotFoundException if the given class wasn't found in any of the 
	 *         known component sources.
	 * @throws IllegalAccessException if the class or its default constructor aren't accessible.
	 * @throws InstantiationException if the Class represents an abstract class, an interface, 
	 *                                an array class, a primitive type, or void; or if the class 
	 *                                has no default constructor; or if the instantiation fails
	 *                                for some other reason.
	 * @throws ClassIsNoComponentException if the given class doesn't implement the IComponent interface.
	 */
	public IComponent createComponent(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ClassIsNoComponentException {
		Class<?> compCls = findClass(className);
		if (!IComponent.class.isAssignableFrom(compCls)) {
			throw new ClassIsNoComponentException(compCls);
		}
		
		IComponent result = (IComponent)compCls.newInstance();
		return result;
	}
	
	/**
	 * Tries to find the given class name in the given source,
	 * loads it and returns an instance of the class if it is
	 * a valid SimpleComponentFramework component.
	 * 
	 * @param className The class name to search for.
	 * @param source The source location to search for the class.
	 * @return The IComponent instance of the given class name.
	 * @throws ClassNotFoundException if the given class wasn't found in any of the 
	 *         known component sources.
	 * @throws IllegalAccessException if the class or its default constructor aren't accessible.
	 * @throws InstantiationException if the Class represents an abstract class, an interface, 
	 *                                an array class, a primitive type, or void; or if the class 
	 *                                has no default constructor; or if the instantiation fails
	 *                                for some other reason.
	 * @throws ClassIsNoComponentException if the given class doesn't implement the IComponent interface.
	 */
	public IComponent createComponent(String className, URL source) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ClassIsNoComponentException {
		Class<?> compCls = findClass(className, source);
		if (!IComponent.class.isAssignableFrom(compCls)) {
			throw new ClassIsNoComponentException(compCls);
		}
		
		IComponent result = (IComponent)compCls.newInstance();
		return result;
	}

	/**
	 * Searches the given component source for the given class name and returns 
	 * a Class instance if it was found.
	 * 
	 * @param className The full qualified name of the class to search
	 *                  including the package name.
	 * @return The Class instance representing the given class name. 
	 * @throws ClassNotFoundException if the class wasn't found in any of the sources.
	 * @throws MalformedURLException if the given source couldn't be parsed to an URL.
	 */
	private Class<?> findClass(String className, URL source) throws ClassNotFoundException {
		URLClassLoader clsLoader = new URLClassLoader(new URL[] { source });
		Class<?> result = clsLoader.loadClass(className);
		return result;
	}

	/**
	 * Searches all component sources for the given class name and returns 
	 * a Class instance if it was found.
	 * 
	 * @param className The full qualified name of the class to search
	 *                  including the package name.
	 * @return The Class instance representing the given class name. 
	 * @throws ClassNotFoundException if the class wasn't found in any of the sources.
	 */
	private Class<?> findClass(String className) throws ClassNotFoundException {
		URLClassLoader clsLoader = new URLClassLoader(sources.toArray(new URL[0]));
		Class<?> result = clsLoader.loadClass(className);
		return result;
	}
}
