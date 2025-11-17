package Aplicacao.Maquina.Exceptions.Handler;

public class MesmoStatusMaquinaException extends MesmoDadoMaquinaException {
    public MesmoStatusMaquinaException() {
        super("O status deve ser diferente do atual");
    }
}
