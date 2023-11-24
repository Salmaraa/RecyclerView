package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieAdapter = MovieAdapter(generateDummy()) { _->
            val intent = Intent(this@MainActivity, detail_film::class.java)
            startActivity(intent)
        }

        with(binding){
            recyclerView.apply {
                adapter = movieAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }

    }

    private fun generateDummy(): List<Film> {

        return listOf(
            Film("Petualangan Sherina 2", "Film ini menceritakan petualangan lanjutan persahabatan antara Sherina dan Yayang versi dewasa.", R.drawable.sherina),
            Film("Tegar", "Film ini mengisahkan kehidupan Tegar, seorang anak berusia 10 tahun dengan kondisi disabilitas.", R.drawable.tegar),
            Film("Hello Ghost", "Film ini menceritakan kehidupan Kresna (Onadio Leonardo) yang, setelah gagal bunuh diri, dapat melihat hantu dan memiliki empat teman hantu.", R.drawable.helloghost),
            Film("Air Mata Suhita", "Hati Suhita, drama romansa Indonesia di pesantren, menyoroti konflik pernikahan yang emosional dan memilukan.", R.drawable.suhita),

            )
    }
}

