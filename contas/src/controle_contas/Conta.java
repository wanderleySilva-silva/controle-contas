package prova;

public class Conta {
    private String numeroConta;
    private float saldo;
    private Banco banco;
    private Cliente cliente;

    public Conta(String numeroConta, float saldo, Banco b, Cliente c){
        this.setNumeroConta(numeroConta);
        this.setSaldo(saldo);
        this.banco = b;
        this.cliente = c;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void depositar(float deposito){
        this.saldo = this.saldo + deposito;
    }

    public void mostraSaldo(){
        System.out.println("Saldo atual R$ = "+this.getSaldo());
    }

}

