#pragma once
#include <stdexcept>

class RailEmptyError final : std::logic_error
{
public:
	explicit RailEmptyError()
		: logic_error("Rail is empty")
	{
	}
};
