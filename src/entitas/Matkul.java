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
public class Matkul {
    private String kode_matkul;
    private String nama_matkul;
    private int sks;
    private String nidn;
    String sks2 = String.valueOf(sks);
    private String nama_dosen;
    private String id_kelas;
    /**
     * @return the nama_matkul
     */
    public String getNama_matkul() {
        return nama_matkul;
    }

    /**
     * @param nama_matkul the nama_matkul to set
     */
    public void setNama_matkul(String nama_matkul) {
        this.nama_matkul = nama_matkul;
    }

    /**
     * @return the sks
     */
    public String getSks() {
        return sks2;
    }

    /**
     * @param sks the sks to set
     */
    public void setSks(String sks2) {
        this.sks2 = sks2;
    }

    /**
     * @return the kode_matkul
     */
    public String getKode_matkul() {
        return kode_matkul;
    }

    /**
     * @param kode_matkul the kode_matkul to set
     */
    public void setKode_matkul(String kode_matkul) {
        this.kode_matkul = kode_matkul;
    }

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
     * @return the id_kelas
     */
    public String getId_kelas() {
        return id_kelas;
    }

    /**
     * @param id_kelas the id_kelas to set
     */
    public void setId_kelas(String id_kelas) {
        this.id_kelas = id_kelas;
    }
    
}
