package br.edu.utfpr.model;

import java.io.Serializable;
import java.util.Date;

public class IMCBean implements Serializable{
	
	private static final float ABAIXO =  18.5f;
	private static final float NORMAL =  25;
	private static final float ACIMA =  30;
	
	private double weight;
	private double height;
	private double imc;
	private Date date;
			
	public IMCBean() {
		// TODO Auto-generated constructor stub
	}	

	public IMCBean(double weight, double height) {
		super();
		this.weight = weight;
		this.height = height;
		calculateBMI();
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void calculateBMI(){
		this.imc = weight/(height * height);
		this.date = new Date();
	}
	
	public String showCategory(){
		if(imc <= ABAIXO){
			return ("Abaixo do peso");
		}
		else if(imc <= NORMAL){
			return ("Peso Normal");
		}
		else if(imc <= ACIMA){
			return("Acima do peso");
		}
		else{
			return("Obeso");
		}
	}

}
