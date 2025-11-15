package Views.Funcionario.Gerente;

import Aplicacao.Funcionario.Nucleo.Dtos.Excluir.ExcluirFuncionarioRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.Excluir.ExcluirFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.Funcionario.FuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.ListarFuncionarios.ListaFuncionariosResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;
import Views.Sistema.Main;
import Views.Sistema.MenuEscolhaId;

public class MenuGerenteRemoverUsuarios {

    public static void menuRemoverEscolha(long idAdm, NivelAcesso nivelAcesso) {
        ListaFuncionariosResponse responseLista = Main.funcionarioController.listaFuncionariosParaGerente(nivelAcesso);

        if (responseLista.listaFuncionarios().isEmpty()) {
            Ferramentas.mensagemErro("Não há nenhum funcionário para excluir");
        } else {
            for (FuncionarioResponse funcionario : responseLista.listaFuncionarios()) {
                System.out.println("ID: " + funcionario.id() + " // Nome: " + funcionario.nome().getNome() + "  // Cargo: " + funcionario.nivelAcesso().name());
            }

            long id = MenuEscolhaId.escolhaIdUpdate();
            ExcluirFuncionarioRequest request = new ExcluirFuncionarioRequest(idAdm, id);
            ExcluirFuncionarioResponse responseExclusao = Main.funcionarioController.excluir(nivelAcesso, request);
            Ferramentas.mensagemErro(responseExclusao.mensagem());
        }
    }
}
