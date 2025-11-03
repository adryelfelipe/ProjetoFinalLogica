package Views;

import Models.AdminModel;
import Models.GerenteModel;
import ProjetoBase.GerenteService;
import ProjetoBase.UsuarioService;
import Repositories.GerenteDAO;
import Repositories.UsuarioDAO;
import Util.Ferramentas;

import java.sql.SQLOutput;

public class MenuAdminUpdateGerente {

    private static final GerenteService gerenteService = new GerenteService();
    private static final UsuarioService usuarioService = new UsuarioService();

    public static void updateGerente(AdminModel adminModel) {
        boolean verifica = false;
        long idGerente;
        int opcaoAdm = 0;

        try {
            idGerente = MenuEscolhaId.escolhaIdUpdate();
        } catch (IllegalArgumentException e) {
            Ferramentas.mensagemErro(e.getMessage());
            return;
        }

        GerenteModel gerente = ((GerenteModel) usuarioService.findById(idGerente));

        while (!verifica)
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
            System.out.println(" [4] - Departamento                  ");
            System.out.println(" [5] - Retornar                      ------------------------");

            try {
                opcaoAdm = Ferramentas.lInteiro();

                switch (opcaoAdm) {
                    case 1 -> {
                        String nome = MenuSetUsuario.MenuSetNome();
                        usuarioService.updateNomeUsuario(adminModel, idGerente, nome);
                        gerente.setNome(nome);
                    }

                    case 2 -> {
                        String cpf = MenuSetUsuario.MenuSetCpf();
                        usuarioService.updateCpfUsuario(adminModel, idGerente, cpf);
                        gerente.setCpf(cpf);
                    }

                    case 3 -> {
                        String senha = MenuSetUsuario.MenuSetSenha();
                        usuarioService.updateSenhaUsuario(adminModel, idGerente, senha);
                        gerente.setSenha(senha);
                    }
                    case 4 -> {
                        int departamento = MenuSetGerente.menuSetDepartamento();
                        gerenteService.updatedepartamento(adminModel, idGerente, departamento);
                        gerente.setDepartamento(departamento);
                    }
                    case 5 ->
                    {
                        return;
                    }
                    default -> Ferramentas.menuDefault();
                }
            }
            catch(IllegalArgumentException e)
            {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
