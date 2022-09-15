package Pi;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Palindromo2 {
	public static void main(String[] args) {
		BigDecimal pi = new BigDecimal(0).setScale(2000);
		BigDecimal mult = new BigDecimal(4);
		System.out.println("Calculando o Pi: ");
		for(int i=0;i<10000000;i++) { //é necessario 5 bilhoes de termos pois converge lentamente
			BigDecimal indice = new BigDecimal(i);
			BigDecimal menosum = new BigDecimal(-1);
			BigDecimal maisum = new BigDecimal(1);
			BigDecimal maisdois = new BigDecimal(2);
			BigDecimal doisindice = maisdois.multiply(indice);
			BigDecimal div = doisindice.add(maisum);
			BigDecimal menosumelevado = menosum.pow(i);
			pi=pi.add(menosumelevado.divide(div, 2000, RoundingMode.HALF_EVEN));
		}
		BigDecimal pifinal = mult.multiply(pi);
		System.out.println(pifinal);
	}
}
