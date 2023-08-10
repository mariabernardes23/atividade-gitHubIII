package Produto;

import Desconto.Desconto;
import java.math.BigDecimal;

public class ProdutoDigital implements DescontoProduto{
    @Override
    public BigDecimal calcularDesconto(Desconto desconto) {
        return (desconto.getDesconto().multiply(new BigDecimal("0.15")));
    }
    
}
