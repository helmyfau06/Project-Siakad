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
public class Kelas {
    private String kode_kelas;
    private char kelas;
    private String nama_jurusan;
    String kls = String.valueOf(kelas);

    /**
     * @return the kode_kelas
     */
    public String getKode_kelas() {
        return kode_kelas;
    }

    /**
     * @param kode_kelas the kode_kelas to set
     */
    public void setKode_kelas(String kode_kelas) {
        this.kode_kelas = kode_kelas;
    }

    /**
     * @return the nama_jurusan
     */
    public String getNama_jurusan() {
        return nama_jurusan;
    }

    /**
     * @param nama_jurusan the nama_jurusan to set
     */
    public void setNama_jurusan(String nama_jurusan) {
        this.nama_jurusan = nama_jurusan;
    }

    /**
     * @return the kelas
     */
    public String getKelas() {
        return kls;
    }

    /**
     * @param kelas the kelas to set
     */
    public void setKelas(String kls) {
        this.kls = kls;
    }
}
