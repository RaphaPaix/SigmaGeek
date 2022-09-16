package Pi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Palindromo5 {
	private static final List<Integer> primos = new ArrayList<Integer>();
	private static final List<Integer> palindromosprimos = new ArrayList<Integer>();
	public static void main(String[] args) {
		Pi pi = new Pi();
		int n=130000; //primeiro Palindromo Primo foi encontrado na iteraçao 129080
		pi.pi(n);
		BigDecimal bigDecimal = pi.getValor();
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
	    //agora vamos encontrar numeros primos em grupos de 9 em 9 e adicionar em uma lista
	    //criar um vetor de posiçao para auxiliar
	    int pp=0;
	    int[] posicao = new int[dPi.length];
	    for(int i=0;i<(dPi.length-8);i++) { //pode ser que o primeiro numero seja 0, 
	    	//mas todo numero terminado em zero é par, entao nao impora
	    	//todo numero terminado em par é divisivel por 2
	    	//se começa ou termina em par, nao pode ser palindromo primo
	    	if(dPi[i]%2==0||dPi[i+8]%2==0) {
	    		continue;
	    	}else {
		    	//para agilizar o processo: conferimos se é palindromo antes
		    	if(dPi[i]==dPi[i+8]) {
		    		if(dPi[i+1]==dPi[i+7]) {
		    			if(dPi[i+2]==dPi[i+6]) {
		    				if(dPi[i+3]==dPi[i+5]) {
		    			    	int numeroTeste = (100000000*dPi[i])+(10000000*dPi[i+1])+(1000000*dPi[i+2])+
		    			    			(100000*dPi[i+3])+(10000*dPi[i+4])+(1000*dPi[i+5])+
		    			    			(100*dPi[i+6])+(10*dPi[i+7])+(1*dPi[i+8]);
		    		    		palindromosprimos.add(numeroTeste);
		    		    		posicao[pp]=i;
		    		    		pp++;
		    				}else {
		    					continue;
		    				}
		    			}else {
		    				continue;
		    			}
		    		}else {
		    			continue;
		    		}
		    	}else {
		    		continue;
		    	}
	    	}
	    }
	    //imprimindo lista do palindromo5 e sua posicao
	    if(palindromosprimos.isEmpty()) {
	    	System.out.println("Palindromo não encontrado");
	    }else {
	    	for(int i=0;i<palindromosprimos.size();i++) {
	    		int palindromo = palindromosprimos.get(i);
	    		int p = posicao[i];
	    		if(ehPrimo(palindromo)) {
	    			System.out.println("O primeiro palindromo de Pi é o numero: "+palindromo);
	    			System.out.println("Ocorreu na iteração: "+p);
	    		}
	    	}
	    }
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
