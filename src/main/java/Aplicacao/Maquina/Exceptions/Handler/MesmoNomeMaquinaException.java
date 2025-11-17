package Aplicacao.Maquina.Exceptions.Handler;

public class MesmoNomeMaquinaException extends MesmoDadoMaquinaException {
    public MesmoNomeMaquinaException() {
        super("O nome da máquina deve ser diferente do atual");
    }
}
