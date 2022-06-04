
public class ContaCorrente extends Conta {
	private double chequeEspecial;

	public ContaCorrente(Cliente titular, int agencia, int conta) {
		super(titular, agencia, conta);
		chequeEspecial = 150;
	}

	@Override
	public void sacar(double valor) {
		if (valor <= super.getSaldo()) {
			super.sacar(valor);
		} else if (valor <= super.getSaldo() + chequeEspecial) {
			chequeEspecial = valor - super.getSaldo();
			super.setSaldo(0);
		} else {
			System.out.println("Saldo insuficiente.");
		}
	}

	@Override
	public void depositar(double valor) {
		if (this.chequeEspecial == 150) {
			super.depositar(valor);
		} else {
			super.depositar(valor - (150 - this.chequeEspecial));
			this.chequeEspecial = 150;
		}
	}
	
	@Override
	public void extrato() {
		System.out.println("Titular: " + super.getTitular().getNome());
		System.out.println("Conta: " + super.getAgencia() + " " + super.getConta());
		System.out.println("Saldo: " + super.getSaldo());
		System.out.println("Cheque Especial: " + chequeEspecial);
		System.out.println("=====================");
	}

}
