package Aplicacao.Maquina.Exceptions.Requests;

public class AtualizarMaquinaNulaException extends MaquinaRequestException {
    public AtualizarMaquinaNulaException() {
        super("As informações de atualização da máquina devem ser bem definidas");
    }
}
