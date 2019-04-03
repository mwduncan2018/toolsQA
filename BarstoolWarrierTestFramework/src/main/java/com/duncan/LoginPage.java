package com.duncan;

import org.openqa.selenium.By;

public class LoginPage {

	public static String url = "http://localhost:54070/Login/Index";

	public static void goTo() {
		Driver.instance.get(url);
	}

	public static LoginCommand loginAs(String username) {
		return new LoginCommand(username);
	}

	public static class LoginCommand {
		private static String commandUsername = "";
		private static String commandPassword = "";

		public LoginCommand(String username) {
			commandUsername = username;
		}

		public LoginCommand withPassword(String password) {
			commandPassword = password;
			return this;
		}

		public void login() {
			Driver.instance.findElement(By.id("Username")).sendKeys(commandUsername);
			Driver.instance.findElement(By.id("Password")).sendKeys(commandPassword);
			Driver.instance.findElement(By.id("btnLogin")).click();
			commandUsername = "";
			commandPassword = "";
		}
	}

	public static String getValidationSummary() {
		return Driver.instance.findElement(By.id("errorMessageInvalidUsernamePassword")).getText();
	}

	public static String getUsernameValidationMessage() {
		return Driver.instance.findElement(By.cssSelector("[name='Username'] + span")).getText();
	}

	public static String getPasswordValidationMessage() {
		return Driver.instance.findElement(By.cssSelector("[name='Password'] + span")).getText();
	}
}
