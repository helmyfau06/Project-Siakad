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
public class MahasiswaImplement {
    public Mahasiswa insert(Mahasiswa o) throws SQLException{
        PreparedStatement st1 = koneksi.getConnection().prepareStatement
        ("insert into pengguna (username, password, role) values(?,?,?)");
        st1.setString(1, o.getNpm());
        st1.setString(2, o.getNpm());
        st1.setString(3, "mahasiswa");
        st1.executeUpdate();
        Statement st2 = koneksi.getConnection().createStatement();
        ResultSet rs=st2.executeQuery("select id_user from pengguna order by id_user desc limit 1");
        int id_user=-1;
        while(rs.next()){
            id_user = rs.getInt("id_user");
        }
        PreparedStatement st = koneksi.getConnection().prepareStatement
        ("insert into mahasiswa values(?,?,?,?,?,?,?)");
        st.setString(1, o.getNpm());
        st.setInt(2, id_user);
        st.setString(3, o.getId_kelas());
        st.setString(4, o.getNama_mhs());
        st.setString(5, o.getJk());
        st.setString(6, o.getTgl_lahir());
        st.setString(7, o.getAlamat());
        st.executeUpdate();
        return o;
    }
    //untuk update ke database
    public void update(Mahasiswa o) throws SQLException{
        PreparedStatement st = koneksi.getConnection().prepareStatement
        ("update mahasiswa set id_kelas=?, nama_mhs=?, jk=?, tgl_lahir=?, alamat=? where npm=?");     
        st.setString(1, o.getId_kelas());
        st.setString(2, o.getNama_mhs());
        st.setString(3, o.getJk());
        st.setString(4, o.getTgl_lahir());
        st.setString(5, o.getAlamat());
        st.setString(6, o.getNpm());
        st.executeUpdate();
    }
    //untuk delete ke database
    public void delete(String npm) throws SQLException{
        PreparedStatement st = koneksi.getConnection().prepareStatement
        ("delete from mahasiswa where npm=?");
        st.setString(1, npm);
        st.executeUpdate();
    }
    
   public List<Mahasiswa> getAll() throws SQLException{
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select mahasiswa.npm, mahasiswa.nama_mhs, mahasiswa.jk, mahasiswa.tgl_lahir, "
                + "mahasiswa.alamat, kelas.id_kelas, jurusan.id_jurusan"
                + " from mahasiswa, kelas, jurusan where mahasiswa.id_kelas = kelas.id_kelas AND kelas.id_jurusan = jurusan.id_jurusan");
        List<Mahasiswa>list=new ArrayList<Mahasiswa>();
        while(rs.next()){
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNpm(rs.getString("npm"));
            mhs.setNama_mhs(rs.getString("nama_mhs"));
            mhs.setId_Jurusan(rs.getString("id_jurusan"));
            mhs.setId_kelas(rs.getString("id_kelas"));           
            mhs.setJk(rs.getString("jk"));
            mhs.setTgl_lahir(rs.getString("tgl_lahir"));
            mhs.setAlamat(rs.getString("alamat"));
            list.add(mhs);
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
    
    public static ArrayList<String> viewKdKelas(String kd_jurusan) throws SQLException{
        ArrayList<String> viewNamaKelas = new ArrayList();
        try{
            Statement kt = koneksi.getConnection().createStatement();
            ResultSet rsKb = kt.executeQuery("SELECT kelas.id_kelas FROM kelas, jurusan "
                    + "WHERE kelas.id_jurusan = jurusan.id_jurusan AND jurusan.id_jurusan = '"+kd_jurusan+"'");
            while(rsKb.next()){
                viewNamaKelas.add(rsKb.getString("id_kelas"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return viewNamaKelas;
    }
}

