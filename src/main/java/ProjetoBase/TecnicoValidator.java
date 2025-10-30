package ProjetoBase;

public class TecnicoValidator {

    // -- Métodos de Regras de Negócio -- //
    public static void verificaRegrasInsercaoTecnico(TecnicoModel tecnicoModel) {
        UsuarioValidator.verificaRegrasInsercaoUsuario(tecnicoModel);
        verificaRegrasEspecialidade(tecnicoModel.getEspecialidade());
    }

    public static void verificaRegrasEspecialidade(int idEspecialidade) {
        if(idEspecialidade > 5) {
            throw new IllegalStateException("ERRO! O ID ESPECIALIDADE NÃO PODE SER MAIOR QUE 4");
        }
    }

    // -- Métodos de Integridade -- //
    public static void verificaIntegridadeEspecialidade(int idEspecialidade) {
        if(idEspecialidade < 0) {
            throw new IllegalArgumentException("ERRO! O ID ESPECIALIDADE NÃO PODE SER MENOR QUE 0");
        }
    }
}
