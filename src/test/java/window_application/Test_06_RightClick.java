package window_application;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class Test_06_RightClick {

 private static WindowsDriver<WindowsElement> windowsDriver = null;
	 
	 @Test
	public void test_rightClick() throws MalformedURLException, InterruptedException {
		// 01. Open Desktop
		DesiredCapabilities rootSessionOptions = new DesiredCapabilities();
		rootSessionOptions.setCapability("app", "Root");
		rootSessionOptions.setCapability("deviceName", "WindowsPC");
		windowsDriver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), rootSessionOptions);
		windowsDriver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
				
		Actions action = new Actions(windowsDriver);
		action.moveToElement(windowsDriver.findElementByName("Postman"));
		action.contextClick();
		action.perform();
		Thread.sleep(2000);
	}
}
