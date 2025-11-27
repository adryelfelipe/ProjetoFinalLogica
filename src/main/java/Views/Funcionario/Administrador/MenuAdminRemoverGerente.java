package Views.Funcionario.Administrador;

import Aplicacao.Funcionario.Nucleo.Dtos.Excluir.ExcluirFuncionarioRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.Excluir.ExcluirFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.ListarFuncionarios.ListaFuncionariosResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;
import Views.Sistema.Main;
import Views.Sistema.MenuEscolhaId;

import java.sql.SQLOutput;

public class MenuAdminRemoverGerente {
    public static void menuRemoverEscolha(long idAdm, NivelAcesso nivelAcesso) {
        ListaFuncionariosResponse responseLista = Main.funcionarioController.listaFuncionariosParaAdm(nivelAcesso);

        if(responseLista.listaFuncionarios() == null) {
            Ferramentas.mensagemErro(responseLista.mensagem());
            return;
        }

        if(responseLista.listaFuncionarios().isEmpty()) {
            Ferramentas.mensagemErro("┃  NÃO HÁ NENHUM FUNCIONARIO PARA EXCLUIR");
            return;
        }

        for(FuncionarioResponse funcionario : responseLista.listaFuncionarios())
        {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.printf("┃  ID: %-50s┃%n", funcionario.id());
            System.out.printf("┃  Nome: %-48s┃%n", funcionario.nome().getNome());
            System.out.printf("┃  Cargo: %-47s┃%n", funcionario.nivelAcesso().name());
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        }

        long id = MenuEscolhaId.escolhaIdUpdate();
        ExcluirFuncionarioRequest request = new ExcluirFuncionarioRequest(idAdm, id);
        ExcluirFuncionarioResponse responseExclusao = Main.funcionarioController.excluir(nivelAcesso, request);
        Ferramentas.mensagemErro(responseExclusao.mensagem());
    }
}
