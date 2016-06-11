import java.io.Serializable;
/**
 * Класс в которм храним модель и номер машин.
 * Вылетало IOException, пока не сделал implements Serializable
 * 
 * @author Slatin Vadim
 */
public class Car implements Serializable {
	private String carModel;  
	private String carNumber; 
		
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
}
