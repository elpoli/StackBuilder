package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import picoplaca.*;

@RunWith(value = Parameterized.class)
public class PlateValidatorTest {
	private String _input;
	private boolean _expected;
	
	@Parameters
	public static Iterable<Object[]> getInput(){
		return Arrays.asList(new Object[][]{
				{"gfg-541",true},{"GFDG-65",false},{"TER-65478",false}});		
	}
	
	public PlateValidatorTest(String input, boolean expected){
		this._input = input;
		this._expected = expected;
	}
	
	@Test
	public void test() {
		PlateValidator objPlateValidator = new PlateValidator(_input);
		boolean result = objPlateValidator.validate();
		assertEquals("Test Plate Validator Error",_expected , result);
	}

}
