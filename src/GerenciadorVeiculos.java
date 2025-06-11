import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorVeiculos {
    public static void main(String[] args) {
        ArrayList<Veiculo> frota = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Adicionar Carro");
            System.out.println("2. Adicionar Moto");
            System.out.println("3. Exibir Veículos");
            System.out.println("4. Verificar Manutenção");
            System.out.println("5. Realizar Manutenção");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: \n");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Placa do carro: ");
                    String placaCarro = scanner.nextLine();
                    System.out.print("Ano do carro: ");
                    int anoCarro = scanner.nextInt();
                    System.out.print("Número de portas: ");
                    int portas = scanner.nextInt();
                    scanner.nextLine();
                    frota.add(new Carro(placaCarro, anoCarro, portas));
                    break;
                case 2:
                    System.out.print("Placa da moto: ");
                    String placaMoto = scanner.nextLine();
                    System.out.print("Ano da moto: ");
                    int anoMoto = scanner.nextInt();
                    System.out.print("Cilindrada: ");
                    int cilindrada = scanner.nextInt();
                    scanner.nextLine();
                    frota.add(new Moto(placaMoto, anoMoto, cilindrada));
                    break;
                case 3:
                    exibindoVeiculos(frota);
                    break;
                case 4:
                    veiculosVerificados(frota);
                    break;
                case 5:
                    if (frota.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado.\n");
                        break;
                    }

                    System.out.println("\n--- Veículos cadastrados ---");
                    for (Veiculo v : frota) {
                        System.out.println("\nTipo: " + v.getClass().getSimpleName() + " | Placa: " + v.getPlaca() + "\n");
                    }


                    System.out.print("\nDigite a placa do veículo para realizar manutenção: ");
                    String placaBusca = scanner.nextLine();

                    boolean encontrado = false;

                    for (Veiculo v : frota) {
                        if (v.getPlaca().equalsIgnoreCase(placaBusca)) {
                            if (v instanceof Manutencao) {
                                String resultado = ((Manutencao) v).realizarManutencao();
                                System.out.println(resultado);
                                encontrado = true;
                            }
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Veículo não encontrado ou não suporta manutenção. \n");
                    }
                    break;

                case 6:
                    System.out.println("Saindo...\n");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private static void exibindoVeiculos(ArrayList<Veiculo> frota) {
        for (Veiculo v : frota) {
            v.exibirDetalhes();
            System.out.println("Seguro: R$ " + v.calcularValorSeguro() + "\n");
            System.out.println("---");
        }
    }

    private static void veiculosVerificados(ArrayList<Veiculo> frota) {
        System.out.println("Veículos verificados:");
        for (Veiculo v : frota) {
            if (v instanceof Manutencao && ((Manutencao) v).isVerificado()) {
                System.out.println("Tipo: " + v.getClass().getSimpleName() + " | Placa: " + v.getPlaca());
            }
        }

        System.out.println("Veículos não verificados:");
        for (Veiculo v : frota) {
            if (v instanceof Manutencao && !((Manutencao) v).isVerificado()) {
                System.out.println("Tipo: " + v.getClass().getSimpleName() + " | Placa: " + v.getPlaca());
            }
        }
    }
}
