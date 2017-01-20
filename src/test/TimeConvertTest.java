package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import picoplaca.*;

@RunWith(value = Parameterized.class)
public class TimeConvertTest {
	private String _input;
	private String _expected;

	@Parameters
	public static Iterable<Object[]> getInput(){
		return Arrays.asList(new Object[][]{
				{"20:50","20.84"},{"07:20","7.34"},{"14:54","14.90"}});		
	}
	
	public TimeConvertTest(String input, String expected){
		this._input = input;
		this._expected = expected;
	}
	
	@Test
	public void test() {
		TimeValidator objTimeValidator = new TimeValidator(_input);
		String result = objTimeValidator.convert();
		assertEquals("Test Time Convert Error",_expected , result);
	}

}
