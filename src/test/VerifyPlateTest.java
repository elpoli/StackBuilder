package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import picoplaca.*;

@RunWith(value = Parameterized.class)
public class VerifyPlateTest {
	private String _input;
	private String _expected;
	
	@Parameters
	public static Iterable<Object[]> getInput(){
		return Arrays.asList(new Object[][]{
			{"20/01/2017,10:15,hgf-547","<< The Car is Authorizad >>"}, 
			{"07/06/2017,07:25,gwn-1234","<< The Car is Not Authorizad >>"}, 
			{"24/04/2017,18:20,nbf-489","<< The Car is Not Authorizad >>"}});
	}
	
	public VerifyPlateTest (String input, String expected){
		this._input=input;
		this._expected=expected;
	}
	
	@Test
	public void test() {
		PicoPlacaValidator objPico = new PicoPlacaValidator(_input,"");		
		String result = objPico.verifyPlate();
		assertEquals("Test Vaerify Plate Error",_expected, result);		
	}

}
