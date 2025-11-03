package Models;

import ProjetoBase.OrdemDeServicoValidator;

public class OrdemDeServicoModel
{
    //--------------------  ATRIBUTOS  --------------------//
    private int statusDaOrdem;
    private long idOrdemDeServico;
    private String descricao;
    private long id_Maquina;
    private long id_Tecnico;
    private double valorDaOrdemDeServico;

    //--------------------  CONSTRUTOR COM ID --------------------//
    public OrdemDeServicoModel(long idOrdemDeServico, long id_Tecnico, long id_Maquina, int statusDaOrdem, String descricao, double valorDaOrdemDeServico) {
        this.idOrdemDeServico = idOrdemDeServico;
        this.id_Tecnico = id_Tecnico;
        this.id_Maquina = id_Maquina;
        this.statusDaOrdem = statusDaOrdem;
        this.descricao = descricao;
        this.valorDaOrdemDeServico = valorDaOrdemDeServico;
    }

    //--------------------  CONSTRUTOR SEM ID --------------------//
    public OrdemDeServicoModel(long id_Tecnico, long id_Maquina, int statusDaOrdem, String descricao, double valorDaOrdemDeServico) {
        this(0, id_Tecnico, id_Maquina, statusDaOrdem, descricao, valorDaOrdemDeServico);
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

    public long getIdMaquina()
    {
        return id_Maquina;
    }

    public long getIdTecnico()
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
