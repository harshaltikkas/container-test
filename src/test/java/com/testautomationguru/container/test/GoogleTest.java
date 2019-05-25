package com.testautomationguru.container.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testautomationguru.container.pages.GooglePage;

import junit.framework.Assert;

public class GoogleTest {
	private WebDriver driver;
	private GooglePage google;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		String username="htikkas%40intraedge.com";
		String authKey="ua73df97ace2ec4a";
		driver = new RemoteWebDriver(new URL("http://" + username + ":" + authKey + "@hub.crossbrowsertesting.com:80/wd/hub"), dc);
		google = new GooglePage(driver);
	}

	@Test
	public void googleTest() throws InterruptedException {
		google.goTo();
		google.searchFor("automation");
		Assert.assertTrue(google.getResults().size() >= 10);
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}
