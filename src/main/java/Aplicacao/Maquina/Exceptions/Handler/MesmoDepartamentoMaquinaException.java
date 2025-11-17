package Aplicacao.Maquina.Exceptions.Handler;

public class MesmoDepartamentoMaquinaException extends MesmoDadoMaquinaException {
    public MesmoDepartamentoMaquinaException() {
        super("O departamento deve ser diferente do atual");
    }
}
