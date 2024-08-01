import java.util.Scanner;
class Main{
	public static void main(String[] args){
		Matriz mat1;
		int det, ordem;
		long inicio, fim, resultadoAlgo1, resultadoAlgo2;	
		Scanner ler = new Scanner(System.in);

		System.out.println("ola, para testar o codigo apenas digite a ordem da matriz que vc deseja calcula");
		System.out.println("caso queria encerrar o programa digite 0 e de enter");
		System.out.println("digite a ordem da matriz:");
		ordem = ler.nextInt();

		while (ordem !=0) {		
			
			mat1 = new Matriz(ordem, ordem);
			mat1.inicializaRandomico();
			mat1.imprime();
			
			inicio = System.nanoTime();
			det = mat1.determinante();
			fim = System.nanoTime();
			resultadoAlgo1 = fim - inicio;
			System.out.println("codigo sem melhoria");
			System.out.println(det);
			System.out.println(resultadoAlgo1);

			System.out.println();
		
			inicio = System.nanoTime();
			det = mat1.determinanteOtimizado();
			fim = System.nanoTime();
			resultadoAlgo2 = fim - inicio;
			System.out.println("codigo com melhoria");
			System.out.println(det);		
			System.out.println(resultadoAlgo2);

			System.out.println("o algoritimo com melhoria foi mais rapido em: "+(resultadoAlgo1-resultadoAlgo2)+" nano segundos");
			System.out.println("digite a ordem da matriz a ser testada:");
			ordem = ler.nextInt();
		}
		ler.close();
	}
}
