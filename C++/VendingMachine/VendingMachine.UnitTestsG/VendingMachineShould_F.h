#pragma once
#include "gtest/gtest.h"
#include "../VendingMachine/VendingMachine.h"

class VendingMachineShould_F :
	public testing::Test
{
protected:
	static VendingMachine BuildTestVendingMachine();
};

static const std::string TEST_IN_STOCK_RAIL_CODE = "T1";
static const std::string TEST_IN_STOCK_LABEL = "In stock";

static const std::string TEST_IN_STOCK_EXPENSIVE_RAIL_CODE = "T2";
static const std::string TEST_IN_STOCK_EXPENSIVE_LABEL = "Expensive";

static const std::string TEST_OUT_OF_STOCK_RAIL_CODE = "T3";
static const std::string TEST_OUT_OF_STOCK_LABEL = "Out of stock";

