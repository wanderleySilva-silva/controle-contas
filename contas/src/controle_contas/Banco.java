package prova;

public class Banco{
    private String nomeAgencia;
    private String numeroAgencia;

    public Banco(String nomeAgencia, String numeroAgencia){
        this.setNomeAgencia(nomeAgencia);
        this.setNumeroAgencia(numeroAgencia);
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    public void alteraDados(String novoNomeAgencia, String novoNumeroAgencia){
        this.nomeAgencia = novoNomeAgencia;
        this.numeroAgencia = novoNumeroAgencia;

        System.out.println("Nome da agência atualizado: " + novoNomeAgencia +
                            "\nNúmero da agência atualizado: " + novoNumeroAgencia);
    }
}
