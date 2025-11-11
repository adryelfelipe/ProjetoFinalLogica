package Aplicacao.Funcionario.Gerente.CasosDeUso.CadastrarGerente.Mapper;

import Aplicacao.Funcionario.Gerente.CasosDeUso.CadastrarGerente.Dtos.CadastroGerenteRequest;
import Dominio.Funcionario.Gerente.Gerente;

public class CadastroGerenteMapper {
    public Gerente paraEntidade(CadastroGerenteRequest request) {
        return new Gerente(request.nomeFuncionario(), request.cpf(), request.senha(), request.listaDepartamentos());
    }
}
