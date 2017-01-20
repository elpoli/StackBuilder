package picoplaca;

public class PlateValidator extends DataValidator{

	private String _plateNumber;

	public String get_plateNumber() {
		return _plateNumber;
	}
	public void set_plateNumber(String _plateNumber) {
		this._plateNumber = _plateNumber;
	}
	
	public PlateValidator(String plateNumber){
		this._plateNumber = plateNumber;
	}
	
	@Override
	public boolean validate() {
		//validate plateNumber
		if((this._plateNumber.length() ==7) && (Character.isLetter(_plateNumber.charAt(0)) && Character.isLetter(_plateNumber.charAt(1)) 
		  && Character.isLetter(_plateNumber.charAt(2))) && _plateNumber.charAt(3)=='-' &&  (Character.isDigit(_plateNumber.charAt(4)) 
		  && Character.isDigit(_plateNumber.charAt(5)) && Character.isDigit(_plateNumber.charAt(6)))){
			return true;				
		}else if ((this._plateNumber.length() ==8) && (Character.isLetter(_plateNumber.charAt(0)) && Character.isLetter(_plateNumber.charAt(1)) 
		 && Character.isLetter(_plateNumber.charAt(2))) && _plateNumber.charAt(3)=='-' &&  (Character.isDigit(_plateNumber.charAt(4)) 
		 && Character.isDigit(_plateNumber.charAt(5)) && Character.isDigit(_plateNumber.charAt(6)) && Character.isDigit(_plateNumber.charAt(7)))){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public String convert() {		
		return null;
	}
	
}
