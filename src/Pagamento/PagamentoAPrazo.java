package Pagamento;

import Menu.MenuView;
import java.math.BigDecimal;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PagamentoAPrazo extends JFrame{

    public PagamentoAPrazo(BigDecimal valor) {
        JOptionPane.showMessageDialog(rootPane, "Valor total a pagar R$ " + valor);
        new MenuView().setVisible(true);
    }
    
}
