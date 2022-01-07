package prova;

public class Cliente extends Pessoa{

    public Cliente(String nome, String cpf){
        super(nome,cpf);
    }

    public String consulta(){
        return "Nome: " + this.getNome() + "\nCPF: " + this.getCpf();
    }
}
