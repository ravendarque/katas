#pragma once
#include <stdexcept>

class InsufficientCreditError final : std::logic_error
{
public:
	explicit InsufficientCreditError()
		: logic_error("Insufficient credit for transaction")
	{
	}
};
