package praktikum4;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class mahasiswa {
    ArrayList<String> listNim = new ArrayList<>();
    ArrayList<String> listNama = new ArrayList<>();
    ArrayList<Date> listTgl = new ArrayList<>();
    ArrayList<Integer> listgender = new ArrayList<>();
    Scanner inputData = new Scanner(System.in);
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
    void add(){
        String nama,nim;
        int tgl,bln,thn;
        Integer jk;
        
        System.out.print("Masukkan NIM: ");
        nim = inputData.nextLine();
        System.out.print("Masukkan Nama: ");
        nama = inputData.nextLine();
        System.out.println("Format Tanggal Lahir (dd/mm/yyyy): ");
        System.out.print("Masukkan tanggal lahir : ");
        tgl = inputData.nextInt();
        System.out.print("Masukkan bulan lahir: ");
        bln = inputData.nextInt();
        System.out.print("Masukkan tahun lahir: ");
        thn = inputData.nextInt();
        Date tanggal = new GregorianCalendar(thn,bln-1,tgl).getTime();
        System.out.print("Input angka satu (1) untuk laki-laki dan kosong (0) untuk perempuan: ");
        jk = inputData.nextInt();
        listNim.add(nim);
        listNama.add(nama);
        listTgl.add(tanggal);
        listgender.add(jk);   
    }
    
    void delete(){
        if(listNim.size() > 0){
            System.out.print("Masukkan NIM mahasiswa yang ingin di hapus: ");
            String hapus = inputData.nextLine();
            inputData.nextLine();
            int index = listNim.indexOf(hapus);
            if(index < 0){
                System.out.println("NIM tidak ditemukan");
            }else{
                listNim.remove(index);
                listNama.remove(index);
                listTgl.remove(index);
                listgender.remove(index);
                System.out.println("Data telah dihapus");
            }
        }else{
            System.out.println("Belum ada data");
        }  
    }
    
    void search(){
        System.out.println("Cari Berdasarkan : ");
        System.out.println("1. NIM");
        System.out.println("2. Gender");
        System.out.print("Pilih: ");
        int pilih = inputData.nextInt();
        switch(pilih){
            case 1:
                inputData.nextLine();
                System.out.print("Masukkan NIM : ");
                String cari = inputData.nextLine();
                for(String cnim: listNim){
                    if(listNim.contains(cari)){
                        int index = listNim.indexOf(cari);
                        String tanggal = formatter.format(listTgl.get(index));
                        String jk = (listgender.get(index) == 0) ? "Perempuan" : "Laki-laki";
                        System.out.println("______________________________\n");
                        System.out.println("Data NIM " + listNim.get(index));
                        System.out.println("______________________________\n");
                        System.out.println("NIM : " + listNim.get(index));
                        System.out.println("Nama : " + listNama.get(index));
                        System.out.println("Tanggal Lahir : " + tanggal);
                        System.out.println("Gender : " + jk);
                        break;
                    }
                }
                break;
            case 2:
                inputData.nextLine();
                System.out.print("  Masukkan Gender(0:Perempuan 1:Laki-laki):");
                int dicari2 = inputData.nextInt();
                for(int n = 0; n < listgender.size(); n++){
                    if(listgender.get(n) == dicari2){
                        String tanggal = formatter.format(listTgl.get(n));
                        String jk = (listgender.get(n) == 0) ? "Perempuan" : "Laki-laki";
                        System.out.println("");
                        System.out.println("___________________\n");
                        System.out.println("Data Mahasiswa");
                        System.out.println("___________________\n");
                        System.out.println("NIM : " + this.listNim.get(n));
                        System.out.println("Nama : " + this.listNama.get(n));
                        System.out.println("Tanggal Lahir : " + tanggal);
                        System.out.println("Gender : " + jk);
                    }
                };
                break;
            default:
                System.out.println("________________________________________\n");
                System.out.println("Menu Yang Anda Pilih Tidak Tersedia.");
                System.out.println("________________________________________\n");
        }
    }
    
    void show(){
        if(listNim.size() == 0){
            System.out.println("_______________________\n");
            System.out.println("Data tidak ditemukan");
            System.out.println("_______________________\n");
        }else{
            for(int n = 0; n < listNim.size(); n++){
                String tanggal = formatter.format(listTgl.get(n));
                String jk = (listgender.get(n) == 0) ? "Perempuan" : "Laki-laki\n";
                System.out.println("Mahasiswa ke " + (n+1));
                System.out.println("______________________________\n");
                System.out.println("NIM : " + listNim.get(n));
                System.out.println("Nama : " + listNama.get(n));
                System.out.println("Tanggal lahir: " + tanggal);
                System.out.println("Gender : " + jk);
                System.out.println("______________________________\n");
            }
            System.out.println("Jumlah Seluruh Mahasiswa : " + listNim.size() +"\n");
        }
    }
}