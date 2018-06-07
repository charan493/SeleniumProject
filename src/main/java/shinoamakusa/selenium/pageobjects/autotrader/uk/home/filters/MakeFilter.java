package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.StaleElementReferenceException;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.PageElement;
import shinoamakusa.selenium.core.elements.SelectElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class MakeFilter extends BaseFilter {
	public MakeFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByName("make");
	}

	public String getCount(String make) {
		return StringUtils.substringBetween(container.findByAttribute("value", make).getText(), "(", ")");
	}

	public void select(String make) {
		try {
			if (container.isClickable()) {
				PageElement makeOption = container.findByAttribute("value", make);
				if (makeOption.exists()) {
					new SelectElement(container).selectOptionByValue(make);
				}
			}
		} catch (StaleElementReferenceException e) {
			select(make);
		}

	}

}