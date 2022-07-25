package window_application;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class Test_02_SetText_GetText_Clear {

	  private static WindowsDriver session = null;

	   @BeforeClass
	    public static void setup() {
	        try {
	            DesiredCapabilities capabilities = new DesiredCapabilities();
	            capabilities.setCapability("app", "C:/Windows/System32/Notepad.exe");
	            capabilities.setCapability("deviceName", "WindowsPC");
	            session = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
	            session.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	            String appTitle = session.getTitle();
	            Assert.assertNotNull(appTitle);

	        }catch(Exception e){
	            e.printStackTrace();
	        } finally {
	        }
	    }

	  
	    @AfterClass
	    public static void TearDown(){  
	        if (session != null) {
	            session.quit();
	        }
	        session = null;
	    }

	    @Test
	    public void test_01_setText_getText()  {
	    	session.findElementByName("Text Editor").sendKeys("This is test from Eclipse");
	    	System.out.println("==> " +session.findElementByName("Text Editor").getText());
	    }
	    
	    @Test
	    public void test_02_clear() throws InterruptedException {
	    	Thread.sleep(2000);
	    	session.findElementByName("Text Editor").clear();
	    	Thread.sleep(2000);
	    }
}

