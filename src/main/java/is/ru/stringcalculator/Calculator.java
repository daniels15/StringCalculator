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
			String delimiter = "";
			if (numbers.startsWith("//"))
			{
				String[] delimiterSplit = numbers.split("\n", 2);
				delimiter = delimiterSplit[0];
				delimiter = delimiter.replace("//", "");
				numbers = delimiterSplit[1];
			}
			
			String[] nums = numbers.split("[" + delimiter + ",\n]");
			checkNegatives(nums);
			return sum(nums);
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
			if (toInt(number) > 1000)
			{
				number = "0";
			}
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
				negatives += ",";
				negatives += number;
			}
		}

		if (!negatives.equals(""))
		{
			negatives = negatives.replaceFirst(",", "");
			throw new IllegalArgumentException("Negatives not allowed: " + negatives);
		}
	}
}