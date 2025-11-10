package Views;

import Dominio.Funcionario.Administrador.Administrador;
import Dominio.Funcionario.Funcionario.Funcionario.Enumeracoes.Departamento;
import Dominio.Funcionario.Funcionario.ObjetosDeValor.CPF;
import Dominio.Funcionario.Funcionario.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Funcionario.ObjetosDeValor.Senha;
import Dominio.Funcionario.Gerente.Gerente;
import Departamento;
import ProjetoBase.GerenteService;
import ProjetoBase.UsuarioService;
import Util.Ferramentas;

public class MenuUpdateADM {

    private static final GerenteService gerenteService = new GerenteService();
    private static final UsuarioService usuarioService = new UsuarioService();

    public static void updateGerente(Administrador administrador) {
        boolean verifica = false;
        long idGerente;
        int opcaoAdm = 0;

        try
        {
            idGerente = MenuEscolhaId.escolhaIdUpdate();
        } catch (IllegalArgumentException e)
        {
            Ferramentas.mensagemErro(e.getMessage());
            return;
        }

        Gerente gerente = ((Gerente) usuarioService.findById(idGerente));

        while (!verifica)
        {
            System.out.println("          ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓          ");
            System.out.println("          ┃       ATUALIZAR GERENTE        ┃          ");
            System.out.println("          ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛          ");

            System.out.print("\n\n"); // pula linhas
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━┓          ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  EDITAR   GERENTE  ┃          ┃            ATUAL           ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━┃          ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println(String.format("┃  1 - Nome          ┃          ┃  %-26s┃", gerente.getNome()));
            System.out.println(String.format("┃  2 - CPF           ┃          ┃  %-26s┃" + gerente.getCpf()));
            System.out.println(String.format("┃  3 - Senha         ┃          ┃  %-26s┃" + gerente.getSenha()));
            System.out.println(String.format("┃  5 - Departamento  ┃          ┃  %-26s┃" + gerente.getDepartamento()));
            System.out.println("┃  6 - Sair do Menu  ┃          ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println("┃ ➤ Escolha:  ");

            try {
                opcaoAdm = Ferramentas.lInteiro();

                switch (opcaoAdm) {
                    case 1 -> {
                        NomeFuncionario nome = MenuSetUsuario.MenuSetNome();
                        usuarioService.updateNomeUsuario(administrador, idGerente, nome);
                        gerente.alteraNome(nome);
                    }

                    case 2 -> {
                        CPF cpf = MenuSetUsuario.MenuSetCpf();
                        usuarioService.updateCpfUsuario(administrador, idGerente, cpf);
                        gerente.alteraCpf(cpf);
                    }

                    case 3 -> {
                        Senha senha = MenuSetUsuario.MenuSetSenha();
                        usuarioService.updateSenhaUsuario(administrador, idGerente, senha);
                        gerente.alteraSenha(senha);
                    }
                    case 4 -> {
                        Departamento departamento = MenuSetGerente.menuSetDepartamento();
                        gerenteService.updateDepartamento(administrador, idGerente, departamento);
                        gerente.setDepartamento(departamento);
                    }
                    case 5 ->
                    {
                        verifica = true;
                        return;
                    }
                    default -> Ferramentas.menuDefault();
                }
            }
            catch(IllegalArgumentException e)
            {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
