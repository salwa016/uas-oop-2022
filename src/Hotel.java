import java.sql.SQLException;
import java.sql.Statement;
import javafx.beans.property.SimpleStringProperty;
import javax.crypto.NullCipher;



      
public class Hotel {

    private String Id_tamu ;
    private String jumlah_tamu = null;
    private String nama_tamu;

    public Hotel( String id_tamu, String jumlah_tamu, String nama_tamu) {
        this.Id_tamu = id_tamu;
        this.jumlah_tamu = jumlah_tamu;
        this.nama_tamu= nama_tamu;
    }

    public String getId_tamu() {
        return Id_tamu;
    }

    public String getJumlah_tamu() {
        return jumlah_tamu;
    }

    public String getNama_tamu(){
        return nama_tamu;
    }

    public boolean update(String nama_tamu, String jumlah_tamu) {
        Database db = new Database();
        try {
            Statement state = db.conn.createStatement();
            String sql = "update tamu SET nama_tamu='%s', jumlah_tamu='%s' WHERE id_tamu=%d";
            sql = String.format(sql, Id_tamu, jumlah_tamu ,nama_tamu );
            state.execute(sql);
            db.conn.close();
            return true;
        } catch (SQLException e1) {
            return false;
        }
    }

    public boolean delete(int id_tamu) {
        Database db = new Database();
        try {
            Statement state = db.conn.createStatement();
            String sql = "delete from tamu WHERE id_tamu=%d";
            sql = String.format(sql, id_tamu);
            state.execute(sql);
            db.conn.close();
            return true;
        } catch (SQLException e1) {
            return false;
        }
    }
}