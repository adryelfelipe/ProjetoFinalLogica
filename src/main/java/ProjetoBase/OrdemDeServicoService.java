package ProjetoBase;

import Models.OrdemDeServicoModel;
import Models.TecnicoModel;
import Models.UsuarioModel;
import Repositories.OrdemDeServicoDAO;

public class OrdemDeServicoService
{
    OrdemDeServicoDAO ordemDeServicoDAO = new OrdemDeServicoDAO();

    public void inserirOrdemDeServico(UsuarioModel usuarioInseridor, OrdemDeServicoModel ordemInserida) {
        UsuarioValidator.temNivelAcesso2(usuarioInseridor);
        OrdemDeServicoValidator.verificaRegrasInsercaoOS(ordemInserida);
        ordemDeServicoDAO.inserirOrdemDeServico(ordemInserida);
    }
}