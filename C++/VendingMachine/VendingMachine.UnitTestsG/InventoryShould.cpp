#include "pch.h"
#include "../VendingMachine/Inventory.h"

TEST(InventoryShould, ProvideEmptyInventoryListWhenNoItemsInInventory)
{
	const Inventory test_inventory;

	const auto actual_inventory_list = test_inventory.GetItems();

	EXPECT_TRUE(actual_inventory_list.empty());
}

TEST(InventoryShould, ProvideOneItemInInventoryListWhenOneItemIsInInventory)
{
	const std::string dummy_display_name = "Test Item";
	const double dummy_price = 1;

	Item test_item(dummy_display_name, dummy_price);

	Inventory inventory;
	inventory.AddItem(test_item);
	const auto actual_inventory_list = inventory.GetItems();

	EXPECT_EQ(actual_inventory_list.size(), 1);
	EXPECT_EQ(actual_inventory_list[0], &test_item);
}

TEST(InventoryShould, ProvideEmptyInventoryListWhenOneItemIsAddedThenRemoved)
{
	const std::string dummy_display_name = "Test Item";
	const double dummy_price = 1;

	Item test_item(dummy_display_name, dummy_price);

	Inventory inventory;
	inventory.AddItem(test_item);
	inventory.RemoveItem(test_item);
	const auto actual_inventory_list = inventory.GetItems();

	EXPECT_TRUE(actual_inventory_list.empty());
}
