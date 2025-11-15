package Views.Sistema;

import Aplicacao.Funcionario.Gerente.Controller.GerenteController;
import Aplicacao.Funcionario.Gerente.Handler.GerenteHandler;
import Aplicacao.Funcionario.Gerente.Mapper.GerenteMapper;
import Aplicacao.Funcionario.Nucleo.Controller.FuncionarioController;
import Aplicacao.Funcionario.Nucleo.Handler.FuncionarioHandler;
import Aplicacao.Funcionario.Nucleo.Mapper.FuncionarioMapper;
import Aplicacao.Funcionario.Nucleo.Servicos.AutorizacaoServico;
import Aplicacao.Funcionario.Supervisor.Controller.SupervisorController;
import Aplicacao.Funcionario.Supervisor.Handler.SupervisorHandler;
import Aplicacao.Funcionario.Supervisor.Mapper.SupervisorMapper;
import Aplicacao.Funcionario.Tecnico.Controller.TecnicoController;
import Aplicacao.Funcionario.Tecnico.Handler.TecnicoHandler;
import Aplicacao.Funcionario.Tecnico.Mapper.TecnicoMapper;
import Aplicacao.Maquina.Controller.MaquinaController;
import Aplicacao.Maquina.Handler.MaquinaHandler;
import Aplicacao.Maquina.Mapper.MaquinaMapper;
import Aplicacao.OrdemDeServico.Controller.OrdemDeServicoController;
import Aplicacao.OrdemDeServico.Handler.OrdemDeServicoHandler;
import Aplicacao.OrdemDeServico.Mapper.OrdemDeServicoMapper;
import Dominio.Funcionario.Administrador.Administrador;
import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;
import Dominio.Funcionario.Nucleo.Servicos.FuncionarioServico;
import Dominio.Funcionario.Supervisor.ObjetosDeValor.MetaMensal;
import Dominio.Funcionario.Supervisor.Supervisor;
import Dominio.Funcionario.Tecnico.Enumeracoes.Especialidade;
import Dominio.Funcionario.Tecnico.Tecnico;
import Dominio.Maquina.Enumeracoes.StatusMaquina;
import Dominio.Maquina.Maquina;
import Dominio.Maquina.ObjetosDeValor.Localizacao;
import Dominio.Maquina.ObjetosDeValor.NomeMaquina;
import Dominio.Maquina.Servicos.MaquinaServico;
import Dominio.OrdemDeServico.Servicos.OsServico;
import Infraestrutura.Persistencia.Implementacao.Funcionario.Mapper.FuncionarioJdbcMapper;
import Infraestrutura.Persistencia.Testes.Funcionario.FuncionarioSimulacaoJDBC;
import Infraestrutura.Persistencia.Testes.Maquina.MaquinaSimulacaoJDBC;
import Infraestrutura.Persistencia.Testes.OsSimulacaoJDBC.OsSimulacaoJDBC;
import Views.Funcionario.Nucleo.MenuInicial;

import java.util.Arrays;

public class Main {
    // Dao para funcionario
    private static FuncionarioSimulacaoJDBC funcionarioDAO = new FuncionarioSimulacaoJDBC();
    //private static FuncionarioJdbcMapper funcionarioJdbcMapper = new FuncionarioJdbcMapper();
    //private static FuncionarioRepositorioJdbc funcionarioDAO = new FuncionarioRepositorioJdbc(funcionarioJdbcMapper);

    // Dao para maquina
    private static MaquinaSimulacaoJDBC maquinaDAO = new MaquinaSimulacaoJDBC();

    // Dao para ordem de serviço
    private static OsSimulacaoJDBC osDAO = new OsSimulacaoJDBC();

    // Aplicação de funcionário
    private static FuncionarioMapper funcionarioMapper = new FuncionarioMapper();
    private static AutorizacaoServico autorizacaoServico = new AutorizacaoServico();
    private static FuncionarioHandler funcionarioHandler = new FuncionarioHandler(funcionarioDAO,funcionarioMapper, autorizacaoServico);
    private static FuncionarioServico funcionarioServico = new FuncionarioServico(funcionarioDAO);

    // Aplicação de Gerente
    private static GerenteMapper gerenteMapper = new GerenteMapper();
    private static GerenteHandler gerenteHandler = new GerenteHandler(gerenteMapper, funcionarioDAO, funcionarioServico, autorizacaoServico);

