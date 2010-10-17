package fhbrs.ooka.ateam.components.tests;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import fhbrs.ooka.ateam.components.ClassIsNoComponentException;
import fhbrs.ooka.ateam.components.ComponentRepository;
import fhbrs.ooka.ateam.components.IComponent;
import fhbrs.ooka.ateam.components.SourceList;

/**
 * Tests the Component Repository class.
 * 
 * @author Markus
 */
public class ComponentRepositoryTest {

	private ComponentRepository repo;

	@Before
	public void setUp() throws MalformedURLException {
		repo = new ComponentRepository();
		repo.getSources().add(new java.io.File(".").toURI().toURL());
	}
	
	@Test
	public void testComponentRepository() {
		assertNotNull(repo);
	}

	@Test
	public void testGetSources() {
		ComponentRepository repo = new ComponentRepository();
		SourceList sources = repo.getSources();
		assertNotNull(sources);
		assertEquals(0, sources.size());
	}

	@Test(expected=ClassNotFoundException.class)
	public void testCreateComponentStringClassNotFoundException() throws ClassNotFoundException, InstantiationException, IllegalAccessException, ClassIsNoComponentException {
		repo.createComponent("some.thing.non.existing");
	}

	@Test(expected=ClassIsNoComponentException.class)
	public void testCreateComponentStringClassIsNoComponentException() throws ClassNotFoundException, InstantiationException, IllegalAccessException, ClassIsNoComponentException {
		repo.createComponent("fhbrs.ooka.ateam.components.tests.ComponentRepositoryTest");
	}

	@Test(expected=IllegalAccessException.class)
	public void testCreateComponentStringIllegalAccessException() throws ClassNotFoundException, InstantiationException, IllegalAccessException, ClassIsNoComponentException {
		repo.createComponent("fhbrs.ooka.ateam.components.tests.BadTestComponent");
	}

	@Test
	public void testCreateComponentString() throws ClassNotFoundException, InstantiationException, IllegalAccessException, ClassIsNoComponentException {
		IComponent comp = repo.createComponent("fhbrs.ooka.ateam.components.tests.TestComponent");
		assertTrue(comp instanceof TestComponent);
	}

	@Test
	public void testCreateComponentStringURL() {
		fail("Not yet implemented");
	}

}
