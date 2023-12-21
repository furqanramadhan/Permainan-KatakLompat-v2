/**
 * Menyatakan sub class spesific class bernama Perak yaitu inheritance dari
 * class abstract Koin dan Meng-override method dari class Koin
 * 
 * @author Nazwa Salsabila
 * @version 19.11.2023
 */
public class Perak extends Koin {
    private int nilai;

    /**
     * Method constructor dengan parameter untuk menyatakan nilai koin
     * yang pada class Perak yaitu 20.
     * 
     * @param
     */
    public Perak(int nilai) {
        super(20);
        this.nilai = 20;
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
