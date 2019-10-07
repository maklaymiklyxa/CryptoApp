package com.dimas.android.cryptoapp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dimas.android.cryptoapp.R
import com.dimas.android.cryptoapp.data.entity.CryptoData
import com.dimas.android.cryptoapp.databinding.ItemRepositoryBinding
import com.dimas.android.cryptoapp.ui.BindingViewHolder

class RepositoryAdapter (var items: List<CryptoData> = arrayListOf(), val vm: CryptoViewModel) :
    RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_repository,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.binding.item = items[position]
        holder.binding.vm = vm
    }

    override fun getItemCount() = items.size
    class RepositoryViewHolder(view: View) : BindingViewHolder<ItemRepositoryBinding>(view)
}
