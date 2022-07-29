package window_application;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class Test_10_UploadFile {

	private static WindowsDriver<WindowsElement> session = null;

	@Test
	public static void test_uploadFile() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app", "C:\\Windows\\System32\\mspaint.exe");
		capabilities.setCapability("deviceName", "WindowsPC");
		session = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capabilities);
		session.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		String filePath = System.getProperty("user.dir")+"\\Include\\UploadFile\\Sample.png" ;
		System.out.println(filePath);		
		
		//Upload File
		session.findElementByName("File tab").click();
		session.findElementByName("Open").click();
		session.findElementByClassName("Edit").sendKeys(filePath); // class name = Edit
		Thread.sleep(5000);
		session.findElementByName("Open").sendKeys(Keys.chord(Keys.ENTER)); // Work perfectly
//		session.findElementByName("Open").click(); // Click doesn't work 
				
	}
}
