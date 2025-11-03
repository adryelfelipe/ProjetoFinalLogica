package ProjetoBase;

import Models.TecnicoModel;
import Models.UsuarioModel;
import Repositories.OrdemDeServicoDAO;

public class OrdemDeServicoService
{
    OrdemDeServicoDAO ordemDeServicoDAO = new OrdemDeServicoDAO();
    OrdemDeServicoService ordemDeServicoService = new OrdemDeServicoService();

    public void inserirOrdemDeServico(UsuarioModel usuarioInseridor, TecnicoModel tecnicoInserido)
    {
        UsuarioValidator.temNivelAcesso2(usuarioInseridor);
        TecnicoValidator.verificaRegrasInsercaoTecnico(tecnicoInserido);
        /*usuarioService.isCpfCadastradoValidator(tecnicoInserido.getCpf());
        usuarioDAO.inserirUsuario(tecnicoInserido);
        tecnicoDAO.inserirTecnico(tecnicoInserido);
    }
}*/
}
}