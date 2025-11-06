package ProjetoBase;

import Models.OrdemDeServicoModel;
import Models.TecnicoModel;
import Models.UsuarioModel;
import Models.joias.StatusOS;
import Repositories.OrdemDeServicoDAO;

public class OrdemDeServicoService
{
    OrdemDeServicoDAO ordemDeServicoDAO = new OrdemDeServicoDAO();

    public void inserirOrdemDeServico(UsuarioModel usuarioInseridor, OrdemDeServicoModel ordemInserida) {
        UsuarioValidator.temNivelAcesso2(usuarioInseridor);
        OrdemDeServicoValidator.verificaRegrasInsercaoOS(ordemInserida);
        ordemDeServicoDAO.inserirOrdemDeServico(ordemInserida);
    }

    public void isIdExistenteValidator(long id) {
        if(!ordemDeServicoDAO.) {
            throw new IllegalStateException("ERRO! O ID NÃO FOI ENCONTRADO");
        }
    }

    public OrdemDeServicoModel findById(long id)
    {
        return ordemDeServicoDAO.findByIdOS(id);
    }

    public void updateDescricaoOS(UsuarioModel usuario, long idOS, String descricao) {
        UsuarioValidator.temNivelAcesso2(usuario);
        OrdemDeServicoValidator.verificaIntegridadeIdOrdem_Servico(idOS);
        OrdemDeServicoValidator.verificaRegrasDescricao(descricao);
        OrdemDeServicoValidator.verificaIntegridadeDescricao(descricao);
        ordemDeServicoDAO.updateDescricaoOrdemDeServico(idOS, descricao);
    }
    public void updateIdMaquinaOS(UsuarioModel usuario, long idOS, long idMaquina)
    {
        UsuarioValidator.temNivelAcesso2(usuario);
        OrdemDeServicoValidator.verificaIntegridadeIdOrdem_Servico(idOS);
        OrdemDeServicoValidator.verificaIntegridadeIdMaquina(idMaquina);
        ordemDeServicoDAO.updateIdMaquina(idOS, idMaquina);
    }
    public void updateIdTecnico(UsuarioModel usuario, long idOS, long idTecnico)
    {
        UsuarioValidator.temNivelAcesso2(usuario);
        OrdemDeServicoValidator.verificaIntegridadeIdOrdem_Servico(idOS);
        OrdemDeServicoValidator.verificaIntegridadeIdTecnico(idTecnico);
        ordemDeServicoDAO.updateIdTecnico(idOS, idTecnico);
    }

    public void updateValorOS(UsuarioModel usuario, long idOS, double valorOS)
    {
        UsuarioValidator.temNivelAcesso2(usuario);
        OrdemDeServicoValidator.verificaIntegridadeIdOrdem_Servico(idOS);
        OrdemDeServicoValidator.verificarValorDaOrdemDeServico(valorOS);
        ordemDeServicoDAO.updateCustoOrdemDeServicos(idOS, valorOS);
    }
    public void updateStatusOS(UsuarioModel usuario, long idOS, StatusOS statusOS)
    {
        UsuarioValidator.temNivelAcesso1(usuario);
        OrdemDeServicoValidator.verificaRegrasStatus(statusOS.getId());
        OrdemDeServicoValidator.verificaIntegridadeStatus(statusOS);
        ordemDeServicoDAO.updateStatusOrdemDeServicos(idOS, statusOS.getId());
    }
}