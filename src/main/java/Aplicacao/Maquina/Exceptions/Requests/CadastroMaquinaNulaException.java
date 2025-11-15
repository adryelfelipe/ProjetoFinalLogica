package Aplicacao.Maquina.Exceptions.Requests;

public class CadastroMaquinaNulaException extends MaquinaRequestException {
    public CadastroMaquinaNulaException() {
        super("As informações do cadastro da máquina devem ser bem definidas");
    }
}
