package Views.Funcionario.Gerente;

import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.Excluir.ExcluirFuncionarioRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.Excluir.ExcluirFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.ListarFuncionarios.ListaFuncionariosResponse;
import Aplicacao.Maquina.Dtos.Exclusao.ExcluirMaquinaRequest;
import Aplicacao.Maquina.Dtos.Exclusao.ExcluirMaquinaResponse;
import Aplicacao.Maquina.Dtos.Listar.ListaMaquinasResponse;
import Aplicacao.Maquina.Dtos.Listar.MaquinaResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;
import Views.Sistema.Main;
import Views.Sistema.MenuEscolhaId;

import java.util.InputMismatchException;

public class MenuExcluirMaquina {
    public static void menuRemoverEscolha(long idGer, NivelAcesso nivelAcesso) {
        ListaMaquinasResponse responseLista = Main.maquinaController.listarMaquinas(nivelAcesso);

        if (responseLista.listaMaquinas().isEmpty()) {
            Ferramentas.mensagemErro("┃  NÃO HÁ NENHUMA MÁQUINA PARA EXCLUIR!");
        } else {
            for (MaquinaResponse maquina : responseLista.listaMaquinas()) {
                System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.printf ("┃  "+Ferramentas.ORANGE_DARK+"ID: "+Ferramentas.AQUA_BLUE+"%-50s┃%n", maquina.id());
                System.out.printf ("┃  "+Ferramentas.ORANGE_DARK+"Nome: "+Ferramentas.AQUA_BLUE+"%-48s┃%n", maquina.nomeMaquina().getNome());
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            }

            System.out.println();

            try{
                long id = MenuEscolhaId.escolhaIdUpdate();
                ExcluirMaquinaRequest request = new ExcluirMaquinaRequest(id);
                ExcluirMaquinaResponse responseExclusao = Main.maquinaController.excluir(nivelAcesso, request);
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
