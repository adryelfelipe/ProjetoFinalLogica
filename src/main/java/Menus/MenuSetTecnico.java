package Menus;

import ProjetoBase.TecnicoValidator;
import ProjetoBase.Ferramentas;

import java.util.InputMismatchException;

public class MenuSetTecnico {

    public static int MenuSetEspecialidade(TecnicoValidator tecnicoValidator){
        while(true){
            System.out.print("Digite a especialidade: ");
            try{
                int especialidade = Ferramentas.lInteiro();
                TecnicoValidator.verificaIntegridadeEspecialidade(especialidade);
                tecnicoValidator.verificaRegrasEspecialidade(especialidade);
                return especialidade;
            } catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }   catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }

        }
    }
}
