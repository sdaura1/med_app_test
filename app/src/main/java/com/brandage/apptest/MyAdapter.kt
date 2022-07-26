package com.brandage.apptest

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brandage.apptest.databinding.AdapterItemBinding
import com.brandage.apptest.models.AssociatedDrugsModel

class MyAdapter(var context: Context) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var branches: List<AssociatedDrugsModel>?

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            AdapterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(branches!![position])
    }

    override fun getItemCount(): Int {
        return branches!!.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(branches: List<AssociatedDrugsModel>?) {
        if (this.branches != null) {
            this.branches = branches
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(private val v: AdapterItemBinding) : RecyclerView.ViewHolder(v.root) {

        @SuppressLint("SetTextI18n")
        fun bind(associatedDrugsModel: AssociatedDrugsModel?) {
            if (associatedDrugsModel != null) {
                v.modelName.text = associatedDrugsModel.name
                v.modelDose.text = associatedDrugsModel.dose
                v.modelStrength.text = associatedDrugsModel.strength
                v.root.setOnClickListener {
                    context.startActivity(
                        Intent(context, DetailedActivity::class.java)
                            .putExtra("NAME", associatedDrugsModel.name)
                            .putExtra("DOSE", associatedDrugsModel.dose)
                            .putExtra("STRENGTH", associatedDrugsModel.strength)
                    )
                }
            }
        }
    }

    init {
        branches = ArrayList()
    }
}