import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ParseException {
        Map<String, Double> vendas1 = new HashMap<>();
        Map<String, Double> vendas2 = new HashMap<>();
        vendas1.put("12/2021", 5200.0);
        vendas1.put("01/2022", 4000.0);
        vendas1.put("02/2022", 4200.0);
        vendas1.put("03/2022", 5850.0);
        vendas1.put("04/2022", 7000.0);

        vendas2.put("12/2021", 3400.0);
        vendas2.put("01/2022", 7700.0);
        vendas2.put("02/2022", 5000.0);
        vendas2.put("03/2022", 5900.0);
        vendas2.put("04/2022", 6500.0);

        Secretario s = new Secretario();
        Gerente g  = new Gerente();
        Vendedor v1= new Vendedor(vendas1);
        Vendedor v2 = new Vendedor(vendas2);

        List<Funcionario> todosFuncionarios = new ArrayList<>();
        List<Funcionario> funcionariosBeneficio = new ArrayList<>();
        List<Funcionario> vendedores = new ArrayList<>();

        todosFuncionarios.add(new Funcionario("Jorge Carvalho", s,"01/2018"));
        todosFuncionarios.add(new Funcionario("Maria Souza", s,"12/2015"));
        todosFuncionarios.add(new Funcionario("Ana Silva", v1,"12/2021"));
        todosFuncionarios.add(new Funcionario("João Mendes", v2,"12/2021"));
        todosFuncionarios.add(new Funcionario("Juliana Alves", g,"07/2017"));
        todosFuncionarios.add(new Funcionario("Bento Albino", g,"03/2014"));

        for (Funcionario f:todosFuncionarios){
            if(f.getCargo().getBeneficio() != 0.0){
                funcionariosBeneficio.add(f);
            }
        }
        for (Funcionario f:todosFuncionarios){
            if(f.getCargo() instanceof Vendedor){
                vendedores.add(f);
            }
        }

        Administracao ad = new Administracao();

        System.out.println(ad.salarioBeneficio(todosFuncionarios,"02/2022"));
        System.out.println(ad.salariosMes(todosFuncionarios,"02/2022"));
        System.out.println(ad.pagoBeneficios(funcionariosBeneficio,"02/2022"));
        System.out.println(ad.salairoMaisAlto(todosFuncionarios,"02/2022"));
        System.out.println(ad.beneficioMaisAlto(funcionariosBeneficio,"02/2022"));
        System.out.println(ad.quemMaisVendeu(vendedores,"02/2022"));
    }
}