package Models;

import Models.joias.Departamento;
import Models.joias.StatusOS;
import ProjetoBase.MaquinaValidator;
import ProjetoBase.OrdemDeServicoValidator;
import ProjetoBase.UsuarioValidator;

public class OrdemDeServicoModel
{
    //--------------------  ATRIBUTOS  --------------------//
    private StatusOS statusDaOrdem;
    private long idOrdemDeServico;
    private String descricao;
    private long id_Maquina;
    private long id_Tecnico;
    private long id_Supervisor;
    private double valorDaOrdemDeServico;

    //--------------------  CONSTRUTOR COM ID --------------------//
    public OrdemDeServicoModel(long idOrdemDeServico, long id_Tecnico, long id_Supervisor, long id_Maquina, StatusOS statusDaOrdem, String descricao, double valorDaOrdemDeServico) {
        this.idOrdemDeServico = idOrdemDeServico;
        this.id_Tecnico = id_Tecnico;
        this.id_Supervisor = id_Supervisor;
        this.id_Maquina = id_Maquina;
        this.statusDaOrdem = statusDaOrdem;
        this.descricao = descricao;
        this.valorDaOrdemDeServico = valorDaOrdemDeServico;
    }

    //--------------------  CONSTRUTOR SEM ID --------------------//
    public OrdemDeServicoModel(long id_Tecnico, long id_Supervisor, long id_Maquina, StatusOS statusDaOrdem, String descricao, double valorDaOrdemDeServico) {
        this(0, id_Tecnico, id_Supervisor, id_Maquina, statusDaOrdem, descricao, valorDaOrdemDeServico);
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
        return id_Maquina;
    }

    public long getIdTecnico()
    {
        return id_Tecnico;
    }

    public long getId_Supervisor() {
        return id_Supervisor;
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

    public void setIdMaquina(long idMaquina)
    {
        MaquinaValidator.verificaIntegridadeIdMaquina(idMaquina);
        this.id_Maquina = idMaquina;
    }

    public void setIdTecnico(long idTecnico)
    {
        UsuarioValidator.verificaIntegridadeIdUsuario(idTecnico);
        this.id_Tecnico = idTecnico;
    }

    public void setId_Supervisor(long id_Supervisor)
    {
        //OrdemDeServicoValidator.
        this.id_Supervisor = id_Supervisor;
    }

    public void setValorDaOrdemDeServico(double valorDaOrdemDeServico)
    {
        OrdemDeServicoValidator.verificarIntegridadeValor(valorDaOrdemDeServico);
        this.valorDaOrdemDeServico = valorDaOrdemDeServico;
    }
}
