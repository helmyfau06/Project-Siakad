/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import koneksiData.*;
import entitas.*;

/**
 *
 * @author ASUS
 */
public class JurusanImplement {
    public Jurusan insert(Jurusan o) throws SQLException{
        PreparedStatement st = koneksi.getConnection().prepareStatement
        ("insert into jurusan values(?,?)");
        st.setString(1, o.getKode_jurusan());
        st.setString(2, o.getNama_jurusan());
        st.executeUpdate();
        return o;
    }
    //untuk update ke database
    public void update(Jurusan o) throws SQLException{
        PreparedStatement st = koneksi.getConnection().prepareStatement
        ("update jurusan set nama_jurusan=? where id_jurusan=?");
        st.setString(1, o.getNama_jurusan());
        st.setString(2, o.getKode_jurusan());
        st.executeUpdate();
    }
    //untuk delete ke database
    public void delete(String kode_jurusan) throws SQLException{
        PreparedStatement st = koneksi.getConnection().prepareStatement
        ("delete from jurusan where id_jurusan=?");
        st.setString(1, kode_jurusan);
        st.executeUpdate();
    }
    
   public List<Jurusan> getAll() throws SQLException{
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from jurusan");
        List<Jurusan>list=new ArrayList<Jurusan>();
        while(rs.next()){
            Jurusan jurusan = new Jurusan();
            jurusan.setKode_jurusan(rs.getString("id_jurusan"));
            jurusan.setNama_jurusan(rs.getString("nama_jurusan"));
            list.add(jurusan);
        }
        return list;
    }
}
