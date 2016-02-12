package main;
import net.sf.memoranda.PhaseListTest;
import net.sf.memoranda.PhaseTest;
import net.sf.memoranda.server.ServerCommCoreTest;
import net.sf.memoranda.server.ServerStartTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Runs all test cases, please JavaDoc all test classes.

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any sub-packages of its
 * package.
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	// Add test classes here
	ServerStartTest.class,
	ServerCommCoreTest.class,
	PhaseTest.class,
	PhaseListTest.class,
})
public class TestAll {

	/**
	 * Launch the test.
	 */
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}