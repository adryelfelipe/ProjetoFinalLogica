package Views.Funcionario.Supervisor;

import Aplicacao.Funcionario.Tecnico.Dtos.Cadastro.CadastroTecnicoRequest;
import Aplicacao.Funcionario.Tecnico.Dtos.Cadastro.CadastroTecnicoResponse;
import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Supervisor.Supervisor;
import Dominio.OrdemDeServico.Enumeracoes.StatusOS;
import Dominio.OrdemDeServico.Enumeracoes.TipoOS;
import Util.Ferramentas;
import Views.Funcionario.Gerente.MenuSetGerente;
import Views.Maquina.MenuSetMaquina;
import Views.OrdemDeServico.MenuSetOrdemDeServico;
import Views.Sistema.Main;

import java.util.ArrayList;

public class MenuCadastroSupervisor
{
    // -- Atributos -- //
    public static void menuCadastroOrdem(NivelAcesso nivelAcesso) {
        // Menu de cadastro
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃    CADASTRO ORDEM DE SERVIÇO   ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

        // ----- Atribuição de caracteríscticas de uma Máquina ----- //
        long idTecnico = MenuSetOrdemDeServico.SetIdTecnico();
        Ferramentas.limpaTerminal();
        long idMaquina = MenuSetMaquina.SetIdMaquina();
        Ferramentas.limpaTerminal();
        long idSupervisor = MenuSetOrdemDeServico.SetIdSupervisor();
        String descricao = MenuSetOrdemDeServico.SetDescricao();
        Ferramentas.limpaTerminal();
        double valorOS = MenuSetOrdemDeServico.SetValorOS();
        Ferramentas.limpaTerminal();
        ArrayList<Departamento> departamento = MenuSetGerente.menuSetDepartamento();

        // -- Criação do objeto e inserção no banco de dados -- //
        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);

        // -- Gerando request para cadastro de Ordem de Serviço -- //
        CadastroOsRequest request = new CadastroOsRequest(idTecnico, idSupervisor, idMaquina, StatusOS.EM_ANDAMENTO, descricao, valorOS, departamento.getFirst(), TipoOS.CORRETIVA);
        CadastroOsResponse response = Main.osController.salvar(nivelAcesso, request);
        Ferramentas.mensagemErro(response.mensagem());
        Ferramentas.limpaTerminal();
    }
}
