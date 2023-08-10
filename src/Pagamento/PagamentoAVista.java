package Pagamento;

import Desconto.Desconto;
import Menu.MenuView;
import Produto.CalculaDesconto;
import Produto.ProdutoDigital;
import Produto.ProdutoFisicos;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class PagamentoAVista extends JFrame{
    private JRadioButton prodFisico;
    private JRadioButton prodDigital;
    private JRadioButton prodVideoGame;
    private JButton efetuarPagamento;
    private Desconto desconto;
    private CalculaDesconto cd;
    private BigDecimal total;
    private BigDecimal desc;
    
    public PagamentoAVista(BigDecimal valor) {
        cd = new CalculaDesconto();
        desconto = new Desconto(valor);
        
        setTitle("Livraria Nova Andradina");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 150);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panelNome = new JPanel(new FlowLayout());
        JPanel panelOpcao = new JPanel(new GridLayout(1, 3));
        JPanel panelBotao = new JPanel(new FlowLayout());
        
        JLabel nomeLabel = new JLabel("Escolha a classificação do produto", SwingConstants.CENTER);
        nomeLabel.setOpaque(true);
        nomeLabel.setFont(new Font("Courrier", Font.BOLD, 20));
        nomeLabel.setVerticalAlignment(SwingConstants.CENTER);
        nomeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        nomeLabel.setVerticalTextPosition(SwingConstants.CENTER);
        
        prodFisico = new JRadioButton("Produto Fisico");
        prodDigital = new JRadioButton("Produto Digital");
        prodVideoGame = new JRadioButton("Jogos de Video Game");;
        
        ButtonGroup grupoBotoes = new ButtonGroup();
        grupoBotoes.add(prodFisico);
        grupoBotoes.add(prodDigital);
        grupoBotoes.add(prodVideoGame);
        
        efetuarPagamento = new JButton("Efetuar Pagamento");
        
        efetuarPagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(prodFisico.isSelected()){
                  pgFisico(valor); 
                }
                if(prodDigital.isSelected()) {
                    pgDigital(valor);
                }
                if(prodVideoGame.isSelected()) {
                    JOptionPane.showMessageDialog(rootPane, "Valor total a pagar R$ " + valor);
                    dispose();
                    new MenuView().setVisible(true);
                }
            }
        });
        
        panelNome.add(nomeLabel);
        panelOpcao.add(prodFisico);
        panelOpcao.add(prodDigital);
        panelOpcao.add(prodVideoGame);
        panelBotao.add(efetuarPagamento);
        panel.add(panelNome, BorderLayout.NORTH);
        panel.add(panelOpcao, BorderLayout.CENTER);
        panel.add(panelBotao, BorderLayout.SOUTH);
        getContentPane().add(panel); 
    }

    private void pgFisico (BigDecimal valor) {
        desc = cd.calularDesconto(desconto, new ProdutoFisicos());
        total = valor.subtract(desc);
        JOptionPane.showMessageDialog(rootPane, "Valor total da compra R$ " + valor + 
                                     "\nDesconto R$ " + desc + "\nTotal a pagar R$ " + total);
        dispose();
        new MenuView().setVisible(true);
        
    }
    
    private void pgDigital(BigDecimal valor) {
        desc = cd.calularDesconto(desconto, new ProdutoDigital());
        total = valor.subtract(desc);
        JOptionPane.showMessageDialog(rootPane, "Valor total da compra R$ " + valor + 
                                     "\nDesconto R$ " + desc + "\nTotal a pagar R$ " + total);
        dispose();
        new MenuView().setVisible(true);
    }
}
