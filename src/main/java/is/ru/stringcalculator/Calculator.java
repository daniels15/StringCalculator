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
				return Integer.parseInt(numbers);
			}
			return -1;
		}
	}
}