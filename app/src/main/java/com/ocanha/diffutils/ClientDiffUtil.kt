package com.ocanha.diffutils

import androidx.recyclerview.widget.DiffUtil

class ClientDiffUtil(
    private val oldList: List<Client>,
    private val newList: List<Client>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        when{
            oldList[oldItemPosition].name != newList[newItemPosition].name -> false
            oldList[oldItemPosition].lastName != newList[newItemPosition].lastName -> false
            oldList[oldItemPosition].city != newList[newItemPosition].city -> false
            else -> true
        }

}