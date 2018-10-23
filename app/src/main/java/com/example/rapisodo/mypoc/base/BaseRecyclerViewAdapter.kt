package com.example.rapisodo.mypoc.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.rapisodo.mypoc.BR

abstract class BaseRecyclerViewAdapter<T, VDB : ViewDataBinding> : RecyclerView.Adapter<BaseViewHolder<T, VDB>>() {

    var items = listOf<T>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T, VDB> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = DataBindingUtil.inflate<VDB>(layoutInflater, getLayoutId(viewType), parent, false)
        return BaseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T, VDB>, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    abstract fun getLayoutId(viewType: Int): Int

}

class BaseViewHolder<T, VDB : ViewDataBinding> constructor(val binding: VDB) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: T) {
//        binding.setVariable(BR.item, item)
        binding.setVariable(BR._all, item)
        binding.executePendingBindings()
    }

}