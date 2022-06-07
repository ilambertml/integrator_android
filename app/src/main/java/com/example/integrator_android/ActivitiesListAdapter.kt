package com.example.integrator_android

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ActivitiesListAdapter(context: Context, private val itemList: MutableList<String>): BaseAdapter(){

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount() = itemList.size

    override fun getItem(position: Int) = itemList[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        val holder: ViewHolder

        if (convertView == null){
            view = inflater.inflate(R.layout.item_list_activities, parent, false)
            holder = ViewHolder()
            holder.nameTextView = view.findViewById(R.id.activityTitleTV) as TextView

            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val nameTextView = holder.nameTextView

        nameTextView.text = getItem(position)

        return view
    }

}

private class ViewHolder{

    lateinit var nameTextView: TextView

}