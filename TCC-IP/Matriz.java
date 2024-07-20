import java.util.Random;

public class Matriz{
	private int[][] mat;
	private int tamLinha;
	private int tamColuna;
	private int ColunaComMainZero;
	private int linhaComMaisZero;
	private int zerosColuna;
	private int zerosLinha;

	Matriz(){
		this.setTamanhoLinha(6);	
		this.setTamanhoColuna(6);
		mat = new int[this.getTamanhoLinha()][this.getTamanhoColuna()];
		setColunaComMainZeros(0);
		setLinhaComMaisZeros(0);
		setZerosColuna(0);
		setZerosLinha(0);
	}

	Matriz(int numLinhas, int numColunas){
		this.setTamanhoLinha(numLinhas);	
		this.setTamanhoColuna(numColunas);
		mat = new int[this.getTamanhoLinha()][this.getTamanhoColuna()];
	}

	private void setColunaComMainZeros(int tempColuna){
		this.ColunaComMainZero = tempColuna;
	}
	private int getColunaComMaiszeros(){
		return this.ColunaComMainZero;
	}

	private void setLinhaComMaisZeros(int tempLinha){
		this.linhaComMaisZero = tempLinha;
	}
	public int getLinhaComMaisZeros(){
		return this.linhaComMaisZero;
	}

	private void setZerosColuna(int tempZerosColuna){
		this.zerosColuna = tempZerosColuna;
	}
	private int getZerosColuna(){
		return this.zerosColuna;
	}

	private void setZerosLinha(int tempZerosLinha){
		this.zerosLinha = tempZerosLinha;
	}
	private int getZerosLinha(){
		return this.zerosLinha;
	}

	public int getValor(int indiceI,int indiceJ){
		return mat[indiceI][indiceJ];
	}	
	
	public void setValor(int indiceI,int indiceJ, int novoValor){
		mat[indiceI][indiceJ] = novoValor;
	}

	public int getTamanhoLinha(){
		return tamLinha;
	}	
	
	public int getTamanhoColuna(){
		return tamColuna;
	}	

	private void setTamanhoLinha(int novoValor){
		tamLinha = novoValor;
	}

	private void setTamanhoColuna(int novoValor){
		tamColuna = novoValor;
	}

	public void imprime(){
		int conti,contj;	
		for(conti = 0; conti < this.getTamanhoLinha(); conti++){
			System.out.println();
			for(contj = 0; contj < this.getTamanhoColuna(); contj++){
				System.out.print(this.getValor(conti,contj) + " ");
			}
		}
		System.out.println("\n");	
	}

	public void inicializaRandomico(){
		int conti,contj, novoValor;
		int ordem = this.getTamanhoLinha();
		Random gerador = new Random();
		for(conti = 0; conti < this.getTamanhoLinha(); conti++){
			for(contj = 0; contj < this.getTamanhoColuna(); contj++){
				novoValor = gerador.nextInt(ordem*ordem);
				this.setValor(conti,contj,novoValor);
			}
		}
	}

	// caso matriz nao quadrada, retorna -1
	public int retorneOrdem(){
		int ordem;
		ordem = -1;
		if(this.getTamanhoLinha() == this.getTamanhoColuna()){
			ordem = this.getTamanhoLinha();
		}

		return ordem;
	}	

	private int detOrdem1(Matriz mat){
		return mat.getValor(0,0);
	}
	
	private int detOrdem2(Matriz mat){
		int diagonalP, diagonalI;

		diagonalP = mat.getValor(0,0) * mat.getValor(1,1);		
		diagonalI = mat.getValor(1,0) * mat.getValor(0,1);		

		return (diagonalP - diagonalI);
	}

	private int calculaSinal(int indiceL, int indiceC){
		int sinal;

		sinal = -1;

		if( ((indiceL + indiceC)% 2) == 0 ){
			sinal = 1;
		}

		return sinal;		
	}

	private void copiaMatrizMaiorParaMenor(Matriz maior,Matriz menor,int isqn,int jsqn){
		int contAi,contAj,contBi,contBj,temp;

		contAi = 0;
		for(contBi = 0; contBi < menor.getTamanhoLinha(); contBi++){
			if(contAi == isqn){
				contAi++;
			}
			contAj = 0;
			for(contBj = 0; contBj < menor.getTamanhoColuna(); contBj++){
				if(contAj == jsqn){
					contAj++;
				}
				temp = maior.getValor(contAi,contAj);
				menor.setValor(contBi,contBj,temp);
				contAj++;
			}
			contAi++;
		}
	}

