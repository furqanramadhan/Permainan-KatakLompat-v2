/**
 * Menyatakan class bernama Pemain dimana
 * pemain memiliki nama dan nilai.
 *
 * @author Nazwa Salsabila
 * @version 29.10.2023
 */
public class Pemain {
    private String nama;
    private int nilai;

    public Pemain(String nama) {
        this.nama = nama;
        // nilai awal
        this.nilai = 0;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNilai() {
        return this.nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

}