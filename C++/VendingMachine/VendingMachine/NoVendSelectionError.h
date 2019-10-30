#pragma once
#include <stdexcept>

class NoVendSelectionError final : std::logic_error
{
public:
	explicit NoVendSelectionError()
		: logic_error("No rail has been selected to vend")
	{
	}
};

