package Aplicacao.Funcionario.Tecnico.Exceptions.Requests;

public class AtualizarTecnicoNuloException extends TecnicoRequestException {
    public AtualizarTecnicoNuloException() {
        super("As informações da atualização do técnico devem ser bem definidas");
    }
}
