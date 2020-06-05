package demoMethodologie;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class TestCalculatrice
{
	Calculatrice calculatrice;
	
	@BeforeEach
	public void beforeEach()
	{
		System.out.println("Initialisation");
		calculatrice = new Calculatrice();
	}
	
	@Test
	public void testAddition()
	{
		System.out.println("Addition");
		int a = 6, b = 10;

		assertTrue(calculatrice.additionner(a, b) == 16, "Devrait être true");
	}
	
	@Test
	@Timeout(value = 1, unit = TimeUnit.MILLISECONDS)
	public void testDivisionParZero()
	{
		System.out.println("Division par zéro");
		String expectedMessage = "/ by zero";
		
		Exception exception = assertThrows(ArithmeticException.class, () ->
											{
												int a = 6, b = 0;
												calculatrice.diviser(a, b);
											},
											"Une ArithmeticException aurait du survenir");

		assertTrue(exception.getMessage().contains(expectedMessage));
	}
	
	@AfterEach
	public void afterEach()
	{
		System.out.println("Nettoyage\n");
		calculatrice = null;
	}
}
