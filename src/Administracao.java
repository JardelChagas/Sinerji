import java.util.List;
import java.util.Map;

public class Administracao {
    public Double salarioBeneficio(List<Funcionario> funcionarios, String data){
        Double salarioTotal = 0.0;
        for (Funcionario f : funcionarios){
            salarioTotal += f.salario(data);
        }
        return salarioTotal;
    }
    public Double salariosMes(List<Funcionario> funcionarios, String data){
        Double salarioTotal = 0.0;
        for (Funcionario f : funcionarios){
            salarioTotal += f.salarioSemBeneficio(data);
        }
        return salarioTotal;
    }
    public Double pagoBeneficios(List<Funcionario> funcionarios, String data){
        Double salarioTotal = 0.0;
        for (Funcionario f : funcionarios){
            salarioTotal += f.beneficios(data);
        }
        return salarioTotal;
    }
    public Double salairoMaisAlto(List<Funcionario> funcionarios, String data){
        Double salarioMaisAlto = 0.0;
        for (Funcionario f : funcionarios){
            if(salarioMaisAlto == 0.0)
                salarioMaisAlto = f.salario(data);
            else if(f.salario(data)>salarioMaisAlto)
                salarioMaisAlto = f.salario(data);
        }
        return salarioMaisAlto;
    }
    public Double beneficioMaisAlto(List<Funcionario> funcionarios, String data){
        Double salarioMaisAlto = 0.0;
        for (Funcionario f : funcionarios){
            if(salarioMaisAlto == 0.0)
                salarioMaisAlto = f.beneficios(data);
            else if(f.beneficios(data) > salarioMaisAlto)
                salarioMaisAlto = f.beneficios(data);
        }
        return salarioMaisAlto;
    }
    public String quemMaisVendeu(List<Funcionario> funcionarios, String data){
        Double salarioTotal = 0.0;
        String quemMaisVendeu = "";
        for (Funcionario f : funcionarios){
            Map<String, Double> vendas = ((Vendedor)f.getCargo()).getVendas();
            if(salarioTotal == 0.0){
                salarioTotal = vendas.get(data);
                quemMaisVendeu = f.getNome();
            }else if (salarioTotal < vendas.get(data)){
                salarioTotal = vendas.get(data);
                quemMaisVendeu = f.getNome();
            }

        }
        return quemMaisVendeu;
    }



}
