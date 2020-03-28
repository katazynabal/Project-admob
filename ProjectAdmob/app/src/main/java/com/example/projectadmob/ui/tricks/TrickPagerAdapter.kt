package com.example.projectadmob.ui.tricks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.projectadmob.databinding.CellTrickRateBinding
import com.example.projectadmob.databinding.CellTrickStepBinding

class TrickPagerAdapter(
    private val callback: TrickPagerCallback
) : RecyclerView.Adapter<TrickPagerAdapter.SliderViewHolder>() {

    interface TrickPagerCallback {
        fun onItemClicked()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if(viewType == 0) {
            StepViewHolder(CellTrickStepBinding.inflate(inflater, parent, false))
        } else {
            RateViewHolder(CellTrickRateBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.binding.executePendingBindings()
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == itemCount -1) 1 else 0
    }

    override fun getItemCount(): Int = 5

    open class SliderViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    inner class StepViewHolder( bind: CellTrickStepBinding) : SliderViewHolder(bind)
    inner class RateViewHolder( bind: CellTrickRateBinding) : SliderViewHolder(bind) {
        init {
            bind.button.setOnClickListener { callback.onItemClicked() }
        }
    }
}
