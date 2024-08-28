package Clase3.act1;

public class Cliente {
    private int id;
    private String name;
    private double scoring;

    public Cliente(int id, String name, double scoring) {
        this.id = id;
        this.name = name;
        this.scoring = scoring;
    }

    public boolean tengoMayorScoring(Cliente clienteAComparar) {
        return this.scoring > clienteAComparar.getScoring();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scoring=" + scoring +
                '}';
    }

    public double getScoring() {
        return scoring;
    }
}
