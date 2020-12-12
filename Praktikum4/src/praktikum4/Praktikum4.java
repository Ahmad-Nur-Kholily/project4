package praktikum4;

import java.util.Scanner;

public class Praktikum4 {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int menu;
        boolean menuX = true;
        mahasiswa data = new mahasiswa();
        while(menuX){
            System.out.println("___________________________\n");
            System.out.println("Pengolah Data Mahasiswa");
            System.out.println("___________________________");
            System.out.println("Menu Utama:");
            System.out.println("1. Tambah Data");
            System.out.println("2. Hapus Data");
            System.out.println("3. Cari Data");
            System.out.println("4. Tampilkan Data");
            System.out.println("5. Keluar");
            System.out.print("Masukkan angka menu : ");
            menu = input.nextInt();
            switch(menu){
                case 1:
                        data.add();
                    break;
                case 2:
                    data.delete();
                    break;
                case 3:
                    data.search();
                    break;
                case 4:
                    data.show();
                    break;
                case 5:
                    menuX = false;
                    break;
                default:
                    System.out.println("_____________________");
                    System.out.println("Menu tidak tersedia");
                    System.out.println("_____________________");
            }
                    
        }
    }
}
