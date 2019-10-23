#pragma once
#include <stdexcept>

class NoItemsInVendException final : std::logic_error
{
public:
	explicit NoItemsInVendException()
		: logic_error("No items to process in vend transaction")
	{
	}
};

