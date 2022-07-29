package window_application;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class Test_11_Keyboard_Action {

	private static WindowsDriver<WindowsElement> session = null;

	/****************************************************************************************
	 * For More : https://www.tabnine.com/code/java/methods/org.openqa.selenium.Keys/chord
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 ****************************************************************************************/
	@Test
	public static void test_uploadFile() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app", "C:/Windows/System32/Notepad.exe");
		capabilities.setCapability("deviceName", "WindowsPC");
		session = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capabilities);
		session.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		Thread.sleep(2000);
		session.findElementByName("File").sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)); 	
		Thread.sleep(2000);
		
		session.findElementByName("Cancel").click();
		session.findElementByName("File").sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)); 	
	}

}
