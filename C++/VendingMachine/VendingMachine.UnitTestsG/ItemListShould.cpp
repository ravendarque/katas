#include "pch.h"
#include "../VendingMachine/ItemList.h"

TEST(ItemListShould, ProvideEmptyItemListListWhenNoItemsInItemList)
{
	const ItemList testItemList;

	const auto actualItemListList = testItemList.GetItems();

	EXPECT_TRUE(actualItemListList.empty());
}

TEST(ItemListShould, ProvideOneItemInItemListListWhenOneItemIsInItemList)
{
	const std::string dummyDisplayName = "Test Item";
	const double dummyPrice = 1;

	const Item testItem(dummyDisplayName, dummyPrice);

	ItemList testItemList;
	testItemList.AddItem(testItem);
	const auto actualItemListList = testItemList.GetItems();

	EXPECT_EQ(actualItemListList.size(), 1);
	EXPECT_EQ(actualItemListList[0], testItem);
}

TEST(ItemListShould, ProvideEmptyItemListListWhenOneItemIsAddedThenRemoved)
{
	const std::string dummyDisplayName = "Test Item";
	const double dummyPrice = 1;

	const Item testItem(dummyDisplayName, dummyPrice);

	ItemList testItemList;
	testItemList.AddItem(testItem);
	testItemList.RemoveItem(testItem);
	const auto actualItemListList = testItemList.GetItems();

	EXPECT_TRUE(actualItemListList.empty());
}
