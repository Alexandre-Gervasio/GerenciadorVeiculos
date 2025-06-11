public class Moto extends Veiculo implements Manutencao {
    private int cilindrada;
    private boolean verificado;

    public Moto(String placa, int ano, int cilindrada) {
        super(placa, ano);
        this.cilindrada = cilindrada;
        this.verificado = false;
    }

    public double calcularValorSeguro() {
        return 300 + (cilindrada * 0.1);
    }

    public String realizarManutencao() {
        this.verificado = true;
        return "Manutenção da moto com placa " + getPlaca() + " realizada. \n";
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void exibirDetalhes() {
        System.out.println("Moto - Placa: " + getPlaca() + ", Ano: " + getAno() + ",Cilindrada: " + cilindrada + "cc \n");
    }
}
