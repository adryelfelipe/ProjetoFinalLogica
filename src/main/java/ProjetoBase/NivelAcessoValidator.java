package ProjetoBase;

public class NivelAcessoValidator {

    public void temNivelAcesso4(UsuarioModel usuario) {
        if (!(usuario.getNivelAcesso() == NivelAcesso.ADMIN)) {
            throw new IllegalStateException("ERRO! FALTA DE PERMISSÃO");
        }
    }

    public void temNivelAcesso3(UsuarioModel usuario) {
        if (!(usuario.getNivelAcesso() == NivelAcesso.GERENTE)) {
            throw new IllegalStateException("ERRO! FALTA DE PERMISSÃO");
        }
    }

    public void temNivelAcesso2(UsuarioModel usuario) {
        if (!(usuario.getNivelAcesso() == NivelAcesso.SUPERVISOR)) {
            throw new IllegalStateException("ERRO! FALTA DE PERMISSÃO");
        }
    }

    public void temNivelAcesso1(UsuarioModel usuario) {
        if (!(usuario.getNivelAcesso() == NivelAcesso.TECNICO)) {
            throw new IllegalStateException("ERRO! FALTA DE PERMISSÃO");
        }
    }
}
