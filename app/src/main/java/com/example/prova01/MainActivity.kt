package com.example.prova01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serviceRetrofit = RetroFitService()
        serviceRetrofit.api?.getProdutos()?.enqueue(object : Callback<List<Produtos>> {
            override fun onResponse(
                call: Call<List<Produtos>?>?,
                response: Response<List<Produtos>?>?
            ) {
                val listaProdutos = response?.body();

                produto01.setImageResource(R.drawable.donut_circle)
                produto02.setImageResource(R.drawable.icecream_circle)
                produto03.setImageResource(R.drawable.froyo_circle)

                descProd1.text = listaProdutos?.get(0)?.descricao
                descProd2.text = listaProdutos?.get(1)?.descricao
                descProd3.text = listaProdutos?.get(2)?.descricao

                valorProd1.text = listaProdutos?.get(0)?.valor.toString()
                valorProd2.text = listaProdutos?.get(1)?.valor.toString()
                valorProd03.text = listaProdutos?.get(2)?.valor.toString()

                Log.d("TEST", listaProdutos?.get(0)?.descricao.toString())
            }

            override fun onFailure(call: Call<List<Produtos>>, t: Throwable) {
                Log.e("Erro", "************** erro **********\n" + t?.message.toString())
            }
        })
    }
}