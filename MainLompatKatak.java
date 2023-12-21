import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Menyatakan class bernama MainLompatKatak untuk memanggil
 * class lainnya seperti class Katak, class Pemain, dan class KotakPermainan.
 * 
 * @author Nazwa Salsabila
 * @version 28.10.2023
 * 
 */

public class MainLompatKatak implements Mainkan {
    public static Scanner s = new Scanner(System.in);
    String namaPlayer;
    Pemain player = null;

    int i;
    int jk = 0, jm = 0, j = 300;
    boolean inputValid = false;
    boolean exitGame = false;

    // Pewarnaan text output dengan 4 pilihan warna.
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";

    /**
     * @param Method constructor dengan parameter.
     */
    public MainLompatKatak() {
        // Menginisalisasi pemain didalam constructor.
        namaPlayer = "";
        player = new Pemain(namaPlayer);
    }

    /**
     * Deklarasi method utama bernama Mainkan untuk bermain lompat katak
     * dengan parameter nama, tingkat kesulitan, kotak, koin, monster, menyelesaikan
     * permainan, dan mendapatkan skor akhir.
     */
    public void Mainkan() {
        int pilih;
        KotakPermainan theGames;
        int level = 0;
        Katak kodok = new Katak();

        do {
            if (!inputValid) {
                System.out.println(ANSI_YELLOW + "==========================================================");
                System.out.println("||Masukkan nama pemain\t\t\t\t\t||");
                System.out.println("==========================================================" + ANSI_RESET);
                String inputName = s.nextLine();
                // Jika user tidak memasukkan nama, maka tetap di set kepada player dan membuat
                // object Pemain yang baru.
                if (!inputName.isEmpty()) {
                    namaPlayer = inputName;
                    inputValid = true;
                    player = new Pemain(namaPlayer);
                }
                System.out.println();
                if (namaPlayer != null && !namaPlayer.isEmpty()) {
                    // Menampilkan nama pemain dengan display warna hijau.
                    System.out.println(ANSI_GREEN +
                            "==========================================================");
                    System.out.println(ANSI_GREEN + "||Nama Pemain : \t\t\t" + player.getNama() +
                            "\t||");
                    System.out.println(ANSI_GREEN +
                            "==========================================================");
                }
            } else {
                /**
                 * Terdapat opsi jika user ingin menggunakan nama sebelumnya, jika tidak maka
                 * bisa memasukkan nama baru.
                 **/
                System.out.println(ANSI_CYAN + "==========================================================");
                System.out.println("||Ingin menggunakan nama pemain sebelumnya? (y/t)       ||");
                System.out.println("==========================================================" + ANSI_RESET);
                String usePreviousName = s.nextLine().toLowerCase();
                if (usePreviousName.equals("t")) {
                    inputValid = false;
                    continue;
                }
            }

            /**
             * Menu level
             * Pemilihan level permainan yang tersedia
             * Pemain dapat memilih level Mudah, Sedang atau Susah.
             */
            do {
                try {
                    System.out.println(ANSI_YELLOW + "==========================================================");
                    System.out.println("||Level\t\t\t\t\t\t\t||");
                    System.out.println("==========================================================");
                    System.out.println("||1. Mudah\t\t\t\t\t\t||");
                    System.out.println("||2. Sedang\t\t\t\t\t\t||");
                    System.out.println("||3. Susah\t\t\t\t\t\t||");
                    System.out.println("==========================================================" + ANSI_RESET);

                    // Handling mismatch jika user memasukkan input selain 1-3.
                    while (!s.hasNextInt()) {
                        System.out.println(ANSI_RED + "==========================================================");
                        System.out.println(ANSI_RED + "||Input String. Masukkan angka antara 1 hingga 3\t||");
                        System.out.println("==========================================================" + ANSI_RESET);
                        s.nextLine();
                    }
                    level = s.nextInt();

                    if (level < 1 || level > 3) {
                        System.out.println(ANSI_RED + "==========================================================");
                        System.out.println(ANSI_RED + "||Input tidak valid. Masukkan angka antara 1 hingga 3   ||");
                        System.out.println("==========================================================" + ANSI_RESET);
                    }
                } catch (InputMismatchException e) {
                    System.out.println(ANSI_RED + "==========================================================");
                    System.out.println(ANSI_RED + "||Input tidak valid. Masukkan angka antara 1 hingga 3   ||");
                    System.out.println("==========================================================" + ANSI_RESET);
                    s.nextLine();

                }

            } while (level < 1 || level > 3);
        } while (!inputValid);
        inputValid = false;

        /**
         * User memasukkan level dengan method switch case sehingga jika salah satu opsi
         * wajib dipilih.
         **/
        switch (level) {
            case 1:
                jk = 100;
                jm = 50;
                System.out.println(ANSI_YELLOW + "==========================================================");
                System.out.println("||\t\t\t<== Mudah ==>\t\t\t||");
                System.out.println("==========================================================" + ANSI_RESET);
                break;
            case 2:
                jk = 100;
                jm = 100;
                System.out.println(ANSI_YELLOW + "==========================================================");
                System.out.println("||\t\t\t<== Sedang ==>\t\t\t||");
                System.out.println("==========================================================" + ANSI_RESET);
                break;
            case 3:
                jk = 100;
                jm = 200;
                System.out.println(ANSI_YELLOW + "==========================================================");
                System.out.println("||\t\t\t<== Susah ==>\t\t\t||");
                System.out.println("==========================================================" + ANSI_RESET);
                break;
        }

        /**
         * Membuat object baru dari kelas KotakPermainan dengan
         * parameter j (jumlah kotak), jk (jumlah koin), dan jm (jumlah monster).
         */
        theGames = new KotakPermainan(j, jk, jm);

        do {
            // Periksa posisi katak serta menampilkan informasi about posisi dan skor.
            int posisiKodok = kodok.getPosisi();
            theGames.contain(posisiKodok);

            System.out.println(ANSI_YELLOW + "\n==========================================================");
            System.out.println("||Katak berada di kotak ke " + posisiKodok + "\t\t\t\t||");
            System.out.println("||Nilai anda: " + kodok.getSkor() + "\t\t\t\t\t||");
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
                    s.nextLine();
                }
                pilih = s.nextInt();
                if (pilih > 0 && pilih < 6) {
                    inputValid = true;
                } else {
                    System.out.println(ANSI_RED + "==========================================================");
                    System.out.println(ANSI_RED + "||Input tidak valid. Masukkan angka antara 1 hingga 5   ||");
                    System.out.println("==========================================================" + ANSI_RESET);
                    s.nextLine();

                }
            } while (!inputValid);

