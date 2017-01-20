package picoplaca;

import java.math.BigDecimal;

public class TimeValidator extends DataValidator {
	
	private String _timeCar;	
	
	public String get_timeCar() {
		return _timeCar;
	}
	public void set_timeCar(String _timeCar) {
		this._timeCar = _timeCar;
	}
	
	public TimeValidator(String timeCar){
		this._timeCar = timeCar;
	}
	
	@Override
	public boolean validate() {
		//validate time
		if(this._timeCar.length() ==5 && Character.isDigit(_timeCar.charAt(0)) && Character.isDigit(_timeCar.charAt(1)) 
		   && _timeCar.charAt(2)==':' &&  Character.isDigit(_timeCar.charAt(3)) && Character.isDigit(_timeCar.charAt(4))
		   && (Integer.parseInt(_timeCar.substring(0,2))>0 && Integer.parseInt(_timeCar.substring(0,2))<=24)
		   && (Integer.parseInt(_timeCar.substring(3))>=0 && Integer.parseInt(_timeCar.substring(3))<=60)){
		   return true;				
		}else{
			return false;
		}
	}
	
	@Override
	public String convert() {
		//Convert time in decimal format
		String hourTemp = this._timeCar.substring(0,2);
		String minTemp = this._timeCar.substring(3);
		BigDecimal hourDecimal = new BigDecimal(hourTemp);
		BigDecimal minDecimal = new BigDecimal(minTemp);
		minDecimal = minDecimal.divide(new BigDecimal(60), 2, BigDecimal.ROUND_CEILING);
		return hourDecimal.add(minDecimal).toString();		
	}
	
}
