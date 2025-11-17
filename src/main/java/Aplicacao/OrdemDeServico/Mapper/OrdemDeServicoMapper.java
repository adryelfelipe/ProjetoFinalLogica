package Aplicacao.OrdemDeServico.Mapper;

import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.OrdemServicoResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.OrdemDeServico.ObjetosDeValor.Descricao;
import Dominio.OrdemDeServico.ObjetosDeValor.ValorOS;
import Dominio.OrdemDeServico.OrdemDeServico;

import java.util.ArrayList;
import java.util.List;

public class OrdemDeServicoMapper {
    public OrdemDeServico paraEntidade(CadastroOsRequest request, Departamento departamento) {
        return new OrdemDeServico(request.idTecnico(),
                request.idSupervisor(),
                request.idMaquina(),
                request.statusOS(),
                new Descricao(request.descricao()),
                new ValorOS(request.valorOS()),
                departamento, request.tipoOS());
    }

    // Cadastro foi um sucesso
    public CadastroOsResponse paraResponse(OrdemDeServico ordemDeServico) {
        return new CadastroOsResponse(ordemDeServico.getIdOs(),true, "✅ Cadastro da ordem de serviço foi um sucesso");
    }

    // Cadastro falhou
    public CadastroOsResponse paraResponse(String mensagem) {
        return new CadastroOsResponse(null, false, mensagem);
    }

    public ListarOsResponse paraListaOsResponse(Departamento departamento, List<OrdemDeServico> lista) {
        List<OrdemServicoResponse> listaResponse = new ArrayList<>();

        for(OrdemDeServico os : lista) {
            if(os.getDepartamento() == departamento) {
                OrdemServicoResponse osResponse = new OrdemServicoResponse(os.getIdOs(), os.getStatusOS(),os.getDescricao() ,os.getTipoOS(), os.getValorOS());
                listaResponse.add(osResponse);
            }
        }

        return new ListarOsResponse(listaResponse);
    }
}
