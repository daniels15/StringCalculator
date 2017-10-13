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
				int total = 0;
				for (String number : twoNumbers)
				{
					total += toInt(number);
				}
				return total;
			}
		}
	}

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}
}