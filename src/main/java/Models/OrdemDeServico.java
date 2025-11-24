package Models;

import Models.Enumeracoes.Departamento;
import Models.Enumeracoes.StatusOS;
import Models.Enumeracoes.TipoOs;
import Service.Validator.OrdemDeServicoValidator;

public class OrdemDeServico
{
    //--------------------  ATRIBUTOS  --------------------//
    private StatusOS statusDaOrdem;
    private long idOrdemDeServico;
    private String descricao;
    private long idMaquina;
    private long idTecnico;
    private Departamento departamento;
    private TipoOs tipoOs;
    private double valorDaOrdemDeServico;

    //--------------------  CONSTRUTOR COM ID --------------------//
    public OrdemDeServico(long idOrdemDeServico, long id_Tecnico, long id_Maquina, StatusOS statusDaOrdem, String descricao, double valorDaOrdemDeServico, Departamento departamento, TipoOs tipoOs) {
        this.idOrdemDeServico = idOrdemDeServico;
        this.idTecnico = id_Tecnico;
        this.idMaquina = id_Maquina;
        this.statusDaOrdem = statusDaOrdem;
        this.descricao = descricao;
        this.valorDaOrdemDeServico = valorDaOrdemDeServico;
        this.departamento = departamento;
    }

    //--------------------  CONSTRUTOR SEM ID --------------------//
    public OrdemDeServico(long id_Tecnico, long id_Maquina, StatusOS statusDaOrdem, String descricao, double valorDaOrdemDeServico, Departamento departamento, TipoOs tipoOs) {
        this(0, id_Tecnico, id_Maquina, statusDaOrdem, descricao, valorDaOrdemDeServico, departamento, tipoOs);
    }

    //-------------  SETTERS E GETTERS  -------------//

    public long getIdOrdemDeServico()
    {
        return idOrdemDeServico;
    }

    public StatusOS getStatusDaOrdem()
    {
        return statusDaOrdem;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public long getIdMaquina()
    {
        return idMaquina;
    }

    public long getIdTecnico()
    {
        return idTecnico;
    }

    public double getValorDaOrdemDeServico()
    {
        return valorDaOrdemDeServico;
    }

    public TipoOs getTipoOs() {
        return tipoOs;
    }

    public void setTipoOs(TipoOs tipoOs) {
        this.tipoOs = tipoOs;
    }

    public void setIdOrdemDeServico(long idOrdemDeServico)
    {
        OrdemDeServicoValidator.verificaIntegridadeIdOrdem_Servico(idOrdemDeServico);
        this.idOrdemDeServico = idOrdemDeServico;
    }

    public void setStatusDaOrdem(StatusOS statusDaOrdem)
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
        this.idMaquina = idMaquina;
    }

    public void setIdTecnico(int idTecnico)
    {
        OrdemDeServicoValidator.verificaIntegridadeIdTecnico(idTecnico);
        this.idTecnico = idTecnico;
    }

    public void setValorDaOrdemDeServico(double valorDaOrdemDeServico)
    {
        OrdemDeServicoValidator.verificarValorDaOrdemDeServico(valorDaOrdemDeServico);
        this.valorDaOrdemDeServico = valorDaOrdemDeServico;
    }

    public long getId_Maquina() {
        return idMaquina;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public long getId_Tecnico() {
        return idTecnico;
    }
}
