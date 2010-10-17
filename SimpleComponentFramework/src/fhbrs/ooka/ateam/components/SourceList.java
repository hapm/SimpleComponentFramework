package fhbrs.ooka.ateam.components;

import java.net.URL;
import java.util.ArrayList;

/**
 * Manages a list of sources for the ComponentRepository.
 * 
 * Sources can be local jar files, paths and remote urls.
 * 
 * @author Markus Andree
 */
public class SourceList extends ArrayList<URL> {
	/**
	 * The serial version uid.
	 */
	private static final long serialVersionUID = 1L;
	
	//TODO add checks for the added strings to be valid component sources like urls or local paths.
}
