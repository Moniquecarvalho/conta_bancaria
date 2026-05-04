package conta_bancaria.model;

import conta_bancaria.util.Cores;

public abstract class Conta {
	
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean sacar(float valor) {

		if (this.saldo <= valor) {
			System.out.println("\n Saldo Insuficiente!");
			
		}

		this.saldo = this.saldo - valor;
		return true;
		
	}

	public void depositar(float valor) {

		this.saldo = this.saldo + valor;

	}
	
	public void visualizar() {

		String tipo = "";

		switch (this.tipo) {
		case 1:
			tipo = "Conta Corrente";
			break;
		case 2:
			tipo = "Conta Poupança";
			break;
		}

		int largura = 72;

		System.out.printf(Cores.ANSI_BLACK_BACKGROUND + "%-" + largura + "s%n", "");
		System.out.printf(
		    Cores.ANSI_BLACK_BACKGROUND + "%-" + largura + "s%n",
		    Cores.TEXT_RED + "************************************************************************" + Cores.TEXT_WHITE
		);
		System.out.printf(
		    Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE + "%-" + largura + "s%n",
		    "Dados da Conta:"
		);
		System.out.printf(
		    Cores.ANSI_BLACK_BACKGROUND + "%-" + largura + "s%n",
		    Cores.TEXT_RED + "************************************************************************" + Cores.TEXT_WHITE
		);
		System.out.printf(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE + "%-" + largura + "s%n", "Numero da Conta: " + this.numero);
		System.out.printf(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE + "%-" + largura + "s%n", "Agência: " + this.agencia);
		System.out.printf(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE + "%-" + largura + "s%n", "Tipo da Conta: " + tipo);
		System.out.printf(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE + "%-" + largura + "s%n", "Titular: " + this.titular);
		System.out.printf(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE + "%-" + largura + "s%n", String.format("Saldo: R$ %.2f", this.saldo));
		System.out.print(Cores.TEXT_RESET);
	}
}

