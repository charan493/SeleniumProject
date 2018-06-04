package shinoamakusa.selenium.pages.autotrader.home;

import shinoamakusa.selenium.pages.BrowserPage;
import shinoamakusa.selenium.pages.autotrader.results.ResultsPage;

public class HomePage extends BrowserPage {
	public HomePage() {
		this.urlPart = "autotrader.ca";
	}

	public void open() {
		super.open();
		String homeUrl = new StringBuilder("https://").append(this.urlPart).toString();
		driver.goTo(homeUrl);
		this.title = driver.getTitle();

	}

	public ResultsPage search(final String postalCode) {
		typePostalCode(postalCode);
		submitSearch();
		return new ResultsPage(driver);
	}
	
	public ResultsPage search(final String make, final String model, final String price, final String postalCode) {
		selectMake(make);
		selectModel(model);
		selectPrice(price);
		typePostalCode(postalCode);
		submitSearch();
		return new ResultsPage(driver);
	}

	private void selectMake(final String make) {
		driver.select(driver.findByID("rfMakes"));
		if (driver.getSelectedElement().isClickable())
			driver.selectOptionByValue(driver.getSelectedElement(), make);
	}

	private void selectModel(final String model) {
		driver.select(driver.findByID("rfModel"));
		if (driver.getSelectedElement().isClickable())
			driver.selectOptionByValue(driver.getSelectedElement(), model);
	}

	private void selectPrice(final String price) {
		driver.select(driver.findByID("rfPriceHigh"));
		if (driver.getSelectedElement().isClickable())
			driver.selectOptionByValue(driver.getSelectedElement(), price);
	}

	private void submitSearch() {
		driver.click(driver.findByID("SearchButton"));
	}

	private void typePostalCode(final String postalCode) {
		driver.select(driver.findByID("locationAddress"));
		driver.typeInto(driver.getSelectedElement(), postalCode);
	}

}
