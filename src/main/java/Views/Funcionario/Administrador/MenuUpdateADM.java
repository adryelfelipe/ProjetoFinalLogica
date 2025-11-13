package Views.Funcionario.Administrador;

public class MenuUpdateADM {
/*
    private static final GerenteService gerenteService = new GerenteService();
    private static final UsuarioService usuarioService = new UsuarioService();

    public static void updateGerente() {
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
            System.out.println(String.format("┃  5 - Departamento  ┃          ┃  %-26s┃" + gerente.getDepartamentos().getListaDepartamentos().get(0)));
            System.out.println("┃  6 - Sair do Menu  ┃          ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println("┃ ➤ Escolha:  ");

            try {
                opcaoAdm = Ferramentas.lInteiro();

                switch (opcaoAdm) {
                    case 1 -> {
                        String nome = MenuSetUsuario.MenuSetNome();
                        usuarioService.updateNomeUsuario(idGerente, nome);
                        gerente.alteraNome(nome);
                    }

                    case 2 -> {
                        CPF cpf = MenuSetUsuario.MenuSetCpf();
                        usuarioService.updateCpfUsuario(idGerente, cpf);
                        gerente.alteraCpf(cpf);
                    }

                    case 3 -> {
                        Senha senha = MenuSetUsuario.MenuSetSenha();
                        usuarioService.updateSenhaUsuario(idGerente, senha);
                        gerente.alteraSenha(senha);
                    }
                    case 4 -> {
                        Departamento departamento = MenuSetGerente.menuSetDepartamento();
                        gerenteService.updateDepartamento(idGerente, new ListaDepartamentos(Arrays.asList(departamento)));
                        gerente.adicionarDepartamento(departamento);
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

             */
}
