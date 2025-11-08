package ProjetoBase;

import Dominio.Entidades.OrdemDeServico;
import Dominio.Entidades.Supervisor;
import Dominio.Entidades.Usuario;
import Dominio.Enumeracoes.StatusOS;
import Repositories.OrdemDeServicoDAO;

public class OrdemDeServicoService
{
    private final OrdemDeServicoDAO ordemDeServicoDAO = new OrdemDeServicoDAO();
    private final UsuarioService usuarioService = new UsuarioService();
    private final MaquinaService maquinaService = new MaquinaService();

    public void inserirOrdemDeServico(Usuario usuarioInseridor, OrdemDeServico ordemInserida) {
        UsuarioValidator.temNivelAcesso2(usuarioInseridor);
        OrdemDeServicoValidator.verificaRegrasInsercaoOS(ordemInserida);
        ordemDeServicoDAO.inserirOrdemDeServico(ordemInserida);
    }

    public void isIdExistenteValidator(long id) {
        if(!ordemDeServicoDAO.verificarIdOS(id)) {
            throw new IllegalStateException("ERRO! O ID NÃO FOI ENCONTRADO");
        }
    }

    public OrdemDeServico findById(long id)
    {
        return ordemDeServicoDAO.findByIdOS(id);
    }

    public void updateDescricaoOS(Usuario usuario, long idOS, String descricao) {
        UsuarioValidator.temNivelAcesso2(usuario);
        OrdemDeServicoValidator.verificaIntegridadeIdOrdem_Servico(idOS);
        OrdemDeServicoValidator.verificaRegrasDescricao(descricao);
        OrdemDeServicoValidator.verificaIntegridadeDescricao(descricao);
        isIdExistenteValidator(idOS);
        ordemDeServicoDAO.updateDescricaoOrdemDeServico(idOS, descricao);
    }
    public void updateIdMaquinaOS(Usuario usuario, long idOS, long idMaquina)
    {
        UsuarioValidator.temNivelAcesso2(usuario);
        OrdemDeServicoValidator.verificaIntegridadeIdOrdem_Servico(idOS);
        OrdemDeServicoValidator.verificaIntegridadeIdMaquina(idMaquina);
        maquinaService.isIdExistenteValidator(idMaquina);
        isIdExistenteValidator(idOS);
        ordemDeServicoDAO.updateIdMaquina(idOS, idMaquina);
    }
    public void updateIdTecnico(Usuario usuario, long idOS, long idTecnico)
    {
        UsuarioValidator.temNivelAcesso2(usuario);
        OrdemDeServicoValidator.verificaIntegridadeIdOrdem_Servico(idOS);
        OrdemDeServicoValidator.verificaIntegridadeIdTecnico(idTecnico);
        usuarioService.isIdExistenteValidator(idTecnico);
        isIdExistenteValidator(idOS);
        ordemDeServicoDAO.updateIdTecnico(idOS, idTecnico);
    }

    public void updateValorOS(Usuario usuario, long idOS, double valorOS)
    {
        UsuarioValidator.temNivelAcesso2(usuario);
        OrdemDeServicoValidator.verificaIntegridadeIdOrdem_Servico(idOS);
        OrdemDeServicoValidator.verificarIntegridadeValor(valorOS);
        isIdExistenteValidator(idOS);
        ordemDeServicoDAO.updateCustoOrdemDeServicos(idOS, valorOS);
    }
    public void updateStatusOS(Usuario usuario, long idOS, StatusOS statusOS)
    {
        UsuarioValidator.temNivelAcesso1(usuario);
        OrdemDeServicoValidator.verificaRegrasStatus(statusOS.getId());
        OrdemDeServicoValidator.verificaIntegridadeStatus(statusOS);
        isIdExistenteValidator(idOS);
        ordemDeServicoDAO.updateStatusOrdemDeServicos(idOS, statusOS);
    }

    public OrdemDeServico visualizarDetalhesDaOS(Supervisor supervisor, long idDaOS)
    {
        OrdemDeServico os = ordemDeServicoDAO.findByIdOS(idDaOS);
        if (os == null) {
            throw new RuntimeException("Ordem de Serviço com ID " + idDaOS + " não encontrada.");
        }
        return os;
    }
}