/**
 * Menyatakan sub class spesific class bernama Emas yaitu inheritance dari
 * class abstract Koin dan Meng-override method dari class Koin
 * 
 * @author Nazwa Salsabila
 * @version 19.11.2023
 */
public class Emas extends Koin {
    private int nilai;

    /**
     * Method constructor dengan parameter untuk menyatakan nilai koin
     * yang pada class Emas yaitu 30.
     * 
     * @param
     */
    public Emas(int nilai) {
        super(30);
        this.nilai = 30;
    }

    /**
     * Method abstract accessor -> return nilai koin
     * 
     * @return
     */
    public int getNilai() {
        return nilai;
    }

    /**
     * Method abstract mutator untuk setter nilai koin yang baru
     * 
     * @param
     */
    public void setNilai(int nilaibaru) {
        this.nilai = nilaibaru;
    }
}
