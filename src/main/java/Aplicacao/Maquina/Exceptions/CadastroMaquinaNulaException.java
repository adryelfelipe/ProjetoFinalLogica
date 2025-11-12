package Aplicacao.Maquina.Exceptions;

public class CadastroMaquinaNulaException extends MaquinaRequestException {
    public CadastroMaquinaNulaException() {
        super("As informações do cadastro da máquina devem ser bem definidas");
    }
}
