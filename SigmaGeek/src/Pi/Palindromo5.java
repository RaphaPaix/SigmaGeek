package Pi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Palindromo5 {
	private static final List<Integer> primos = new ArrayList<Integer>();
	private static final List<Integer> zeronoinicioenofinal = new ArrayList<Integer>();
	public static void main(String[] args) {
		Pi pi = new Pi();
		int n=100;
		pi.pi(n);
		BigDecimal bigDecimal = pi.getValor();
		System.out.println(bigDecimal);
		//obtendo tamanho de pi
		int tamanhopi = bigDecimal.toPlainString().length();
	    char[] decimaispi = bigDecimal.toPlainString().toCharArray();
	    //transformar o array char[] em array numero
	    int[] dPi = new int[decimaispi.length];
	    for(int i=0;i<decimaispi.length;i++) {
	    	switch (decimaispi[i]) {
	    	case '0':
	    		dPi[i]=0;
	    		break;
			case '1':
				dPi[i]=1;
				break;
			case '2':
				dPi[i]=2;
				break;
			case '3':
				dPi[i]=3;
				break;
			case '4':
				dPi[i]=4;
				break;
			case '5':
				dPi[i]=5;
				break;
			case '6':
				dPi[i]=6;
				break;
			case '7':
				dPi[i]=7;
				break;
			case '8':
				dPi[i]=8;
				break;
			case '9':
				dPi[i]=9;
				break;
			case '.':
				dPi[i]=0;
			default:
				break;
			}
	    }
	    //agora vamos encontrar numeros primos de 9 em 9 e adicionar em uma lista
	    System.out.println(dPi.length);
	    for(int i=0;i<(dPi.length-8);i++) { //pode ser que o primeiro numero seja 0, 
	    	//mas todo numero terminado em zero é par, entao nao impora
	 
	    	int numeroTeste = (100000000*dPi[i])+(10000000*dPi[i+1])+(1000000*dPi[i+2])+
	    			(100000*dPi[i+3])+(10000*dPi[i+4])+(1000*dPi[i+5])+
	    			(100*dPi[i+6])+(10*dPi[i+7])+(1*dPi[i+8]);
	    	System.out.println(numeroTeste);
	    	if(ehPrimo(numeroTeste)) {
	    		primos.add(numeroTeste);
	    	}
	    }
	    System.out.println(primos);
	    
	    //agora vamos encontrar numeros palindromos
	}
	private static boolean ehPrimo(int numero) {
		if(numero==0||numero==1) {
			return false;
		}
	    for (int j = 2; j < numero; j++) {
	        if (numero % j == 0)
	            return false;   
	    }
	    return true;
	}
}
//PRECISO COM 70000 CASAS, PELO MENOS!