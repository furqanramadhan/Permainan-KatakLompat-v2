/**
 * 
 * Menyatakan sub class spesific class bernama Aves yaitu inheritance dari class
 * abstract Monster dan Meng-override method dari class Monster
 * 
 * @author Nazwa Salsabila
 * @version 19.11.2023
 */
public class Aves extends Monster {
    private int nilai;
    private String nama;

    /**
     * Method constructor dengan parameter untuk menginisialisasi
     * nilai serta nama.
     * 
     * @param nilai
     * @param nama
     */
    public Aves(int nilai, String nama) {
        this.nilai = nilai;
        this.nama = nama;
    }

    /**
     * Method abstract accessor untuk return dari monster -> nilai,
     * 
     * @return
     */
    @Override
    public int getNilai() {
        return nilai;
    }

    /**
     * Method abstract accessor untuk return dari monster -> nama,
     * 
     * @return
     */
    @Override
    public String getNama() {
        return nama;
    }

    /**
     * Method mutator sebagai setter nama monster,
     * implementasi akan diwarisi pada class inherintace yang
     * meng-extends class Monster
     * 
     * @param
     */
    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }
}
