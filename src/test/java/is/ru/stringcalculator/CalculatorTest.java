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
		Calculator.Add("1,-4\n-5,2,-100");
	}

	@Test
	public void testManyNumbersOver1000()
	{
		assertEquals(1, Calculator.Add("1,1001"));
	}

	@Test
	public void testOneNumberOver1000()
	{
		assertEquals(0, Calculator.Add("1001"));
	}

	@Test
	public void testCustomDelimiter()
	{
		assertEquals(3, Calculator.Add("//;\n1;2"));
		assertEquals(1, Calculator.Add("//;\n1"));
		assertEquals(11, Calculator.Add("//;\n1,2;3\n5"));
		assertEquals(11, Calculator.Add("//x\n1,2x3\n5"));
	}
}