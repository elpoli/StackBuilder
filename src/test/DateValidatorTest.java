package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import picoplaca.*;

@RunWith(value = Parameterized.class)
public class DateValidatorTest {
	private String _input;
	private boolean _expected;
	
	@Parameters
	public static Iterable<Object[]> getInput(){
		return Arrays.asList(new Object[][]{
				{"19/01/2017",true},{"19/AB/2017",false},{"50/06/2017",false}});		
	}
	
	public DateValidatorTest(String input, boolean expected){
		this._input = input;
		this._expected = expected;
	}
	
	@Test
	public void test() {
		DateValidator objDateValidator = new DateValidator(_input);
		boolean result = objDateValidator.validate();		
		assertEquals("Test Date Validate Error",_expected , result);		
	}

}
