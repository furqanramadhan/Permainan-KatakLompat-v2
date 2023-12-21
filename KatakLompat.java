
// Import semua package yang dibutuhkan
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class KatakLompat {
  /**
   * 
   * Metode sederhana untuk menyatakan class dengan nama "KatakLompat" dengan
   * method
   * constructornya adalah public.
   * 
   * Program ini memungkinkan user untuk mengontrol seekor katak yang melompat
   * diatas
   * kotak-kotak untuk mendapatkan poin serta menghidari monster untuk mencapai
   * titik
   * finish.
   * 
   * @author Nazwa Salsabila and Furqan Ramadhan
   * @version 1.0
   *          NPM : 2208107010010
   * 
   * 
   * @param args the args[]
   *             link video :
   */

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_CYAN = "\u001B[36m";

  /**
   *
   * deklarasi method bernama resetVariables untuk mereset parameter
   * yang diperlukan ketika user bermain ulang
   * 
   * @param kotak
   * @param posisi
   * @param nilai
   */
  public static void resetVariables(int[] kotak, int[] posisi, int[] nilai) {
    for (int i = 0; i < kotak.length; i++) {
      kotak[i] = 0;
    }
    // Reset posisi ke 0.
    posisi[0] = 0;
    // Reset nilai ke 100.
    nilai[0] = 100;
  }

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int kotak[] = new int[300];
    int pilih = 0;
    int level = 0;
    // Array untuk indeks posisi dan nilai.
    int posisi[] = { 0 };
    int nilai[] = { 100 };
    int koin = 30;
    int monster = 10;
    boolean inputValid = false;
    boolean exitGame = false;

    do {
      // Tambahkan pesan dengan warna Yellow.
      System.out.println(ANSI_YELLOW + "=========================================");
      System.out.println("||\tSelamat datang di game\t\t||");
      System.out.println("=========================================");
      System.out.println("||\tLompat Hai Katak, Lompat!\t||");
      System.out.println("=========================================" + ANSI_RESET);

      System.out.println(ANSI_YELLOW + "=========================================");
      System.out.println("||Penambahan Poin:\t\t\t||");
      System.out.println("=========================================");
      System.out.println("||koin perunggu, nilai bertambah 10\t||");
      System.out.println("||koin perak, nilai bertambah 20\t||");
      System.out.println("||koin emas, nilai bertambah 30\t\t||");
      System.out.println("=========================================" + ANSI_RESET);

      System.out.println(ANSI_YELLOW + "==================================================");
      System.out.println("||Pengurangan Poin:\t\t\t\t||");
      System.out.println("==================================================");
      System.out.println("||Katak dimakan oleh Aves, nilai berkurang 5 \t\t||");
      System.out.println("||Katak dimakan oleh Serpentes, nilai berkurang 10\t||");
      System.out.println("||Katak dimakan oleh Aligator, nilai berkurang 15\t||");
      System.out.println("==================================================" + ANSI_RESET);

      System.out.println(ANSI_YELLOW + "==========================================================");
      System.out.println("||Peraturan\t\t\t\t\t\t||");
      System.out.println("==========================================================");
      System.out.println("||1. Jika katak berada pada kotak 300, permainan selesai||");
      System.out.println("||2. Jika nilai 0, permainan selesai\t\t\t||");
      System.out.println("==========================================================" + ANSI_RESET);

      System.out.println(ANSI_CYAN + "==========================================================");
      System.out.println("||Press any key to begin...\t\t\t\t||");
      System.out.println("==========================================================" + ANSI_RESET);
      s.nextLine();

      System.out.println(ANSI_YELLOW + "==========================================================");
      System.out.println("||Level\t\t\t\t\t\t\t||");
      System.out.println("==========================================================");
      System.out.println("||1. Mudah\t\t\t\t\t\t||");
      System.out.println("||2. Sedang\t\t\t\t\t\t||");
      System.out.println("||3. Susah\t\t\t\t\t\t||");
      System.out.println("==========================================================" + ANSI_RESET);

      // Handling mismatch jika user memasukkan input selain 1-3.
      do {
        System.out.print(ANSI_YELLOW + "||Masukkan Level: ");
        if (s.hasNextInt()) {
          level = s.nextInt();
          if (level >= 1 && level <= 3) {
            inputValid = true;
          } else {
            // Tambahkan pesan error dengan warna Red.
            System.out.println(ANSI_RED + "==========================================================");
            System.out.println(ANSI_RED + "||Input tidak valid. Masukkan angka antara 1 hingga 3   ||");
            System.out.println("==========================================================" + ANSI_RESET);
          }
        } else {
          System.out.println(ANSI_RED + "==========================================================");
          System.out.println(ANSI_RED + "||Input tidak valid. Masukkan angka antara 1 hingga 3   ||");
          System.out.println("==========================================================" + ANSI_RESET);
          // Wrong input.
          s.next();
        }
      } while (!inputValid);
      inputValid = false;

      // Ganti dari flow control if ke switch case.
      switch (level) {
        case 1:
          koin = 100;
          monster = 50;
          System.out.println(ANSI_YELLOW + "==========================================================");
          System.out.println("||\t\t\t<== Mudah ==>\t\t\t||");
          System.out.println("==========================================================" + ANSI_RESET);
          break;

        case 2:
          koin = 100;
          monster = 100;
          System.out.println(ANSI_YELLOW + "==========================================================");
          System.out.println("||\t\t\t<== Sedang ==>\t\t\t||");
          System.out.println("==========================================================" + ANSI_RESET);
          break;

        case 3:
          koin = 100;
          monster = 200;
          System.out.println(ANSI_YELLOW + "==========================================================");
          System.out.println("||\t\t\t<== Susah ==>\t\t\t||");
          System.out.println("==========================================================" + ANSI_RESET);
          break;
      }

      resetVariables(kotak, posisi, nilai);

      Random p_acak = new Random();
      for (int i = 0; i < koin; i++) {
        int nilaiAcak = p_acak.nextInt(300);
        while (kotak[nilaiAcak] != 0) {
          nilaiAcak += 1;
          if (nilaiAcak > 299) {
            nilaiAcak = 1;
          }
        }
        kotak[nilaiAcak] = p_acak.nextInt(3) + 1;
      }
      for (int i = 0; i < monster; i++) {
        int nilaiAcak = p_acak.nextInt(300);
        while (kotak[nilaiAcak] != 0) {
          nilaiAcak += 1;
          if (nilaiAcak > 299) {
            nilaiAcak = 1;
          }
        }
        kotak[nilaiAcak] = p_acak.nextInt(3) + 5;
      }

      do {
        System.out.println(ANSI_YELLOW + "\n==========================================================");
        System.out.println("||Katak berada di kotak ke " + Arrays.toString(posisi) + "\t\t\t\t||");
        System.out.println("||Nilai anda: " + Arrays.toString(nilai) + "\t\t\t\t\t||");
        System.out.println("==========================================================" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "||1. Lompat 1 kotak\t\t\t\t\t||");
        System.out.println("||2. Lompat 2 kotak\t\t\t\t\t||");
        System.out.println("||3. Mundur 1 kotak\t\t\t\t\t||");
        System.out.println("||4. Mundur 2 kotak\t\t\t\t\t||");
        System.out.println("||5. Keluar\t\t\t\t\t\t||");
        System.out.println("==========================================================" + ANSI_RESET);

        // Handling mismatch jika user memasukkan input selain 1-3.
        do {
          while (!s.hasNextInt()) {
            System.out.println(ANSI_RED + "==========================================================");
            System.out.println(ANSI_RED + "||Input tidak valid. Masukkan angka antara 1 hingga 5   ||");
            System.out.println("==========================================================" + ANSI_RESET);
            // Wrong input.
            s.next();
          }
          pilih = s.nextInt();
          if (pilih >= 1 && pilih <= 5) {
            inputValid = true;
          } else {
            System.out.println(ANSI_RED + "==========================================================");
            System.out.println(ANSI_RED + "||Input tidak valid. Masukkan angka antara 1 hingga 5   ||");
            System.out.println("==========================================================" + ANSI_RESET);
          }
        } while (!inputValid);

        if (pilih == 1) {
          if (posisi[0] + 1 > 299) {
            System.out.println(ANSI_RED + "Katak tidak bisa melompat lebih jauh dari kotak terakhir." + ANSI_RESET);
          } else {
            posisi[0] += 1;
          }
        } else if (pilih == 2) {
          if (posisi[0] + 2 > 299) {
            System.out.println(ANSI_RED + "Katak tidak bisa melompat lebih jauh dari kotak terakhir." + ANSI_RESET);
          } else {
            posisi[0] += 2;
          }
        } else if (pilih == 3) {
          if (posisi[0] - 1 < 0) {
            System.out.println(ANSI_RED + "Katak tidak bisa mundur lebih dari kotak awal." + ANSI_RESET);
          } else {
            posisi[0] -= 1;
          }
        } else if (pilih == 4) {
          if (posisi[0] - 2 < 0) {
            System.out.println(ANSI_RED + "Katak tidak bisa mundur lebih dari kotak awal." + ANSI_RESET);
          } else {
            posisi[0] -= 2;
          }
        } else if (pilih == 5) {
          System.out.println(ANSI_YELLOW + "==========================================================");
          System.out.println("||\t\t\t<== Keluar ==>\t\t\t||");
          System.out.println("==========================================================" + ANSI_RESET);
          break;
        } else {
          System.out.println(ANSI_RED + "Pilihan tidak valid." + ANSI_RESET);
        }

        if (exitGame) {
          break;
        }

        // Ganti dari flow control if ke switch case.
        switch (kotak[posisi[0]]) {
          case 1:
            nilai[0] += 10;
            System.out.println(ANSI_GREEN + "\n==========================================================");
            System.out.println("||Katak menemukan koin perunggu, nilai bertambah 10||");
            System.out.println("==========================================================" + ANSI_RESET);
            break;
          case 2:
            nilai[0] += 20;
            System.out.println(ANSI_GREEN + "\n==========================================================");
            System.out.println("||Katak menemukan koin perak, nilai bertambah 20||");
            System.out.println("==========================================================" + ANSI_RESET);
            break;
          case 3:
            nilai[0] += 30;
            System.out.println(ANSI_GREEN + "\n==========================================================");
            System.out.println("||Katak menemukan koin Emas, nilai bertambah 30\t||");
            System.out.println("==========================================================" + ANSI_RESET);
            break;
          case 5:
            if (posisi[0] != 0) {
              nilai[0] -= 5;
            }
            System.out.println(ANSI_RED + "\n==========================================================");
            System.out.println("||Katak dimakan Aves, nilai berkurang 5\t\t||");
            System.out.println("==========================================================" + ANSI_RESET);
            break;
          case 6:
            if (posisi[0] != 0) {
              nilai[0] -= 10;
            }
            System.out.println(ANSI_RED + "\n==========================================================");
            System.out.println("||Katak dimakan Serpentes, nilai berkurang 10\t\t||");
            System.out.println("==========================================================" + ANSI_RESET);
            break;
          case 7:
            if (posisi[0] != 0) {
              nilai[0] -= 15;
            }
            System.out.println(ANSI_RED + "\n==========================================================");
            System.out.println("||Katak dimakan Aligator, nilai berkurang 15\t\t||");
            System.out.println("==========================================================" + ANSI_RESET);
            break;
          default:
            System.out.println(ANSI_GREEN + "\n==========================================================");
            System.out.println("||Katak tidak menemukan apapun\t\t\t\t||");
            System.out.println("==========================================================" + ANSI_RESET);
            break;
        }

      } while (nilai[0] >= 0 && posisi[0] != 299);

      if (nilai[0] < 0) {
        System.out.println(ANSI_RED + "\n==========================================================");
        System.out.println("||\t\t\tGame Over, Katak Mati\t\t\t||");
        System.out.println("==========================================================" + ANSI_RESET);
      } else {
        System.out.println(ANSI_GREEN + "\n==========================================================");
        System.out.println("||\t\t\tKatak Menang\t\t\t||");
        System.out.println("==========================================================" + ANSI_RESET);
      }
      System.out.println(ANSI_YELLOW + "==========================================================");
      System.out.println("||\t\t\tnilai Akhir\t\t\t||");
      System.out.println("==========================================================");
      System.out.println("||\t\t\t" + nilai[0] + "\t\t\t\t||");
      System.out.println("==========================================================" + ANSI_RESET);
      System.out.println(ANSI_YELLOW + "||\t\t\tPosisi Katak\t\t\t||");
      System.out.println("==========================================================");
      System.out.println("||\t\t\t" + posisi[0] + "\t\t\t\t||");

      if (nilai[0] > 1000) {
        System.out.println(ANSI_GREEN + "==========================================================");
        System.out.println("||\t\t\tPencapaian\t\t\t||");
        System.out.println("==========================================================");
        System.out.println("||\t\t\tKatak Excellent\t\t\t||");
        System.out.println("==========================================================" + ANSI_RESET);
      } else if (nilai[0] > 500 && nilai[0] < 1000) {
        System.out.println(ANSI_GREEN + "==========================================================");
        System.out.println("||\t\t\tPencapaian\t\t\t||");
        System.out.println("==========================================================");
        System.out.println("||\t\t\tKatak Good\t\t\t||");
        System.out.println("==========================================================" + ANSI_RESET);
      } else {
        System.out.println(ANSI_GREEN + "==========================================================");
        System.out.println("||\t\t\tPencapaian\t\t\t||");
        System.out.println("==========================================================");
        System.out.println("||\t\t\tKatak Bad\t\t\t||");
        System.out.println("==========================================================" + ANSI_RESET);
      }

      System.out.println("\n+---------------------------------------+");
      System.out.println("|## Apakah anda ingin lanjut bermain? (y/t)? ##|");
      System.out.println("|                      Ya (y)             |");
      System.out.println("|                     Tidak (T)           |");
      System.out.println("+-----------------------------------------+");
      System.out.print("Masukkan pilihan anda: ");
      char ulang = s.next().charAt(0);

      if (ulang != 'y') {
        System.out.println(ANSI_YELLOW + "\nTerima kasih telah bermain!" + ANSI_RESET);
        break;
      }

    } while (true);
    // Close scanner after use.
    s.close();
  }
}