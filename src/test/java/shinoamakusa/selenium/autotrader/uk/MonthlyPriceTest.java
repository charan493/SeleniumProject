package shinoamakusa.selenium.autotrader.uk;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class MonthlyPriceTest extends BaseTest {

	@Test(invocationCount = 1)
	public void monthlyPriceTest() {

		homepage.typePostalCode(postalCode);
		homepage.selectRadius(radius);
		homepage.selectNearlyNew(selectNearlyNew);
		homepage.selectNew(selectNew);
		homepage.selectMake(make);
		homepage.selectModel(model);
		homepage.selectMonthlyPrice();

		resultsPage = homepage.submitSearch();

		assertTrue(resultsPage.isValidPage());
		assertTrue(resultsPage.countContains(homepage.searchCount()));
		assertTrue(resultsPage.isRadiusSelected(radius));
		assertTrue(resultsPage.isPostalCode(postalCode));
		assertTrue(resultsPage.isMakeSelected(make));
		assertTrue(resultsPage.isModelSelected(model));

		assertTrue(resultsPage.carFiltersContain(homepage.selectedCarFilters()));

		resultsPage.selectMonthlyPriceHighest();
		assertTrue(resultsPage.isSortOrderDescending(true));

	}

}
