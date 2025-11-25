package Views.Supervisor;
/*
import DAO.OrdemDeServicoDAO;
import Models.Enumeracoes.Departamento;
import Models.OrdemDeServico;
import Models.Supervisor;
import Util.Ferramentas;

import java.sql.SQLException;
import java.util.List;

public class MenuSupervisorAcompanharStatus
{
    private OrdemDeServicoDAO ordemDeServicoDAO = new OrdemDeServicoDAO();

    public static void acompanharStatus(Supervisor supervisor)
    {
        System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃       "+Ferramentas.ORANGE_DARK+"ACOMPANHAR STATUS DE ORDEM DE SERVIÇO"+Ferramentas.AQUA_BLUE+"       ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        try {

            //                    DESCOBRIR QUAL O DEPARTAMENTO DO SUPERVISOR                    //
            List<Departamento> departamentos = supervisor.getListaDepartamentos();

            if (departamentos.isEmpty()) {
                System.out.println(Ferramentas.AQUA_BLUE+"┃  ERRO: VOCÊ NÃO ESTÁ VINCULADO A NUNHUM DEPARTAMENTO!");
                return;
            }

            //                    PEGA O PRIMEIRO DEPARTAMENTO DA LISTA                    //
            Departamento deptEnum = departamentos.getFirst();

            //                    CONVERTE O ENUM PARA O ID NUMÉRICO DO BANCO                    //
            long idDeptBanco = (deptEnum == Departamento.ELETRICA) ? 1 : 2;

            System.out.println("Listando OSs do departamento: " + deptEnum);

            //                    CHAMAR A DAO                    //
            List<OrdemDeServico> listaOS = ordemDeServicoDAO.listarPorDepartamento(idDeptBanco);

            if (listaOS.isEmpty()) {
                System.out.println("Nenhuma Ordem de Serviço encontrada.");
                return;
            }

            //                    EXIBIR TABELA FORMATADA                    //
            // %-5d = NÚMERO ALINHADO À ESQUEDA COM 5 ESPAÇOS
            // %-15s = TEXTO ALINHADO À ESQUERDA COM 15 ESPAÇOS
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
*/