	private int detOrdemN(Matriz mat){
		int sinal,cofator,detTemp,resposta,contC,numL,numC;
		Matriz matmenor;
		numL = this.getTamanhoLinha();
		numC = this.getTamanhoColuna();
		
		resposta = 0;
		for(contC = 0; contC < mat.getTamanhoColuna(); contC++){
			cofator = mat.getValor(0,contC);
			sinal = this.calculaSinal(0,contC);
			matmenor = new Matriz(numL-1,numC-1);
			this.copiaMatrizMaiorParaMenor(mat,matmenor,0,contC);
			detTemp = matmenor.determinante();
			resposta = resposta + (cofator * sinal * detTemp);
		}
		return (resposta);
	}

	public int determinante(){
		int ordem,det;

		ordem = this.retorneOrdem();
		det = 0;

		if(ordem > 0){
			switch (ordem) {
			    case 1: det = this.detOrdem1(this);
					break;
			    case 2: det = this.detOrdem2(this);
					break;
			    default: det = this.detOrdemN(this);				
					break;
			}
			
		}
		else{
			System.out.println("Matriz nao eh quadrada!! retornando 0");
		}

		return det;
	}

	//inicio dos incrementos
	public int determinanteComIncremento(){
		int ordem,det;

		ordem = this.retorneOrdem();
		det = 0;

		if(ordem > 0){
			switch (ordem) {
			    case 1: det = this.detOrdem1(this);
					break;
			    case 2: det = this.detOrdem2(this);
					break;
			    default: det = this.detOrdemNComIncremento(this);				
					break;
			}
			
		}
		else{
			System.out.println("Matriz nao eh quadrada!! retornando 0");
		}

		return det;
	}

	private int detOrdemNComIncremento(Matriz mat){
		int sinal,cofator,detTemp,resposta,contC,contL;
		Matriz matmenor;
		
		this.AchaColunaComMainZero();
		this.AchaLinhaComMainZero();

		resposta = 0;
		if (this.LinhaOUcoluna()) {
			for(contC = 0; contC < mat.getTamanhoColuna(); contC++){
				cofator = mat.getValor(this.getLinhaComMaisZeros(),contC);
				if(cofator!=0){
					sinal = this.calculaSinal(this.getLinhaComMaisZeros(),contC);
					matmenor = new Matriz(this.getTamanhoLinha()-1,this.getTamanhoColuna()-1);
					this.copiaMatrizMaiorParaMenor(mat,matmenor,this.getLinhaComMaisZeros(),contC);
					detTemp = matmenor.determinante();
					resposta = resposta + (cofator * sinal * detTemp);
				}
			}			
		}
		else{
			for(contL = 0; contL < mat.getTamanhoLinha(); contL++){
				cofator = mat.getValor(contL,this.getColunaComMaiszeros());
				if(cofator!=0){
					sinal = this.calculaSinal(contL,this.getColunaComMaiszeros());
					matmenor = new Matriz(this.getTamanhoLinha()-1,this.getTamanhoColuna()-1);
					this.copiaMatrizMaiorParaMenor(mat,matmenor,contL,this.getColunaComMaiszeros());
					detTemp = matmenor.determinante();
					resposta = resposta + (cofator * sinal * detTemp);
				}
			}
		}
		return (resposta);
	}

	private void AchaColunaComMainZero(){
		int contC,contL, somatorio;
		somatorio = 0;
		for(contC = 0; contC < this.getTamanhoColuna(); contC++){
			for(contL = 0; contL < this.getTamanhoLinha(); contL++){
				if (this.getValor(contL, contC)==0){
					somatorio = somatorio + 1;
				}
			}
			if(somatorio>this.getZerosColuna()){
				this.setZerosColuna(somatorio);
				this.setColunaComMainZeros(contC);
			}
			somatorio=0;
		}

	}

	private void AchaLinhaComMainZero(){
		int contC,contL, somatorio;
		somatorio = 0;
		for(contL = 0; contL < this.getTamanhoLinha(); contL++){
			for(contC = 0; contC < this.getTamanhoColuna(); contC++){
				if (this.getValor(contL, contC)==0){
					somatorio = somatorio + 1;
				}
			}
			if(somatorio>this.getZerosLinha()){
				this.setZerosLinha(somatorio);
				this.setLinhaComMaisZeros(contL);
			}
			somatorio=0;
		}
	}

	private boolean LinhaOUcoluna(){
		boolean chave;
		if(this.getLinhaComMaisZeros()>this.getColunaComMaiszeros()){
			chave = true;
		}
		else{
			chave = false;
		}
		return chave;
	}
}
