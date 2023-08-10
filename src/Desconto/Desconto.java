package Desconto;

import java.math.BigDecimal;

public class Desconto {
    private BigDecimal desconto;

    public Desconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }
}
