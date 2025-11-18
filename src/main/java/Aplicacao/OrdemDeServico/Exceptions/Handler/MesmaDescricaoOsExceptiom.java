package Aplicacao.OrdemDeServico.Exceptions.Handler;

public class MesmaDescricaoOsExceptiom extends MesmoDadoOsException {
    public MesmaDescricaoOsExceptiom() {
        super("A descrição deve ser diferente da atual");
    }
}
