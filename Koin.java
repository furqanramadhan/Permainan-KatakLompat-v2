/**
 * Menyatakan class bernama Koin
 * untuk menentukan nilai koin dan input yang dimasukkan
 *
 * @author Nazwa Salsabila
 * @version 29.10.2023
 */
public class Koin {
    private int nilai;

    /**
     * @param method constructor untuk menyatakan nilai pemain
     */
    public Koin() {
        // inisialisasi constructor nilai koin dengan nilai 10.
        nilai = 10;
    }

    /**
     * @param method constructor untuk menentukan nilai koin
     */
    public Koin(int nilai) {
        this.nilai = nilai;
    }

    /**
     * 
     * @return method constructor -> return nilai koin
     */
    public int getNilai() {
        return nilai;
    }

    /**
     * 
     * @param method mutator untuk setter nilai koin yang baru
     */
    public void setNilai(int nilaibaru) {
        this.nilai = nilaibaru;
    }
}
