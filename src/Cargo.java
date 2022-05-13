public class Cargo {
    private Double salarioInicial;
    private Double beneficio;

    public Double getSalarioInicial() {
        return salarioInicial;
    }

    public void setSalarioInicial(Double salarioInicial) {
        if(salarioInicial > 1){
            this.salarioInicial = salarioInicial;
        }

    }

    public Double getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(Double beneficio) {
        if(beneficio >= 0 && beneficio <= 1)
            this.beneficio = beneficio;
    }


}
