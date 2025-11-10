package Views;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;
import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Supervisor.ObjetosDeValor.MetaMensal;
import Dominio.Funcionario.Supervisor.Supervisor;
import Dominio.Funcionario.Tecnico.Tecnico;
import Dominio.Funcionario.Tecnico.Enumeracoes.Especialidade;
import ProjetoBase.*;
import Util.Ferramentas;
import java.util.InputMismatchException;

public class MenuUpdateGerente {
    private static final UsuarioService usuarioService = new UsuarioService();
    private static final TecnicoService tecnicoService = new TecnicoService();
    private static final SupervisorService supervisorService = new SupervisorService();

    public static void menuUpdateEscolha(Gerente gerente) {
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
                case 1 -> menuUpdateTecnico(gerente);
                case 2 -> menuUpdateSupervisor(gerente);
                case 3 -> {return;}

                default -> Ferramentas.mensagemErro("ERRO! TENTE NOVAMENTE!");
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
                    NomeFuncionario nome = MenuSetUsuario.MenuSetNome();
                    usuarioService.updateNomeUsuario(gerente, idTecnico, nome);
                    tecnico.alteraNome(nome);
                }

                case 2 -> {
                    CPF cpf = MenuSetUsuario.MenuSetCpf();
                    usuarioService.updateCpfUsuario(gerente, idTecnico, cpf);
                    tecnico.alteraCpf(cpf);
                }

                case 3 -> {
                    Senha senha = MenuSetUsuario.MenuSetSenha();
                    usuarioService.updateSenhaUsuario(gerente, idTecnico, senha);
                    tecnico.alteraSenha(senha);
                }
                case 4 -> {
                    Especialidade especialidade = MenuSetTecnico.MenuSetEspecialidade();
                    tecnicoService.updateEspecialidade(gerente, idTecnico, especialidade);
                    tecnico.alteraEspecialidade(especialidade);
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
                    NomeFuncionario nome = MenuSetUsuario.MenuSetNome();
                    usuarioService.updateNomeUsuario(gerente, idSupervisor, nome);
                    supervisor.alteraNome(nome);
                }

                case 2 -> {
                    CPF cpf = MenuSetUsuario.MenuSetCpf();
                    usuarioService.updateCpfUsuario(gerente, idSupervisor, cpf);
                    supervisor.alteraCpf(cpf);
                }

                case 3 -> {
                    Senha senha = MenuSetUsuario.MenuSetSenha();
                    usuarioService.updateSenhaUsuario(gerente, idSupervisor, senha);
                    supervisor.alteraSenha(senha);
                }
                case 4 -> {
                    MetaMensal metaMensal = MenuSetSupervisor.MenuSetMetaMensal();
                    supervisorService.updateMetaMensal(gerente, idSupervisor, metaMensal);
                    supervisor.alteraMetaMensal(metaMensal);
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
