package Views;

import Dominio.Compartilhado.Nome;
import Dominio.Funcionario.Administrador.Administrador;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Funcionario.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;
import Dominio.Funcionario.Gerente.Gerente;
import Departamento;
import ProjetoBase.GerenteService;
import Util.Ferramentas;

public class MenuCadastroADM {
    private static final GerenteService gerenteService = new GerenteService();

    public static void menuCadastroGerente(Administrador administrador) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃       CADASTRO GERENTE         ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.println(" ");

        // ----- Atribuição de caracteríscticas de um Usuário ----- //
        Nome nome = MenuSetUsuario.MenuSetNome();
        Ferramentas.limpaTerminal();

        CPF cpf = MenuSetUsuario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        Senha senha = MenuSetUsuario.MenuSetSenha();
        Ferramentas.limpaTerminal();

        // ----- Atribuição de caracteríscticas de um Gerente ----- //
        Departamento idDepartamento = MenuSetGerente.menuSetDepartamento();
        Ferramentas.limpaTerminal();

        // -- Criação do objeto e inserção no banco de dados -- //
        Ferramentas.limpaTerminal();

        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);
        Ferramentas.limpaTerminal();

        try {
            Gerente gerente = new Gerente(nome, cpf, senha, idDepartamento);
            gerenteService.inserirGerente(administrador, gerente);
            System.out.println("GERENTE CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }
}
