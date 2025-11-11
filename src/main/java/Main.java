//import Models.AdminModel;
import Dominio.Funcionario.Administrador.Administrador;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;
import testesProjeto.Infra.TesteDao;
import Views.MenuInicial;

import java.util.Arrays;

public class Main
{
    // -- Testes -- //
    private static TesteDao testeDao = new TesteDao();

    // -- Métodos -- //
    public static void main(String[] args) {
        testeDao.funcionarioArrayList.add(new Administrador(1,new NomeFuncionario("joaozera"),new CPF("12345678910"), new Senha("Abcdw234@"), new ListaDepartamentos(Arrays.asList(Departamento.MECANICA))));

        MenuInicial.Menu();
    }
}