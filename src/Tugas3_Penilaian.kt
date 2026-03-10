// M. Wahyu Hilal Abroor / F1D02310123 / Mobile B

//Membuat fungsi untuk validasi input nilai
fun input(pesan:String): Int{
    while(true){
        print(pesan)
        val nilai = readLine()?.toIntOrNull()

        if (nilai != null && nilai in 0..100) {
            return nilai
        } else{
            println("Error: Nilai tidak boleh kosong dan harus di antara 0 - 100 :(")
        }
    }
}

//fungsi main
fun main(){
    println("===== SISTEM PENILAIAN =====")
    println()

    // membuat validasi untuk input nama agar namanya tidak kosong
    var nama: String
    while (true) {
        print("Masukkan Nama Mahasiswa: ")
        nama = readLine()!!
        if (nama.isNotEmpty()) break
        println("Error: Nama tidak boleh kosong!")
    }

    //kode yg fungsinya untuk mengambil input dari user
    val uts = input("Masukkan Nilai UTS (0-100): ")
    val uas = input("Masukkan Nilai UAS (0-100): ")
    val tugas = input("Masukkan Nilai Tugas (0-100): ")

    //menghitung nilai akhir
    val nilaiAkhir = (uts * 0.3) + (uas * 0.4) + (tugas * 0.3)


    // menentukan grade untuk setiap range nilai
    val grade = when (nilaiAkhir.toInt()){
        in 85..100 -> "A"
        in 70..84 -> "B"
        in 60..69 -> "C"
        in 50..59 -> "D"
        else -> "E"
    }

    // keterangan dari setiap grade
    val keterangan = when (grade) {
        "A" -> "Sangat Baik"
        "B" -> "Baik"
        "C" -> "Cukup"
        "D" -> "Kurang"
        else -> "Sangat Kurang"
    }

    // status
    val status = if (nilaiAkhir >= 60) "LULUS" else "TIDAK LULUS"


    //menampilkan hasil akhir penilaian
    println()
    println("===== HASIL PENILAIAN =====")
    println("Nama        : $nama")
    println("Nilai UTS   : $uts (Bobot 30%)")
    println("Nilai UAS   : $uas (Bobot 40%)")
    println("Nilai Tugas : $tugas (Bobot 30%)")

    println("-----------------------------")

    println("Nilai Akhir : $nilaiAkhir")
    println("Grade       : $grade")
    println("Keterangan  : $keterangan")
    println("Status      : $status")

    println()

    // menampilkan pesan untuk status yg sesuai
    if (status == "LULUS") {
        println("Selamat! Anda dinyatakan LULUS.")
    } else {
        println("Maaf, Anda belum lulus. Selamat Mengulang:(")
    }

}