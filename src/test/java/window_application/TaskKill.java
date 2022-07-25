package window_application;

import java.io.IOException;
import org.testng.annotations.Test;

public class TaskKill {

	@Test
	public void test_taskill() throws IOException {
		Runtime run = Runtime.getRuntime();    
		run.exec("taskkill /F /IM WinAppDriver.exe");
	}
}
