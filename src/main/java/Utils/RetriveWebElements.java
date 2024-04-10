package Utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClasses.BaseTest;

public class RetriveWebElements {
	
	
	public WebElement getWebElement(String WebElementType, String WebElementValue) {
   
		switch(WebElementType) {
		
		case "xpath":
			return BaseTest.driver.findElement(By.xpath(WebElementValue));
		case "id":
			return BaseTest.driver.findElement(By.id(WebElementValue));	
		case "name":
			return BaseTest.driver.findElement(By.name(WebElementValue));
		case "classname":
			return BaseTest.driver.findElement(By.className(WebElementValue));
		case "tagname":
			return BaseTest.driver.findElement(By.tagName(WebElementValue));
		case "linktext":
			return BaseTest.driver.findElement(By.linkText(WebElementValue));
		case "partiallinktext":
			return BaseTest.driver.findElement(By.partialLinkText(WebElementValue));
		case "cssselector":
			return BaseTest.driver.findElement(By.cssSelector(WebElementValue));
		default:
			return null;
			
		}
		
	}
	
	public List<WebElement> getWebElements(String WebElementType, String WebElementValue) {
		   
		switch(WebElementType) {
		
		case "xpath":
			return BaseTest.driver.findElements(By.xpath(WebElementValue));
		case "id":
			return BaseTest.driver.findElements(By.id(WebElementValue));	
		case "name":
			return BaseTest.driver.findElements(By.name(WebElementValue));
		case "classname":
			return BaseTest.driver.findElements(By.className(WebElementValue));
		case "tagname":
			return BaseTest.driver.findElements(By.tagName(WebElementValue));
		case "linktext":
			return BaseTest.driver.findElements(By.linkText(WebElementValue));
		case "partiallinktext":
			return BaseTest.driver.findElements(By.partialLinkText(WebElementValue));
		case "cssselector":
			return BaseTest.driver.findElements(By.cssSelector(WebElementValue));
		default:
			return null;
			
		}
		
	}


}
