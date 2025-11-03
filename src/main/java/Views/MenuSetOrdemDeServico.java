package Views;

import ProjetoBase.*;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuSetOrdemDeServico {
    private static final UsuarioService usuarioService = new UsuarioService();
    private static final MaquinaService maquinaService = new MaquinaService();

    public static long SetIdTecnico(){
        int idTecnico;

        while(true)
        {
            System.out.println("Digite o ID do técnico: ");

            try {
                idTecnico = Ferramentas.lInteiro();
                UsuarioValidator.verificaIntegridadeIdUsuario(idTecnico);
                usuarioService.isIdExistenteValidator(idTecnico);
                return idTecnico;
            } catch (IllegalArgumentException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }

    public static long SetIdMaquina(){
        int idMaquina;

        while(true)
        {
            System.out.println("Digite o ID da máquina: ");

            try {
                idMaquina = Ferramentas.lInteiro();
                UsuarioValidator.verificaIntegridadeIdUsuario(idMaquina);
                maquinaService.isIdExistenteValidator(idMaquina);
                return idMaquina;
            } catch (IllegalArgumentException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }

    public static long SetStatusOS(){
        while(true) {
            System.out.println(" ");
            System.out.println("|==================================|");
            System.out.println("|   SELECIONE O STATUS DA MÁQUINA  |");
            System.out.println("|==================================|");
            System.out.println("| 1 - EM MANUTENÇÃO                |");
            System.out.println("| 2 - Eletricista Fabril           |");
            System.out.println("| 3 - Soldador                     |");
            System.out.println("| 4 - Eletromecânica               |");
            System.out.println("| 5 - Pintor Industrial            |");
            System.out.print("| Escolha: ");

            try
            {
                idEspecialidade = Ferramentas.lInteiro();

                switch (idEspecialidade)
                {
                    case 1 -> {
                        return 1;
                    }
                    case 2 ->{
                        return 2;
                    }
                    case 3 ->{
                        return 3;
                    }
                    case 4 ->{
                        return 4;
                    }
                    case 5 ->{
                        return 5;
                    }

                    default -> Ferramentas.menuDefault();
                }
            }
    }
}
