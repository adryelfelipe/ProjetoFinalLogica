package Dominio.Ocorrencia.Servicos;

import Dominio.Ocorrencia.Repositories.OcorrenciaRepositorio;

public class OcorrenciaServico {
    OcorrenciaRepositorio ocorrenciaRepositorio;

    public OcorrenciaServico(OcorrenciaRepositorio ocRepositorio) {
        this.ocorrenciaRepositorio = ocRepositorio;
    }
}
