//import Models.AdminModel;
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
import Repositories.FuncionarioDAO;
import Repositories.teste;
import Util.Ferramentas;
import Views.MenuInicial;

import java.util.Arrays;

public class Main
{
    // ----------- DEFINIÇÃO DE FUNCIONÁRIO ESCOLHENDO A IMPLEMENTAÇÃO DO REPOSITÓRIO ----------- //
    //private static final FuncionarioDAO funcionarioDao = new FuncionarioDAO();
    //private static final FuncionarioServico funcionarioServico = new FuncionarioServico(funcionarioDao);
    // private static final FuncionarioMapper funcionarioMapper = new FuncionarioMapper();
    // private static final FuncionarioHandler funcionarioHandler = new FuncionarioHandler(funcionarioDao, funcionarioMapper);
    // private static final FuncionarioController funcionarioController = new FuncionarioController(funcionarioHandler);
    // private static final AutorizacaoServico autorizacaoServico = new AutorizacaoServico();

    // -- TESTES -- //
    private static final teste teste = new teste();
    private static final FuncionarioServico funcionarioServicoTst = new FuncionarioServico(teste);
    private static final FuncionarioMapper funcionarioMapperTst = new FuncionarioMapper();
    private static final FuncionarioHandler funcionarioHandlerTst = new FuncionarioHandler(teste, funcionarioMapperTst);
    private static final FuncionarioController funcionarioControllerTst = new FuncionarioController(funcionarioHandlerTst);
    private static final GerenteMapper gerenteMapperTst = new GerenteMapper();
    private static final AutorizacaoServico autorizacaoServicoTst = new AutorizacaoServico();
    private static final GerenteHandler gerenteHandlerTst = new GerenteHandler(gerenteMapperTst, teste, funcionarioServicoTst, autorizacaoServicoTst);
    private static final GerenteController gerenteControllerTst = new GerenteController(gerenteHandlerTst);


    // ----------- DEFINIÇÃO DE GERENTE ESCOLHENDO A IMPLEMENTAÇÃO DO REPOSITÓRIO ----------- //
    // private static final GerenteMapper gerenteMapper = new GerenteMapper();
    // private static final GerenteHandler gerenteHandler = new GerenteHandler(gerenteMapper, funcionarioDao, funcionarioServico, autorizacaoServico);
    // private static final GerenteController gerenteController = new GerenteController(gerenteHandler);


    // ----------- DEFINIÇÃO DOS MENUS NECESSÁRIOS ----------- //
    //private static MenuInicial menuInicial = new MenuInicial(gerenteController, funcionarioController);
    private static MenuInicial menuTestes = new MenuInicial(gerenteControllerTst, funcionarioControllerTst);

    // -- Métodos -- //
    public static void main(String[] args) {
        teste.funcionarioArrayList.add(new Administrador(1,new NomeFuncionario("joaozera"),new CPF("12345678910"), new Senha("Abcdw234@"), new ListaDepartamentos(Arrays.asList(Departamento.MECANICA))));


        System.out.println(Ferramentas.BLUE+"▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉");
        System.out.println("▉▉▉  ");
        System.out.println("▉▉▉   ▉▉▉   ▉▉▉   ▉▉▉▉▉▉▉   ▉▉▉▉▉▉▉▉▉");
        System.out.println("▉▉▉   ▉▉▉   ▉▉▉   ▉▉▉       ▉▉▉   ▉▉▉");
        System.out.println("▉▉▉   ▉▉▉   ▉▉▉   ▉▉▉▉▉▉▉   ▉▉▉   ▉▉▉");
        System.out.println("▉▉▉   ▉▉▉   ▉▉▉   ▉▉▉       ▉▉▉   ▉▉▉");
        System.out.println("▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉   ▉▉▉▉▉▉▉   ▉▉▉▉▉▉▉▉▉");
        System.out.println("                                  ▉▉▉");
        System.out.println("▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉"+Ferramentas.RESET);

        menuTestes.Menu();
        // menuInicial.Menu();
    }
}