
public abstract class Conta {
	private int agencia;
	private int conta;
	private double saldo;
	private Cliente titular;

	public Conta(Cliente titular, int agencia, int conta) {
		this.titular = titular;
		this.agencia = agencia;
		this.conta = conta;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getConta() {
		return conta;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void sacar(double valor) {
		if (valor <= saldo) {
			saldo -= valor;
			System.out.println("Saldo: " + getSaldo());
		} else {
			System.out.println("Saldo insuficiente");
		}
	}

	public void depositar(double valor) {
		saldo += valor;
		System.out.println("Saldo: " + getSaldo());
	}

	public void transferir(Conta beneficiario, double valor) {
		if (beneficiario != null && valor <= saldo) {
			saldo -= valor;
			System.out.println("Tranferencia realizada com sucesso.");
		} else {
			System.out.println("Tranferencia realizada não realizada.");
		}
	}

	public void extrato() {
		System.out.println("Titular: " + titular.getNome());
		System.out.println("Conta: " + agencia + " " + conta);
		System.out.println("Saldo: " + saldo);
		System.out.println("=====================");
	}

}
