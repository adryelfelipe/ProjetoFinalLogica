package Views.Administrador;

import Models.Administrador;
import Models.Gerente;
import Models.Enumeracoes.Departamento;
import Service.UsuarioService;
import Util.Ferramentas;
import Views.Nucleo.MenuEscolhaId;
import Views.Nucleo.MenuAlteraUsuario;

import java.util.Arrays;

public class MenuUpdateADM {

    private static final UsuarioService usuarioService = new UsuarioService();

    public static void updateGerente(Administrador administrador) {
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

        while (true)
        {
            System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                  "+Ferramentas.ORANGE_DARK+"ATUALIZAR GERENTE"+Ferramentas.AQUA_BLUE+"                ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println("                                                     ");
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━┓         ┏━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"EDITAR   GERENTE"+Ferramentas.AQUA_BLUE+"  ┃         ┃        "+Ferramentas.ORANGE_DARK+"ATUAL"+Ferramentas.AQUA_BLUE+"       ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━┃         ┃━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃  1 - Nome          ┃         ┃ Nome: " + gerente.getNome());
            System.out.println("┃  2 - CPF           ┃         ┃ CPF: " + gerente.getCpf());
            System.out.println("┃  3 - Senha         ┃         ┃ Senha: " + gerente.getSenha());
            System.out.println("┃  5 - Departamento  ┃         ┃ Departamento: " + gerente.getListaDepartamentos().getFirst());
            System.out.println("┃  6 - Sair do Menu  ┃         ┗━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println("┃ ➤ Escolha:  ");

            try {
                opcaoAdm = Ferramentas.lInteiro();

                switch (opcaoAdm) {
                    case 1 -> {
                        String nome = MenuAlteraUsuario.MenuSetNome();
                        gerente.setNome(nome);
                    }

                    case 2 -> {
                        String cpf = MenuAlteraUsuario.MenuSetCpf();
                        gerente.setCpf(cpf);
                    }

                    case 3 -> {
                        String senha = MenuAlteraUsuario.MenuSetSenha();
                        gerente.setSenha(senha);
                    }
                    case 4 -> {
                        Departamento departamento = MenuAlteraADM.menuSetDepartamento();
                        gerente.setListaDepartamentos(Arrays.asList(departamento));
                    }
                    case 5 ->
                    {
                        usuarioService.atualizar(administrador, gerente);
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
