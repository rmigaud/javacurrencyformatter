package hackerrank.javacurrencyformatter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JavacurrencyformatterApplicationTests {

	@Test
	void contextLoads() {
		assertEquals(true, true);
	}

	@Test
	void exampleOne() {

		assertEquals(new String[]{
				"US: $12,324.13",
				"India: Rs.12,324.13",
				"China: ￥12,324.13",
				"France: 12 324,13 €"}, formattedPayment(12324.134));
	}

	private String[] formattedPayment(double payment) {
		String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
		String india = NumberFormat.getCurrencyInstance(new Locale("en" ,"in", "Rs.")).format(payment);
		String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
		String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
		return new String[] {us, india, china, france};
	}
}
