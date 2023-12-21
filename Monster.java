/**
 * Menyatakan class Monster dimana monster akan
 * mengurangi skor dari pemain
 *
 * @author Nazwa Salsabila
 * @version 29.10.2023
 */

public class Monster {
    private int nilai;
    private String nama;

    /**
     * @param Method constructor dengan tanpa paramater.
     */
    public Monster() {
        // inisialisasi sebuah monster dengan nama dan pengurangan skor
        nama = "Aves";
        nilai = -5;

        nama = "Serpentes";
        nilai = -10;

        nama = "Aligator";
        nilai = -15;
    }

    /**
     * 
     * @param nilai Method constructor dengan parameter untuk menginisialisasi
     *              nilai serta nama.
     * @param nama
     */
    public Monster(int nilai, String nama) {
        this.nilai = nilai;
        this.nama = nama;
    }

    /**
     * 
     * @return Method accessor untuk return dari monster -> nilai
     */
    public int getNilai() {
        return this.nilai;
    }

    /**
     * 
     * @return Method accessor untuk return dari monster -> nama monster
     */
    public String getNama() {
        return this.nama;
    }

    /**
     * 
     * @param Method mutator sebagai setter nama monster.
     */
    public void setNama(String nama) {
        this.nama = nama;
    }
}
