package Views.Gerente;
import Models.*;
import Models.Enumeracoes.Especialidade;
import Service.UsuarioService;
import Util.Ferramentas;
import Views.Nucleo.MenuEscolhaId;
import Views.Nucleo.MenuAlteraUsuario;

import java.util.InputMismatchException;

public class MenuUpdateGerente {
    //                    ATRIBUTOS                    //
    private static final UsuarioService usuarioService = new UsuarioService();

    public static void menuUpdateEscolha(Gerente gerente) {
        //                    GARANTIA DE INICIAÇÃO                    //
        boolean verifica = false;
        int opUpdate = 0;

        while(true)
        {
            //                    MENU                    //
            while(!verifica) {
                System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃            "+Ferramentas.ORANGE_DARK+"ATUALIZAR TÉCNICO/SUPERVISOR"+Ferramentas.AQUA_BLUE+"           ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
                System.out.println("┃                                                   ┃");
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Atualizar Técnico"+Ferramentas.AQUA_BLUE+"                            ┃");
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Atualizar Supervisor"+Ferramentas.AQUA_BLUE+"                         ┃");
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - Sair do Menu"+Ferramentas.AQUA_BLUE+"                                 ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┃ ➤ Escolha: ");

                try
                {
                    opUpdate = Ferramentas.lInteiro();
                    verifica = true;
                }
                catch (InputMismatchException e){
                    Ferramentas.menuDefault();
                }
            }

            //                    REINICIA A VARIAVEL DE INICIAÇÃO                    //
            verifica = false;

            switch(opUpdate) {
                case 1 -> menuUpdateTecnico(gerente);
                case 2 -> menuUpdateSupervisor(gerente);
                case 3 -> {return;}

                default -> Ferramentas.mensagemErro(Ferramentas.ITALIC+Ferramentas.DARK_CYAN+"┃  ERRO! TENTE NOVAMENTE!"+Ferramentas.RESET+Ferramentas.AQUA_BLUE);
            }
        }
    }

    public static void menuUpdateTecnico(Gerente gerente) {
            //                    GARANTIA DE INICIAÇÃO                    //
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
                //                    MENU                    //
                System.out.println("\n                                                 \n");
                System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃                  "+Ferramentas.ORANGE_DARK+"ATUALIZAR TÉCNICO"+Ferramentas.AQUA_BLUE+"                ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("                                                     ");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━┓         ┏━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"EDITAR   TÉCNICO"+Ferramentas.AQUA_BLUE+"  ┃         ┃        "+Ferramentas.ORANGE_DARK+"ATUAL"+Ferramentas.AQUA_BLUE+"       ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━┃         ┃━━━━━━━━━━━━━━━━━━━━┃");
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Nome"+Ferramentas.AQUA_BLUE+"          ┃         ┃ Nome: " + tecnico.getNome());
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - CPF"+Ferramentas.AQUA_BLUE+"           ┃         ┃ CPF: " + tecnico.getCpf());
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - Senha"+Ferramentas.AQUA_BLUE+"         ┃         ┃ Senha: " + tecnico.getSenha());
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"5 - Especialidade"+Ferramentas.AQUA_BLUE+" ┃         ┃ Especialidade: " + tecnico.getEspecialidade());
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"6 - Sair do Menu"+Ferramentas.AQUA_BLUE+"  ┃         ┗━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┃ ➤ Escolha:  ");

                try
                {
                    UpdateT = Ferramentas.lInteiro();
                    verifica = true;
                } catch (InputMismatchException e){
                    Ferramentas.menuDefault();
                }
            }

            //                    REINICIA A VARIAVEL DE INICIAÇÃO                    //
            verifica = false;

            switch(UpdateT) {
                case 1 -> {
                    String nome = MenuAlteraUsuario.MenuSetNome();
                    tecnico.setNome(nome);
                    usuarioService.atualizar(gerente, tecnico);
                }

                case 2 -> {
                    String cpf = MenuAlteraUsuario.MenuSetCpf();
                    tecnico.setCpf(cpf);
                    usuarioService.atualizar(gerente, tecnico);
                }

                case 3 -> {
                    String senha = MenuAlteraUsuario.MenuSetSenha();
                    tecnico.setSenha(senha);
                    usuarioService.atualizar(gerente, tecnico);
                }
                case 4 -> {
                    Especialidade especialidade = MenuAlteraGerente.MenuSetEspecialidade();
                    tecnico.setEspecialidade(especialidade);
                    usuarioService.atualizar(gerente, tecnico);
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
        //                    GARANTIA DE INICIAÇÃO DE VARIÁVEIS                    //
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
                //                    MENU                    //
                System.out.println("\n                                                       \n");
                System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃                "+Ferramentas.ORANGE_DARK+"ATUALIZAR SUPERVISOR"+Ferramentas.AQUA_BLUE+"               ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("                                                            ");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┓        ┏━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃ "+Ferramentas.ORANGE_DARK+"EDITAR   SUPERVISOR"+Ferramentas.AQUA_BLUE+" ┃        ┃       "+Ferramentas.ORANGE_DARK+"ATUAL"+Ferramentas.AQUA_BLUE+"        ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┃        ┃━━━━━━━━━━━━━━━━━━━━┃");
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Nome"+Ferramentas.AQUA_BLUE+"           ┃        ┃ Nome: " + supervisor.getNome());
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - CPF"+Ferramentas.AQUA_BLUE+"            ┃        ┃ CPF: " + supervisor.getCpf());
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - Senha"+Ferramentas.AQUA_BLUE+"          ┃        ┃ Senha: " + supervisor.getSenha());
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"5 - Meta Mensal"+Ferramentas.AQUA_BLUE+"    ┃        ┃ Meta Mensal: " + supervisor.getMetaMensal());
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"6 - Sair do Menu"+Ferramentas.AQUA_BLUE+"   ┃        ┗━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┃ ➤ Escolha:  ");

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

            // REINICIA A VARIÁVEL DE INICIAÇÃO                    //
            verifica = false;

            switch(UpdateS)
            {
                case 1 -> {
                    String nome = MenuAlteraUsuario.MenuSetNome();
                    supervisor.setNome(nome);
                }

                case 2 -> {
                    String cpf = MenuAlteraUsuario.MenuSetCpf();
                    supervisor.setCpf(cpf);
                }

                case 3 -> {
                    String senha = MenuAlteraUsuario.MenuSetSenha();
                    supervisor.setSenha(senha);
                }
                case 4 -> {
                    double metaMensal = MenuAlteraGerente.MenuSetMetaMensal();
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
