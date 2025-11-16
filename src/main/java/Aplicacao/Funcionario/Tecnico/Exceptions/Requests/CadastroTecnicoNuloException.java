package Aplicacao.Funcionario.Tecnico.Exceptions.Requests;

public class CadastroTecnicoNuloException extends TecnicoRequestException {
    public CadastroTecnicoNuloException() {
        super("As informações do cadastro do técnico devem ser bem definidas");
    }
}
