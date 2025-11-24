package Service.Validator;

import Models.Enumeracoes.Departamento;
import Models.Enumeracoes.StatusOc;

public class OcorrenciaValidator
{
    // verificação do ID da ocorrência
    public static void verificarIdOc(long ID_OC)
    {
        if(ID_OC < 0)
        {
            throw new IllegalArgumentException("ERRO! O ID DA OCORRÊNCIA NÃO PODE SER NEGATIVO");
        }
    }

    // verificação do ID da máquina
    public static void verificarIdMaquina(long idMaquina)
    {
        if(idMaquina < 0)
        {
            throw new IllegalArgumentException("ERRO! O ID DA MÁQUINA NÃO PODE SER NEGATIVO");
        }
    }

    public static void verificarDepartamento(Departamento departamento)
    {
        if(departamento == null)
        {
            throw new IllegalStateException("ERRO! O DEPARTAMENTO NÃO PODE SER NULO");
        }
    }

    public static void verificarStatusOc(StatusOc statusOC)
    {
        if(statusOC == null)
        {
            throw new IllegalStateException("ERRO! O STATUS DA OCORRÊNCIA NÃO PODE SER NULO");
        }
    }
}
