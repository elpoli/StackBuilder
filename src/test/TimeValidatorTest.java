package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import picoplaca.*;

@RunWith(value = Parameterized.class)
public class TimeValidatorTest {
	private String _input;
	private boolean _expected;
	
	@Parameters
	public static Iterable<Object[]> getInput(){
		return Arrays.asList(new Object[][]{
				{"20:04",true},{"25:20",false},{"15//100",false}});		
	}
	
	public TimeValidatorTest(String input, boolean expected){
		this._input = input;
		this._expected = expected;
	}
	
	@Test
	public void test() {
		TimeValidator objTimeValidator = new TimeValidator(_input);
		boolean result = objTimeValidator.validate();
		assertEquals("Test Time Validate Error",_expected , result);
	}

}