            /**
             * Pemilihan langkah katak bagi user untuk membuat katak bergerak maju atau
             * mundur melalui input.
             **/
            if (pilih == 1) {
                if (kodok.getPosisi() + 1 > 300) {
                    System.out.println(
                            ANSI_RED + "Katak tidak bisa melompat lebih jauh dari kotak terakhir." + ANSI_RESET);
                    continue;
                } else {
                    kodok.loncatDekat();
                }
            } else if (pilih == 2) {
                if (kodok.getPosisi() + 2 > 300) {
                    System.out.println(
                            ANSI_RED + "Katak tidak bisa melompat lebih jauh dari kotak terakhir." + ANSI_RESET);
                    continue;
                } else {
                    kodok.loncatJauh();
                }
            } else if (pilih == 3) {
                if (kodok.getPosisi() - 1 < 0) {
                    System.out.println(ANSI_RED + "Katak tidak bisa mundur lebih dari kotak awal." + ANSI_RESET);
                    continue;
                } else {
                    if (level != 3) {
                        if (kodok.getSkor() > 0) {
                            kodok.mundurDekat();
                            kodok.setSkor(kodok.getSkor() - 5);
                        }
                    } else {
                        kodok.mundurDekat();
                    }
                }
            } else if (pilih == 4) {
                if (kodok.getPosisi() - 2 < 0) {
                    System.out.println(ANSI_RED + "Katak tidak bisa mundur lebih dari kotak awal." + ANSI_RESET);
                    continue;
                } else {
                    if (level != 3) {
                        if (kodok.getSkor() > 0) {
                            kodok.mundurJauh();
                            kodok.setSkor(kodok.getSkor() - 10);
                        }
                    } else {
                        kodok.mundurJauh();
                    }
                }
            } else if (pilih == 5) {
                System.out.println(ANSI_YELLOW + "==========================================================");
                System.out.println("||\t\t\t<== Keluar ==>\t\t\t||");
                System.out.println("==========================================================" + ANSI_RESET);
                break;
            }

            kodok.setSkor(kodok.getSkor() + theGames.contain(kodok.getPosisi()));

            if (theGames.contain(kodok.getPosisi()) == 10) {
                System.out.println(ANSI_GREEN +
                        "\n==========================================================");
                System.out.println("||Katak menemukan koin perunggu, nilai bertambah 10\t||");
                System.out.println("=========================================================="
                        + ANSI_RESET);
                s.nextLine();

            } else if (theGames.contain(kodok.getPosisi()) == 20) {
                System.out.println(ANSI_GREEN +
                        "\n==========================================================");
                System.out.println("||Katak menemukan koin perak, nilai bertambah 20\t||");
                System.out.println("=========================================================="
                        + ANSI_RESET);
                s.nextLine();

            } else if (theGames.contain(kodok.getPosisi()) == 30) {
                System.out.println(ANSI_GREEN +
                        "\n==========================================================");
                System.out.println("||Katak menemukan koin Emas, nilai bertambah 30\t\t||");
                System.out.println("=========================================================="
                        + ANSI_RESET);
                s.nextLine();

            } else if (theGames.contain(kodok.getPosisi()) == -5) {
                System.out.println(ANSI_RED +
                        "\n==========================================================");
                System.out.println("||Katak dimakan Aves, nilai berkurang 5\t\t\t||");
                System.out.println("=========================================================="
                        + ANSI_RESET);
                s.nextLine();

            } else if (theGames.contain(kodok.getPosisi()) == -10) {
                System.out.println(ANSI_RED +
                        "\n==========================================================");
                System.out.println("||Katak dimakan Serpentes, nilai berkurang 10\t\t||");
                System.out.println("=========================================================="
                        + ANSI_RESET);
                s.nextLine();

            } else if (theGames.contain(kodok.getPosisi()) == -15) {

                System.out.println(ANSI_RED +
                        "\n==========================================================");
                System.out.println("||Katak dimakan Aligator, nilai berkurang 15\t\t||");
                System.out.println("=========================================================="
                        + ANSI_RESET);

                s.nextLine();
            } else {
                System.out.println(ANSI_GREEN +
                        "\n==========================================================");
                System.out.println("||Katak tidak menemukan apapun\t\t\t\t||");
                System.out.println("=========================================================="
                        + ANSI_RESET);
                s.nextLine();
            }

