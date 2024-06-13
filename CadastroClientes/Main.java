import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

public class Main {
    private static ClienteDAO clienteDAO = new ClienteDAOImpl();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Clientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Campos de texto para entrada de dados com máscaras
        JTextField nomeField = new JTextField(20);
        JFormattedTextField cpfField = createFormattedField("###.###.###-##");
        JFormattedTextField telefoneField = createFormattedField("(##) ####-####");
        JTextField enderecoField = new JTextField(20);
        JTextField numeroField = new JTextField(5); // Campo para o número do endereço
        JTextField complementoField = new JTextField(20); // Campo para o complemento do endereço
        JTextField cidadeField = new JTextField(20);
        JTextField estadoField = new JTextField(20);

        // Campo para consultar cliente por CPF
        JFormattedTextField consultaCpfField = createFormattedField("###.###.###-##");

        // Campo para remover cliente por CPF
        JFormattedTextField removerCpfField = createFormattedField("###.###.###-##");

        // Adicionando os componentes ao painel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("CPF:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(cpfField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Telefone:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(telefoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Endereço:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(enderecoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Número:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(numeroField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Complemento:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(complementoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Cidade:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(cidadeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Estado:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(estadoField, gbc);

        // Botão para adicionar cliente
        JButton addButton = new JButton("Adicionar Cliente");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validação dos campos
                if (nomeField.getText().trim().isEmpty() || cpfField.getText().trim().isEmpty() ||
                        telefoneField.getText().trim().isEmpty() || enderecoField.getText().trim().isEmpty() ||
                        numeroField.getText().trim().isEmpty() || cidadeField.getText().trim().isEmpty() ||
                        estadoField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Cliente cliente = new Cliente(
                        nomeField.getText().trim(),
                        cpfField.getText().trim(),
                        telefoneField.getText().trim(),
                        enderecoField.getText().trim() + ", " + numeroField.getText().trim() + (complementoField.getText().trim().isEmpty() ? "" : ", " + complementoField.getText().trim()),
                        cidadeField.getText().trim(),
                        estadoField.getText().trim()
                );
                clienteDAO.adicionarCliente(cliente);
                JOptionPane.showMessageDialog(frame, "Cliente adicionado com sucesso!");
                clearFields();
            }

            private void clearFields() {
                nomeField.setText("");
                cpfField.setText("");
                telefoneField.setText("");
                enderecoField.setText("");
                numeroField.setText("");
                complementoField.setText("");
                cidadeField.setText("");
                estadoField.setText("");
            }
        });

        // Botão para listar clientes
        JButton listButton = new JButton("Listar Clientes");
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Cliente> clientes = clienteDAO.listarClientes();
                if (clientes.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Nenhum cliente cadastrado.", "Informação", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    StringBuilder sb = new StringBuilder("<html>");
                    for (Cliente cliente : clientes) {
                        sb.append(cliente.toString()).append("<br>");
                    }
                    sb.append("</html>");
                    JOptionPane.showMessageDialog(frame, sb.toString());
                }
            }
        });

        // Botão para consultar cliente
        JButton consultaButton = new JButton("Consultar Cliente");
        consultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = consultaCpfField.getText().trim();
                if (cpf.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "CPF é obrigatório para consultar um cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Cliente cliente = clienteDAO.obterCliente(cpf);
                if (cliente == null) {
                    JOptionPane.showMessageDialog(frame, "Cliente não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, cliente.toString(), "Cliente Encontrado", JOptionPane.INFORMATION_MESSAGE);
                }
                consultaCpfField.setText("");
            }
        });

        // Botão para remover cliente
        JButton removeButton = new JButton("Remover Cliente");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = removerCpfField.getText().trim();
                if (cpf.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "CPF é obrigatório para remover um cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                clienteDAO.removerCliente(cpf);
                JOptionPane.showMessageDialog(frame, "Cliente removido com sucesso!");
                removerCpfField.setText("");
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Consultar Cliente (CPF):"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(consultaCpfField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Remover Cliente (CPF):"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(removerCpfField, gbc);

        // Adicionando botões ao painel
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(addButton, gbc);

        gbc.gridy = 11;
        panel.add(listButton, gbc);

        gbc.gridy = 12;
        panel.add(consultaButton, gbc);

        gbc.gridy = 13;
        panel.add(removeButton, gbc);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private static JFormattedTextField createFormattedField(String pattern) {
        try {
            MaskFormatter maskFormatter = new MaskFormatter(pattern);
            maskFormatter.setPlaceholderCharacter('_');
            return new JFormattedTextField(new DefaultFormatterFactory(maskFormatter));
        } catch (ParseException e) {
            e.printStackTrace();
            return new JFormattedTextField();
        }
    }
}
