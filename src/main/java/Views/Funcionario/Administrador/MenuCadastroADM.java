package Views.Funcionario.Administrador;

import Aplicacao.Funcionario.Gerente.Dtos.Cadastro.CadastroGerenteRequest;
import Aplicacao.Funcionario.Gerente.Dtos.Cadastro.CadastroGerenteResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;
import Views.Funcionario.Gerente.MenuSetGerente;
import Views.Sistema.Main;
import Views.Funcionario.Nucleo.MenuSetFuncionario;

import java.util.List;

public class MenuCadastroADM {
    public static void menuCadastroGerente(NivelAcesso nivelAcesso) {
        System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                    "+Ferramentas.ORANGE_DARK+"CADASTRO GERENTE"+Ferramentas.AQUA_BLUE+"                    ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println("                                                          ");

        // ----- Atribuição de caracteríscticas de um Usuário ----- //
        String nome = MenuSetFuncionario.MenuSetNome();
        Ferramentas.limpaTerminal();

        String cpf = MenuSetFuncionario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        String senha = MenuSetFuncionario.MenuSetSenha();
        Ferramentas.limpaTerminal();

        // ----- Atribuição de caracteríscticas de um Gerente ----- //
        List<Departamento> listaDepartamentos = MenuSetGerente.menuSetDepartamento();
        Ferramentas.limpaTerminal();

        // -- Criação do objeto e inserção no banco de dados -- //
        Ferramentas.limpaTerminal();

        System.out.println(Ferramentas.ITALIC+Ferramentas.DARK_CYAN+"┃  PROCESSANDO DADOS..."+Ferramentas.AQUA_BLUE);
        Ferramentas.Delay(1000);
        Ferramentas.limpaTerminal();

        // -- Gerando request para cadastro de gerente -- //
        CadastroGerenteRequest gerenteRequest = new CadastroGerenteRequest(nome, cpf, senha, listaDepartamentos);
        CadastroGerenteResponse gerenteResponse = Main.gerenteController.salvar(nivelAcesso,gerenteRequest);

        if(gerenteResponse.status()) {
            Ferramentas.mensagemSucesso(gerenteResponse.mensagem());
        } else {
            Ferramentas.mensagemErro(gerenteResponse.mensagem());
        }

        Ferramentas.Delay(800);
        Ferramentas.limpaTerminal();
    }
}
