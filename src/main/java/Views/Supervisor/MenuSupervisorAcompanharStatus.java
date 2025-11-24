package Views.Supervisor;

import DAO.OrdemDeServicoDAO;
import Models.Enumeracoes.Departamento;
import Models.OrdemDeServico;
import Models.Supervisor;
import java.sql.SQLException;
import java.util.List;

public class MenuSupervisorAcompanharStatus
{
    private OrdemDeServicoDAO ordemDeServicoDAO = new OrdemDeServicoDAO();

    public static void acompanharStatus(Supervisor supervisor)
    {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃       ACOMPANHAR STATUS DE ORDEM DE SERVIÇO       ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        try {

            // 1. Descobrir qual o departamento do Supervisor
            List<Departamento> departamentos = supervisor.getListaDepartamentos();

            if (departamentos.isEmpty()) {
                System.out.println("Erro: Você não está vinculado a nenhum departamento.");
                return;
            }

            // Pega o primeiro departamento da lista
            Departamento deptEnum = departamentos.getFirst();

            // Converte o Enum para o ID numérico do banco
            long idDeptBanco = (deptEnum == Departamento.ELETRICA) ? 1 : 2;

            System.out.println("Listando OSs do departamento: " + deptEnum);

            // 2. Chamar a DAO
            List<OrdemDeServico> listaOS = ordemDeServicoDAO.listarPorDepartamento(idDeptBanco);

            if (listaOS.isEmpty()) {
                System.out.println("Nenhuma Ordem de Serviço encontrada.");
                return;
            }

            // 3. Exibir Tabela Formatada
            // %-5d = número alinhado à esquerda com 5 espaços
            // %-15s = texto alinhado à esquerda com 15 espaços
            System.out.println("----------------------------------------------------------");
            System.out.printf("%-5s | %-10s | %-15s | %-15s%n", "ID", "Máquina", "Tipo", "Status");
            System.out.println("----------------------------------------------------------");

            for (OrdemDeServico os : listaOS) {
                System.out.printf("%-5d | %-10d | %-15s | %-15s%n",
                        os.getIdOrdemDeServico(),
                        os.getIdMaquina(),
                        os.getTipoOs(),
                        os.getStatusDaOrdem()
                );
            }
            System.out.println("----------------------------------------------------------");

        } catch (SQLException e) {
            System.err.println("Erro de conexão ao buscar departamentos: " + e.getMessage());
        }
    }
}
