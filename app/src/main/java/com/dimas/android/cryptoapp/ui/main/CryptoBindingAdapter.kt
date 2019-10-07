package com.dimas.android.cryptoapp.ui.main

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dimas.android.cryptoapp.data.entity.CryptoData

@BindingAdapter(value = ["repositories", "viewModel"])
fun setRepositories(view: RecyclerView, items: List<CryptoData>, vm: CryptoViewModel) {
    view.adapter?.run {
        if (this is RepositoryAdapter) {
            this.items = items
            this.notifyDataSetChanged()
        }
    } ?: run {
        RepositoryAdapter(items, vm).apply { view.adapter = this }
    }
}