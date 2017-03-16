package aliceinnets.test.api;

import aliceinnets.finance.api.TestGoogleFinanceGetpricesApi;
import aliceinnets.python.jyplot.TestJyPlot;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestAll extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for algorithm repository");

		suite.addTestSuite(TestGoogleFinanceGetpricesApi.class);
		suite.addTestSuite(TestJyPlot.class);

		return suite;
	}

}
