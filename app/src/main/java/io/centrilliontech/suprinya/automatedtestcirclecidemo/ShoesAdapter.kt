package io.centrilliontech.suprinya.automatedtestcirclecidemo

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import io.centrilliontech.suprinya.R
import io.centrilliontech.suprinya.automatedtestcirclecidemo.glide.GlideApp

class ShoesAdapter(private val context: Context) : RecyclerView.Adapter<ShoesAdapter.ViewHolder>() {
    private var mItems: ShoesShelfContainer = ShoesShelfContainer()

    fun setItems(items: ShoesShelfContainer) {
        mItems = items
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtName.text = mItems.data[position].name

        if(mItems.data[position].amount > 0){
            holder.btnAdd.alpha = 1f
            holder.btnAdd.isClickable = true

            holder.txtAmount.text = mItems.data[position].amount.toString()
        }else{
            holder.btnAdd.alpha = .5f
            holder.btnAdd.isClickable = false

            holder.txtAmount.text = context.getString(R.string.out_of_stock)
            holder.txtAmount.setTextColor(Color.RED)
        }

        GlideApp.with(context)
                .load(mItems.data[position].image)
                .into(holder.imgView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.entry_shoes, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mItems.data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName:TextView = itemView.findViewById(R.id.txtName)
        val txtAmount:TextView = itemView.findViewById(R.id.txtAmount)
        val btnAdd:Button = itemView.findViewById(R.id.btnAdd)
        val imgView:ImageView = itemView.findViewById(R.id.imgShoes)

    }

}