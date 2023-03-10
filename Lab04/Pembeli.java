class Pembeli {

    // TODO: Implementasi visibility modifier yang sesuai
    String nama;
    long jumlahUang;
    Pesanan[] listPesanan = new Pesanan[20];
    final int MAKS_JUMLAH_BARANG = 20;

    // TODO: Implementasi constructor yang sesuai
    public Pembeli(String nama, long jumlahUang){
        this.nama = nama;
        this.jumlahUang = jumlahUang;
    }

    /*
     * Method yang akan mengembalikan sebuah String yang merupakan pesan hasil dari
     * query BELI.
     */
    public String tambahPesanan(Barang barang, int jumlah){
        String namaBarang = barang.getNama(); // memanggil method getter dengan return nama barang tsb
        int stokBarang = barang.getStok(); // memanggil method getter dengan return stok dari barang tsb
        
        // mengecek apakah jumlah yang diinput user melebih stok barang yang ada
        if (jumlah > stokBarang) {
            return "Tidak bisa memesan " + namaBarang + " sebanyak " + jumlah + " buah. Stok barang tidak cukup.";
        }
    
        // menghitung total harga setiap iterasi pesanan
        long totalHargaSaatIni = 0;
        for (Pesanan pesanan: listPesanan){ // mengiterasi
            totalHargaSaatIni += pesanan.totalHarga();
        }
    
        // mengecek apakah total harga saat ini melebihi budget pembeli
        if (totalHargaSaatIni + (barang.getHarga() * jumlah) > jumlahUang){
            return "Tidak bisa memesan " + namaBarang + " sebanyak " + jumlah + " buah. Uang " + nama + " tidak cukup.";
        }
    
        // memeriksa apakah sudah ada pesanan dengan barang yang sama
        for (Pesanan pesanan: listPesanan){
            if (pesanan.getBarang().equals(namaBarang)){
                pesanan.setJumlahBarang(pesanan.getJumlahBarang()+jumlah); // update jumlah barang dengan nama yang sama
                return nama + " berhasil memesan " + namaBarang + " sebanyak " + jumlah + " buah.";
            }
        }
    
        // mengecek apakah list sudah penuh atau belum
        boolean listIsFull = true;
        for (int i = 0; i < listPesanan.length; i++){
            if (listPesanan[i] == null){
                listIsFull = false;
            }
            else {
                return "Tidak bisa memesan " + namaBarang + " sebanyak " + jumlah + " buah. List pesanan " + nama + " melebihi kapasitas.";
            }
        }
        // menambah pesanan barang yang baru dipesan ke list
        for (int i = 0; i < listPesanan.length; i++){
            if (listPesanan[i] == null){
                listPesanan[i] = new Pesanan(barang, jumlah); // apakah perlu break?
            }
        }
        return nama + " berhasil memesan " + namaBarang + " sebanyak " + jumlah + " buah."; // jika tidak memenuhi 
    }
    
    /*
     * Method untuk mengosongkan list pesanan
     */
    public void resetPesanan(){
        listPesanan = new Pesanan[20];
    }

    // TODO: Tambahkan getter/setter/method lain yang diperlukan

    public String getNama() {
        return nama;
    }

    public long getUang (){
        return jumlahUang;
    }

}
