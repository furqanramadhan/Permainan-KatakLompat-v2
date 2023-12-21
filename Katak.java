/**
 * Menyatakan class bernama Katak
 * untuk menentukan sifat katak,
 * yaitu dapat melangkah maju atau mundur,
 * serta mendapatkan posisi dan skor.
 *
 * @author Nazwa Salsabila
 * @version 29.10.2023
 * 
 */
public class Katak {
    private int posisi;
    private int skor;

    /**
     * Metode sederhana untuk menyatakan object dari
     * class katak dengan method constructor adalah
     * public.
     */
    public Katak() {
        // Inisialisasi nilai awal dari variabel
        posisi = 0;
        skor = 100;
    }

    /**
     * 
     * @return method accessor -> return posisi untuk menentukan posisi baru.
     */
    public int getPosisi() {
        return this.posisi;
    }

    /**
     * 
     * @param method mutator untuk setter posisiBaru
     */
    public void setPosisi(int posisiBaru) {
        this.posisi = posisiBaru;
    }

    /**
     * 
     * @return method accessor -> return skor untuk menentukan skor baru.
     */
    public int getSkor() {
        return this.skor;
    }

    /**
     * 
     * @param method mutator untuk setter skorBaru
     */
    public void setSkor(int skorBaru) {
        this.skor = skorBaru;
    }

    /**
     * Method mutator untuk memajukan posisi katak sebanyak satu
     */
    public void loncatDekat() {
        this.posisi += 1;
    }

    /**
     * Method mutator untuk memajukan posisi katak sebanyak dua
     */
    public void loncatJauh() {
        this.posisi += 2;
    }

    /**
     * Method mutator untuk memundurkan posisi katak sebanyak satu
     */
    public void mundurDekat() {
        this.posisi -= 1;
    }

    /**
     * 
     * Method mutator untuk memundurkan posisi katak sebanyak dua
     */
    public void mundurJauh() {
        this.posisi -= 2;
    }
}
