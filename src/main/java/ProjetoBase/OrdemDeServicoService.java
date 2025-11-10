package ProjetoBase;

import Dominio.OrdemDeServico.ObjetosDeValor.Descricao;
import Dominio.OrdemDeServico.ObjetosDeValor.ValorOS;
import Dominio.OrdemDeServico.OrdemDeServico;
import Dominio.Funcionario.Supervisor.Supervisor;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.OrdemDeServico.Enumeracoes.StatusOS;
import Repositories.OrdemDeServicoDAO;

public class OrdemDeServicoService
{
    private final OrdemDeServicoDAO ordemDeServicoDAO = new OrdemDeServicoDAO();
    private final UsuarioService usuarioService = new UsuarioService();
    private final MaquinaService maquinaService = new MaquinaService();

    public void inserirOrdemDeServico(Funcionario funcionarioInseridor, OrdemDeServico ordemInserida) {
        UsuarioValidator.temNivelAcesso2(funcionarioInseridor);
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

    public void updateDescricaoOS(Funcionario funcionario, long idOS, Descricao descricao) {
        UsuarioValidator.temNivelAcesso2(funcionario);
        isIdExistenteValidator(idOS);
        ordemDeServicoDAO.updateDescricaoOrdemDeServico(idOS, descricao);
    }
    public void updateIdMaquinaOS(Funcionario funcionario, long idOS, long idMaquina)
    {
        UsuarioValidator.temNivelAcesso2(funcionario);
        OrdemDeServicoValidator.verificaIntegridadeIdOrdem_Servico(idOS);
        OrdemDeServicoValidator.verificaIntegridadeIdMaquina(idMaquina);
        maquinaService.isIdExistenteValidator(idMaquina);
        isIdExistenteValidator(idOS);
        ordemDeServicoDAO.updateIdMaquina(idOS, idMaquina);
    }
    public void updateIdTecnico(Funcionario funcionario, long idOS, long idTecnico)
    {
        UsuarioValidator.temNivelAcesso2(funcionario);
        OrdemDeServicoValidator.verificaIntegridadeIdOrdem_Servico(idOS);
        OrdemDeServicoValidator.verificaIntegridadeIdTecnico(idTecnico);
        usuarioService.isIdExistenteValidator(idTecnico);
        isIdExistenteValidator(idOS);
        ordemDeServicoDAO.updateIdTecnico(idOS, idTecnico);
    }

    public void updateValorOS(Funcionario funcionario, long idOS, ValorOS valorOS)
    {
        UsuarioValidator.temNivelAcesso2(funcionario);
        isIdExistenteValidator(idOS);
        ordemDeServicoDAO.updateCustoOrdemDeServicos(idOS, valorOS);
    }
    public void updateStatusOS(Funcionario funcionario, long idOS, StatusOS statusOS)
    {
        UsuarioValidator.temNivelAcesso1(funcionario);
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