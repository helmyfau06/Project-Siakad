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
import projectsiakad.*;
import entitas.*;

/**
 *
 * @author ASUS
 */
public class NilaiImplement {
    public Nilai insert(Nilai o) throws SQLException{
        PreparedStatement st = koneksi.getConnection().prepareStatement
        ("insert into nilai values(?,?,?,?,?,?,?,?)");
        st.setString(1, null);
        st.setString(2, o.getNpm());
        st.setString(3, o.getId_matkul());
        st.setString(4, o.getNilai_tugas()+"");
        st.setString(5, o.getNilai_uts()+"");
        st.setString(6, o.getNilai_uas()+"");
        st.setString(7, o.getNilai_akhir()+"");
        st.setString(8, o.getIndex());
        st.executeUpdate();
        return o;
    }
    //untuk update ke database
    public void update(Nilai o) throws SQLException{
        PreparedStatement st = koneksi.getConnection().prepareStatement
        ("update nilai set npm=?, id_matkul=?, nilai_tugas=?, nilai_uts=?, nilai_uas=?, nilai_akhir=?, index_nilai=? where id_nilai=?");     
        st.setString(1, o.getNpm());
        st.setString(2, o.getId_matkul());
        st.setInt(3, o.getNilai_tugas());
        st.setInt(4, o.getNilai_uts());
        st.setInt(5, o.getNilai_uas());
        st.setInt(6, o.getNilai_akhir());
        st.setString(7, o.getIndex());
        st.setInt(8, o.getId_nilai());
        st.executeUpdate();
    }
    //untuk delete ke database
    public void delete(String id_nilai) throws SQLException{
        PreparedStatement st = koneksi.getConnection().prepareStatement
        ("delete from nilai where id_nilai=?");
        st.setString(1, id_nilai);
        st.executeUpdate();
    }
    
   public List<Nilai> getAll(String kode_matkul) throws SQLException{
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("SELECT nilai.id_nilai, mahasiswa.npm, mahasiswa.nama_mhs, "
                + " nilai.nilai_tugas, nilai.nilai_uts, nilai.nilai_uas, nilai.nilai_akhir, nilai.index_nilai FROM mahasiswa, nilai, kelas, matkul "
                + "WHERE mahasiswa.npm = nilai.npm AND matkul.id_matkul = nilai.id_matkul AND kelas.id_kelas = matkul.id_kelas "
                + "AND matkul.id_matkul = '"+kode_matkul+"'");
        List<Nilai>list=new ArrayList<Nilai>();
        while(rs.next()){
            Nilai nilai = new Nilai();
            nilai.setId_nilai(rs.getInt("id_nilai"));
            //nilai.setId_kelas(rs.getString("id_kelas"));
            nilai.setNpm(rs.getString("npm"));
            nilai.setNama(rs.getString("nama_mhs"));
            nilai.setNilai_tugas(rs.getInt("nilai_tugas"));           
            nilai.setNilai_uts(rs.getInt("nilai_uts"));
            nilai.setNilai_uas(rs.getInt("nilai_uas"));
            nilai.setNilai_akhir(rs.getInt("nilai_akhir"));
            nilai.setIndex(rs.getString("index_nilai"));
            list.add(nilai);
        }
        return list;       
    }
   
    public ArrayList<String> viewKdMatkul() throws SQLException{
        ArrayList<String> viewNamaMatkul = new ArrayList();
        try{
            Statement kt = koneksi.getConnection().createStatement();
            ResultSet rsKb = kt.executeQuery("SELECT id_matkul, nama_matkul FROM matkul where nidn='"+UserSession.getDosen().getNidn()+"'");
            while(rsKb.next()){
                viewNamaMatkul.add(rsKb.getString("id_matkul")+"-"+rsKb.getString("nama_matkul"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return viewNamaMatkul;
    }
    
    public static Kelas viewKdKelas(String kd_matkul) throws SQLException{
        Kelas kelas = new Kelas();
        try{             
            Statement kt = koneksi.getConnection().createStatement();
            ResultSet rsKb = kt.executeQuery("SELECT id_kelas FROM matkul where id_matkul='"+kd_matkul+"'");
            while(rsKb.next()){
                kelas.setKode_kelas(rsKb.getString("id_kelas"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return kelas;
    }
    
    public ArrayList<String> viewNpm(String kd_kelas) throws SQLException{
        ArrayList<String> viewNamaMhs = new ArrayList();
        try{
            Statement kt = koneksi.getConnection().createStatement();
            ResultSet rsKb = kt.executeQuery("SELECT mahasiswa.npm FROM mahasiswa, matkul, dosen, kelas where"
                    + " mahasiswa.id_kelas = kelas.id_kelas AND kelas.id_kelas = matkul.id_kelas AND dosen.nidn = matkul.nidn AND kelas.id_kelas='"+kd_kelas+"' group by mahasiswa.npm");
            while(rsKb.next()){
                viewNamaMhs.add(rsKb.getString("npm"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return viewNamaMhs;
    }
    public static Mahasiswa viewNamaMahasiswa(String npm) throws SQLException{
        Mahasiswa mhs = new Mahasiswa();
        try{             
            Statement kt = koneksi.getConnection().createStatement();
            ResultSet rsKb = kt.executeQuery("SELECT nama_mhs FROM mahasiswa where npm='"+npm+"'");
            while(rsKb.next()){
                mhs.setNama_mhs(rsKb.getString("nama_mhs"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return mhs;
    }
}
