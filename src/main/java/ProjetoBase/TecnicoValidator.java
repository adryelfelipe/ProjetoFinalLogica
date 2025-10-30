package ProjetoBase;

public class TecnicoValidator {

    // -- Atributos -- //
    private static final UsuarioValidator usuarioValidator = new UsuarioValidator();

    // -- Métodos de Regras de Negócio -- //
    public void verificaRegrasInsercaoTecnico(TecnicoModel tecnicoModel) {
        usuarioValidator.verificaRegrasInsercaoUsuario(tecnicoModel);
        verificaRegrasEspecialidade(tecnicoModel.getEspecialidade());
    }

    public void verificaRegrasEspecialidade(int idEspecialidade) {
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
