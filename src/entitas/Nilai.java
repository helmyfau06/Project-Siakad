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
public class Nilai {
    private int id_nilai;
    private String id_kelas;
    private String npm;
    private String nama;
    private String id_matkul;
    private String nama_matkul;
    private int nilai_tugas;
    private int nilai_uts;
    private int nilai_uas;
    private int nilai_akhir;
    private char index;
    String indeks = String.valueOf(index);

    /**
     * @return the npm
     */
    public String getNpm() {
        return npm;
    }

    /**
     * @param npm the npm to set
     */
    public void setNpm(String npm) {
        this.npm = npm;
    }

    /**
     * @return the id_matkul
     */
    public String getId_matkul() {
        return id_matkul;
    }

    /**
     * @param id_matkul the id_matkul to set
     */
    public void setId_matkul(String id_matkul) {
        this.id_matkul = id_matkul;
    }

    /**
     * @return the nilai_tugas
     */
    public int getNilai_tugas() {
        return nilai_tugas;
    }

    /**
     * @param nilai_tugas the nilai_tugas to set
     */
    public void setNilai_tugas(int nilai_tugas) {
        this.nilai_tugas = nilai_tugas;
    }

    /**
     * @return the nilai_uts
     */
    public int getNilai_uts() {
        return nilai_uts;
    }

    /**
     * @param nilai_uts the nilai_uts to set
     */
    public void setNilai_uts(int nilai_uts) {
        this.nilai_uts = nilai_uts;
    }

    /**
     * @return the nilai_uas
     */
    public int getNilai_uas() {
        return nilai_uas;
    }

    /**
     * @param nilai_uas the nilai_uas to set
     */
    public void setNilai_uas(int nilai_uas) {
        this.nilai_uas = nilai_uas;
    }

    /**
     * @return the index
     */
    public String getIndex() {
        return indeks;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(String indeks) {
        this.indeks = indeks;
    }

    /**
     * @return the id_nilai
     */
    public int getId_nilai() {
        return id_nilai;
    }

    /**
     * @param id_nilai the id_nilai to set
     */
    public void setId_nilai(int id_nilai) {
        this.id_nilai = id_nilai;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
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

    /**
     * @return the nilai_akhir
     */
    public int getNilai_akhir() {
        return nilai_akhir;
    }

    /**
     * @param nilai_akhir the nilai_akhir to set
     */
    public void setNilai_akhir(int nilai_akhir) {
        this.nilai_akhir = nilai_akhir;
    }

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
    
}
