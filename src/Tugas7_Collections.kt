// M. Wahyu Hilal Abroor / F1D02310123 / Mobile B

//membuat data class mahasiswa
data class NilaiMahasiswa(
    val nim: String,
    val nama: String,
    val mataKuliah: String,
    val nilai: Int
)

// membuat fungsi untuk menentukan grade
fun getGrade(nilai: Int): String {
    return when (nilai) {
        in 85..100 -> "A"
        in 70..84 -> "B"
        in 60..69 -> "C"
        in 50..59 -> "D"
        else -> "E"
    }
}

fun main(){
    // membuat 10 data mahasiswa
    val mahasiswa = listOf(
        NilaiMahasiswa("F1D02310123","Wahyu Abroor   ","Pemrograman Bergerak",95),
        NilaiMahasiswa("F1D02310114","Izzat Gagah    ","Pemrograman Bergerak",90),
        NilaiMahasiswa("F1D02310098","Abdi Gacor     ","Pemrograman Bergerak",96),
        NilaiMahasiswa("F1D02310141","Bayu Dubai     ","Pemrograman Bergerak",82),
        NilaiMahasiswa("F1D02310052","Nufa Nupeng    ","Pemrograman Bergerak",70),
        NilaiMahasiswa("F1D02310048","Fadila Eure    ","Pemrograman Bergerak",75),
        NilaiMahasiswa("F1D02310001","Khair Josu     ","Pemrograman Bergerak",88),
        NilaiMahasiswa("F1D02310002","Neymar Junior  ","Pemrograman Bergerak",40),
        NilaiMahasiswa("F1D02310003","Ronaldo Penaldo","Pemrograman Bergerak",60),
        NilaiMahasiswa("F1D0231004","Messi Miami    ","Pemrograman Bergerak",55)
    )

    // Menampilkan semua data
    println("===== DATA NILAI MAHASISWA =====")
    println()

    println("No  NIM        Nama             MataKuliah            Nilai")
    mahasiswa.forEachIndexed { i, m ->
        println("${i+1} ${m.nim}  ${m.nama}  ${m.mataKuliah}  ${m.nilai}")
    }

    //menghitung nilai rata rata
    val rataRata = mahasiswa.map {
        it.nilai
    }.average()

    //menghitung nilai tertinggi
    val tertinggi = mahasiswa.maxByOrNull {
        it.nilai
    }

    //menghitung nilai terendah
    val terendah = mahasiswa.minByOrNull {
        it.nilai
    }

    println("\n===== STATISTIK =====")
    println("Total Mahasiswa : ${mahasiswa.size}")
    println("Rata-rata Nilai : $rataRata")
    println("Nilai Tertinggi : ${tertinggi?.nilai} (${tertinggi?.nama})")
    println("Nilai Terendah  : ${terendah?.nilai} (${terendah?.nama})")


    //filter lulus
    val lulus = mahasiswa.filter{
        it.nilai >= 70
    }

    //filter tidak lulus
    val tidakLulus = mahasiswa.filter { it.nilai < 70 }

    println("\n===== MAHASISWA LULUS =====")
    lulus.forEachIndexed { i, m ->
        println("${i + 1}. ${m.nama} - ${m.nilai} (${getGrade(m.nilai)})")
    }

    println("\n===== MAHASISWA TIDAK LULUS =====")
    tidakLulus.forEachIndexed { i, m ->
        println("${i + 1}. ${m.nama} - ${m.nilai} (${getGrade(m.nilai)})")
    }

    // mengurutkan nilai berdasarkan ascending
    val asc = mahasiswa.sortedBy {
        it.nilai
    }

    //mengurutkan nilai berdasarkan descending
    val desc = mahasiswa.sortedByDescending {
        it.nilai
    }


    println("\n===== SORTING ASCENDING =====")
    asc.forEach {
        println("${it.nama} - ${it.nilai}")
    }

    println("\n===== SORTING DESCENDING =====")
    desc.forEach {
        println("${it.nama} - ${it.nilai}")
    }

    // membuat filter untuk mengelompokkan mahasiswa berdasarkan gradenya
    val groupGrade = mahasiswa.groupBy {
        getGrade(it.nilai)
    }

    println("\n===== JUMLAH PER GRADE =====")
    groupGrade.toSortedMap().forEach { grade, list ->
        println("Grade $grade : ${list.size} mahasiswa")
    }


    println("\n===== CARI MAHASISWA =====")

    print("Masukkan nama yang ingin dicari: ")
    val keyword = readLine()!!

    val search = mahasiswa.filter {
        it.nama.contains(keyword, ignoreCase = true)
    }

    if (search.isEmpty()) {
        println("Mahasiswa tidak ditemukan.")
    } else {
        println("\nHasil Pencarian:")
        search.forEachIndexed { i, m ->
            println("${i + 1}. ${m.nama} - ${m.nilai}")
        }
    }

}



