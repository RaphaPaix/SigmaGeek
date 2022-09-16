package Pi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Palindromo5 {
	private static final List<Integer> primos = new ArrayList<Integer>();
	private static final List<Integer> palindromosprimos = new ArrayList<Integer>();
	public static void main(String[] args) {
		Pi pi = new Pi();
		int n=1000;
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
	    //agora vamos encontrar numeros primos em grupos de 9 em 9 e adicionar em uma lista
	    System.out.println(dPi.length);
	    //criar um vetor de posiçao para auxiliar
	    int p=0;
	    int[] posicao = new int[dPi.length];
	    for(int i=0;i<(dPi.length-8);i++) { //pode ser que o primeiro numero seja 0, 
	    	//mas todo numero terminado em zero é par, entao nao impora
	    	//todo numero terminado em par é divisivel por 2
	    	//se começa ou termina em par, nao pode ser palindromo primo
	    	if(dPi[i]%2==0||dPi[i+8]%2==0) {
	    		continue;
	    	}else {
		    	int numeroTeste = (100000000*dPi[i])+(10000000*dPi[i+1])+(1000000*dPi[i+2])+
		    			(100000*dPi[i+3])+(10000*dPi[i+4])+(1000*dPi[i+5])+
		    			(100*dPi[i+6])+(10*dPi[i+7])+(1*dPi[i+8]);
		    	//System.out.println(numeroTeste);
		    	if(ehPrimo(numeroTeste)) {
		    		primos.add(numeroTeste);
		    		posicao[p]=i;
		    		p++;
		    	}
	    	}
	    }
	    //imprimindo numeros primos e suas posiçoes:
	    for (int i=0;i<primos.size();i++) {
	    	int primo = primos.get(i);
			System.out.println("Numero: "+primo+"de posicao: "+posicao[i]);
		}
	    //agora vamos encontrar numeros palindromos dentro do conjunto de primos
	    int ppp=0;
	    int[] posicaopalindromoprimo = new int[primos.size()];
	    for (int i=0;i<primos.size();i++) {
	    	int primo = primos.get(i);
	    	//primeiro transformamos o inteiro primo em um vetor de 9 espaços
		    int[] vetorprimo = new int[9];
			//para ser palindromo, vamos inverter e conferir se fica igual
	    		vetorprimo[0]=primo/100000000;
	    		vetorprimo[1]=primo/10000000;
	    		vetorprimo[2]=primo/1000000;
	    		vetorprimo[3]=primo/100000;
	    		vetorprimo[4]=primo/10000;
	    		vetorprimo[5]=primo/1000;
	    		vetorprimo[6]=primo/100;
	    		vetorprimo[7]=primo/10;
	    		vetorprimo[8]=primo/1;
	    		if(vetorprimo[0]==vetorprimo[8]) {
	    			if(vetorprimo[1]==vetorprimo[7]) {
	    				if(vetorprimo[2]==vetorprimo[6]) {
	    					if(vetorprimo[3]==vetorprimo[5]) {
	    						palindromosprimos.add(primo);
	    						posicaopalindromoprimo[ppp]=i;
	    						ppp++;
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
	    //imprimindo lista do palindromo5 e sua posicao
	    if(palindromosprimos.isEmpty()) {
	    	System.out.println("Palindromo não encontrado");
	    }else {
	    	for(int i=0;i<palindromosprimos.size();i++) {
	    		int palindromo = palindromosprimos.get(i);
	    		int pos = posicaopalindromoprimo[i];
	    		System.out.println("Numero: "+palindromo+" de posicao: "+pos);
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
//PRECISO COM 70000 CASAS, PELO MENOS!