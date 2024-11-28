import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Banco {
    private JPanel Banco;
    private JLabel saldoLabel;
    private JLabel lblSaque;
    private JLabel lblValorSaque;
    private JButton btnRealizardeposito;
    private JButton btnRealizarsaque;
    private JLabel lblSaldo;
    private JLabel lblDeposito;
    private JLabel lblValorDeposito;
    private JTextArea txtAreaMsgm;
    private JButton btnLimpar;
    private JTextField txtSaque;
    private JTextField txtDeposito;

    private Double saldo = 500.00;
    private Double cleitomLindo;

    public Banco() {
        saldoLabel.setText("R$ " + String.format("%.2f", saldo));
        btnRealizardeposito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtDeposito.getText().replace(",", ".").isEmpty()) {
                    txtAreaMsgm.setText("Informe um valor!");
                    return;
                }
                try {
                    cleitomLindo = Double.parseDouble(txtDeposito.getText().replace(",", "."));
                    if (cleitomLindo > 1000.00) {
                        txtAreaMsgm.setText("Depósito acima do limite permitido!");
                    } else if (cleitomLindo < 0) {
                        txtAreaMsgm.setText("Valor negativo!");
                    } else {
                        txtAreaMsgm.setText("Depósito realizado com sucesso!");
                        saldo = saldo + cleitomLindo;
                        saldoLabel.setText("R$ " + String.format("%.2f", saldo));
                        cleitomLindo = 0.0;
                    }
                } catch (NumberFormatException ex) {
                    txtAreaMsgm.setText("Erro! Insira somente números!");
                }
            }
        });

        btnRealizarsaque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtSaque.getText().replace(",", ".").isEmpty()) {
                    txtAreaMsgm.setText("Informe um valor!");
                    return;
                }
                try {
                    cleitomLindo = Double.parseDouble(txtSaque.getText().replace(",", "."));
                    if (cleitomLindo > saldo) {
                        txtAreaMsgm.setText("Saldo insuficiente!");
                    } else if (cleitomLindo < 0) {
                        txtAreaMsgm.setText("Valor negativo!");
                    } else {
                        txtAreaMsgm.setText("Saque realizado com sucesso!");
                        saldo = saldo - cleitomLindo;
                        saldoLabel.setText("R$ " + String.format("%.2f", saldo));
                        cleitomLindo = 0.0;
                    }
                } catch (NumberFormatException ex) {
                    txtAreaMsgm.setText("Erro! Insira somente números!");
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSaque.setText("");
                txtDeposito.setText("");
                txtAreaMsgm.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema Banco");
        frame.setContentPane(new Banco().Banco);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 450);
        frame.setVisible(true);
    }

}