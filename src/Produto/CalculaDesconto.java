package Produto;

import Desconto.Desconto;
import java.math.BigDecimal;

public class CalculaDesconto {
    public BigDecimal calularDesconto(Desconto desconto, DescontoProduto desProduto) {
        return desProduto.calcularDesconto(desconto);
    }
}
