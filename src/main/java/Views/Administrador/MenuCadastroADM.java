package Views.Administrador;

import Models.Administrador;
import Models.Gerente;
import Models.Enumeracoes.Departamento;
import Service.UsuarioService;
import Util.Ferramentas;
import Views.Nucleo.MenuAlteraUsuario;

import java.util.Arrays;

public class MenuCadastroADM {
    private static final UsuarioService usuarioService = new UsuarioService();

    public static void menuCadastroGerente(Administrador administrador) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                  CADASTRO GERENTE                 ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println(" ");

        //                    ATRIBUÇÃO DE CARACTERÍSTICAS DE UM USUÁRIO                    //
        String nome = MenuAlteraUsuario.MenuSetNome();
        Ferramentas.limpaTerminal();

        String cpf = MenuAlteraUsuario.MenuSetCpf();
        Ferramentas.limpaTerminal();

        String senha = MenuAlteraUsuario.MenuSetSenha();
        Ferramentas.limpaTerminal();

        //                    ATRIBUIÇÃO DE CARACTERÍSTICAS DE UM GERENTE                    //
        Departamento departamento = MenuAlteraADM.menuSetDepartamento();
        Ferramentas.limpaTerminal();

        //                    CRIAÇÃO DO OBJETO E INSERÇÃO NO BANCO DE DADOS                 //
        Ferramentas.limpaTerminal();

        System.out.println("┃  PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);
        Ferramentas.limpaTerminal();

        try {
            Gerente gerente = new Gerente(nome, cpf, senha, Arrays.asList(departamento));
            usuarioService.salvarGerente(administrador, gerente);
            System.out.println("┃  GERENTE CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }
}
