import java.util.ArrayList;
import java.util.Collections;

/**
 * Menyatakan class KotakPermainan yang digunakan
 * sebagai tempat katak akan bergerak.
 *
 * @author Nazwa Salsabila
 * @version 29.10.2023
 */
public class KotakPermainan {
  private Kotak boardGame[];
  private int jumlahKotak;
  private int jumlahKoin;
  private int jumlahMonster;
  private int acakKoin[];
  private int acakMonster[];
  private int i;

  /**
   * 
   * @param j  method constructor untuk menginisialiasi j untuk jumlahKotak.
   * @param jk method constructor untuk menginisialiasi jk untuk jumlahKoin.
   * @param jm method constructor untuk menginisialiasi jm untuk jumlahMonster.
   * 
   */
  public KotakPermainan(int j, int jk, int jm) {
    this.jumlahKotak = j;
    this.jumlahKoin = jk;
    this.jumlahMonster = jm;

    // memberikan nilai acak kepada koin dan monster
    generateAcak();
    // memasukkan nilai acak kepada boardGame
    inisialisasiKotak();
  }

  /**
   * Method mutator untuk memberikan nilai acak kepada variabel
   * acakKoin dan acakMonster.
   */
  public void generateAcak() {
    ArrayList<Integer> list = new ArrayList<Integer>();

    // Nilai acak ditentukan sebanyak jumlah kotak
    for (i = 0; i < jumlahKotak; i++) {
      list.add(i);
    }

    // Collection untuk mengacak nilai kepada koin
    Collections.shuffle(list);

    // Salin sejumlah indeks sesuai jumlah koin ke dalam array acakKoin
    acakKoin = new int[jumlahKoin];
    for (i = 0; i < jumlahKoin; i++) {
      acakKoin[i] = list.get(i);
    }

    // Salin indeks yang tersisa ke dalam array acakMonster
    acakMonster = new int[jumlahMonster];
    for (i = 0; i < jumlahMonster; i++) {
      acakMonster[i] = list.get(i + jumlahKoin);
    }
  }

  /**
   * Method mutator untuk memberi isi kotak yang sudah
   * di generate dengan salah satu, yaitu koin atau monster.
   */
  private void inisialisasiKotak() {
    boardGame = new Kotak[jumlahKotak];
    Koin koin1 = new Koin(10);
    Koin koin2 = new Koin(20);
    Koin koin3 = new Koin(30);

    Monster monster1 = new Monster(-5, "Aves");
    Monster monster2 = new Monster(-10, "Serpentes");
    Monster monster3 = new Monster(-15, "Aligator");

    for (i = 0; i < jumlahKotak; i++) {
      boardGame[i] = new Kotak();
    }

    for (i = 0; i < jumlahKoin; i++) {
      if (i % 3 == 0) {
        boardGame[acakKoin[i]].addKoin(koin1);
      } else if (i % 3 == 1) {
        boardGame[acakKoin[i]].addKoin(koin2);
      } else {
        boardGame[acakKoin[i]].addKoin(koin3);
      }
    }

    for (i = 0; i < jumlahMonster; i++) {
      if (i % 3 == 0) {
        boardGame[acakMonster[i]].addMonster(monster1);
      } else if (i % 3 == 1) {
        boardGame[acakMonster[i]].addMonster(monster2);
      } else {
        boardGame[acakMonster[i]].addMonster(monster3);
      }
    }
  }

  /**
   * 
   * @param posisi method accessor dimana contain akan
   *               return -> boardGame koin, nilai, atau monster
   * @return
   */
  public int contain(int posisi) {
    if (posisi >= 0 && posisi < jumlahKotak) {
      if (boardGame[posisi].isThereKoin()) {
        return boardGame[posisi].getKoin().getNilai();
      } else if (boardGame[posisi].isThereMonster()) {
        return boardGame[posisi].getMonster().getNilai();
      }
    }
    return 0;
  }
}
