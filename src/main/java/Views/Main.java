package Views;

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
import Dominio.Funcionario.Administrador.Administrador;
import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;
import Dominio.Funcionario.Nucleo.Servicos.FuncionarioServico;
import Dominio.Maquina.Servicos.MaquinaServico;
import Infraestrutura.FuncionarioDAO;
import Infraestrutura.testes.FuncionarioTesteDAO;
import Infraestrutura.testes.MaquinaTesteDAO;

import java.util.Arrays;

public class Main {
    // Dao para testes
    private static FuncionarioTesteDAO funcionarioDAO = new FuncionarioTesteDAO();
    //private static FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private static MaquinaTesteDAO maquinaTesteDAO = new MaquinaTesteDAO();

    // Aplicação teste de funcionário
    private static FuncionarioMapper funcionarioMapper = new FuncionarioMapper();
    private static FuncionarioHandler funcionarioHandler = new FuncionarioHandler(funcionarioDAO,funcionarioMapper);
    private static AutorizacaoServico autorizacaoServico = new AutorizacaoServico();
    private static FuncionarioServico funcionarioServico = new FuncionarioServico(funcionarioDAO);
    private static MaquinaServico maquinaServico = new MaquinaServico(maquinaTesteDAO);

    // Aplicação teste de Gerente
    private static GerenteMapper gerenteMapper = new GerenteMapper();
    private static GerenteHandler gerenteHandler = new GerenteHandler(gerenteMapper, funcionarioDAO, funcionarioServico, autorizacaoServico);

    // Aplicação teste de Supervisor
    private static SupervisorMapper supervisorMapper = new SupervisorMapper();
    private static SupervisorHandler supervisorHandler = new SupervisorHandler(supervisorMapper, funcionarioDAO, funcionarioServico, autorizacaoServico);

    // Aplicação para teste de Tecnico
    private static TecnicoMapper tecnicoMapper = new TecnicoMapper();
    private static TecnicoHandler tecnicoHandler = new TecnicoHandler(funcionarioDAO, funcionarioServico, autorizacaoServico, tecnicoMapper);

    // Aplicação para teste de máquina
    private static MaquinaMapper maquinaMapper = new MaquinaMapper();
    private static MaquinaHandler maquinaHandler = new MaquinaHandler(maquinaServico, maquinaMapper, autorizacaoServico, maquinaTesteDAO);

    // Controllers públicas
    public static GerenteController gerenteController = new GerenteController(gerenteHandler);
    public static FuncionarioController funcionarioController = new FuncionarioController(funcionarioHandler);
    public static SupervisorController supervisorController = new SupervisorController(supervisorHandler);
    public static TecnicoController tecnicoController = new TecnicoController(tecnicoHandler);
    public static MaquinaController maquinaController = new MaquinaController(maquinaHandler);

    public static void main(String[] args) {
        funcionarioDAO.funcionarioArrayList.add(new Administrador(1,new NomeFuncionario("joaozera"),new CPF("12345678910"), new Senha("123456@Aa"), new ListaDepartamentos(Arrays.asList(Departamento.MECANICA))));
        funcionarioDAO.funcionarioArrayList.add(new Gerente(1,new NomeFuncionario("joaozera"),new CPF("12345678912"), new Senha("123456@Aa"), new ListaDepartamentos(Arrays.asList(Departamento.MECANICA))));
        MenuInicial.Menu();
    }
}
