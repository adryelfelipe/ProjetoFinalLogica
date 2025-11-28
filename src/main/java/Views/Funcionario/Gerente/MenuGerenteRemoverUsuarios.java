package Views.Funcionario.Gerente;

import Aplicacao.Funcionario.Nucleo.Dtos.Excluir.ExcluirFuncionarioRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.Excluir.ExcluirFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.ListarFuncionarios.ListaFuncionariosResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;
import Views.Sistema.Main;
import Views.Sistema.MenuEscolhaId;

import java.util.InputMismatchException;

public class MenuGerenteRemoverUsuarios {

    public static void menuRemoverEscolha(long idAdm, NivelAcesso nivelAcesso) {
        ListaFuncionariosResponse responseLista = Main.funcionarioController.listaFuncionariosParaGerente(nivelAcesso);

        if (responseLista.listaFuncionarios().isEmpty()) {
            Ferramentas.mensagemErro("┃  NÃO HÁ NENHUM FUNCIONÁRIO PARA EXCLUIR!");
        } else {
            for (FuncionarioResponse funcionario : responseLista.listaFuncionarios()) {
                System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.printf ("┃  "+Ferramentas.ORANGE_DARK+"ID: "+Ferramentas.AQUA_BLUE+"%-50s┃%n", funcionario.id());
                System.out.printf ("┃  "+Ferramentas.ORANGE_DARK+"Nome: "+Ferramentas.AQUA_BLUE+"%-48s┃%n", funcionario.nome().getNome());
                System.out.printf ("┃  "+Ferramentas.ORANGE_DARK+"Cargo: "+Ferramentas.AQUA_BLUE+"%-47s┃%n", funcionario.nivelAcesso().name());
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            }

            System.out.println();

            try{
                long id = MenuEscolhaId.escolhaIdUpdate();
                ExcluirFuncionarioRequest request = new ExcluirFuncionarioRequest(idAdm, id);
                ExcluirFuncionarioResponse responseExclusao = Main.funcionarioController.excluir(nivelAcesso, request);
                if(responseExclusao.status()) {
                    Ferramentas.mensagemSucesso(responseExclusao.mensagem());
                } else {
                    Ferramentas.mensagemErro(responseExclusao.mensagem());
                }
            } catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }

        Ferramentas.limpaTerminal();
    }
}
