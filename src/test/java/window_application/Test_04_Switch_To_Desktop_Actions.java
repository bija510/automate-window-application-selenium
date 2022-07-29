package window_application;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class Test_04_Switch_To_Desktop_Actions {

	 private static WindowsDriver windowsDriver = null;
	 
	 @Test
	public void test_switch_to_desktop() throws MalformedURLException, InterruptedException {
		// 01. Open Desktop
		DesiredCapabilities rootSessionOptions = new DesiredCapabilities();
		rootSessionOptions.setCapability("app", "Root");
		rootSessionOptions.setCapability("deviceName", "WindowsPC");
		windowsDriver = new WindowsDriver(new URL("http://127.0.0.1:4723"), rootSessionOptions);
		windowsDriver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
				
		Actions action = new Actions(windowsDriver);
		action.moveToElement(windowsDriver.findElementByName("Postman"));
		action.contextClick();
		action.perform();
		Thread.sleep(2000);
	}
}
