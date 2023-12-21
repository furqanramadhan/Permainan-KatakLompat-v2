/**
 * Menyatakan class abstract bernama Monster dimana monster akan
 * mengurangi skor dari pemain
 *
 * @author Nazwa Salsabila
 * @version 19.11.2023
 */

public abstract class Monster {
    private int nilai;
    private String nama;

    /**
     * Method constructor dengan tanpa paramater.
     * 
     * @param
     */
    public Monster() {

    }

    /**
     * 
     * Method constructor dengan parameter untuk menginisialisasi
     * nilai serta nama.
     * 
     * @param nilai
     * @param nama
     */
    public Monster(int nilai, String nama) {
        this.nilai = nilai;
        this.nama = nama;
    }

    /**
     * Method abstract accessor untuk return dari monster -> nilai,
     * implementasi akan diwarisi pada class inheritance yang meng-extends
     * class Monster
     * 
     * @return
     */
    public abstract int getNilai();

    /**
     * Method abstract accessor untuk return dari monster -> nama monster,
     * implementasi akan diwarisi pada class inheritance yang meng-extends
     * class Monster
     * 
     * @return
     */
    public abstract String getNama();

    /**
     * Method mutator sebagai setter nama monster,
     * implementasi akan diwarisi pada class inherintace yang
     * meng-extends class Monster
     * 
     * @param
     */
    public abstract void setNama(String nama);

}
