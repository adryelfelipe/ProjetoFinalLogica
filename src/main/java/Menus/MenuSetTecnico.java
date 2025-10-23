package Menus;

import ProjetoBase.TecnicoValidator;
import ProjetoBase.Ferramentas;

public class MenuSetTecnico {

    public static String MenuSetEspecialidade(TecnicoValidator tecnicoValidator){
        while(true){
            System.out.print("Digite a especialidade: ");
            String especialidade = Ferramentas.lString();

            try
            {
                TecnicoValidator.verificaIntegridadeEspecialidade(especialidade);
                tecnicoValidator.verificaRegrasEspecialidade(especialidade);
                return especialidade;
            }
            catch (IllegalArgumentException | IllegalStateException e)
            {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
