import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        String tipoConta = "corrente";
        Scanner leitura = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        String nome = leitura.nextLine();
        System.out.print("Digite o saldo inicial: ");
        double saldo = leitura.nextDouble();

        int opcao = 0;

        System.out.println("**************************************");
        System.out.println("nome do cliente = " + nome);
        System.out.println("tipo da conta = " + tipoConta);
        System.out.println("saldo disponivel = %.2f".formatted(saldo));
        System.out.println("**************************************");

        String menu = """
                digite sua opção!
                1 consultar saldo
                2 transferir valor
                3 receber valor
                4 sair
                """;

        while (opcao != 4) {
            System.out.println(menu);
            opcao = leitura.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("saldo atual: %.2f".formatted(saldo));
                    break;
                case 2:
                    System.out.println("quanto deseja transferir: ");
                    double valorTransferencia = leitura.nextDouble();
                    if (valorTransferencia > saldo) {
                        System.out.println("Saldo insuficiente para realizar a transferência.\n");
                    } else if (valorTransferencia <= 0) {
                        System.out.println("Valor inválido para transferência.\n");
                    } else {
                        saldo -= valorTransferencia;
                        System.out.println("Transferência realizada com sucesso!");
                        System.out.println("Saldo atualizado: %.2f".formatted(saldo));
                    }
                    break;
                case 3:
                    System.out.println("informe o valor que deseja receber ");
                    double valorRecebido = leitura.nextDouble();
                    if (valorRecebido <= 0) {
                        System.out.println("Valor inválido.\n");
                    } else {
                        saldo += valorRecebido;
                        System.out.println("Valor recebido com sucesso!");
                        System.out.println("Saldo atualizado: %.2f\n".formatted(saldo));
                    }
                    break;
                case 4:
                    System.out.println("Finalizando a aplicação. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Escolha um número de 1 a 4.\n");
                    break;
            }
        }

        leitura.close();
    }
}