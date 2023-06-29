package modeldata;

import java.io.File;

public class DataKomunitas implements Data {
    private String username;
    private String password;
    private String nama;
    private String alamat;
    private String tujuan;
    private String jumlah;
    private String noHp;
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public DataKomunitas(String username, String password, String nama, String alamat, String tujuan, String jumlah,
            String noHp, File file) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.alamat = alamat;
        this.tujuan = tujuan;
        this.jumlah = jumlah;
        this.noHp = noHp;
        this.file = file;
    }

    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    @Override
    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTujuan() {
        return tujuan;
    }

    public String getJumlah() {
        return jumlah;
    }

    public String getNoHp() {
        return noHp;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
