package ProjetoBase;

import Dominio.Funcionario.Gerente.Gerente;
import Departamento;

public class GerenteValidator {
    // -- Verifica regras de négoico -- //
    public static void verificaRegrasInsercaoGerente(Gerente gerente) {
        verificaRegrasDepartamento(gerente.getDepartamento());
        UsuarioValidator.verificaRegrasInsercaoUsuario(gerente);
    }

    public static void verificaRegrasDepartamento(Departamento departamento) {
        if(departamento == null) {
            throw new IllegalStateException("ERRO! O DEPARTAMENTO NÃO PODE SER NULO");
        }

        if(departamento.getId() > 3) {
            throw new IllegalStateException("ERRO! ID DE DEPARTAMENTO INVÁLIDO");
        }
    }

    // -- Verifica integridade de dados -- //
    public static void verificaIntegridadeDepartamento(Departamento idDepartamento){
        if(idDepartamento.getId() < 0) {
            throw new IllegalArgumentException("ERRO! O ID NÃO PODE SER NEGATIVO");
        }
    }
}
