package Service;

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
}