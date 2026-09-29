/*
 * ===== KENAPA do-while BERBEDA? =====
 * for dan while mengecek kondisi SEBELUM badan loop dijalankan. Dengan
 * n = 0, kondisi (1 <= 0) langsung salah, sehingga badan loop tidak
 * pernah jalan dan barisnya kosong. do-while menjalankan badan loop dulu
 * baru mengecek kondisi, jadi angka 1 tetap tercetak satu kali.
 *
 * Kesimpulan: do-while mengecek kondisinya sesudah badan loop dijalankan,
 * jadi badannya pasti jalan minimal sekali.
 *
 * ===== KENAPA LOOP TIDAK BERHENTI DI i = 8? =====
 * Di dalam badan loop, continue (cek genap) ditulis SEBELUM break
 * (cek i > 7). Saat i = 8, angka itu genap, sehingga continue langsung
 * melompat ke iterasi berikutnya dan pengecekan break tidak pernah
 * tercapai. Baru saat i = 9 (ganjil) continue dilewati, kondisi i > 7
 * bernilai benar, dan break menghentikan loop. Jadi loop berhenti di
 * i = 9, bukan i = 8.
 */
import java.util.Scanner;

public class TigaLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Batas deret (n) : ");
        int n = input.nextInt();

        System.out.println();
        System.out.println("===== SATU DERET, TIGA LOOP =====");

        // Versi for (pencacah: i)
        System.out.print("for      : ");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Versi while (pencacah: j)
        System.out.print("while    : ");
        int j = 1;
        while (j <= n) {
            System.out.print(j + " ");
            j++;
        }
        System.out.println();

        // Versi do-while (pencacah: k)
        System.out.print("do-while : ");
        int k = 1;
        do {
            System.out.print(k + " ");
            k++;
        } while (k <= n);
        System.out.println();

        // Saringan deret 1-10 (angka tetap, tidak ikut n)
        int tercetak = 0;
        System.out.print("Disaring : ");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;   // lewati angka genap
            }
            if (i > 7) {
                break;      // berhenti kalau i > 7
            }
            System.out.print(i + " ");
            tercetak++;
        }
        System.out.println();
        System.out.println("Sampai println  : " + tercetak + " kali");

        input.close();

        System.out.println();

        // Bukti off-by-one: dua penghitung terpisah
        int kurang = 0;
        for (int i = 1; i < n; i++) {
            kurang++;
        }
        int kurangSama = 0;
        for (int i = 1; i <= n; i++) {
            kurangSama++;
        }
        System.out.println("i <  n berputar : " + kurang + " kali");
        System.out.println("i <= n berputar : " + kurangSama + " kali");
    }
}