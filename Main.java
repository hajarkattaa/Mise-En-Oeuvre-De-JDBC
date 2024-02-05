import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        // Définition des informations de connexion
        String url = "mongodb+srv://hajarkattaa:Ev2fdV4sQdNhnk1S@cluster0.xaqszmr.mongodb.net/?retryWrites=true&w=majority";
        String user = "";
        String password = "";

        // Déclaration des objets de connexion
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            Class.forName("mongodb.jdbc.MongoDriver");

            // pr créer une instruction SQL
            stmt = conn.createStatement();

            // pr exécuter une requête SQL (par exemple, récupérer des données)
            rs = stmt.executeQuery("SELECT * FROM mycollection");

            // Parcourir les résultats de la requête
            while (rs.next()) {
                // Traiter chaque ligne de résultat
                String id = rs.getString("id");
                String name = rs.getString("name");
                // Afficher les données récupérées
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}