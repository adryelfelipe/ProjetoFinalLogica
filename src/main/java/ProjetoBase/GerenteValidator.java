package ProjetoBase;

public class GerenteValidator {

    // -- Verifica regras de négoico -- //
    public void verificaRegrasIdDepartamento(int idDepartamento) {
        if(idDepartamento > 3) {
            throw new IllegalStateException("ERRO! ID DE DEPARTAMENTO INVÁLIDO");
        }
    }

    // -- Verifica integridade de dados -- //
    public static void verificaIntegridadeIdDepartamento(int idDepartamento){
        if(idDepartamento < 0) {
            throw new IllegalArgumentException("ERRO! O ID NÃO PODE SER NEGATIVO");
        }
    }
}
