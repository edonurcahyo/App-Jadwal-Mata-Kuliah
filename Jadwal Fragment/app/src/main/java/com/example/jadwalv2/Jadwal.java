package com.example.jadwalv2;

public class Jadwal {
    private final String hari;
    private final String waktu;
    private final String mataKuliah;
    private final String ruang;
    private final String gedung;

    public Jadwal(String hari, String waktu, String mataKuliah, String ruang, String gedung) {
        this.hari = hari;
        this.waktu = waktu;
        this.mataKuliah = mataKuliah;
        this.ruang = ruang;
        this.gedung = gedung;
    }

    public String getHari() {
        return hari;
    }

    public String getWaktu() {
        return waktu;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public String getRuang() {
        return ruang;
    }

    public String getGedung() {
        return gedung;
    }
}

