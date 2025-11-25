package Views.Supervisor;

import Models.Enumeracoes.Departamento;
import Models.Enumeracoes.TipoOs;
import Models.OrdemDeServico;
import Models.Supervisor;
import Models.Enumeracoes.StatusOS;
import Service.MaquinaService;
import Service.OrdemDeServicoService;
import Util.Ferramentas;

public class MenuCadastroSupervisor
{
    //                    ATRIBUTOS                    //
    private static final OrdemDeServicoService ordemDeServicoService = new OrdemDeServicoService();
    private static final MaquinaService maquinaService = new MaquinaService();

    public static void menuCadastroOrdem(Supervisor supervisor) {
        //                    GARANTIA DE INICIAÇÃO DE VARIÁVEIS                    //
        long idTecnico = 0;
        long idMaquina = 0;

        //                    MENU DE CADASTRO                    //
        System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃             "+Ferramentas.ORANGE_DARK+"CADASTRO ORDEM DE SERVIÇO"+Ferramentas.AQUA_BLUE+"             ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        //ATRIBUIÇÃO DE CARACTERÍSTICAS DE UMA ORDEM DE SERVIÇO                    //
        try{
            idTecnico = MenuAlteraOrdemDeServico.SetIdTecnico();
            Ferramentas.limpaTerminal();
            idMaquina = MenuAlteraOrdemDeServico.SetIdMaquina();
        } catch (IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
            return;
        }
        Ferramentas.limpaTerminal();
        String descricao = MenuAlteraOrdemDeServico.SetDescricao();
        Ferramentas.limpaTerminal();
        double valorOrdemServico = MenuAlteraOrdemDeServico.SetValorOS();
        Ferramentas.limpaTerminal();

        //                    CRIAÇÃO DO OBJETO E INSERÇÃO NO BANCO DE DADOS                    //
        System.out.println(Ferramentas.DARK_CYAN+"┃  PROCESSANDO DADOS..."+Ferramentas.AQUA_BLUE);
        Ferramentas.Delay(1000);

        Departamento departamento = maquinaService.maquinaParaDepartamento(idMaquina);

        try {
            OrdemDeServico ordemServico =   new OrdemDeServico(idTecnico, idMaquina,StatusOS.ABERTA, descricao, valorOrdemServico, departamento, TipoOs.CORRETIVA);
            ordemDeServicoService.inserirOrdemDeServico(supervisor, ordemServico);
            Ferramentas.limpaTerminal();
            System.out.println(Ferramentas.ORANGE_DARK+"┃  ORDEM DE SERVIÇO CADASTRADA COM SUCESSO!"+Ferramentas.AQUA_BLUE);
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }
}
