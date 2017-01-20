package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import picoplaca.*;

@RunWith(value = Parameterized.class)
public class CreateDataTest {	
	private boolean _expected;

	@Parameters
	public static Iterable<Object[]> getInput(){
		return Arrays.asList(new Object[][]{
				{true},{true},{true}});		
	}
	
	public CreateDataTest(boolean expected){		
		this._expected = expected;
	}
	
	@Test
	public void test() {
		boolean result = DataMemory.createData();
		assertEquals("Test Create Data Error",_expected , result);
	}

}
