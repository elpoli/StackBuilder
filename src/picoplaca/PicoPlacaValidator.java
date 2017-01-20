package picoplaca;

import java.math.BigDecimal;
import java.util.Scanner;

public class PicoPlacaValidator {

	private String _plateNumber;
	private String _dateCar;
	private String _timeCar;	
	static Scanner scan;	
	DateValidator objDateValidator;		
	static String executionControl = "C";	
		
	public PicoPlacaValidator(){
		validateDate();
		validateTime();
		validatePlate();		
		DataMemory.createData();				
	}
	
	public PicoPlacaValidator(String dummyVal){
		
	}
	
	public PicoPlacaValidator(String inputData, String dummyVal){		
		String[] inputArray = inputData.split(",");
		String dateCar = inputArray[0];
		String timeCar = inputArray[1];
		String plateNumber = inputArray[2];
		objDateValidator = new DateValidator(dateCar);
		if(objDateValidator.validate()){				
			this._timeCar = timeCar;
			this._plateNumber = plateNumber;		
		}
		DataMemory.createData();	
	}
	
	public String getDateCar(){
		return this._dateCar;
	}	
	public String getTimeCar(){
		return this._timeCar;
	}	
	public String getPlateNumber(){
		return this._plateNumber;
	}	
			
	public static void main(String[] args) {		
		scan = new Scanner(System.in);
		while(executionControl.equals("C")){			
			PicoPlacaValidator objPico = new PicoPlacaValidator();
			objPico.verifyPlate();			
			executionControl = "";
			while(!executionControl.equals("C") && !executionControl.equals("E")){
				System.out.println("[Press (C)ontinue or (E)xit]");
				executionControl = scan.nextLine().toUpperCase();			
			}
		}
		System.out.println("[Program Finished]  ********************************");
		scan.close();
	}
	
	public String verifyPlate(){	
		String message="";
		//get day of week	   
		String dayCompare = objDateValidator.convert();		
		//get time in decimal format
		TimeValidator objTimeValidator = new TimeValidator(this._timeCar);
		BigDecimal timeCompare = new BigDecimal(objTimeValidator.convert());		
		//get last digits of plate numbers authorized
		String endingNumbers = DataMemory.get_daysPlate().get(dayCompare);		
		boolean authorized=false;
		String timeRange=null;
		
		if(endingNumbers == null){
			//if day if not in hash map then is authorized
			authorized = true;
		}else{
			String minHour="";
			String maxHour="";
			if(timeCompare.compareTo(new BigDecimal(12)) <= 0){
				//search in morning				
				timeRange = DataMemory.getAllowedHours().get("MORNING");	
				minHour = timeRange.substring(0,4);
				maxHour = timeRange.substring(5);
			}else{
				//search in afternoon				
				timeRange = DataMemory.getAllowedHours().get("AFTERNOON");
				minHour = timeRange.substring(0,5);
				maxHour = timeRange.substring(6);
			}
						
			BigDecimal minHourDecimal = new BigDecimal(minHour);
			BigDecimal maxHourDecimal = new BigDecimal(maxHour);
			//check if the time entered is in the allowed range
			if((timeCompare.compareTo(minHourDecimal) >= 0) && (timeCompare.compareTo(maxHourDecimal) <= 0)){
				String[] charArray = endingNumbers.split("-");
				for(int i=0;i<=charArray.length-1;i++){
					//check if the last digit of plate number is authorized					
					if(this._plateNumber.substring(this._plateNumber.length()-1).equals(String.valueOf(charArray[i]))){
						authorized = true;
						break;
					}
				}
			}else{
				authorized = true;
			}
		}
			
		//show result message
		System.out.println("[[DATA ENTERED]]");
		System.out.println("Date: " + this._dateCar);
		System.out.println("Time: " + this._timeCar);
		System.out.println("Plate Number: " + this._plateNumber);
		System.out.println("");
		
		if(authorized){
			message = "<< The Car is Authorizad >>";			
		}else{
			message = "<< The Car is Not Authorizad >>";			
		}
		System.out.println(message);
		System.out.println("");
		
		return message;
	}
	
	public String validatePlate(){			
		String message="";
		while(this._plateNumber == null){		
			System.out.println("****************************************************");
			System.out.println("Please insert your plate number. e.g.: [ABC-123]");
			String plateNumber = scan.nextLine();	
			PlateValidator objPlateValidator = new PlateValidator(plateNumber);
			if(objPlateValidator.validate()){
				this._plateNumber = plateNumber;
				message = "<< The plate number is valid. Ok. >>";
				//System.out.println("<< The plate number is valid. Ok. >>");
				System.out.println("****************************************************");
				//scan.close();
			}else{
				message = "<< The plate number is invalid. >>";
				System.out.println(message);
			}
		}
		return message;
	}
	
	public String validateDate(){
		String message="";
		while(this._dateCar == null){	
			System.out.println("****************************************************");
			System.out.println("Please insert the date. e.g. [20/06/2010]");
			String date = scan.nextLine();	
			objDateValidator = new DateValidator(date);
			if(objDateValidator.validate()){				
				this._dateCar = date;
				message = "<< The date is valid. Ok. >>";
				//System.out.println("<< The date is valid. Ok. >>");				
				//scan.close();
			}else{				
				message = "<< The date is invalid. >>";
				System.out.println(message);				
			}
		}
		return message;
	}	
	public String validateTime(){	
		String message="";
		while(this._timeCar == null){
			System.out.println("****************************************************");
			System.out.println("Please insert the time. e.g.: [04:45] 24-hrs (hh:mm)");
			String time = scan.nextLine();	
			TimeValidator objTimeValidator = new TimeValidator(time);
			if(objTimeValidator.validate()){				
				this._timeCar = time;
				message="<< The time is valid. Ok. >>";
				//System.out.println("<< The time is valid. Ok. >>");				
				//scan.close();
			}else{			
				message = "<< The time is invalid. >>";
				System.out.println(message);				
			}
		}
		return message;
	}	
}
