package picoplaca;

import java.util.HashMap;

public class DataMemory {

	private static HashMap<String, String> _daysPlate;
	private static HashMap<String, String> allowedHours;
	
	public static HashMap<String, String> get_daysPlate() {
		return _daysPlate;
	}	
	public static HashMap<String, String> getAllowedHours() {
		return allowedHours;
	}	
	
	public static boolean createData(){
		//save data in memory
		try{
			_daysPlate = new HashMap<String, String>();
			_daysPlate.put("MONDAY", "1-2");
			_daysPlate.put("TUESDAY", "3-4");
			_daysPlate.put("WEDNESDAY", "5-6");
			_daysPlate.put("THURSDAY", "7-8");
			_daysPlate.put("FRIDAY", "9-0");
			allowedHours = new HashMap<String, String>();
			allowedHours.put("MORNING", "7.00-9.50");
			allowedHours.put("AFTERNOON", "16.00-19.50");	
			return true;
		}catch(Exception ex){
			return false;
		}		
	}
	
}
