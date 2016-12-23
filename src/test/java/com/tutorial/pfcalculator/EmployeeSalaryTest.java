package com.tutorial.pfcalculator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class EmployeeSalaryTest {

	EmployeeSalary salaryObj1;
	EmployeeSalary salaryObj2;
	EmployeeSalary salaryObj3;
	EmployeeSalary salaryObj4;
	EmployeeSalary salaryObj5;
	EmployeeSalary salaryObj6;
	EmployeeSalary salaryObj7;
	
	EmployeeSalaryService salaryService;
	
	@Before
	public void init(){
		salaryObj1 = Mockito.mock(EmployeeSalary.class);
		when(salaryObj1.getGrossSalary()).thenReturn(11000.0);
		salaryObj2 = Mockito.mock(EmployeeSalary.class);
		when(salaryObj2.getGrossSalary()).thenReturn(123456.0);
		salaryObj3 = Mockito.mock(EmployeeSalary.class);
		when(salaryObj3.getGrossSalary()).thenReturn(6234.0);
		salaryObj4 = Mockito.mock(EmployeeSalary.class);
		when(salaryObj4.getGrossSalary()).thenReturn(3000.0);
		salaryObj5 = Mockito.mock(EmployeeSalary.class);
		when(salaryObj5.getGrossSalary()).thenReturn(0.0);
		salaryObj6 = Mockito.mock(EmployeeSalary.class);
		when(salaryObj6.getGrossSalary()).thenReturn(-12.0);
		salaryObj7 = Mockito.mock(EmployeeSalary.class);
		when(salaryObj7.getBasicSalary()).thenReturn(10000.0);
		salaryService = new EmployeeSalaryService();
	}

	/**
	 * Test for the scenario: if gross salary is
	 * greater than 10000, basic salary should be 
	 * 40% of the gross
	 */
	@Test
	public void basicSalaryVerificationTest(){
		
		double basic1 = salaryService.calculateBasicSalary(salaryObj1);
		assertEquals(4400.0, basic1, 0.001);
		
		double basic2 = salaryService.calculateBasicSalary(salaryObj2);
		assertEquals(49382.4, basic2, 0.001);
		
		
	}
	@Test
	public void basicSalaryverificationTest2(){
		
		double basic3 = salaryService.calculateBasicSalary(salaryObj3);
		assertEquals(1246.8, basic3, 0.001);
		
		double basic4 = salaryService.calculateBasicSalary(salaryObj4);
		assertEquals(600.0, basic4, 0.001);
		
	} 
	
	/*Test if some one have gross salary zero then basic pay must be zero.*/
	@Test
	public void testBasicVerficationTest3(){
		double basic5 = salaryService.calculateBasicSalary(salaryObj5);
		assertEquals(0.0, basic5, 0.001);
	}
	
	/*Test if gross salary is negative then basic pay must be zero*/
	@Test
	public void testBasicVerficationTest4(){
		double basic6 = salaryService.calculateBasicSalary(salaryObj6);
		assertEquals(0.0, basic6, 0.001);
	}
	
	
	@Test
	 public void testGrossSalaryonLoanAmount(){
		double grossSalary= salaryService.calculateGrossSalary(salaryObj4,1000.0);
		assertEquals(2000.0, grossSalary, 0.01);
		
		double grossSalary1= salaryService.calculateGrossSalary(salaryObj4,4000.0);
		assertEquals(-1000.0, grossSalary1, 0.01);
	}
	
	/**
	 * PF is 12% of basic
	 * 
	 * */
	@Test
	public void calculatePF(){
		double pf = salaryService.getPF(salaryObj7); 
		assertEquals(1200, pf, 0.001);
	}
	
	@Test(expected = NullPointerException.class)
	public void calculatePF_exception(){
		
		double pf1 = salaryService.getPF(null); 
	}
	
	@Test
	public void calculatePF1(){
		double pf = salaryService.getPF(salaryObj7); 
		assertNotEquals(1200, pf, 0.001);
	}
	
}
