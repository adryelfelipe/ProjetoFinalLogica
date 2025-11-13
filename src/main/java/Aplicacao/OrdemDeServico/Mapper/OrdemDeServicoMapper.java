package Aplicacao.OrdemDeServico.Mapper;

import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsResponse;
import Dominio.OrdemDeServico.ObjetosDeValor.Descricao;
import Dominio.OrdemDeServico.ObjetosDeValor.ValorOS;
import Dominio.OrdemDeServico.OrdemDeServico;

public class OrdemDeServicoMapper {
    public OrdemDeServico paraEntidade(CadastroOsRequest request) {
        return new OrdemDeServico(request.idTecnico(),
                request.idSupervisor(),
                request.idMaquina(),
                request.statusOS(),
                new Descricao(request.descricao()),
                new ValorOS(request.valorOS()),
                request.departamento(), request.tipoOS());
    }

    // Cadastro foi um sucesso
    public CadastroOsResponse paraResponse(OrdemDeServico ordemDeServico) {
        return new CadastroOsResponse(ordemDeServico.getIdOs(),true, "Cadastro da ordem de serviço foi um sucesso");
    }

    // Cadastro falhou
    public CadastroOsResponse paraResponse(String mensagem) {
        return new CadastroOsResponse(null, false, mensagem);
    }
}
