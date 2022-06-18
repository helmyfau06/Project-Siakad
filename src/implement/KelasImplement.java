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
public class KelasImplement {
    public Kelas insert(Kelas o) throws SQLException{
        PreparedStatement st = koneksi.getConnection().prepareStatement
        ("insert into kelas values(?,?,?)");
        st.setString(1, o.getKode_kelas());
        st.setString(2, o.getNama_jurusan());
        st.setString(3, o.getKelas());
        st.executeUpdate();
        return o;
    }
    //untuk update ke database
    public void update(Kelas o) throws SQLException{
        PreparedStatement st = koneksi.getConnection().prepareStatement
        ("update kelas set id_jurusan=?, kelas=? where id_kelas=?");
        st.setString(1, o.getNama_jurusan());
        st.setString(2, o.getKelas());
        st.setString(3, o.getKode_kelas());
        st.executeUpdate();
    }
    //untuk delete ke database
    public void delete(String kode_kelas) throws SQLException{
        PreparedStatement st = koneksi.getConnection().prepareStatement
        ("delete from kelas where id_kelas=?");
        st.setString(1, kode_kelas);
        st.executeUpdate();
    }
    
   public List<Kelas> getAll() throws SQLException{
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from kelas");
        List<Kelas>list=new ArrayList<Kelas>();
        while(rs.next()){
            Kelas kls = new Kelas();
            kls.setKode_kelas(rs.getString("id_kelas"));
            kls.setNama_jurusan(rs.getString("id_jurusan"));
            kls.setKelas(rs.getString("kelas"));
            list.add(kls);
        }
        return list;
    }
   
    public ArrayList<String> viewKdJurusan() throws SQLException{
        ArrayList<String> viewNamaJurusan = new ArrayList();
        try{
            Statement kt = koneksi.getConnection().createStatement();
            ResultSet rsKb = kt.executeQuery("SELECT id_jurusan FROM jurusan");
            while(rsKb.next()){
                viewNamaJurusan.add(rsKb.getString("id_jurusan"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return viewNamaJurusan;
    }
   
   
}
