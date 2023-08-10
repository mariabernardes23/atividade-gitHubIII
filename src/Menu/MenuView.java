package Menu;

import Pagamento.PagamentoAPrazo;
import Pagamento.PagamentoAVista;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MenuView extends JFrame{
    private JTextField valorTextField;
    private JRadioButton vistaRadio;
    private JRadioButton prazoRadio;
    private JButton btnCadastrar;
    
    public MenuView() {
        setTitle("Livraria Nova Andradina");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 150);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panelNome = new JPanel(new FlowLayout());
        JPanel panelValor = new JPanel(new GridLayout(2, 1));
        JPanel panelBotao = new JPanel(new FlowLayout());
        
        JLabel nomeLabel = new JLabel("Gerenciamento de Pagamento", SwingConstants.CENTER);
        nomeLabel.setOpaque(true);
        nomeLabel.setFont(new Font("Courrier", Font.BOLD, 20));
        nomeLabel.setVerticalAlignment(SwingConstants.CENTER);
        nomeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        nomeLabel.setVerticalTextPosition(SwingConstants.CENTER);
        
        JLabel valorLabel = new JLabel("Digite o valor da compra: ");
        valorTextField = new JTextField();
       
        vistaRadio = new JRadioButton("À Vista");
        prazoRadio = new JRadioButton("À Prazo");
        
        ButtonGroup grupoBotoes = new ButtonGroup();
        grupoBotoes.add(vistaRadio);
        grupoBotoes.add(prazoRadio);
        
        btnCadastrar = new JButton("Cadastrar Pagamento");
        
        btnCadastrar.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vistaRadio.isSelected()){
                   BigDecimal valor = new BigDecimal(valorTextField.getText());
                   PagamentoAVista pg = new PagamentoAVista(valor);
                   pg.setVisible(true);
                   dispose();
                }
                if(prazoRadio.isSelected()) {
                    BigDecimal valor = new BigDecimal(valorTextField.getText());
                    PagamentoAPrazo pg = new PagamentoAPrazo(valor);
                    pg.setVisible(true);
                    dispose();
                }
            }
        });
        
        panelNome.add(nomeLabel);
        panelValor.add(valorLabel);
        panelValor.add(valorTextField);
        panelValor.add(vistaRadio);
        panelValor.add(prazoRadio);
        panelBotao.add(btnCadastrar);
        panel.add(panelNome, BorderLayout.NORTH);
        panel.add(panelValor, BorderLayout.CENTER);
        panel.add(panelBotao, BorderLayout.SOUTH);
        getContentPane().add(panel);
    }
}
