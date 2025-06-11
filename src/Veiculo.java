public abstract class Veiculo {
    private String placa;
    private int ano;

    public Veiculo(String placa, int ano) {
        this.placa = placa;
        this.ano = ano;
    }
    
    public int getAno() {
        return ano;
    }

    public String getPlaca() {
        return placa;
    }

    public abstract double calcularValorSeguro();

    public void exibirDetalhes(){
        System.out.println("Placa: " + placa + "\n");
        System.out.println("Ano: " + ano + "\n");
    }
}