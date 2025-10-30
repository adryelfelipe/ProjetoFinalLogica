package ProjetoBase;

public class OrdemDeServicoModel
{
    //--------------------  ATRIBUTOS  --------------------//
    private int statusDaOrdem;

    private long idOrdemDeServico;
    private String descricao;
    private int id_Maquina;
    private int id_Tecnico;
    private double valorDaOrdemDeServico;

    //--------------------  CONSTRUTOR  --------------------//
    public OrdemDeServicoModel(int idOrdemDeServico, int id_Tecnico, int id_Maquina, int statusDaOrdem, String descricao, double valorDaOrdemDeServico) {
        this.idOrdemDeServico = idOrdemDeServico;
        this.id_Tecnico = id_Tecnico;
        this.id_Maquina = id_Maquina;
        this.statusDaOrdem = statusDaOrdem;
        this.descricao = descricao;
        this.valorDaOrdemDeServico = valorDaOrdemDeServico;
    }

    //-------------  SETTERS E GETTERS  -------------//

    public long getIdOrdemDeServico()
    {
        return idOrdemDeServico;
    }

    public int getStatusDaOrdem()
    {
        return statusDaOrdem;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public int getIdMaquina()
    {
        return id_Maquina;
    }

    public int getIdTecnico()
    {
        return id_Tecnico;
    }

    public double getValorDaOrdemDeServico()
    {
        return valorDaOrdemDeServico;
    }

    public void setIdOrdemDeServico(long idOrdemDeServico)
    {
        OrdemDeServicoValidator.verificaIntegridadeIdOrdem_Servico(idOrdemDeServico);
        this.idOrdemDeServico = idOrdemDeServico;
    }

    public void setStatusDaOrdem(int statusDaOrdem)
    {
        OrdemDeServicoValidator.verificaIntegridadeStatus(statusDaOrdem);
        this.statusDaOrdem = statusDaOrdem;
    }

    public void setDescricao(String descricao)
    {
        OrdemDeServicoValidator.verificaRegrasDescricao(descricao);
        this.descricao = descricao;
    }

    public void setIdMaquina(int idMaquina)
    {
        OrdemDeServicoValidator.verificaIntegridadeIdMaquina(idMaquina);
        this.id_Maquina = idMaquina;
    }

    public void setIdTecnico(int idTecnico)
    {
        OrdemDeServicoValidator.verificaIntegridadeIdTecnico(idTecnico);
        this.id_Tecnico = idTecnico;
    }

    public void setValorDaOrdemDeServico(double valorDaOrdemDeServico)
    {
        OrdemDeServicoValidator.verificarValorDaOrdemDeServico(valorDaOrdemDeServico);
        this.valorDaOrdemDeServico = valorDaOrdemDeServico;
    }
}
