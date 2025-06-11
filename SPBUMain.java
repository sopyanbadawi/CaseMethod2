import java.util.Scanner;
public class SPBUMain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedListAntrian antrian = new LinkedListAntrian();
        RiwayatQueue riwayatTransaksi = new RiwayatQueue();
        int pilihan;

        do {
            System.out.println("--- Menu SPBU ---");
            System.out.println("1. Tambah Antrian Kendaraan");
            System.out.println("2. Tampilkan Antrian Kendaraan");
            System.out.println("3. Cek Jumlah Antrian Kendaraan");
            System.out.println("4. Layani Kendaraan");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scan.nextInt();
            scan.nextLine(); 

            switch(pilihan) {
                case 1:
                    System.out.print("Masukkan Plat Nomor: ");
                    String platNomor = scan.nextLine();
                    System.out.print("Masukkan Tipe Kendaraan: ");
                    String tipe = scan.nextLine();
                    System.out.print("Masukkan Merk Kendaraan: ");
                    String merk = scan.nextLine();
                    Kendaraan kendaraan = new Kendaraan(platNomor, tipe, merk);
                    antrian.addLast(kendaraan);
                    System.out.println(">> Kendaraan masuk ke dalam antrian. \n");
                    break;

                case 2:
                    System.out.println("Antrian Kendaraan: ");    
                    System.out.println("\n--- Antrian Kendaraan ---");
                    antrian.print();
                    break;

                case 3:
                    System.out.println("\n>> Jumlah kendaraan dalam antrian: " + antrian.getSize() + " \n");
                    break;

                case 4:
                    if (antrian.isEmpty()) {
                        System.out.println("Belum ada kendaraan yang mengantri. \n");
                    } else {
                        Kendaraan kendaraanAntri = antrian.head.data;
                        System.out.println("Petugas Melayani " + kendaraanAntri.platNomor);
                        System.out.print("Masukkan jenis BBM: ");
                        String jenisBBM = scan.nextLine();
                        System.out.print("Masukkan harga per liter: ");
                        double hargaPerLiter = scan.nextDouble();
                        System.out.print("Masukkan jumlah liter: ");
                        double liter = scan.nextDouble();
                        scan.nextLine(); 

                        BBM bbm = new BBM(jenisBBM, hargaPerLiter);
                        TransaksiPengisian transaksi = new TransaksiPengisian(kendaraanAntri, bbm, liter);
                        riwayatTransaksi.enqueue(transaksi);
                        antrian.removeFirst();
                        System.out.println(">> Transaksi berhasil dicatat.\n");
                    }

                    break;

                case 5:
                    System.out.println("\n-- Riwayat Transaksi --");
                    riwayatTransaksi.print();
                    break;

                case 0:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihan != 0);

        scan.close();
    }
    
}
