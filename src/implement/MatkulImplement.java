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
public class MatkulImplement {
    public Matkul insert(Matkul o) throws SQLException{
        PreparedStatement st = koneksi.getConnection().prepareStatement
        ("insert into matkul values(?,?,?,?,?)");
        st.setString(1, o.getKode_matkul());
        st.setString(2, o.getNidn());
        st.setString(3, o.getId_kelas());
        st.setString(4, o.getNama_matkul());
        st.setString(5, o.getSks());       
        st.executeUpdate();
        return o;
    }
    //untuk update ke database
    public void update(Matkul o) throws SQLException{
        PreparedStatement st = koneksi.getConnection().prepareStatement
        ("update matkul set nidn=?, id_kelas=?, nama_matkul=?, sks=? where id_matkul=?");     
        st.setString(1, o.getNidn());
        st.setString(2, o.getId_kelas());
        st.setString(3, o.getNama_matkul());
        st.setString(4, o.getSks());
        st.setString(5, o.getKode_matkul());
        st.executeUpdate();
    }
    //untuk delete ke database
    public void delete(String kode_matkul) throws SQLException{
        PreparedStatement st = koneksi.getConnection().prepareStatement
        ("delete from matkul where id_matkul=?");
        st.setString(1, kode_matkul);
        st.executeUpdate();
    }
    
   public List<Matkul> getAll() throws SQLException{
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select matkul.id_matkul, matkul.nama_matkul, matkul.sks, "
                + "dosen.nama_dosen, id_kelas from matkul, dosen where matkul.nidn = dosen.nidn");
        List<Matkul>list=new ArrayList<Matkul>();
        while(rs.next()){
            Matkul mtkl = new Matkul();
            mtkl.setKode_matkul(rs.getString("id_matkul"));
            mtkl.setNama_matkul(rs.getString("nama_matkul"));
            mtkl.setSks(rs.getString("sks"));
            mtkl.setNama_dosen(rs.getString("nama_dosen"));
            mtkl.setId_kelas(rs.getString("id_kelas"));
            list.add(mtkl);
        }
        return list;
    }
   
    public ArrayList<String> viewKdDosen() throws SQLException{
        ArrayList<String> viewNamaDosen = new ArrayList();
        try{
            Statement kt = koneksi.getConnection().createStatement();
            ResultSet rsKb = kt.executeQuery("SELECT nidn, nama_dosen FROM dosen");
            while(rsKb.next()){
                viewNamaDosen.add(rsKb.getString("nidn")+"-"+rsKb.getString("nama_dosen"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return viewNamaDosen;
    }
    
    public ArrayList<String> viewKdKelas() throws SQLException{
        ArrayList<String> viewNamaKelas = new ArrayList();
        try{
            Statement kt = koneksi.getConnection().createStatement();
            ResultSet rsKb = kt.executeQuery("SELECT id_kelas FROM kelas");
            while(rsKb.next()){
                viewNamaKelas.add(rsKb.getString("id_kelas"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return viewNamaKelas;
    }
}
