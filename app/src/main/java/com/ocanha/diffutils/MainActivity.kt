package com.ocanha.diffutils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ocanha.diffutils.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var adapter : ClientAdapter

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val clients = getData()
        initRecyclerView(clients)

        binding.floatingActionButton.setOnClickListener {

            val newClients = listOf(
                Client(
                    id = 10,
                    name = "Nome",
                    lastName = "Sobrenome Novo",
                    city = "Cidade Novo"
                )
            )
            adapter.setData(newClients)

        }

    }

    private fun initRecyclerView(clients: MutableList<Client>) {

        adapter = ClientAdapter(clients)
        binding.rvClients.adapter = adapter

    }

    private fun getData(): MutableList<Client> {

        val result = mutableListOf<Client>()
        repeat(5) {
            result.add(
                Client(
                    id = it,
                    name = "Nome $it",
                    lastName = "Sobrenome $it",
                    city = "Cidade $it"
                )
            )
        }
        return result
    }

}