package shinoamakusa.selenium.pages;

import shinoamakusa.selenium.framework.drivers.BrowserDriver;
import shinoamakusa.selenium.framework.drivers.DriverType;

public class BrowserPage {
	protected BrowserDriver driver;
	protected String sourceHTML;
	protected String title;
	protected String url;
	protected String urlPart;
	
	public BrowserPage()
	{
		driver =  new BrowserDriver(DriverType.Chrome);
	}
	
	public void close()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	
	public boolean isValidPage()
	{
		return driver.urlContains(this.urlPart);
	}
	
	public void open()
	{
		driver.open();
	}

}
