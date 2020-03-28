package com.example.projectadmob.ui.tricks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.projectadmob.databinding.CellTrickListItemBinding
import com.example.projectadmob.databinding.CellTrickRateBinding
import com.example.projectadmob.databinding.CellTrickStepBinding

class TrickListAdapter(
    private val callback: TrickPagerCallback
) : RecyclerView.Adapter<TrickListAdapter.SliderViewHolder>() {

    interface TrickPagerCallback {
        fun onItemClicked()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TrickViewHolder(CellTrickListItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.binding.executePendingBindings()
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == itemCount -1) 1 else 0
    }

    override fun getItemCount(): Int = 50

    open class SliderViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    inner class TrickViewHolder( bind: CellTrickListItemBinding) : SliderViewHolder(bind) {
        init {
            bind.root.setOnClickListener { callback.onItemClicked() }
        }
    }
}
