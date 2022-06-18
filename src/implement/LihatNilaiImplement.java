/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

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
public class LihatNilaiImplement {
    public List<Nilai> getAll(String npm) throws SQLException{
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("SELECT matkul.id_matkul, matkul.nama_matkul, nilai.nilai_tugas, nilai.nilai_uts, nilai.nilai_uas,"
                + " nilai.nilai_akhir, nilai.index_nilai FROM mahasiswa, nilai, kelas, matkul "
                + "WHERE mahasiswa.npm = nilai.npm AND matkul.id_matkul = nilai.id_matkul AND kelas.id_kelas = matkul.id_kelas AND mahasiswa.npm = '"+npm+"'");
        List<Nilai>list=new ArrayList<Nilai>();
        while(rs.next()){
            Nilai nilai = new Nilai();
            nilai.setId_matkul(rs.getString("id_matkul"));
            nilai.setNama_matkul(rs.getString("nama_matkul"));
            nilai.setNilai_tugas(rs.getInt("nilai_tugas"));           
            nilai.setNilai_uts(rs.getInt("nilai_uts"));
            nilai.setNilai_uas(rs.getInt("nilai_uas"));
            nilai.setNilai_akhir(rs.getInt("nilai_akhir"));
            nilai.setIndex(rs.getString("index_nilai"));
            list.add(nilai);
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
    
    public ArrayList<String> viewNpm(String kd_kelas) throws SQLException{
        ArrayList<String> viewNamaMhs = new ArrayList();
        try{
            Statement kt = koneksi.getConnection().createStatement();
            ResultSet rsKb = kt.executeQuery("SELECT mahasiswa.npm, mahasiswa.nama_mhs FROM mahasiswa, matkul, dosen, kelas where"
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
