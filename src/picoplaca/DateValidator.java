package picoplaca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateValidator extends DataValidator{

	private String _dateCar;
	SimpleDateFormat dateFormat;
	Date dateTemp;
	
	public String getDateCar() {
		return _dateCar;
	}
	public void setDateCar(String dateCar) {
		this._dateCar = dateCar;
	}
	
	
	public DateValidator(String dateCar) {
		this._dateCar = dateCar;
	}
	
	@Override
	public boolean validate() {
		//validate date
		try {
			dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);	  
			dateFormat.setLenient(false);
			dateTemp = dateFormat.parse(this._dateCar);
			return true;
		} catch (ParseException e) {			
			//e.printStackTrace();
			return false;
		}		
	}
	
	@Override
	public String convert(){
		//get day of week	
		dateFormat.applyPattern("EEEE");		    
		return dateFormat.format(dateTemp).toUpperCase();		
	}
}
