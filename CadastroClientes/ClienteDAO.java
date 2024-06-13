import java.util.List;

public interface ClienteDAO {
    void adicionarCliente(Cliente cliente);
    Cliente obterCliente(String cpf);
    List<Cliente> listarClientes();
    void atualizarCliente(Cliente cliente);
    void removerCliente(String cpf);
}
