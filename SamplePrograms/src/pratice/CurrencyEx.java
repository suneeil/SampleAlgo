package pratice;

import java.util.Currency;
import java.util.Locale;

public class CurrencyEx {

	public static void main(String[] args) {
		Currency curr = Currency.getInstance(Locale.CHINA);
		System.out.println("CurrencyCode: "+curr.getCurrencyCode());
		System.out.println("Name: "+curr.getDisplayName());
		
	}

}
