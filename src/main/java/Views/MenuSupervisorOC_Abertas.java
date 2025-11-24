package Views;
import DAO.MaquinaDAO;
import DAO.OcorrenciaDAO;
import Database.ConnectionFactory;
import Models.Enumeracoes.Departamento;
import Models.Enumeracoes.StatusOS;
import Models.Enumeracoes.StatusOc;
import Models.Enumeracoes.TipoOs;
import Models.Ocorrencia;
import Models.OrdemDeServico;
import Models.Supervisor;
import Service.OrdemDeServicoService;
import Util.Ferramentas;
import Views.Supervisor.MenuCadastroSupervisor;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

public class MenuSupervisor {

    private OcorrenciaDAO ocorrenciaDAO = new OcorrenciaDAO();
    private MaquinaDAO maquinaDAO = new MaquinaDAO();
    private OrdemDeServicoService osService = new OrdemDeServicoService();

    public void criarOsPreditiva(long idUsuarioLogado, Supervisor supervisor) {
        System.out.println("\n--- Criar OS Preditiva a partir de Ocorrência ---");

        try (Connection conn = ConnectionFactory.getConnection()) {

            // 1. Descobrir o departamento do supervisor
            List<Departamento> departamentos = paraDepartamentosPorId(conn, idUsuarioLogado);

            if (departamentos.isEmpty()) {
                System.out.println("Supervisor sem departamento vinculado.");
                return;
            }

            // Pega o primeiro departamento (Exemplo: Eletrica)
            Departamento deptEnum = departamentos.getFirst();

            // Converte Enum para ID (ajuste os IDs conforme seu banco)
            long idDeptSupervisor = (deptEnum == Departamento.ELETRICA) ? 1 : 2;

            // 2. Buscar lista da DAO (listarOcAtivas)
            List<Ocorrencia> listaAbertas = ocorrenciaDAO.listarOcAtivas(idDeptSupervisor);

            if (listaAbertas.isEmpty()) {
                System.out.println("Nenhuma ocorrência aberta para o departamento " + deptEnum);
                return;
            }

            // 3. Exibir Lista
            System.out.println("ID | Maquina | Status:");
            for (Ocorrencia oc : listaAbertas) {
                System.out.println(oc.getID_OC() + " | " + oc.getIdMaquina() + " | " + oc.getStatusOC());
            }

            // 4. Selecionar Ocorrência
            System.out.print("Digite o ID da ocorrência: ");
            long idSelecionado = Ferramentas.lInteiro();

            Ocorrencia ocorrenciaSelecionada = null;

            // Busca manual sem stream
            for (Ocorrencia oc : listaAbertas) {
                if (oc.getID_OC() == idSelecionado) {
                    ocorrenciaSelecionada = oc;
                    break;
                }
            }

            if (ocorrenciaSelecionada == null) {
                System.out.println("ID inválido.");
                return;
            }

            // OS Preditiva
            MenuCadastroSupervisor.menuCadastroOrdem(supervisor);
            System.out.println(">> Sucesso: Ordem de Serviço Preditiva criada!");

            // 7. Atualizar a Ocorrência para EM_ANDAMENTO
            ocorrenciaSelecionada.setStatusOC(StatusOc.EM_ANDAMENTO);
            ocorrenciaDAO.atualizarStatusOc(ocorrenciaSelecionada);

        } catch (SQLException e) {
            System.err.println("Erro de conexão: " + e.getMessage());
        }
    }
}