/**
 * Menyatakan class abstract bernama Koin
 * untuk menentukan nilai koin dan input yang dimasukkan
 *
 * @author Nazwa Salsabila
 * @version 19.11.2023
 */

public abstract class Koin {
    private int nilai;

    /**
     * Method constructor tanpa parameter untuk menyatakan nilai koin
     * 
     * @param
     */
    public Koin() {
        nilai = 10;
    }

    /**
     * Method abstract accessor dengan parameter untuk menentukan nilai koin secara
     * default
     * 
     * 
     * @param
     */
    public Koin(int nilaiDefault) {
        this.nilai = nilaiDefault;
    }

    /**
     * Method abstract accessor -> return nilai koin
     * implementasi akan diwarisi pada class inheritance yang meng-extend class Koin
     * 
     * @return
     */
    public abstract int getNilai();

    /**
     * Method abstract mutator untuk setter nilai koin yang baru
     * implementasi akan diwarisi pada class inheritance yang meng-extend class Koin
     * 
     * @param
     */
    public abstract void setNilai(int nilaibaru);
}
