package testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//Works if run by a runner.
@RunWith(Suite.class)

@Suite.SuiteClasses( { TestJunit1.class ,TestJunit2.class })

public class JunitTestSuite { }