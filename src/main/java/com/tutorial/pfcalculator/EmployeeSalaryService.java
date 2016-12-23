package com.tutorial.pfcalculator;

public class EmployeeSalaryService {

	public double calculateBasicSalary(EmployeeSalary salaryObj) {
		
		double gross = salaryObj.getGrossSalary();
		if(gross <= 0){
			return 0.0;
		}
		if(gross > 10000)
		{
			return gross * 0.4;
		}else { 
			return gross * 0.2;
		}
		
	}

	public double calculateGrossSalary(EmployeeSalary salaryObj4, double d) {
		// TODO Auto-generated method stub
		
		double grossSalary= salaryObj4.getGrossSalary();
			return grossSalary-d;
	}

	public double getPF(EmployeeSalary salaryObj7) {
		// TODO Auto-generated method stub
		
		return salaryObj7.getBasicSalary()*0.12;
	}

}
