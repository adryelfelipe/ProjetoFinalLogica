package Service;

import Models.Enumeracoes.StatusOS;
import Models.OrdemDeServico;
import Models.Funcionario;
import DAO.OrdemDeServicoDAO;
import Service.Validator.OrdemDeServicoValidator;
import Service.Validator.UsuarioValidator;

public class OrdemDeServicoService
{
    OrdemDeServicoDAO ordemDeServicoDAO = new OrdemDeServicoDAO();

    public void inserirOrdemDeServico(Funcionario funcionarioInseridor, OrdemDeServico ordemInserida) {
        UsuarioValidator.temNivelAcesso2(funcionarioInseridor);
        OrdemDeServicoValidator.verificaRegrasInsercaoOS(ordemInserida);
        ordemDeServicoDAO.inserirOrdemDeServico(ordemInserida);
    }

    public void isIdExistenteValidator(long id) {

    }
    public void atualizarValor_OS (Funcionario funcionario, long id, double valor){
        UsuarioValidator.temNivelAcesso1(funcionario);
        ordemDeServicoDAO.updateCustoOrdemDeServicos(id,valor);
    }

    public void atualizarStatus_OS (Funcionario funcionario, long id,int status ){
        UsuarioValidator.temNivelAcesso1(funcionario);
        ordemDeServicoDAO.updateStatusOrdemDeServicos(id,status);

        if(StatusOS.FECHADA.getId() == status){
            ordemDeServicoDAO.deletarOrdemDeServico(id);
        }
    }

    public void atualizarDescricao_OS (Funcionario funcionario, long id, String descricao ){
        UsuarioValidator.temNivelAcesso2(funcionario);
        ordemDeServicoDAO.updateDescricaoOrdemDeServico(id, descricao);
    }

    public void atualizarMaquina_OS (Funcionario funcionario, long id, long id_maquina){
        UsuarioValidator.temNivelAcesso2(funcionario);
        ordemDeServicoDAO.updateIdMaquina(id,id_maquina);
    }

    public void atualizarTecnico_OS (Funcionario funcionario, long id, long id_tecnico){
        UsuarioValidator.temNivelAcesso2(funcionario);
        ordemDeServicoDAO.updateIdTecnico(id, id_tecnico);
    }

    public void atualizarSupervisor_OS (Funcionario funcionario, long id, long id_supervisor){
        UsuarioValidator.temNivelAcesso2(funcionario);
        ordemDeServicoDAO.updateIdSupervisor(id, id_supervisor);
    }
}