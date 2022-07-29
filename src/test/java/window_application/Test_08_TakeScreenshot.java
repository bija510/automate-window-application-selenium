package window_application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class Test_08_TakeScreenshot {

	private static WindowsDriver<WindowsElement> windowsDriver = null;
	
	@Test
	public void test_screenshot() throws InterruptedException, IOException {
		// 01. Open Desktop
		DesiredCapabilities rootSessionOptions = new DesiredCapabilities();
		rootSessionOptions.setCapability("app", "C:/Windows/System32/Notepad.exe");
		rootSessionOptions.setCapability("deviceName", "WindowsPC");
		windowsDriver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), rootSessionOptions);
		windowsDriver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		
		File src = ((TakesScreenshot) windowsDriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("../automate-window-application-selenium/Screenshot/"+ "DemoScreenShot" +".png"));
		
	}
}
