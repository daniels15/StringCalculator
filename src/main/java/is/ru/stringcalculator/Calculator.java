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
			return -1;
		}
	}

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}
}