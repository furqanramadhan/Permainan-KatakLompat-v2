// Import semua package yang dibutuhkan
import java.util.Scanner;
import java.util.Random;

public class KatakLompatDefault {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String arg[]) {
        Scanner s = new Scanner(System.in);
        int[] kotak = new int[300];
        int pilih;
        int nilai = 100;
        int level;
        int posisi = 0;
        int koin, monster;
        char ulang;

        do {
            System.out.println(ANSI_YELLOW + "=========================================");
            System.out.println("||\tSelamat datang di game\t\t||");
            System.out.println("=========================================");
            System.out.println("||\tLompat Hai Katak, Lompat!\t||");
            System.out.println("=========================================" + ANSI_RESET);

            // Tambahkan pesan dengan warna
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
            System.out.println("||Katak dimakan oleh Aves, nilai berkurang 5\t||");
            System.out.println("||Katak dimakan oleh Serpentes, nilai berkurang 10\t||");
            System.out.println("||Katak dimakan oleh Aligator, nilai berkurang 15\t||");
            System.out.println("==================================================" + ANSI_RESET);

            System.out.println(ANSI_YELLOW + "==========================================================");
            System.out.println("||Peraturan\t\t\t\t\t\t||");
            System.out.println("==========================================================");
            System.out.println("||1. Jika katak berada pada kotak 300, permainan selesai||");
            System.out.println("||2. Jika nilai 0, permainan selesai\t\t\t||");
            System.out.println("==========================================================" + ANSI_RESET);

            System.out.println(ANSI_YELLOW + "==========================================================");
            System.out.println("||Level\t\t\t\t\t\t\t||");
            System.out.println("==========================================================");
            System.out.println("||1. Mudah\t\t\t\t\t\t||");
            System.out.println("||2. Sedang\t\t\t\t\t\t||");
            System.out.println("||3. Susah\t\t\t\t\t\t||");
            System.out.println("==========================================================" + ANSI_RESET);

            System.out.print("Masukkan level: ");
            level = s.nextInt();

            while (level < 1 || level > 3) {
                System.out.println(ANSI_RED + "==========================================================");
                System.out.println("||Level yang anda masukkan salah\t\t\t||");
                System.out.print("||Masukkan level: ");
                level = s.nextInt();
                System.out.println("==========================================================" + ANSI_RESET);
            }

            if (level == 1) {
                koin = 100;
                monster = 50;
                System.out.println(ANSI_YELLOW + "==========================================================");
                System.out.println("||\t\t\t<== Mudah ==>\t\t\t||");
                System.out.println("==========================================================" + ANSI_RESET);
            } else if (level == 2) {
                koin = 100;
                monster = 100;
                System.out.println(ANSI_YELLOW + "==========================================================");
                System.out.println("||\t\t\t<== Sedang ==>\t\t\t||");
                System.out.println("==========================================================" + ANSI_RESET);
            } else if (level == 3) {
                koin = 100;
                monster = 200;
                System.out.println(ANSI_YELLOW + "==========================================================");
                System.out.println("||\t\t\t<== Susah ==>\t\t\t||");
                System.out.println("==========================================================" + ANSI_RESET);
            } else {
                koin = 30;
                monster = 10;
            }

            Random p_acak = new Random();
            for (int i = 0; i < koin; i++) {
                int nilaiAcak = p_acak.nextInt(500);
                while (kotak[nilaiAcak] != 0) {
                    nilaiAcak += 1;
                    if (nilaiAcak > 499) {
                        nilaiAcak = 1;
                    }
                }
                kotak[nilaiAcak] = p_acak.nextInt(3) + 1;

            }
            for (int i = 0; i < monster; i++) {
                int nilaiAcak = p_acak.nextInt(500);
                while (kotak[nilaiAcak] != 0) {
                    nilaiAcak += 1;
                    if (nilaiAcak > 499) {
                        nilaiAcak = 1;
                    }
                }
                kotak[nilaiAcak] = p_acak.nextInt(3) + 5;
            }

            do {
                System.out.println(ANSI_YELLOW + "\n==========================================================");
                System.out.println("||Katak berada di kotak ke " + posisi + "\t\t\t\t||");
                System.out.println("||Nilai anda: " + nilai + "\t\t\t\t\t||");
                System.out.println("==========================================================" + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "||1. Lompat 1 kotak\t\t\t\t\t||");
                System.out.println("||2. Lompat 2 kotak\t\t\t\t\t||");
                System.out.println("||3. Mundur 1 kotak\t\t\t\t\t||");
                System.out.println("||4. Mundur 2 kotak\t\t\t\t\t||");
                System.out.println("||5. Keluar\t\t\t\t\t\t||");
                System.out.println("==========================================================" + ANSI_RESET);
                System.out.print(ANSI_YELLOW + "||Masukkan pilihan: ");
                pilih = s.nextInt();
                while (pilih < 1 || pilih > 5) {
                    System.out.println(ANSI_RED + "==========================================================");
                    System.out.println("\n||Langkah yang anda masukkan salah\t\t\t||");
                    System.out.print("||Masukkan langkah yang diinginkan : ");
                    pilih = s.nextInt();
                    System.out.println("==========================================================" + ANSI_RESET);
                }

                if (pilih == 1) {
                    if (posisi + 1 > 499) {
                        continue;
                    } else {
                        posisi += 1;
                    }
                } else if (pilih == 2) {
                    if (posisi + 2 > 499) {
                        continue;
                    } else {
                        posisi += 2;
                    }
                } else if (pilih == 3) {
                    if (posisi - 1 < 0) {
                        continue;
                    } else {
                        posisi -= 1;
                    }
                } else if (pilih == 4) {
                    if (posisi - 2 < 0) {
                        continue;
                    } else {
                        posisi -= 2;
                    }
                } else if (pilih == 5) {
                    System.out.println(ANSI_YELLOW + "==========================================================");
                    System.out.println("||\t\t\t<== Keluar ==>\t\t\t||");
                    System.out.println("==========================================================" + ANSI_RESET);
                    break;
                }

                if (kotak[posisi] == 1) {
                    nilai += 10;
                    System.out.println(ANSI_GREEN + "\n==========================================================");
                    System.out.println("||Katak menemukan koin perunggu, nilai bertambah 10||");
                    System.out.println("==========================================================" + ANSI_RESET);
                } else if (kotak[posisi] == 2) {
                    nilai += 20;
                    System.out.println(ANSI_GREEN + "\n==========================================================");
                    System.out.println("||Katak menemukan koin Perak, nilai bertambah 20\t||");
                    System.out.println("==========================================================" + ANSI_RESET);
                } else if (kotak[posisi] == 3) {
                    nilai += 30;
                    System.out.println(ANSI_GREEN + "\n==========================================================");
                    System.out.println("||Katak menemukan koin Emas, nilai bertambah 30\t||");
                    System.out.println("==========================================================" + ANSI_RESET);
                } else if (kotak[posisi] == 5) {
                    nilai -= 5;
                    System.out.println(ANSI_RED + "\n==========================================================");
                    System.out.println("||Katak dimakan Aves, nilai berkurang 5\t\t||");
                    System.out.println("==========================================================" + ANSI_RESET);
                } else if (kotak[posisi] == 6) {
                    nilai -= 10;
                    System.out.println(ANSI_RED + "\n==========================================================");
                    System.out.println("||Katak dimakan Serpentes, nilai berkurang 10\t\t||");
                    System.out.println("==========================================================" + ANSI_RESET);
                } else if (kotak[posisi] == 7) {
                    nilai -= 15;
                    System.out.println(ANSI_RED + "\n==========================================================");
                    System.out.println("||Katak dimakan Aligator, nilai berkurang 15\t\t||");
                    System.out.println("==========================================================" + ANSI_RESET);
                } else {
                    System.out.println(ANSI_GREEN + "\n==========================================================");
                    System.out.println("||Katak tidak menemukan apapun\t\t\t\t||");
                    System.out.println("==========================================================" + ANSI_RESET);
                }
            } while (nilai >= 0 && posisi != 499);

            if (nilai < 0) {
                System.out.println(ANSI_RED + "\n==========================================================");
                System.out.println("||\t\t\tKatak Mati\t\t\t||");
                System.out.println("==========================================================" + ANSI_RESET);
            } else {
                System.out.println(ANSI_GREEN + "\n==========================================================");
                System.out.println("||\t\t\tKatak Menang\t\t\t||");
                System.out.println("==========================================================" + ANSI_RESET);
            }
            System.out.println(ANSI_YELLOW + "==========================================================");
            System.out.println("||\t\t\tnilai Akhir\t\t\t||");
            System.out.println("==========================================================");
            System.out.println("||\t\t\t" + nilai + "\t\t\t\t||");
            System.out.println("==========================================================" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "||\t\t\tPosisi Katak\t\t\t||");
            System.out.println("==========================================================");
            System.out.println("||\t\t\t" + posisi + "\t\t\t\t||");

            if (nilai > 200) {
                System.out.println(ANSI_GREEN + "==========================================================");
                System.out.println("||\t\t\tPencapaian\t\t\t||");
                System.out.println("==========================================================");
                System.out.println("||\t\t\tKatak Excellent\t\t\t||");
                System.out.println("==========================================================" + ANSI_RESET);
            } else if (nilai > 100 && nilai < 200) {
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
            ulang = s.next().charAt(0);

            System.out.println();

        } while (ulang != 't');
        System.out.println(ANSI_YELLOW + "\nTerima kasih telah bermain game Katak Lompat" + ANSI_RESET);
    }
}


