package Pi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Palindromo {
	public static void main(String[] args) {
		BigDecimal pi = new BigDecimal(0).setScale(1000, BigDecimal.ROUND_HALF_EVEN);;
		BigDecimal div = new BigDecimal(4);
		System.out.println("Somas: ");
		for(int i=1;i<100000;i+=4) {
			BigDecimal indice = new BigDecimal(i);
			BigDecimal divB = new BigDecimal(0);
			divB = div.divide(indice, 1000, RoundingMode.HALF_UP);
			pi=pi.add(divB);
			//System.out.println(divB);
			//System.out.println(pi);
		}
		System.out.println("Subtraçao: ");
		for(int i=3;i<100000;i+=4) {
			BigDecimal indice = new BigDecimal(i);
			BigDecimal divB = new BigDecimal(0);
			divB = div.divide(indice, 1000, RoundingMode.HALF_UP);
			pi=pi.subtract(divB);
			//System.out.println(divB);
			//System.out.println(pi);
		}
		System.out.println("Valor de pi = "+pi);
	}
}
