

import java.text.SimpleDateFormat;
import java.util.Date;

public class Funcionario {
    public Funcionario(String nome, Cargo cargo, String mesContratacao){
        setNome(nome);
        setCargo(cargo);
        setMesContratacao(mesContratacao);
        Double salarioAtual;

        if(this.cargo instanceof Secretario){
            Double salarioInicial = cargo.getSalarioInicial();
            Double beneficio = cargo.getBeneficio();
            salarioAtual = salarioInicial + tempoDeTrabalho("") * 1000;
            salarioAtual += salarioAtual * beneficio;
            this.salarioAtual = salarioAtual;
        }else if(this.cargo instanceof Vendedor){
            Double salarioInicial = cargo.getSalarioInicial();
            Double beneficio = cargo.getBeneficio();
            salarioAtual = salarioInicial + tempoDeTrabalho("") * 1800;
            salarioAtual += ((Vendedor) cargo).getVendas().get("04/2022") * beneficio;
            this.salarioAtual = salarioAtual;
        }else if(this.cargo instanceof Gerente){
            Double salarioInicial = cargo.getSalarioInicial();
            Double beneficio = cargo.getBeneficio();
            salarioAtual = salarioInicial + tempoDeTrabalho("") * 3000;
            salarioAtual += salarioAtual * beneficio;
            this.salarioAtual = salarioAtual;
        }

    }
    private String nome;
    private Cargo cargo;
    private String mesContratacao;
    private Double salarioAtual;

    public Double getSalarioAtual() {
        return salarioAtual;
    }

    public void setSalarioAtual(Double salarioAtual) {
        this.salarioAtual = salarioAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getMesContratacao() {
        return mesContratacao;
    }

    public void setMesContratacao(String mesContratacao) {
        this.mesContratacao = mesContratacao;
    }

    private int tempoDeTrabalho(String data){
        String[] dataContratacao = mesContratacao.split("/");
        int mesContratacao = Integer.parseInt(dataContratacao[0]);
        int anoContratacao = Integer.parseInt(dataContratacao[1]);
        if(data==null || data.isEmpty()){
            Date dataHoraAtual = new Date();
            data = new SimpleDateFormat("MM/yyyy").format(dataHoraAtual);
        }

        String[] dataatual = data.split("/");
        int mesAtual = Integer.parseInt(dataatual[0]);
        int anoAtual = Integer.parseInt(dataatual[1]);
        int anoDeTrabalho = anoAtual - anoContratacao;
        int mesDeTrabalho = mesAtual - mesContratacao;

        if(mesDeTrabalho < 0){
            anoDeTrabalho--;
        }
        return anoDeTrabalho;
    }
    public Double salario(String data){
        Double salario = 0.0;
        if(this.cargo instanceof Secretario){
            Double salarioInicial = cargo.getSalarioInicial();
            Double beneficio = cargo.getBeneficio();
            salario = salarioInicial + tempoDeTrabalho(data) * 1000;
            salario += salario * beneficio;
        }else if(this.cargo instanceof Vendedor){
            Double salarioInicial = cargo.getSalarioInicial();
            Double beneficio = cargo.getBeneficio();
            salario = salarioInicial + tempoDeTrabalho(data) * 1800;
            salario += ((Vendedor) cargo).getVendas().get(data) * beneficio;
        }else if(this.cargo instanceof Gerente){
            Double salarioInicial = cargo.getSalarioInicial();
            Double beneficio = cargo.getBeneficio();
            salario = salarioInicial + tempoDeTrabalho(data) * 3000;
            salario += salarioAtual * beneficio;
        }

        return salario;
    }

    public Double salarioSemBeneficio(String data){
        Double salario = 0.0;
        if(this.cargo instanceof Secretario){
            Double salarioInicial = cargo.getSalarioInicial();
            Double beneficio = cargo.getBeneficio();
            salario = salarioInicial + tempoDeTrabalho(data) * 1000;
        }else if(this.cargo instanceof Vendedor){
            Double salarioInicial = cargo.getSalarioInicial();
            Double beneficio = cargo.getBeneficio();
            salario = salarioInicial + tempoDeTrabalho(data) * 1800;
        }else if(this.cargo instanceof Gerente){
            Double salarioInicial = cargo.getSalarioInicial();
            Double beneficio = cargo.getBeneficio();
            salario = salarioInicial + tempoDeTrabalho(data) * 3000;
        }

        return salario;
    }

    public Double beneficios(String data){
        Double salario = 0.0;
        if(this.cargo instanceof Secretario){
            Double salarioInicial = cargo.getSalarioInicial();
            Double beneficio = cargo.getBeneficio();
            salario = salarioInicial + tempoDeTrabalho(data) * 1000;
            salario = salario * beneficio;
        }else if(this.cargo instanceof Vendedor){
            Double salarioInicial = cargo.getSalarioInicial();
            Double beneficio = cargo.getBeneficio();
            salario = salarioInicial + tempoDeTrabalho(data) * 1800;
            salario = ((Vendedor) cargo).getVendas().get(data) * beneficio;
        }else if(this.cargo instanceof Gerente){
            Double salarioInicial = cargo.getSalarioInicial();
            Double beneficio = cargo.getBeneficio();
            salario = salarioInicial + tempoDeTrabalho(data) * 3000;
            salario = salarioAtual * beneficio;
        }

        return salario;
    }


}
