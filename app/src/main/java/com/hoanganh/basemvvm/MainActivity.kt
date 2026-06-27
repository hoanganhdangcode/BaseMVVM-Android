package com.hoanganh.basemvvm

import android.content.Context
import com.google.gson.Gson
import com.hoanganh.basemvvm.core.base.BaseActivity
import com.hoanganh.basemvvm.databinding.MainActivityBinding

class MainActivity : BaseActivity<MainActivityBinding>(
    MainActivityBinding::inflate
) {
    override fun initView() {
        super.initView()
        val json = AssetUtil.readJson(this, "www/adapter.json")
        val config = Gson().fromJson(json, AdapterConfig::class.java)
        binding?.tvTextDemo?.text = config.baseUrl
    }
}
data class AdapterConfig(
    val baseUrl: String,
    val enableLog: Boolean,
    val timeout: Long
)
object AssetUtil {

    fun readJson(context: Context, fileName: String): String {
        return context.assets.open(fileName)
            .bufferedReader()
            .use { it.readText() }
    }
}