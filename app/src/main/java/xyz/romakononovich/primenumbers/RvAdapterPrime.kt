package xyz.romakononovich.primenumbers

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item.view.*

/**
 * Created by RomanK on 15.07.18.
 */
class RvAdapterPrime(
        context: Context?) : RecyclerView.Adapter<RvAdapterPrime.ViewHolder>() {
    private val list: MutableList<Long> = ArrayList()
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setList(listTmp: List<Long>) {
        list.clear()
        list.addAll(listTmp)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ViewHolder(
            view: View) : RecyclerView.ViewHolder(view) {

        fun bind(history: Long) {
            itemView.textView.text = history.toString()
        }


    }

}