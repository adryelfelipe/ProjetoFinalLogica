package ProjetoBase;

import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;

public class GerenteValidator {
    // -- Verifica regras de négoico -- //
    public static void verificaRegrasInsercaoGerente(Gerente gerente) {
        verificaRegrasDepartamento(gerente.getDepartamentos().getListaDepartamentos().get(0));
        UsuarioValidator.verificaRegrasInsercaoUsuario(gerente);
    }

    public static void verificaRegrasDepartamento(Departamento departamento) {
        if(departamento == null) {
            throw new IllegalStateException("ERRO! O DEPARTAMENTO NÃO PODE SER NULO");
        }
    }

    // -- Verifica integridade de dados -- //
    public static void verificaIntegridadeDepartamento(Departamento idDepartamento){
    }
}
