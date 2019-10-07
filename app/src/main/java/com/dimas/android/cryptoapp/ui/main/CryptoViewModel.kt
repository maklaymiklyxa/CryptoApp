package com.dimas.android.cryptoapp.ui.main

import com.dimas.android.cryptoapp.base.BaseViewModel
import com.dimas.android.cryptoapp.data.db.dao.CryptoDAO
import com.dimas.android.cryptoapp.data.rest.api.CryptoAPI
import com.dimas.android.cryptoapp.data.entity.CryptoData
import com.dimas.android.cryptoapp.extension.with
import com.dimas.android.cryptoapp.util.NotNullMutableLiveData
import com.dimas.android.cryptoapp.util.ioThread

class CryptoViewModel(private val cryptoApi: CryptoAPI, private val dao: CryptoDAO) :
    BaseViewModel() {
    private var count: Int = 2
    private val mRefreshing: NotNullMutableLiveData<Boolean> = NotNullMutableLiveData(false)
    val refreshing: NotNullMutableLiveData<Boolean>
        get() = mRefreshing

    private val mItems: NotNullMutableLiveData<List<CryptoData>> =
        NotNullMutableLiveData(arrayListOf())
    val items: NotNullMutableLiveData<List<CryptoData>>
        get() = mItems

    fun getCrypto() {
        val params = mutableMapOf<String, String>().apply {
            this["start"] = count.toString()
            this["limit"] = (count + 5).toString()
        }
        count += 5

        addToDisposable(cryptoApi.getCryptoInfo(params).with()
            .doOnSubscribe { mRefreshing.value = true }
            .doOnSuccess { mRefreshing.value = false }
            .doOnError { mRefreshing.value = false }
            .subscribe({
                mItems.value = it.data
                saveToCryptoData(it.data)
            }, {
                // handle errors
            })
        )

        if (mItems.value.isEmpty()) {
            addToDisposable(dao.getAllCryptoData().with()
                .doOnSubscribe { mRefreshing.value = true }
                .doOnSuccess { mRefreshing.value = false }
                .doOnError { mRefreshing.value = false }
                .subscribe({
                    mItems.value = it
                }, {
                    // handle errors
                })
            )
        }
    }

    private fun saveToCryptoData(repository: List<CryptoData>) =
        ioThread {
            dao.insertAllList(repository)
        }
}