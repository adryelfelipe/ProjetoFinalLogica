package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // Conexão com o Banco de Dados
    public static Connection getConnection ()
    {
        String url = "jdbc:mysql://avnadmin:AVNS_I2ViM3IuPO0TByk7qNc@mysqlteste-theuzinx23-d156.d.aivencloud.com:19307/ManutencaoServicosDB?ssl-mode=REQUIRED";
        String user = "avnadmin";
        String senha = "AVNS_I2ViM3IuPO0TByk7qNc";

        Connection conn = null;

        try {
            return conn = DriverManager.getConnection(url, user, senha);
        }
        catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco");
        }
        return conn;
    }
}
