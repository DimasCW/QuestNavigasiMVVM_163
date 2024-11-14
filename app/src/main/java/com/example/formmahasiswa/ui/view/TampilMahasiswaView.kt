package com.example.formmahasiswa.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.formmahasiswa.model.Mahasiswa

//TampilanMahasiswaView menampilkan data Mahasiswa yang disimpan di ViewModel,
// sehingga pengguna bisa melihat data yang baru saja dimasukkan.

@Composable
fun TampilanMahasiswaView(
    mhs: Mahasiswa,
    onBackClick: () -> Unit
){
    Column (modifier = Modifier.padding().fillMaxSize()){
        TampilData(
            judul = "Nama",
            isinya = mhs.nama
        )
        TampilData(
            judul = "Nim",
            isinya = mhs.nim
        )
        TampilData(
            judul = "Email",
            isinya = mhs.email
        )
        TampilData(
            judul = "NomorHp",
            isinya = mhs.nomorHp
        )

        TampilData(
            judul = "Gender",
            isinya = mhs.gender
        )
        TampilData(
            judul = "Alamat",
            isinya = mhs.alamat
        )

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Kembali")
        }

    }
}




@Composable
fun TampilData(
    judul: String,
    isinya: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween // Mengatur jarak antar elemen
    ) {
        Text(judul, modifier = Modifier.weight(0.8f)) // Label judul
        Text(":", modifier = Modifier.weight(0.2f)) // Titik dua
        Text(isinya, modifier = Modifier.weight(2f)) // Isi dari data
    }
}