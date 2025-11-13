package Views.Funcionario.Gerente;
import Dominio.Funcionario.Supervisor.Supervisor;
import Dominio.Funcionario.Tecnico.Tecnico;
import Dominio.Funcionario.Tecnico.Enumeracoes.Especialidade;
import Util.Ferramentas;
import Views.Sistema.MenuEscolhaId;
import Views.Funcionario.Supervisor.MenuSetSupervisor;
import Views.Funcionario.Tecnico.MenuSetTecnico;
import Views.Funcionario.Nucleo.MenuSetFuncionario;

import java.util.InputMismatchException;

public class MenuUpdateGerente {
    public static void menuUpdateEscolha() {
        // Menu
        boolean verifica = false;
        int opUpdate = 0;

        while(true)
        {

            while(!verifica) {
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃         MENU ATUALIZAR         ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
                System.out.println("┃                                ┃");
                System.out.println("┃  1 - Alterar Técnico           ┃");
                System.out.println("┃  2 - Alterar Supervisor        ┃");
                System.out.println("┃  3 - Sair do Menu              ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
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

            // Reinicia a veriável de verificação
            verifica = false;

            switch(opUpdate) {
                case 1 -> menuUpdateTecnico();
                case 2 -> menuUpdateSupervisor();
                case 3 -> {return;}

                default -> Ferramentas.mensagemErro("ERRO! TENTE NOVAMENTE!");
            }
        }
    }

    public static void menuUpdateTecnico() {
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

        Tecnico tecnico = null;

        while(true)
        {

            while(!verifica)
            {

                System.out.println("\n                                                 \n");
                System.out.println("         ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓          ");
                System.out.println("         ┃       ATUALIZAR TECNICO       ┃         ");
                System.out.println("         ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛          ");
                System.out.println("                                                     ");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━┓         ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃  EDITAR   TÉCNICO  ┃         ┃            ATUAL           ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━┃         ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
                System.out.println(String.format("┃  1 - Nome          ┃         ┃  %-26s┃", tecnico.getNome()));
                System.out.println(String.format("┃  2 - CPF           ┃         ┃  %-26s┃", tecnico.getCpf()));
                System.out.println(String.format("┃  3 - Senha         ┃         ┃  %-26s┃", tecnico.getSenha()));
                System.out.println(String.format("┃  4 - Especialidade ┃         ┃  %-26s┃", tecnico.getEspecialidade()));
                System.out.println("┃  5 - Sair do Menu  ┃         ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
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

            // Reinicia a veriável de verificação
            verifica = false;

            switch(UpdateT) {
                case 1 -> {
                    String nome = MenuSetFuncionario.MenuSetNome();

                }

                case 2 -> {
                    String cpf = MenuSetFuncionario.MenuSetCpf();

                }

                case 3 -> {
                    String senha = MenuSetFuncionario.MenuSetSenha();

                }
                case 4 -> {
                    Especialidade especialidade = MenuSetTecnico.MenuSetEspecialidade();

                }
                case 5 ->
                {
                    return;
                }
                default -> Ferramentas.menuDefault();
            }
        }
    }
    public static void menuUpdateSupervisor()
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

        Supervisor supervisor = null;

        while(true)
        {
            while(!verifica)
            {
                System.out.println("\n                                                       \n");
                System.out.println("             ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓            ");
                System.out.println("             ┃      ATUALIZAR SUPERVISOR     ┃            ");
                System.out.println("             ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛            ");
                System.out.println("                                                            ");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━┓         ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃  EDITAR   SUPERVISOR  ┃         ┃            ATUAL           ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━┃         ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println(String.format("┃  1 - Nome          ┃         ┃  %-26s┃", supervisor.getNome()));
                System.out.println(String.format("┃  2 - CPF           ┃         ┃  %-26s┃", supervisor.getCpf()));
                System.out.println(String.format("┃  3 - Senha         ┃         ┃  %-26s┃", supervisor.getSenha()));
                System.out.println(String.format("┃  4 - Meta Mensal   ┃         ┃  %-26s┃", supervisor.getMetaMensal()));
                System.out.println("┃  6 - Sair do Menu     ┃         ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━┛");
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

            // Reinicia a veriável de verificação
            verifica = false;

            switch(UpdateS)
            {
                case 1 -> {
                    String nome = MenuSetFuncionario.MenuSetNome();

                }

                case 2 -> {
                    String cpf = MenuSetFuncionario.MenuSetCpf();

                }

                case 3 -> {
                    String senha = MenuSetFuncionario.MenuSetSenha();

                }
                case 4 -> {
                    double metaMensal = MenuSetSupervisor.MenuSetMetaMensal();

                }
                case 5 ->
                {
                    return;
                }

                default -> Ferramentas.menuDefault();
            }
        }
    }

}
