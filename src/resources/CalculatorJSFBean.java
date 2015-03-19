package resources;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value ="calculator")
@ViewScoped
public class CalculatorJSFBean implements Serializable{
	private double number1;
	private double number2;
	private double result;
	
	public CalculatorJSFBean() {
		
	}

	public double getNumber1() {
		return number1;
	}

	public void setNumber1(double number1) {
		this.number1 = number1;
	}

	public double getNumber2() {
		return number2;
	}

	public void setNumber2(double number2) {
		this.number2 = number2;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
	public void add() {
		result = number1 + number2;
	}
	
	public void subtract() {
		result = number1 - number2;
	}
	
	public void multiply() {
		result = number1 * number2;
	}
	
	public void divide() {
		result = number1 / number2;
	}
}
