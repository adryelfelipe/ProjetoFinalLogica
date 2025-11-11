package testesProjeto;

import Aplicacao.Funcionario.Gerente.Controller.GerenteController;
import Aplicacao.Funcionario.Gerente.Handler.GerenteHandler;
import Aplicacao.Funcionario.Gerente.Mapper.GerenteMapper;
import Aplicacao.Funcionario.Nucleo.Controller.FuncionarioController;
import Aplicacao.Funcionario.Nucleo.Handler.FuncionarioHandler;
import Aplicacao.Funcionario.Nucleo.Mapper.FuncionarioMapper;
import Aplicacao.Funcionario.Nucleo.Servicos.AutorizacaoServico;
import Dominio.Funcionario.Administrador.Administrador;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;
import Dominio.Funcionario.Nucleo.Servicos.FuncionarioServico;
import Views.MenuInicial;
import testesProjeto.Infra.TesteDao;

import java.util.Arrays;

public class MainTestes {
    // Dao para testes
    private static TesteDao testeDao = new TesteDao();

    // Aplicação teste de funcionário
    private static FuncionarioMapper funcionarioMapper = new FuncionarioMapper();
    private static FuncionarioHandler funcionarioHandler = new FuncionarioHandler(testeDao,funcionarioMapper);
    private static AutorizacaoServico autorizacaoServico = new AutorizacaoServico();
    private static FuncionarioServico funcionarioServico = new FuncionarioServico(testeDao);

    // Aplicação teste de gerente
    private static GerenteMapper gerenteMapper = new GerenteMapper();
    private static GerenteHandler gerenteHandler = new GerenteHandler(gerenteMapper,testeDao, funcionarioServico, autorizacaoServico);

    // Controllers públicas
    public static GerenteController gerenteController = new GerenteController(gerenteHandler);
    public static FuncionarioController funcionarioController = new FuncionarioController(funcionarioHandler);

    public static void main(String[] args) {
        testeDao.funcionarioArrayList.add(new Administrador(1,new NomeFuncionario("joaozera"),new CPF("12345678910"), new Senha("123456@Aa"), new ListaDepartamentos(Arrays.asList(Departamento.MECANICA))));
        MenuInicial.Menu();
    }
}
