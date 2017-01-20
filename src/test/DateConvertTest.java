package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import picoplaca.*;

@RunWith(value = Parameterized.class)
public class DateConvertTest {
	private String _input;
	private String _expected;
	
	@Parameters
	public static Iterable<Object[]> getInput(){
		return Arrays.asList(new Object[][]{
				{"19/01/2017","THURSDAY"},{"25/06/2017","SUNDAY"},{"14/02/2017","TUESDAY"}});		
	}
	
	public DateConvertTest(String input, String expected){
		this._input = input;
		this._expected = expected;
	}

	@Test
	public void test() {
		DateValidator objDateValidator = new DateValidator(_input);
		objDateValidator.validate();	
		String result = objDateValidator.convert();	
		assertEquals("Test Date Convert Error",_expected , result);
	}

}
