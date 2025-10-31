package ProjetoBase;

import Connections.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrdemDeServicoDAO {
    public void inserirOrdemDeServico(OrdemDeServicoModel ordemDeServico) {
        String querySQL = "INSERT INTO OrdemServicos (id_os, descricao, status_ordem, custo) VALUES (?, ?, ?, ?)";
/*
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, ordemDeServico.getIdOrdemDeServico());
            stmt.setString(2, ordemDeServico.getDescricao());
            stmt.setString(3, ordemDeServico.get);
        }
    }*/
    }
}
