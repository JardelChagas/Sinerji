import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Vendedor extends Cargo {
    public Vendedor(Map<String, Double> vendas){
        setSalarioInicial(12000.0);
        setBeneficio(0.3);
        setVendas(vendas);
    }

    public Map<String, Double> getVendas() {
        return vendas;
    }

    public void setVendas(Map<String, Double> vendas) {
        this.vendas = vendas;
    }

    private Map<String, Double> vendas = new HashMap<>();
}
