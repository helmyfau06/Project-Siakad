/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsiakad;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import entitas.*;
import koneksiData.*;

/**
 *
 * @author ASUS
 */
public class UserSession {
    private static int userId;
    private static String userLogin;
    private static String role;

    public static void setUserLogin(String userLogin) {
        UserSession.userLogin = userLogin;
    }
    
    public static String getUserLogin() {
        return userLogin;
    }

    /**
     * @return the role
     */
    public static String getRole() {
        return role;
    }

    /**
     * @param aRole the role to set
     */
    public static void setRole(String aRole) {
        role = aRole;
    }

    /**
     * @return the userId
     */
    public static int getUserId() {
        return userId;
    }

    /**
     * @param aUserId the userId to set
     */
    public static void setUserId(int aUserId) {
        userId = aUserId;
    }
    
    public static Mahasiswa getMahasiswa() throws SQLException{
        Mahasiswa mhs = new Mahasiswa();
            Statement st = koneksi.getConnection().createStatement();
            ResultSet rs=st.executeQuery("SELECT mahasiswa.npm, mahasiswa.nama_mhs, mahasiswa.id_kelas, jurusan.nama_jurusan"
                    + " FROM mahasiswa, kelas, jurusan where mahasiswa.id_kelas = kelas.id_kelas AND kelas.id_jurusan = jurusan.id_jurusan"
                    + " AND id_user = "+UserSession.getUserId());           
            while(rs.next()){
                mhs.setNpm(rs.getString("npm"));
                mhs.setNama_mhs(rs.getString("nama_mhs"));
                mhs.setId_kelas(rs.getString("id_kelas"));
                mhs.setNama_jurusan(rs.getString("nama_jurusan"));
            }           
            return mhs;
    }
    
    public static Dosen getDosen() throws SQLException{
        Dosen dosen = new Dosen();
            Statement st = koneksi.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from dosen where id_user = "+UserSession.getUserId());           
            while(rs.next()){
                dosen.setNidn(rs.getString("nidn"));
                dosen.setNama_dosen(rs.getString("nama_dosen"));
                dosen.setId_user(rs.getInt("id_user"));
            }
            return dosen;
    }
}
