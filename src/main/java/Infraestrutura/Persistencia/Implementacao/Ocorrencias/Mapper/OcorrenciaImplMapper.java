package Infraestrutura.Persistencia.Implementacao.Ocorrencias.Mapper;// Ou seu pacote de mappers

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Ocorrencia.Enumeracoes.StatusOc;

public class OcorrenciaImplMapper {

        public Departamento mapearDepartamento(int id) {
            return switch (id) {
                case 1 -> Departamento.ELETRICA;
                case 2 -> Departamento.MECANICA;
                default -> Departamento.MECANICA;
            };
        }

        public StatusOc mapearStatus(int id) {
            return switch (id) {
                case 1 -> StatusOc.ABERTA;
                case 2 -> StatusOc.EM_ANDAMENTO;
                default -> StatusOc.FECHADA;
            };
        }
        public StatusOc getStatusParaGeral()
        {
            return StatusOc.FECHADA;
        }
    }
