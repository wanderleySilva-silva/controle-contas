package prova;

public class Poupanca extends Conta{
    private float juros;

    public Poupanca(String numeroConta, float saldo, Banco b, Cliente c, float juros) {
        super(numeroConta, saldo, b, c);
        this.setJuros(juros);
    }

    public float getJuros() {
        return juros;
    }

    public void setJuros(float juros) {
        this.juros = juros;
    }

    public void renderJuros(float t){
        float resultado = 1;
        for(int i = 0; i < t; i++){
            resultado = resultado*(1 + juros);
        }
        float montante = getSaldo()*resultado;
        this.setSaldo(montante);

        System.out.println("Cliente: "+this.getCliente().getNome() + "\nCPF: "+ this.getCliente().getCpf() + "\nSaldo com juros = R$ "+this.getSaldo());
    }
}
