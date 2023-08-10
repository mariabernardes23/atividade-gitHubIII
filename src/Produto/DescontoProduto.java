package Produto;

import Desconto.Desconto;
import java.math.BigDecimal;

public interface DescontoProduto {
    BigDecimal calcularDesconto(Desconto desconto);
}
