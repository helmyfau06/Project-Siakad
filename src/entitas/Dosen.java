/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitas;

/**
 *
 * @author ASUS
 */
public class Dosen {
    private String nidn;
    private String nama_dosen;
    private int id_user;

    /**
     * @return the nidn
     */
    public String getNidn() {
        return nidn;
    }

    /**
     * @param nidn the nidn to set
     */
    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    /**
     * @return the nama_dosen
     */
    public String getNama_dosen() {
        return nama_dosen;
    }

    /**
     * @param nama_dosen the nama_dosen to set
     */
    public void setNama_dosen(String nama_dosen) {
        this.nama_dosen = nama_dosen;
    }

    /**
     * @return the id_user
     */
    public int getId_user() {
        return id_user;
    }

    /**
     * @param id_user the id_user to set
     */
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
