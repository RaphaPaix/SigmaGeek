package Pi;

import java.math.BigDecimal;

public class Palindromo5 {
	public static void main(String[] args) {
		Pi pi = new Pi();
		int n=40;
		pi.pi(n);
		BigDecimal bigDecimal = pi.getValor();
		System.out.println(bigDecimal);
	}
}
