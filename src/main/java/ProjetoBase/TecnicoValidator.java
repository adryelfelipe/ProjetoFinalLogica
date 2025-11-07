package ProjetoBase;

import Models.TecnicoModel;
import Models.joias.Especialidade;

public class TecnicoValidator {

    // -- Métodos de Regras de Negócio -- //
    public static void verificaRegrasInsercaoTecnico(TecnicoModel tecnicoModel) {
        UsuarioValidator.verificaRegrasInsercaoUsuario(tecnicoModel);
        verificaRegrasEspecialidade(tecnicoModel.getEspecialidade());
    }

    public static void verificaRegrasEspecialidade(Especialidade especialidade) {
        if(especialidade == null) {
            throw new IllegalStateException("ERRO! A ESPECIALIDADE NÃO PODE SER NULA");
        }

        if(especialidade.getId() > 5) {
            throw new IllegalStateException("ERRO! O ID ESPECIALIDADE NÃO PODE SER MAIOR QUE 4");
        }
    }

    // -- Métodos de Integridade -- //
    public static void verificaIntegridadeEspecialidade(Especialidade especialidade) {
        if(especialidade.getId() < 0) {
            throw new IllegalArgumentException("ERRO! O ID ESPECIALIDADE NÃO PODE SER MENOR QUE 0");
        }
    }
}
