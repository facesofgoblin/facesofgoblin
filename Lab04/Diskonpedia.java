import java.io.*;
import java.util.StringTokenizer;
import Template_Lab_04.Pembeli;


public class Diskonpedia {

    private static InputReader in = new InputReader(System.in);
    private static PrintWriter out = new PrintWriter(System.out);
    private static Barang[] listBarang;
    private static Pembeli[] listPembeli;

    /*
     * Method utama program
     */
    public static void main(String[] args) {

        // Inisiasi Barang
        int jumlahBarang = in.nextInt();
        listBarang = new Barang[jumlahBarang];

        for(int i = 0; i < jumlahBarang; i++){
            String namaBarang = in.next();
            long harga = in.nextLong();
            int stok = in.nextInt();

            //TODO: Inisiasi objek barang baru dan masukkan ke listBarang
            Barang barangBaru = new Barang(harga, namaBarang, stok);
            listBarang[i] = barangBaru;

        }

        // Inisiasi Pembeli
        int jumlahPembeli = in.nextInt();
        listPembeli = new Pembeli[jumlahPembeli];

        for(int i = 0; i < jumlahPembeli; i++){
            String namaPembeli = in.next();
            long jumlahUang = in.nextLong();

            //TODO: Inisiasi objek pembeli baru dan masukkan ke listPembeli
            Pembeli pembeliBaru = new Pembeli(namaPembeli, jumlahUang);
            listPembeli [i] = pembeliBaru;
        }

        // Jalanin Query
        int jumlahPerintah = in.nextInt();

        for(int i = 0; i < jumlahPerintah; i++){
            String perintah = in.next();
            switch (perintah) {
                case "PESAN" -> {
                    String namaPembeli = in.next();
                    String namaBarang = in.next();
                    int jumlah = in.nextInt();
                    pesan(namaPembeli, namaBarang, jumlah);
                    break;
                }
                case "BAYAR" -> {
                    String namaPembeli = in.next();
                    bayar(namaPembeli);
                    break;
                }
                case "DISKON" -> {
                    String namaPembeli = in.next();
                    diskon(namaPembeli);
                    break;
                }
                case "RESTOCK" -> {
                    String namaBarang = in.next();
                    int jumlah = in.nextInt();
                    restock(namaBarang, jumlah);
                    break;
                }
            }
        }
        out.close();
    }

    /*
     * Method untuk perintah PESAN
     */
    public static void pesan(String namaPembeli, String namaBarang, int jumlah){
        //TODO: Implementasi perintah PESAN
        Pembeli objekKelas = new Pembeli ();
        objekKelas.tambahPesanan(namaBarang, jumlah);

    }

    /*
     * Method untuk perintah BAYAR
     */
    public static void bayar(String namaPembeli){
        // TODO: Implementasi perintah BAYAR

    }

    /*
     * Method untuk perintah RESTOCK
     */
    public static void restock(String namaBarang, int jumlah){
        //TODO: Implementasi perintah RESTOCK


    }

    /*
     * Method untuk perintah DISKON.
     */
    public static void diskon(String namaPembeli){
        // TODO: Implementasi method ini

    }

    /*
     * Method untuk mencari persentase diskon yang didapat oleh pembeli.
     * Method ini mengembalikan persentase diskon yang didapat.
     */
    public static int hitungDiskon(Pembeli pembeli){
        //TODO: Implementasi method ini
        return 0;
    }

    /*
     * Method untuk mencari Barang berdasarkan nama
     */
    public static Barang cariBarang(String nama){
        for(Barang barang: listBarang){
            if(barang.getNama().equals(nama))
                return barang;
        }
        return null;
    }

    /*
     * Method untuk mencari Pembeli berdasarkan nama
     */
    public static Pembeli cariPembeli(String nama){
        for(Pembeli pembeli: listPembeli){
            if(pembeli.getNama().equals(nama))
                return pembeli;
        }
        return null;
    }

    // taken from https://codeforces.com/submissions/Petr
    // together with PrintWriter, these input-output (IO) is much faster than the usual Scanner(System.in) and System.out
    // please use these classes to avoid your fast algorithm gets Time Limit Exceeded caused by slow input-output (IO)
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
