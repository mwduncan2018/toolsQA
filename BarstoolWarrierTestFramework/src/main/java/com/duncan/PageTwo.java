package com.duncan;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageTwo {

	public static String url = "http://localhost:54070/Alpha/PageTwo";

	public static void goTo() {
		Driver.instance.get(url);
	}

	public static Boolean isAt() {
		if (Driver.instance.findElement(By.id("pageTitle")).getText().equals("Page Two")) {
			return true;
		}
		return false;
	}
	
	public static CreateCustomerCommand createCustomer() {
		return new CreateCustomerCommand();
	}

	public static class CreateCustomerCommand {
		private static String commandFirstName = "";
		private static String commandLastName = "";
		private static String commandAge = "";
		private static String commandJob = "";
		private static String commandSalary = "";
		
		public CreateCustomerCommand withFirstName(String firstName) {
			commandFirstName = firstName;
			return this;
		}
		
		public CreateCustomerCommand withLastName(String lastName) {
			commandLastName = lastName;
			return this;
		}
		
		public CreateCustomerCommand withAge(String age) {
			commandAge = age;
			return this;
		}
		
		public CreateCustomerCommand withJob(String job) {
			commandJob = job;
			return this;
		}
		
		public CreateCustomerCommand withSalary(String salary) {
			commandSalary = salary;
			return this;
		}
		
		public void clickButtonCreate() {
			Driver.instance.findElement(By.id("FirstName")).sendKeys(commandFirstName);
			Driver.instance.findElement(By.id("LastName")).sendKeys(commandLastName);
			Driver.instance.findElement(By.id("Age")).sendKeys(commandAge);
			Driver.instance.findElement(By.id("Salary")).sendKeys(commandSalary);
			Driver.instance.findElement(By.id("Job")).sendKeys(commandJob);
			Driver.instance.findElement(By.id("btnCreate")).click();
			commandFirstName = "";
			commandLastName = "";
			commandAge = "";
			commandJob = "";
			commandSalary = "";
		}
		
		public void submit() {
			clickButtonCreate();
		}
	}

}
