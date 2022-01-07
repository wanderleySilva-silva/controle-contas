package prova;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Conta> listaContas = new ArrayList<>();
        ArrayList<Poupanca> listaPoupanca = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        Conta c;
        Poupanca p;
        Banco b;
        Cliente cliente;

        String nomeCliente;
        String numeroConta;
        String cpf;
        String nomeAgencia, numeroAgencia;
        float saldo, juros;

        int opc = 0;
        do {
            System.out.println("--------------------------------------");
            System.out.println(" GERENCIAMENTO DE CONTAS E POUPANÇAS  ");
            System.out.println("--------------------------------------");
            System.out.println("Escolha a opção desejada: ");
            System.out.println("1. Cadastrar Conta ou Poupança.\n" +
                               "2. Realizar depósito.\n" +
                               "3. Render juros.\n" +
                               "4. Consultar número e nome da agência.\n" +
                               "5. Alterar o número e nome da agência.\n" +
                               "0. Sair.");
            System.out.println("---------------------------------------");

            opc = scan.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Digite: " + "\n1 - Conta." + "\n2 - Poupança.");
                    opc = scan.nextInt();

                    if (opc == 1) {
                        if(listaContas.size() < 10){
                            scan.nextLine();
                            System.out.println("Digite o nome do cliente: ");
                            nomeCliente = scan.nextLine();

                            System.out.println("Digite o CPF do cliente: ");
                            cpf = scan.nextLine();

                            System.out.println("Digite o nome da agência do cliente: ");
                            nomeAgencia = scan.nextLine();

                            System.out.println("Digite o número da agência do cliente: ");
                            numeroAgencia = scan.nextLine();

                            System.out.println("Digite o número da conta do cliente: ");
                            numeroConta = scan.nextLine();

                            System.out.println("Digite o saldo da conta do cliente: ");
                            saldo = scan.nextFloat();

                            b = new Banco(nomeAgencia, numeroAgencia);
                            cliente = new Cliente(nomeCliente, cpf);
                            c = new Conta(numeroConta, saldo, b, cliente);
                            listaContas.add(c);

                        }else{
                            System.out.println("Já atingimos o limite máximo de contas cadastradas.");
                        }
                    } else {
                        if(listaPoupanca.size() < 10){
                            scan.nextLine();
                            System.out.println("Digite o nome do cliente: ");
                            nomeCliente = scan.nextLine();

                            System.out.println("Digite o CPF do cliente: ");
                            cpf = scan.nextLine();

                            System.out.println("Digite o nome da agência do cliente: ");
                            nomeAgencia = scan.nextLine();

                            System.out.println("Digite o número da agência do cliente: ");
                            numeroAgencia = scan.nextLine();

                            System.out.println("Digite o número da conta do cliente: ");
                            numeroConta = scan.nextLine();

                            System.out.println("Digite o saldo da poupança do cliente: ");
                            saldo = scan.nextFloat();

                            System.out.println("Digite a taxa de juros da poupança do cliente: ");
                            juros = scan.nextFloat();

                            b = new Banco(nomeAgencia,numeroAgencia);
                            cliente = new Cliente(nomeCliente,cpf);
                            p = new Poupanca(numeroConta,saldo,b,cliente,juros);

                            listaPoupanca.add(p);
                        }else{
                            System.out.println("Já atingimos o limite máximo de poupanças cadastradas.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Depositar em: " + "\n1 - Conta." + "\n2 - Poupança.");
                    int opcDeposito = scan.nextInt();

                    if (opcDeposito == 1) {
                        if (listaContas == null || listaContas.size() == 0) {
                            System.out.println("Nenhuma conta cadastrada.");
                        } else{
                            scan.nextLine();
                            System.out.println("Digite o CPF: ");
                            String cpfDeposito = scan.nextLine();

                            for (int i = 0;i < listaContas.size();i++) {
                                if (listaContas.get(i).getCliente().getCpf().equalsIgnoreCase(cpfDeposito)) {
                                    System.out.println("Informe o valor do depósito: ");
                                    float valor = scan.nextFloat();
                                    scan.nextLine();
                                    listaContas.get(i).depositar(valor);
                                    listaContas.get(i).mostraSaldo();
                                    break;
                                }else{
                                    System.out.println("CPF não encontrado.");
                                }
                            }
                        }

                    } else {
                        if(listaPoupanca == null || listaPoupanca.size() == 0){
                            System.out.println("Nenhuma poupança cadastrada.");
                        } else{
                            scan.nextLine();
                            System.out.println("Digite o CPF: ");
                            String cpfDeposito = scan.nextLine();

                            for (Poupanca poupanca : listaPoupanca) {
                                if (poupanca.getCliente().getCpf().equalsIgnoreCase(cpfDeposito)) {
                                    System.out.println("Informe o valor do depósito: ");
                                    float valor = scan.nextFloat();
                                    scan.nextLine();
                                    poupanca.depositar(valor);
                                    poupanca.mostraSaldo();
                                    break;
                                }else{
                                    System.out.println("CPF não encontrado.");
                                }
                            }
                        }
                    }

                    break;
                case 3:
                    scan.nextLine();
                    if (listaPoupanca == null || listaPoupanca.size() == 0) {
                        System.out.println("Nenhuma poupança cadastrada.");
                    } else {
                        System.out.println("Digite o CPF: ");
                        String cpfJuros = scan.nextLine();

                        for (int i = 0; i < listaPoupanca.size();i++) {
                            if (listaPoupanca.get(i).getCliente().getCpf().equalsIgnoreCase(cpfJuros)) {
                                System.out.println("Informe o período de tempo da aplicação: ");
                                float tempo = scan.nextFloat();
                                scan.nextLine();
                                listaPoupanca.get(i).renderJuros(tempo);
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Consultar:" + "\n1 - Conta." + "\n2 - Poupança.");
                    int opcConsulta = scan.nextInt();

                    if(opcConsulta == 1){
                        scan.nextLine();
                        if(listaContas == null || listaContas.size() == 0){
                            System.out.println("Nenhuma conta cadastrada.");
                        }else{
                            System.out.println("Informe o nome da agência: ");
                            String agenciaNome = scan.nextLine();

                            System.out.println("Informe o número da agência: ");
                            String agenciaNumero = scan.nextLine();

                            for(Conta conta: listaContas){
                                if(conta.getBanco().getNomeAgencia().equalsIgnoreCase(agenciaNome) &&
                                   conta.getBanco().getNumeroAgencia().equalsIgnoreCase(agenciaNumero)){
                                    System.out.println(conta.getCliente().consulta());
                                    break;
                                }else{
                                    System.out.println("Dados incorretos.");
                                }
                            }
                        }
                    }
                    if(opcConsulta == 2){
                        scan.nextLine();
                        if(listaPoupanca == null || listaPoupanca.size() == 0){
                            System.out.println("Nenhuma poupança cadastrada.");
                        }else{
                            System.out.println("Informe o nome da agência: ");
                            String agenciaNome = scan.nextLine();

                            System.out.println("Informe o número da agência: ");
                            String agenciaNumero = scan.nextLine();

                            for(Poupanca poupanca: listaPoupanca){
                                if(poupanca.getBanco().getNomeAgencia().equalsIgnoreCase(agenciaNome) &&
                                   poupanca.getBanco().getNumeroAgencia().equalsIgnoreCase(agenciaNumero)){
                                    System.out.println(poupanca.getCliente().consulta());
                                    break;
                                }else{
                                    System.out.println("Dados incorretos.");
                                }
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("Alterar dados da:" + "\n1 - Conta." + "\n2 - Poupança.");
                    int opcAlterar = scan.nextInt();

                    if(opcAlterar == 1){
                        scan.nextLine();
                        if(listaContas == null || listaContas.size() == 0){
                            System.out.println("Nenhuma conta cadastrada.");
                        }else{
                            System.out.println("Informe o nome do titular: ");
                            String titularNome = scan.nextLine();

                            for(Conta conta: listaContas){
                                if(conta.getCliente().getNome().equalsIgnoreCase(titularNome)){
                                    System.out.println("Informe o novo nome da agência: ");
                                    String novoNomeAgencia = scan.nextLine();

                                    System.out.println("Informe o novo número da agência: ");
                                    String novoNumeroAgencia = scan.nextLine();

                                    conta.getBanco().alteraDados(novoNomeAgencia,novoNumeroAgencia);
                                    break;
                                }else{
                                    System.out.println("Dados incorretos.");
                                }
                            }
                        }
                    }
                    if(opcAlterar == 2){
                        scan.nextLine();
                        if(listaPoupanca == null || listaPoupanca.size() == 0){
                            System.out.println("Nenhuma poupança cadastrada.");
                        }else{
                            System.out.println("Informe o nome do titular: ");
                            String nomeTitular = scan.nextLine();

                            for(Poupanca poupanca: listaPoupanca){
                                if(poupanca.getCliente().getNome().equalsIgnoreCase(nomeTitular)){
                                    System.out.println("Informe o novo nome da agência: ");
                                    String novoNomeAgencia = scan.nextLine();

                                    System.out.println("Informe o novo número da agência: ");
                                    String novoNumeroAgencia = scan.nextLine();

                                    poupanca.getBanco().alteraDados(novoNomeAgencia,novoNumeroAgencia);
                                    break;
                                }else{
                                    System.out.println("Dados incorretos.");
                                }
                            }
                        }
                    }
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }while (opc != 0);
    }
}

