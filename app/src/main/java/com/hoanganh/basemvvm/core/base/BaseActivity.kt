package com.hoanganh.basemvvm.core.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding


abstract class BaseActivity<VB : ViewBinding?>(
    private val bindingInflater: (LayoutInflater) -> VB
) : AppCompatActivity() {
    protected var binding: VB? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = bindingInflater.invoke(layoutInflater)
        setContentView(binding?.root)
        initView()
        initListener()
        initObserver()
        initData()
    }

    protected open fun initView() {}

    protected open fun initListener() {}

    protected open fun initObserver() {}

    protected open fun initData() {}
}