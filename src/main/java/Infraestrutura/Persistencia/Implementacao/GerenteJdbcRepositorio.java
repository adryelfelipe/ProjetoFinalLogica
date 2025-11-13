package Infraestrutura.Persistencia.Implementacao;

public class GerenteJdbcRepositorio {
    /*
    public void salvar(Gerente gerente)
    {
        String querySQL = "INSERT INTO Gerentes (id_gerente, id_departamento) VALUES (?, ?)";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, gerente.getId());
            stmt.setInt(2, gerente.getDepartamentos().getListaDepartamentos().get(0).getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("ERRO AO INSERIR GERENTE");
        }
    }

    public boolean excluirPorID(long id)
    {
        String querySQL = "DELETE FROM Gerentes WHERE id_gerente = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setLong(1, id);

            int linhasAF = stmt.executeUpdate();

            // Se conseguir retorna true.
            if(linhasAF > 0 )
            {
                return true;
            }
            // Senão conseguir retorna false.
            else
            {
                return false;
            }
        }catch (SQLException e )
        {
            System.err.println("ERRO ao deletar gerente com o ID: " + id);
            return false;
        }
    }

    public void updateDepartamento(long id, Departamento departamento)
    {
        String querySQL = "UPDATE Gerentes SET id_departamento = ? WHERE id_gerente = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySQL))
        {
            stmt.setInt(1, departamento.getId());
            stmt.setLong(2, id);

            stmt.executeUpdate();
        }catch (SQLException e)
        {
            System.err.println("ERRO ao atualizar departamento do gerente");
        }
    }


     */
}