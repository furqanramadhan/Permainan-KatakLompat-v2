/**
 * Menyatakan sub class spesific class bernama Perunggu yaitu inheritance dari
 * class abstract Koin dan Meng-override method dari class Koin
 * 
 * @author Nazwa Salsabila
 * @version 19.11.2023
 */
public class Perunggu extends Koin {
    private int nilai;

    /**
     * Method constructor dengan parameter untuk menyatakan nilai koin
     * yang pada class Perunggu yaitu 10.
     * 
     * @param
     */
    public Perunggu(int nilai) {
        super(10);
        this.nilai = 10;
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
