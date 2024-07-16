class Main{
		
	public static void main(String[] args){
		Matriz mat1;
		int det;
		long inicio, fim, resultado;	
		int ordem;
		ordem= 9;
		mat1 = new Matriz(ordem, ordem);
		mat1.inicializaRandomico();

		mat1.AchaColunaComMainZero();
		mat1.AchaLinhaComMainZero();
		
		mat1.imprime();
		inicio = System.nanoTime();
		det = mat1.determinante();
		fim = System.nanoTime();
		resultado = fim - inicio;
		System.out.println(det);
		System.out.println(resultado);
		mat1.AchaColunaComMainZero();
		mat1.AchaLinhaComMainZero();
		
		
		/*
		
		array com as ordens [3,5,7,9,11,13]
		
		enquanto tiver ordem no array faca
			ordemMatriz = ordemDaVez
			
		 	para cada ordem faca
		 		cria a matriz com a ordem
		 		para cara repeticao faca	
		 			inicializa randomicamente com a ordem	
		 			calculaDet com metodoBase
		 			calculaDet com otimiV1
		 			calculaDet com otimiV2
		 		fim-para
		 	fim-para	
		 		

		*/


	}

}
