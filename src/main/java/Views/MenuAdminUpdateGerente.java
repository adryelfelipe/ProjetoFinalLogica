package Views;

import Models.AdminModel;
import Models.GerenteModel;
import ProjetoBase.GerenteService;
import ProjetoBase.UsuarioService;
import Repositories.UsuarioDAO;
import Util.Ferramentas;

import java.sql.SQLOutput;

public class MenuAdminUpdateGerente
{
    private static final UsuarioService usuarioService = new UsuarioService();
    private static final GerenteService gerenteService = new GerenteService();
    private static final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public static void updateGerente(AdminModel adminModel)
    {
        boolean verifica = false;
        long idGerente;

        try {
            idGerente = MenuEscolhaId.escolhaIdUpdate();
        } catch (IllegalArgumentException e) {
            Ferramentas.mensagemErro(e.getMessage());
            return;
        }

        GerenteModel gerente = ((GerenteModel) usuarioDAO.findById(idGerente));

        while(!verifica)
        {
            System.out.println("|================================|");
            System.out.println("|======  ATUALIZAR GERENTE  =====|");
            System.out.println("|================================|");

            System.out.println("       -------------------           --------- ATUAL --------");
            System.out.println("       |EDITAR   GERENTE|            |Nome: " + gerente.getNome());
            System.out.println("       -------------------           |CPF: " + gerente.getCpf());
            System.out.println("                                     |Senha: " + gerente.getSenha());
            System.out.println(" [1] - Nome                          |Departamento: " + gerente.getDepartamento());
            System.out.println(" [2] - CPF                           ");
            System.out.println(" [3] - Senha                         ");
            System.out.println(" [9] - Departamento                  ------------------------");
        }
    }
}
