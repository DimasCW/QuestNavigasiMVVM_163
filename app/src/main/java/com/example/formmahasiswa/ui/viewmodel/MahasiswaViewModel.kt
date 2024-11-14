package com.example.formmahasiswa.ui.viewmodel
//4
import androidx.lifecycle.ViewModel
import com.example.formmahasiswa.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel: ViewModel (){
    private val _uiState = MutableStateFlow(Mahasiswa())

    val uiState: StateFlow<Mahasiswa> = _uiState.asStateFlow()

    fun saveDataMahasiswa(
        ls : MutableList<String>
    ){
        //saveDataMahasiswa di ViewModel memperbarui _uiState dengan data baru menggunakan update dan copy
           _uiState.update { data ->
               data.copy(
                   nama = ls[0],
                   gender = ls[4],
                   alamat = ls[5]
               )
           }
    }
}