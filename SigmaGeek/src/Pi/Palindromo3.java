package Pi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Palindromo3 {
	public static void main(String[] args) {
		//vamos utilizar o método de Nilakantha
		MathContext mc = new MathContext(2000);
		BigDecimal pi = new BigDecimal(0, mc);
		BigDecimal soma3 = new BigDecimal(3);
		BigDecimal mult4 = new BigDecimal(4);
		BigDecimal soma2 = new BigDecimal(2);
		System.out.println("Calculando pi: ");
		int maisoumenos=0;
		for(int i=0;i<=10000000;i+=2) { //20min - 100 milhoes
			BigDecimal i2 = new BigDecimal(i+2);
			BigDecimal i3 = new BigDecimal(i+3);
			BigDecimal i4 = new BigDecimal(i+4);
			BigDecimal divisor = (i2.multiply(i3)).multiply(i4);
			//System.out.println(divisor);
			BigDecimal x = mult4.divide(divisor, mc);
			//System.out.println(x);
			if(maisoumenos%2==0) { //soma
				pi=pi.add(x);
				maisoumenos++;
			}else { //subtrai
				pi=pi.subtract(x);
				maisoumenos++;
			}
		}
		BigDecimal pifinal = pi.add(soma3);
		System.out.println(pifinal);
	}
}
