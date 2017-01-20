package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CreateDataTest.class, DateConvertTest.class,
		DateValidatorTest.class, PlateValidatorTest.class,
		TimeConvertTest.class, TimeValidatorTest.class, VerifyPlateTest.class })
public class PicoPlacaTestSuite {

}
