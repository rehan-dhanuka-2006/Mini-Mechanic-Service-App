package com.dawaiwaala.minimechanicserviceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MechanicAdapter(
    private val mechanics: MutableList<Mechanic>,
    private val onMechanicClick: (Mechanic) -> Unit
) : RecyclerView.Adapter<MechanicAdapter.MechanicViewHolder>() {

    class MechanicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.findViewById(R.id.mechanicName)
        val rating: TextView = itemView.findViewById(R.id.mechanicRating)
        val distance: TextView = itemView.findViewById(R.id.mechanicDistance)
        val location: TextView = itemView.findViewById(R.id.mechanicLocation)
        val services: TextView = itemView.findViewById(R.id.mechanicServices)
        val status: TextView = itemView.findViewById(R.id.mechanicStatus)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MechanicViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mechanic, parent, false)

        return MechanicViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MechanicViewHolder,
        position: Int
    ) {

        val mechanic = mechanics[position]

        holder.name.text = mechanic.name
        holder.rating.text = "⭐ ${mechanic.rating}"
        holder.distance.text = "📍 ${mechanic.distance}"
        holder.location.text = mechanic.location

        holder.services.text =
            "🔧 ${mechanic.services.joinToString(", ")}"

        holder.status.text =
            "Status: ${mechanic.status}"

        holder.itemView.setOnClickListener {
            onMechanicClick(mechanic)
        }
    }

    override fun getItemCount(): Int {
        return mechanics.size
    }

    fun updateData(newMechanics: List<Mechanic>) {
        mechanics.clear()
        mechanics.addAll(newMechanics)
        notifyDataSetChanged()
    }
}