
public class Main {

	public static void main(String[] args) {
		Banco Nudio = new Banco("Nudio");
		Banco Santandio = new Banco("Santandio");
		
		Nudio.listarContas();
		Santandio.listarContas();
		
		Cliente walmir = new Cliente("Walmir Silva", "88988889999");
		Cliente sarah = new Cliente("Sarah Luiza", "88999999999");
		
		Conta nudioWalmir = Nudio.criarContaPoupanca(walmir);
		Conta santandioWalmir = Santandio.criarContaCorrente(walmir);
		Conta nudioSarah = Nudio.criarContaPoupanca(sarah);
		
		Nudio.listarContas();
		Santandio.listarContas();
		
		nudioWalmir.depositar(500);
		santandioWalmir.depositar(1500);
		nudioSarah.depositar(500);
		
		nudioWalmir.sacar(150);
		santandioWalmir.sacar(1200);
		nudioSarah.depositar(100);
		
		nudioWalmir.extrato();
		santandioWalmir.extrato();
		nudioSarah.extrato();
		
		santandioWalmir.sacar(400);
		
		santandioWalmir.extrato();
		
		santandioWalmir.depositar(1050);
		
		santandioWalmir.extrato();
		
	}

}
