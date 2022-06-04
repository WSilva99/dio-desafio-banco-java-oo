import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Banco {
	private String nome;
	private int agencia;
	private int sequencial;
	private List<Conta> contas;

	public Banco(String nome) {
		this.nome = nome;
		this.agencia = new Random().nextInt(150 - 1) + 1;
		this.sequencial = 0;
		this.contas = new ArrayList<Conta>();
	}

	public String getNome() {
		return nome;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getSequencial() {
		return sequencial;
	}

	public List<Conta> getContas() {
		return contas;
	}
	
	public Conta criarContaPoupanca(Cliente titular) {
		Conta cp = new ContaPoupanca(titular, agencia, ++sequencial);
		contas.add(cp);
		return cp;
	}
	
	public Conta criarContaCorrente(Cliente titular) {
		Conta cc = new ContaCorrente(titular, agencia, ++sequencial);
		contas.add(cc);
		return cc;
	}
	
	public void cancelarConta(Conta c) {
		contas.remove(c);
	}
	
	public Conta buscarConta(int conta) {
		for(Conta c: contas) {
			if(c.getConta() == conta) {
				return c;
			}
		}
		return null;
	}
	
	public void listarContas() {
		if(contas != null && !contas.isEmpty()) {
			for(Conta c: contas) {
				if(c instanceof ContaPoupanca) {
					System.out.println("Conta Poupanca");
				} else if(c instanceof ContaCorrente) {
					System.out.println("Conta Corrente");
				}
				System.out.println("Titular: "+c.getTitular().getNome());
				System.out.println("Conta: "+c.getAgencia()+" "+c.getConta());
				System.out.println("=====================");
			}			
		} else {
			System.out.println("Sem registros");
		}
	}
	
}
