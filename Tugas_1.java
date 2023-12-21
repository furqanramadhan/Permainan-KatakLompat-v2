import java.util.Random;
import java.util.Scanner;

public class Tugas_1 {
    /**
     * 
     * Metode sederhana untuk menyatakan class dengan nama "Tugas_1" dengan method
     * constructor adalah public
     * 
     * @author furqan ramadhan
     * @version 1.1
     *          NPM : 2108107010013
     *          Main
     * 
     * @param args the args[]
     *             link video :
     *             https://drive.google.com/file/d/1pFkOtDGPGXwBpjIAAnWIkfdC_vPo9X2Q/view?usp=sharing
     */

    public static void main(String[] args) {
        // Inisialisasi tipe data
        Scanner sc = new Scanner(System.in);
        int position = 0;
        int score = 100;
        int square = 500;
        int i;
        int j;
        int difficulty;
        int index_item = 3;
        int explore[] = new int[505];
        int index_coin[] = { 10, 20, 50 };
        int count_coin[] = { 100, 50, 10 };
        int index_monster[] = { -5, -10, -25 };
        int count_monster[] = { 80, 40, 5 };
        char confirm;
        System.out.printf("Hai Katak, Melompatlah!... \n");
        System.out.println("Press any key to begin...");
        sc.nextLine();
        char arah;

        confirm = 'y';
        // Ketika pemain memberi input : y , maka permainan dimulai dari awal
        while (confirm == 'y') {

            String difficulty_mode = "";
            System.out.println("Level yang tersedia: ");
            System.out.println("1. Mudah");
            System.out.println("2. Menengah");
            System.out.println("3. Sulit");

            difficulty = sc.nextInt();

            while (difficulty > 3 || difficulty < 1) {
                System.out.printf("Masukkan hanya nilai 1 - 3! \n");
                System.out.println("Pilihlah level: ");
                difficulty = sc.nextInt();
            }

            // Pembuatan level beserta nilai koin dan monster
            switch (difficulty) {
                case 1:
                    difficulty_mode = "Mudah";
                    count_coin[0] = 150;
                    count_coin[1] = 50;
                    count_coin[2] = 0;

                    count_monster[0] = 100;
                    count_monster[1] = 20;
                    count_monster[2] = 2;

                    break;
                case 2:
                    difficulty_mode = "Menengah";
                    count_coin[0] = 150;
                    count_coin[1] = 50;
                    count_coin[2] = 5;

                    count_monster[0] = 120;
                    count_monster[1] = 30;
                    count_monster[2] = 10;

                    break;
                case 3:
                    difficulty_mode = "Sulit";
                    count_coin[0] = 150;
                    count_coin[1] = 50;
                    count_coin[2] = 30;

                    count_monster[0] = 80;
                    count_monster[1] = 120;
                    count_monster[2] = 40;
                    break;
            }

            System.out.printf("Pilihan level yang kamu pilih adalah: %s \n", difficulty_mode);

            // memulai nilai acak
            Random rd = new Random();

            for (i = 0; i < index_item; i++) {
                for (j = 0; j < count_coin[i]; j++) {
                    int temp = rd.nextInt(square - 1);
                    while (explore[temp] != 0) {
                        temp++;
                        if (temp > 499) {
                            temp = 1;
                        }
                    }
                    explore[temp] += index_coin[i];
                }
            }

            for (i = 0; i < index_item; i++) {
                for (j = 0; j < count_monster[i]; j++) {
                    int temp = rd.nextInt(square - 1);
                    while (explore[temp] != 0) {
                        temp++;
                        if (temp > 499) {
                            temp = 1;
                        }
                    }
                    explore[temp] += index_monster[i];
                }
            }

            // Posisi Katak saat loop
            System.out.println("Posisi katak di-" + position);
            System.out.println("Poin diperoleh: " + score);

            while (position < 499 && score > 0) {
                // konfirmasi apakah pemain ingin bergerak maju atau mundur
                System.out.print("Apakah anda ingin maju (D) atau mundur (A)? (a/d): ");
                arah = sc.next().charAt(0);
                // Exception Handling jika salah input
                if (arah != 'a' && arah != 'd' && arah != 'A' && arah != 'D') {
                    System.out.println("Masukkan sesuai instruksi.");
                    continue;
                }

                // input langkah yang ingin maju atau mundur
                System.out.println("Berapa Langkah?");
                System.out.println("1. Satu Langkah");
                System.out.println("2. Dua Langkah");
                System.out.print("Masukkan pilihan   : ");

                int moving = sc.nextInt();
                while (moving > 2 || moving < 1) {
                    System.out.println("Maaf, tidak ada pilihan");
                    System.out.print("Masukkan pilihan   : ");

                    moving = sc.nextInt();
                }

                while ((position + moving > 500 && arah == 'd') || (position - moving < 0 && arah == 'a')) {
                    System.out.println("Maaf, Langkah anda akan keluar kotak");
                    System.out.print("Apakah anda ingin maju (D) atau mundur (A)? (a/d): ");
                    arah = sc.next().charAt(0);
                    // Exception Handling jika salah input
                    if (arah != 'a' && arah != 'd' && arah != 'A' && arah != 'D') {
                        System.out.println("Masukkan sesuai instruksi.");
                        continue;

                    }
                    System.out.println("Berapa Langkah?");
                    System.out.println("1. Satu Langkah");
                    System.out.println("2. Dua Langkah");
                    System.out.print("Masukkan pilihan   : ");

                    moving = sc.nextInt();
                }
                if (arah == 'a' || arah == 'A') {
                    position -= moving;
                } else {
                    position += moving;
                }
                score += explore[position];
                if (explore[position] < 0) {
                    System.out.println("Ada Monster!! :) poin dikurangi");
                } else if (explore[position] > 0) {
                    System.out.println("Katak mendapatkan Poin : " + score);
                }
                if (position < 499) {
                    System.out.println("Posisi katak di-" + position);
                    System.out.println("Poin diperoleh : " + score);
                } else {
                    System.out.println("Selamat anda mencapai titik akhir!!!");
                    System.out.println("Poin terakhir  : " + score);

                }

            }
            // Grade skor
            if (score < 0) {
                System.out.println("Maaf poin anda sudah habis, Game Over!");
            } else if (score < 500) {
                System.out.println("Bad!");
            } else if (score < 1500) {
                System.out.println("Good!");
            } else {
                System.out.println("Excellent!");
            }
            // konfirmasi user apakah ingin bermain lagi atau tidak
            System.out.print("Ingin bermain lagi ? (yes/no)   : ");
            confirm = sc.next().charAt(0);
        }
        System.out.println("Terima kasih !");
        sc.close();
    }
}