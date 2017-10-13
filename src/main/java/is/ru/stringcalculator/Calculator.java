package is.ru.stringcalculator;

public class Calculator
{
	public static int Add(String numbers)
	{
		if (numbers.equals(""))
		{
			return 0;
		}
		else
		{
			if (!numbers.contains(","))
			{
				return toInt(numbers);
			}
			else
			{
				String[] twoNumbers = numbers.split(",");
				return sum(twoNumbers);
			}
		}
	}

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}

	private static int sum(String[] nums)
	{
		int total = 0;
		for (String number : nums)
		{
			total += toInt(number);
		}
		return total;
	}
}