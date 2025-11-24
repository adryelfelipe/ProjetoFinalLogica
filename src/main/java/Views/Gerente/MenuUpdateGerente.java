package Views.Gerente;
import Models.*;
import Models.Enumeracoes.Especialidade;
import Service.UsuarioService;
import Util.Ferramentas;
import Views.Nucleo.MenuEscolhaId;
import Views.MenuSetSupervisor;
import Views.MenuSetTecnico;
import Views.MenuSetUsuario;

import java.util.InputMismatchException;

public class MenuUpdateGerente {
    private static final UsuarioService usuarioService = new UsuarioService();

    public static void menuUpdateEscolha(Gerente gerente) {
        // Menu
        boolean verifica = false;
        int opUpdate = 0;

        while(true)
        {

            while(!verifica) {
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃                    ATUALIZAR OS                   ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
                System.out.println("┃                                                   ┃");
                System.out.println("┃  1 - Alterar Técnico                              ┃");
                System.out.println("┃  2 - Alterar Supervisor                           ┃");
                System.out.println("┃  3 - Sair do Menu                                 ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┃  Escolha: ");

                try
                {
                    opUpdate = Ferramentas.lInteiro();
                    verifica = true;
                }
                catch (InputMismatchException e){
                    Ferramentas.menuDefault();
                }
            }

            // Reinicia a veriável de verificação
            verifica = false;

            switch(opUpdate) {
                case 1 -> menuUpdateTecnico(gerente);
                case 2 -> menuUpdateSupervisor(gerente);
                case 3 -> {return;}

                default -> Ferramentas.mensagemErro("┃  ERRO! TENTE NOVAMENTE!");
            }
        }
    }

    public static void menuUpdateTecnico(Gerente gerente) {
            // -- Garantia de inicialização -- //
        long idTecnico;
        int UpdateT = 0;
        boolean verifica = false;

        try
        {
            idTecnico = MenuEscolhaId.escolhaIdUpdate();
        } catch (InputMismatchException e)
        {
            Ferramentas.mensagemErro(e.getMessage());
            return;
        }

        Tecnico tecnico = ((Tecnico) usuarioService.findById(idTecnico));

        while(true)
        {

            while(!verifica)
            {

                System.out.println("\n                                                 \n");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃                    ATUALIZAR OS                   ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("                                                     ");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━┓         ┏━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃  EDITAR   TÉCNICO  ┃         ┃        ATUAL       ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━┃         ┃━━━━━━━━━━━━━━━━━━━━┃");
                System.out.println("┃  1 - Nome          ┃         ┃ Nome: " + tecnico.getNome());
                System.out.println("┃  2 - CPF           ┃         ┃ CPF: " + tecnico.getCpf());
                System.out.println("┃  3 - Senha         ┃         ┃ Senha: " + tecnico.getSenha());
                System.out.println("┃  5 - Especialidade ┃         ┃ Especialidade: " + tecnico.getEspecialidade());
                System.out.println("┃  6 - Sair do Menu  ┃         ┗━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┃  Escolha:  ");

                try
                {
                    UpdateT = Ferramentas.lInteiro();
                    verifica = true;
                } catch (InputMismatchException e){
                    Ferramentas.menuDefault();
                }
            }

            // Reinicia a veriável de verificação
            verifica = false;

            switch(UpdateT) {
                case 1 -> {
                    String nome = MenuSetUsuario.MenuSetNome();
                    tecnico.setNome(nome);
                }

                case 2 -> {
                    String cpf = MenuSetUsuario.MenuSetCpf();
                    tecnico.setCpf(cpf);
                }

                case 3 -> {
                    String senha = MenuSetUsuario.MenuSetSenha();
                    tecnico.setSenha(senha);
                }
                case 4 -> {
                    Especialidade especialidade = MenuSetTecnico.MenuSetEspecialidade();
                    tecnico.setEspecialidade(especialidade);
                }
                case 5 ->
                {
                    return;
                }
                default -> Ferramentas.menuDefault();
            }
        }
    }
    public static void menuUpdateSupervisor(Gerente gerente)
    {
        long idSupervisor;
        int UpdateS = 0;
        boolean verifica = false;

        try
        {
            idSupervisor = MenuEscolhaId.escolhaIdUpdate();
        }
        catch (InputMismatchException e)
        {
            Ferramentas.mensagemErro(e.getMessage());
            return;
        }

        Supervisor supervisor = ((Supervisor) usuarioService.findById(idSupervisor));

        while(true)
        {
            while(!verifica)
            {
                System.out.println("\n                                                       \n");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃                    ATUALIZAR OS                   ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("                                                            ");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┓        ┏━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃ EDITAR   SUPERVISOR ┃        ┃       ATUAL        ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┃        ┃━━━━━━━━━━━━━━━━━━━━┃");
                System.out.println("┃  1 - Nome           ┃        ┃ Nome: " + supervisor.getNome());
                System.out.println("┃  2 - CPF            ┃        ┃ CPF: " + supervisor.getCpf());
                System.out.println("┃  3 - Senha          ┃        ┃ Senha: " + supervisor.getSenha());
                System.out.println("┃  5 - Meta Mensal    ┃        ┃ Meta Mensal: " + supervisor.getMetaMensal());
                System.out.println("┃  6 - Sair do Menu   ┃        ┗━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┃  Escolha:  ");

                try
                {
                    UpdateS = Ferramentas.lInteiro();
                    verifica = true;
                }
                catch (InputMismatchException e)
                {
                    Ferramentas.menuDefault();
                }
            }

            // Reinicia a veriável de verificação
            verifica = false;

            switch(UpdateS)
            {
                case 1 -> {
                    String nome = MenuSetUsuario.MenuSetNome();
                    supervisor.setNome(nome);
                }

                case 2 -> {
                    String cpf = MenuSetUsuario.MenuSetCpf();
                    supervisor.setCpf(cpf);
                }

                case 3 -> {
                    String senha = MenuSetUsuario.MenuSetSenha();
                    supervisor.setSenha(senha);
                }
                case 4 -> {
                    double metaMensal = MenuSetSupervisor.MenuSetMetaMensal();
                    supervisor.setMetaMensal(metaMensal);
                }
                case 5 ->
                {
                    usuarioService.atualizar(gerente, supervisor);
                    return;
                }

                default -> Ferramentas.menuDefault();
            }
        }
    }
}