    // Aplicação de Supervisor
    private static SupervisorMapper supervisorMapper = new SupervisorMapper();
    private static SupervisorHandler supervisorHandler = new SupervisorHandler(supervisorMapper, funcionarioDAO, funcionarioServico, autorizacaoServico);

    // Aplicação de Tecnico
    private static TecnicoMapper tecnicoMapper = new TecnicoMapper();
    private static TecnicoHandler tecnicoHandler = new TecnicoHandler(funcionarioDAO, funcionarioServico, autorizacaoServico, tecnicoMapper);

    // Aplicação de máquina
    private static MaquinaMapper maquinaMapper = new MaquinaMapper();
    private static MaquinaServico maquinaServico = new MaquinaServico(maquinaDAO);
    private static MaquinaHandler maquinaHandler = new MaquinaHandler(maquinaServico, maquinaMapper, autorizacaoServico, maquinaDAO);

    // Aplicaçã de Ordem de Serviço
    private static OsServico osServico = new OsServico(maquinaDAO, funcionarioDAO, osDAO);
    private static OrdemDeServicoMapper osMapper = new OrdemDeServicoMapper();
    private static OrdemDeServicoHandler osHandler = new OrdemDeServicoHandler(osDAO, autorizacaoServico, osServico, osMapper, maquinaDAO);

    // Controllers públicas
    public static GerenteController gerenteController = new GerenteController(gerenteHandler);
    public static FuncionarioController funcionarioController = new FuncionarioController(funcionarioHandler);
    public static SupervisorController supervisorController = new SupervisorController(supervisorHandler);
    public static TecnicoController tecnicoController = new TecnicoController(tecnicoHandler);
    public static MaquinaController maquinaController = new MaquinaController(maquinaHandler);
    public static OrdemDeServicoController osController = new OrdemDeServicoController(osHandler);

    // Inicialização do código
    public static void main(String[] args) {

        // Testes com ArrayList
        funcionarioDAO.funcionarioArrayList.add(new Administrador(0,new NomeFuncionario("joaoAdmA"),new CPF("12345678910"), new Senha("123456@Aa"), new ListaDepartamentos(Arrays.asList(Departamento.MECANICA))));
        funcionarioDAO.funcionarioArrayList.add(new Administrador(7,new NomeFuncionario("joaoAdmB"),new CPF("12345678911"), new Senha("123456@Aa"), new ListaDepartamentos(Arrays.asList(Departamento.MECANICA))));
        funcionarioDAO.salvar(new Gerente(new NomeFuncionario("joaoGerenteA"),new CPF("12345678912"), new Senha("123456@Aa"), new ListaDepartamentos(Arrays.asList(Departamento.MECANICA))));
        funcionarioDAO.salvar(new Gerente(new NomeFuncionario("joaoGerenteB"),new CPF("12345678913"), new Senha("123456@Aa"), new ListaDepartamentos(Arrays.asList(Departamento.MECANICA))));
        funcionarioDAO.salvar(new Tecnico(new NomeFuncionario("joaoTecnicoA"),new CPF("12345678914"), new Senha("123456@Aa"), new ListaDepartamentos(Arrays.asList(Departamento.MECANICA)), Especialidade.SOLDADOR));
        funcionarioDAO.salvar(new Tecnico(new NomeFuncionario("joaoTecnicoB"),new CPF("12345678915"), new Senha("123456@Aa"), new ListaDepartamentos(Arrays.asList(Departamento.MECANICA)), Especialidade.SOLDADOR));
        funcionarioDAO.salvar(new Supervisor(new NomeFuncionario("joaoSupervisorA"),new CPF("12345678916"), new Senha("123456@Aa"), new ListaDepartamentos(Arrays.asList(Departamento.MECANICA)), new MetaMensal(60000)));
        funcionarioDAO.salvar(new Supervisor(new NomeFuncionario("joaoSupervisorB"),new CPF("12345678917"), new Senha("123456@Aa"), new ListaDepartamentos(Arrays.asList(Departamento.MECANICA)), new MetaMensal(60000)));
        maquinaDAO.salvar(new Maquina(new NomeMaquina("MatheusCNC"), Departamento.MECANICA, StatusMaquina.FUNCIONANDO));

        // Inicialização com menu
        MenuInicial.Menu();
    }
}
