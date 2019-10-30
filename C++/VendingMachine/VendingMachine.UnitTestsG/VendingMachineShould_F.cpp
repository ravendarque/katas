#include "pch.h"
#include "VendingMachineShould_F.h"

VendingMachine VendingMachineShould_F::BuildTestVendingMachine()
{
	const double testInStockPrice = 1;
	const unsigned int testInStockInitialInventory = 1;

	const double testInStockExpensivePrice = 9;
	const unsigned int testInStockExpensiveInitialInventory = 1;

	const double testOutOfStockPrice = 1;
	const unsigned int testOutOfStockInitialInventory = 0;

	RailsConfiguration testRailsConfiguration;

	const RailConfigurationSettings testInStockSettings(TEST_IN_STOCK_RAIL_CODE,
	                                                    testInStockPrice,
	                                                    testInStockInitialInventory,
	                                                    TEST_IN_STOCK_LABEL);
	testRailsConfiguration.Add(testInStockSettings);

	const RailConfigurationSettings testInStockExpensiveSettings(TEST_IN_STOCK_EXPENSIVE_RAIL_CODE,
	                                                             testInStockExpensivePrice,
	                                                             testInStockExpensiveInitialInventory,
	                                                             TEST_IN_STOCK_EXPENSIVE_LABEL);
	testRailsConfiguration.Add(testInStockExpensiveSettings);

	const RailConfigurationSettings testOutOfStockSettings(TEST_OUT_OF_STOCK_RAIL_CODE,
	                                                       testOutOfStockPrice,
	                                                       testOutOfStockInitialInventory,
	                                                       TEST_OUT_OF_STOCK_LABEL);
	testRailsConfiguration.Add(testOutOfStockSettings);

	Rails testRails(testRailsConfiguration);

	Credit testCredit;

	VendingMachine testVendingMachine(testRails, testCredit);

	return testVendingMachine;
}
