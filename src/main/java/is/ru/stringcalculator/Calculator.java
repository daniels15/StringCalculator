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
			if (!numbers.contains(",") && !numbers.contains("\n"))
			{
				if (numbers.contains("-"))
				{
					System.out.print("Negatives not allowed: " + numbers);
					throw new IllegalArgumentException("Negatives not allowed: " + numbers);
				}
				return toInt(numbers);
			}
			else
			{
				String[] nums = numbers.split("[,\n]");
				checkNegatives(nums);
				return sum(nums);
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

	private static void checkNegatives(String[] nums)
	{
		String negatives = "";
		for (String number : nums)
		{
			if (number.contains("-"))
			{
				negatives += number;
				negatives += ",";
			}
		}

		if (!negatives.equals(""))
		{
			System.out.print("Negatives not allowed: " + negatives);
			throw new IllegalArgumentException("Negatives not allowed: " + negatives);
		}
	}
}