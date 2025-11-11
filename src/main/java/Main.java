//import Models.AdminModel;
import Aplicacao.Funcionario.Gerente.CasosDeUso.CadastrarGerente.Handler.CadastroGerenteHandler;
import Aplicacao.Funcionario.Gerente.CasosDeUso.CadastrarGerente.Mapper.CadastroGerenteMapper;
import Aplicacao.Funcionario.Gerente.GerenteController;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioQueriesRepositorio;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;
import Dominio.Funcionario.Nucleo.Servicos.FuncionarioServico;
import Repositories.FuncionarioDAO;
import Repositories.GerenteDAO;
import Util.Ferramentas;
import Views.MenuInicial;

import java.sql.SQLException;

public class Main
{
    // ----------- DEFINIÇÃO DE FUNCIONÁRIO ESCOLHENDO A IMPLEMENTAÇÃO DO REPOSITÓRIO ----------- //
    private static final FuncionarioQueriesRepositorio funcionarioDao = new FuncionarioDAO();
    private static final FuncionarioServico funcionarioServico = new FuncionarioServico(funcionarioDao);

    // ----------- DEFINIÇÃO DE GERENTE ESCOLHENDO A IMPLEMENTAÇÃO DO REPOSITÓRIO ----------- //
    private static final FuncionarioRepositorio gerenteDao = new GerenteDAO();
    private static final CadastroGerenteMapper cadastroGerenteMapper = new CadastroGerenteMapper();
    private static final CadastroGerenteHandler cadastroGerenteHandler = new CadastroGerenteHandler(cadastroGerenteMapper, gerenteDao, funcionarioServico);
    private static final GerenteController gerenteController = new GerenteController(cadastroGerenteHandler);

    // ----------- DEFINIÇÃO DOS MENUS NECESSÁRIOS ----------- //
    private static MenuInicial menuInicial = new MenuInicial(gerenteController);

    // -- Métodos -- //
    public static void main(String[] args) {
        System.out.println(Ferramentas.BLUE+"▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉");
        System.out.println("▉▉▉  ");
        System.out.println("▉▉▉   ▉▉▉   ▉▉▉   ▉▉▉▉▉▉▉   ▉▉▉▉▉▉▉▉▉");
        System.out.println("▉▉▉   ▉▉▉   ▉▉▉   ▉▉▉       ▉▉▉   ▉▉▉");
        System.out.println("▉▉▉   ▉▉▉   ▉▉▉   ▉▉▉▉▉▉▉   ▉▉▉   ▉▉▉");
        System.out.println("▉▉▉   ▉▉▉   ▉▉▉   ▉▉▉       ▉▉▉   ▉▉▉");
        System.out.println("▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉   ▉▉▉▉▉▉▉   ▉▉▉▉▉▉▉▉▉");
        System.out.println("                                  ▉▉▉");
        System.out.println("▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉"+Ferramentas.RESET);

        menuInicial.Menu();
    }
}