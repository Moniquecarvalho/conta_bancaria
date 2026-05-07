package conta_bancaria.controller;

import java.util.ArrayList;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;
	

	@Override
	public void listarTodos() {
		for (var conta : listaContas) {
			conta.visualizar();
		}

	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.printf("A conta número %d foi criada com sucesso!%n", conta.getNumero());

	}

	@Override
	public void procurarPorNumero(int numero) {

		var conta = BuscarNaCollection(numero);

		if (conta != null) {
			conta.visualizar();
		} else {
			System.out.printf("A Conta número: %d não foi encontrada!%n", numero);
		}

	}

	@Override
	public void atualizar(Conta conta) {

		var buscaConta = BuscarNaCollection(conta.getNumero());

		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.printf("A conta número %d foi atualizada com sucesso!%n", conta.getNumero());
		} else {
			System.out.printf("A conta número %d não foi encontrada!%n", numero);
		}

	}

	@Override
	public void deletar(int numero) {

		var conta = BuscarNaCollection(numero);

		if (conta != null) {
			if (listaContas.remove(conta) == true) {
				System.out.printf("A conta número: %d foi  deletada com sucesso!%n", numero);
			} else {
				System.out.printf("A conta número: %d não encontrada!%n", numero);

			}
		}

	}

	@Override
	public void sacar(int numero, float valor) {

		var conta = BuscarNaCollection(numero);

		if (conta != null) {

			if (conta.sacar(valor) == true) {
				System.out.printf("\nO saque na Conta número: %d foi  efetuado com sucesso!%n", numero);
			} else {
				System.out.printf("\nA conta número: %d não encontrada!%n", numero);

			}
		}

	}

	@Override
	public void depositar(int numero, float valor) {

		var conta = BuscarNaCollection(numero);

		if (conta != null) {
			conta.depositar(valor);
			System.out.printf("\nO Depósito na Conta número: %d foi  efetuado com sucesso!%n", numero);
		} else {
			System.out.printf("\nA conta número: %d não encontrada!%n", numero);

		}
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {

		var contaOrigem = BuscarNaCollection(numeroOrigem);
		var contaDestino = BuscarNaCollection(numeroDestino);

		if (contaOrigem != null && contaDestino != null) {

			if (contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.printf("\nA Transferência da conta: %d, para a conta %d foi  efetuado com sucesso!%n",
						numeroOrigem, numeroDestino);

			}

		} else {
			System.out.printf("\nA conta de Origem e/ou Destino não foram encontradas!%n");

		}

	}

	public int gerarNumero() {

		return ++numero;
	}

	public Conta BuscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}

		return null;
	}

	@Override
	public void deletar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	

}
