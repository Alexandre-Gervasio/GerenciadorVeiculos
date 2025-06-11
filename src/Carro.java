public class Carro extends Veiculo implements Manutencao {
    private int numeroPortas;
    private boolean verificado;

    public Carro(String placa, int ano, int numeroPortas) {
        super(placa, ano);
        this.numeroPortas = numeroPortas;
        this.verificado = false;
    }

    public double calcularValorSeguro() {
        return 1000 + (numeroPortas * 100);
    }

    public String realizarManutencao() {
        this.verificado = true;
        return "Manutenção do carro com placa " + getPlaca() + " realizada. \n";
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void exibirDetalhes() {
        System.out.println("Carro - Placa: " + getPlaca() + ", Ano: " + getAno() + ", Portas: " + numeroPortas + "\n");
    }
}
