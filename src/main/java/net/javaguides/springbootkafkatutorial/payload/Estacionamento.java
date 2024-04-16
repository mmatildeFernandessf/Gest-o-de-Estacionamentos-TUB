package net.javaguides.springbootkafkatutorial.payload;

public class Estacionamento {

    private int numLugares;
    private String localizacao;

    public int getnumLugares() {
        return numLugares;
    }

    public void setnumLugares(int numLugares) {
        this.numLugares = numLugares;
    }

    public String getlocalizacao() {
        return localizacao;
    }

    public void setlocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }



    @Override
    public String toString() {
        return "Estacionamento{" +
                "numLugares=" + numLugares +
                ", localizacao='" + localizacao + '\'' +

                '}';
    }
}
