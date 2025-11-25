package Views;

import DAO.OrdemDeServicoDAO;
import Models.Enumeracoes.StatusOS;
import Models.OrdemDeServico;
import Service.OrdemDeServicoService;
import Util.Ferramentas;

public class MenuOrdemDeServico
{
    private static OrdemDeServicoDAO osDao = new OrdemDeServicoDAO();
    private static OrdemDeServicoService osService = new OrdemDeServicoService();

    public static void exibirOS()
    {
        if(osDao.listarOsAtivas().isEmpty())
        {
            Ferramentas.mensagemErro("┃  SEM ORDENS DE SERVIÇO ATIVAS");
            return;
        }

        for(OrdemDeServico os : osDao.listaOsAtivas())
        {
            System.out.println(Ferramentas.AQUA_BLUE+"┃  ID: "+Ferramentas.AQUA_BLUE + os.getIdOrdemDeServico());
            System.out.println(Ferramentas.AQUA_BLUE+"┃  Status: "+Ferramentas.AQUA_BLUE+ os.getStatusDaOrdem());
        }
    }

    public static void concluirOS()
    {
        if(osDao.listarOsAtivas().isEmpty())
        {
            Ferramentas.mensagemErro("┃  SEM ORDENS DE SERVIÇO ATIVAS");
            return;
        }

        for(OrdemDeServico os : osDao.listaOsAtivas())
        {
            if(os.getStatusDaOrdem() == StatusOS.EM_ANDAMENTO)
            {
                System.out.println(Ferramentas.AQUA_BLUE+"┃  ID: " + os.getIdOrdemDeServico());
                System.out.println(Ferramentas.AQUA_BLUE+"┃  Descrição: " + os.getDescricao());
            }
        }

        System.out.println(Ferramentas.AQUA_BLUE+"┃  Digite o ID da Ordem de Serviço que deseja concluir: ");
        long id = Ferramentas.lInteiro();

        if(osDao.existeId(id))
        {
            OrdemDeServico os = osDao.buscarPorId(id);
            os.setStatusDaOrdem(StatusOS.FECHADA);
            osService.atualizar(os);
        }
        else
        {
            Ferramentas.mensagemErro("┃  ERRO! ID NÃO EXISTE");
            return;
        }
    }
}
