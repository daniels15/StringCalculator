package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest
{
	@Test
	public void testEmptyString()
	{
		assertEquals(0, Calculator.Add(""));
	}

	@Test
	public void testOneNumber()
	{
		assertEquals(1, Calculator.Add("1"));
		assertEquals(2, Calculator.Add("2"));
		assertEquals(205, Calculator.Add("205"));
	}

	@Test
	public void testTwoNumbers()
	{
		assertEquals(2, Calculator.Add("1,1"));
		assertEquals(1, Calculator.Add("0,1"));
		assertEquals(210, Calculator.Add("102,108"));
	}

	@Test
	public void testManyNumbers()
	{
		assertEquals(4, Calculator.Add("1,1,2"));
		assertEquals(12, Calculator.Add("0,1,4,7"));
		assertEquals(237, Calculator.Add("102,108,5,10,12"));
	}

	@Test
	public void testNewLine()
	{
		assertEquals(2, Calculator.Add("1\n1"));
		assertEquals(12, Calculator.Add("0\n1,4,7"));
		assertEquals(237, Calculator.Add("102,108\n5\n10,12"));

	}

	@Test(expected=IllegalArgumentException.class)
	public void testOneNumberNegative()
	{
		Calculator.Add("-1");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testManyNumbersNegative()
	{
		Calculator.Add("1,-3\n-5");
	}
}