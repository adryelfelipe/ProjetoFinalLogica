package Views;

import Models.AdminModel;
import Util.Ferramentas;

import java.sql.SQLOutput;

public class MenuAdminUpdateGerente
{
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

        while(!verifica)
        {
            System.out.println("|================================|");
            System.out.println("|======  ATUALIZAR GERENTE  =====|");
            System.out.println("|================================|");

            System.out.println("       -------------------           --------- ATUAL --------");
            System.out.println("       |EDITAR   GERENTE|           |Nome: " + .getNome());
            System.out.println("       -------------------           |CPF: " + paciente.getCpf());
            System.out.println("                                     |Senha: " + paciente.getSenha());
            System.out.println(" [1] - Nome                          |Email: " + paciente.getEmail());
            System.out.println(" [2] - CPF                           |Departamento: " + );
            System.out.println(" [3] - Senha                         ");
            System.out.println(" [9] - Departamento                  ------------------------");
        }
    }
}
