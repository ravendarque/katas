#pragma once
#include <stdexcept>

class InsufficientCreditException final : std::logic_error
{
public:
	explicit InsufficientCreditException()
		: logic_error("Insufficient credit for transaction")
	{
	}
};
