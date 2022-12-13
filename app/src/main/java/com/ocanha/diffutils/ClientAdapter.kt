package com.ocanha.diffutils

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ocanha.diffutils.databinding.ResItemClientBinding

class ClientAdapter(private var clients: List<Client>) :
    RecyclerView.Adapter<ClientAdapter.ClientViewHolder>() {

    inner class ClientViewHolder(itemView: ResItemClientBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        private val tvName: TextView

        init {
            tvName = itemView.tvName
        }

        fun bind(client: Client) {
            tvName.text = "${client.name} ${client.lastName}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder =
        ClientViewHolder(
            ResItemClientBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) =
        holder.bind(clients[position])

    override fun getItemCount(): Int = clients.size

    fun setData(newListClients: List<Client>) {

        val diffUtil = ClientDiffUtil(clients, newListClients)
        val diffResult = DiffUtil.calculateDiff(diffUtil)

        clients = newListClients

        diffResult.dispatchUpdatesTo(this)

    }

}