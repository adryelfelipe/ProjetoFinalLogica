package Service.Validator;

import Models.OrdemDeServico;
import Models.Enumeracoes.StatusOS;

public class OrdemDeServicoValidator
{
    // -- Verifica regras de negócio -- //
    public static void verificaRegrasInsercaoOS(OrdemDeServico ordemServico) {
        verificaRegrasDescricao(ordemServico.getDescricao());
        verificaRegrasStatus(ordemServico.getStatusDaOrdem().getId());
    }

    public static void verificaRegrasDescricao(String descricao) {
        if (descricao == null) {
            throw new IllegalStateException("ERRO! A DESCRIÇÃO NÃO PODE SER NULO");
        }

        if (descricao.length() < 5 || descricao.length() > 100) {
            throw new IllegalStateException("ERRO! A DESCRIÇÃO DEVE CONTER MAIS DE 1 CARACTER E MENOS QUE 100");
        }
    }

    public static void verificaRegrasStatus(int Status){
        if(Status > 3) {
            throw new IllegalStateException("ERRO! O ID DO STATUS NÃO PODE SER MAIOR QUE 3");
        }
    }

    // -- Verifica integridade de dados -- //
    public static void verificaIntegridadeStatus(StatusOS statusOS) {
        if(statusOS.getId() < 0) {
            throw new IllegalArgumentException("ERRO! O ID DO STATUS NÃO PODE SER NEGATIVO");
        }
    }

    public static void verificaIntegridadeIdTecnico(long idTecnico) {
        if(idTecnico < 0) {
            throw new IllegalArgumentException("ERRO! O ID DO TÉCNICO NÃO PODE SER NEGATIVO");
        }
    }

    public static void verificaIntegridadeIdOrdem_Servico(long idOrdem_Servico) {
        if(idOrdem_Servico < 0) {
            throw new IllegalArgumentException("ERRO! O ID DA ORDEM DE SERVIÇO NÃO PODE SER NEGATIVO");
        }
    }

    public static void verificaIntegridadeIdMaquina(long idMaquina) {
        if(idMaquina < 0) {
            throw new IllegalArgumentException("ERRO! O ID DA MÁQUINA NÃO PODE SER NEGATIVO");
        }
    }

    public static void verificarValorDaOrdemDeServico(double valorDaOrdemDeServico) {
        if (valorDaOrdemDeServico < 0.0) {
            throw new IllegalArgumentException("O VALOR DA ORDEM DE SERVIÇO NAO PODE SER NEGATIVO");
        }
    }

    public static void verificaIntegridadeDescricao(String descricao) {
        if(descricao.isBlank()) {
            throw new IllegalStateException("ERRO! A DESCRIÇÃO NÃO PODE SER VAZIA");
        }
    }
}