            // Set skor terakhir yang diperoleh katak.
            player.setNilai(kodok.getSkor());

            // Permainan akan terus berulang selama skor >= 0 dan posisi < 300.z
        } while (kodok.getSkor() >= 0 && kodok.getPosisi() != 300);

        if (kodok.getPosisi() < 0) {
            System.out.println(ANSI_RED + "\n==========================================================");
            System.out.println("||\t\t\tGame Over, Katak Mati\t\t\t||");
            System.out.println("==========================================================" + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "\n==========================================================");
            System.out.println("||\t\t\tKatak Menang\t\t\t||");
            System.out.println("==========================================================" + ANSI_RESET);
        }

        // Menampilkan nilai akhir user, skor katak, dan posisi katak.
        System.out.println(ANSI_YELLOW + "==========================================================");
        System.out.println("||\t\t\tnilai Akhir\t\t\t||");
        System.out.println("||\t\t\t" + player.getNama() + "\t\t        ||");
        System.out.println("==========================================================");
        System.out.println("||\t\t\tSkor Katak: " + kodok.getSkor() + "     \t\t||");
        System.out.println("==========================================================" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "||\t\t\tPosisi Katak\t\t\t||");
        System.out.println("==========================================================");
        System.out.println("||\t\t\t" + kodok.getPosisi() + "\t\t\t\t||");

        // Kategori pencapaian skor dengan tiga kategori.
        if (kodok.getSkor() > 1000) {
            System.out.println(ANSI_GREEN + "==========================================================");
            System.out.println("||\t\t\tPencapaian\t\t\t||");
            System.out.println("==========================================================");
            System.out.println("||\t\t\tKatak Excellent\t\t\t||");
            System.out.println("==========================================================" + ANSI_RESET);
        } else if (kodok.getSkor() > 500 && kodok.getSkor() < 1000) {
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

    }

    /**
     * 
     * @param args Method main untuk memanggil class Mainkan dan create new object
     *             pada MainLompatKatak.
     */
    public static void main(String[] args) {
        // Create new object hayuk from class MainLompatKatak.
        MainLompatKatak hayuk = new MainLompatKatak();

        char confirm = 'y';

        // Informasi permainan.
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

        System.out.println(ANSI_YELLOW + "==========================================================");
        System.out.println("||Pengurangan Poin:\t\t\t\t\t||");
        System.out.println("==========================================================");
        System.out.println("||Katak dimakan oleh Aves, nilai berkurang 5 \t\t||");
        System.out.println("||Katak dimakan oleh Serpentes, nilai berkurang 10\t||");
        System.out.println("||Katak dimakan oleh Aligator, nilai berkurang 15\t||");
        System.out.println("==========================================================" + ANSI_RESET);

        System.out.println(ANSI_YELLOW + "==========================================================");
        System.out.println("||Peraturan\t\t\t\t\t\t||");
        System.out.println("==========================================================");
        System.out.println("||1. Jika katak berada pada kotak 300, permainan selesai||");
        System.out.println("||2. Jika nilai 0, permainan selesai\t\t\t||");
        System.out.println("==========================================================" + ANSI_RESET);

        System.out.println(ANSI_CYAN + "==========================================================");
        System.out.println("||Press any key to begin...\t\t\t\t||");
        System.out.println("==========================================================" + ANSI_RESET);
        MainLompatKatak.s.nextLine();

        // Loop selama confirm yes, memanggil object hayuk untuk memulai permainan.
        while (confirm == 'y') {
            hayuk.Mainkan();
            System.out.println("\n+-------------------------------------------------------+");
            System.out.println("|##        Apakah anda ingin lanjut bermain? (y/t)?   ##|");
            System.out.println("|                      Ya (Yes)                         |");
            System.out.println("|                     Tidak (No)                        |");
            System.out.println("+-------------------------------------------------------+");

            System.out.print("Masukkan pilihan anda: ");
            confirm = s.next().charAt(0);
            s.nextLine();
        }

        System.out.println(ANSI_CYAN + "==========================================================");
        System.out.println("|| \t\t Terima kasih telah bermain! \t\t||");
        System.out.println("==========================================================" + ANSI_RESET);

        // Close scanner.
        MainLompatKatak.s.close();

    }
}