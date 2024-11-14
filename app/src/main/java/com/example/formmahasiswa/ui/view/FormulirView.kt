package com.example.formmahasiswa.ui.view



// Import pustaka Compose untuk membuat UI
import android.widget.Button
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.formmahasiswa.model.DataJK

// Fungsi utama untuk menampilkan input form biodata
@Composable
fun FormulirView(modifier: Modifier = Modifier,
    pilihanJk : List<String>,
                     onClickButton: (MutableList<String>) -> Unit
) {
    // Variabel untuk menyimpan data input pengguna
    var nama by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var nomorHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisK by remember { mutableStateOf("") }
    var listData : MutableList<String> = mutableListOf(nama,nim,email, nomorHp,jenisK, alamat)

    // Kolom utama untuk seluruh layout
    Column(
        modifier = Modifier
            .fillMaxSize()  // Mengisi ukuran layar penuh
            .padding(16.dp),  // Memberikan jarak padding 16dp
        horizontalAlignment = Alignment.CenterHorizontally // Pusatkan semua elemen
    ) {
        // Judul biodata
        Text(
            "BIODATA",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )

        // Spacer untuk jarak antara judul dan konten
        Spacer(modifier = Modifier.padding(20.dp))

        // TextField untuk input Nama
        TextField(
            value = nama,
            onValueChange = { nama = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("Nama") },
            placeholder = {
                Text("Masukkan Nama Anda", color = Color.Gray)
            }
        )

        TextField(
            value = nim,
            onValueChange = { nim = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("Nim") },
            placeholder = {
                Text("Masukkan Nim Anda", color = Color.Gray)
            }
        )


        // Row untuk pilihan jenis kelamin menggunakan RadioButton
        Row {
            pilihanJk.forEach { selectedJK ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = jenisK == selectedJK,
                        onClick = {
                            jenisK = selectedJK // Set pilihan jenis kelamin
                        }
                    )
                    Text(selectedJK)
                }
            }
        }

        // TextField untuk input Email
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("Email") },
            placeholder = {
                Text("Masukkan Email Anda", color = Color.Gray)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email) // Opsi keyboard email
        )

        // TextField untuk input Nomor HP
        TextField(
            value = nomorHp,
            onValueChange = { nomorHp = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("Nomor Hp") },
            placeholder = {
                Text("Masukkan Nomor Hp Anda", color = Color.Gray)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number) // Opsi keyboard angka
        )

        // TextField untuk input Alamat
        TextField(
            value = alamat,
            onValueChange = { alamat = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("Alamat") },
            placeholder = {
                Text("Masukkan Alamat Anda", color = Color.Gray)
            }
        )

        // Pengguna membuka aplikasi dan melihat FormulirView untuk mengisi biodata (nama, email, nomor HP, alamat, dan jenis kelamin).
        //Saat data diisi, state dari setiap input disimpan di variabel yang diingat (remember).
        //Ketika pengguna menekan tombol submit, FormulirView mengirim data yang diisi (dalam bentuk listData)
        // ke MahasiswaViewModel melalui fungsi saveDataMahasiswa
        Button(
            onClick = {
                onClickButton(listData)
            },
            modifier = Modifier.padding(vertical = 10.dp)
        ) {
            Text("Submit")
        }



    }
}

