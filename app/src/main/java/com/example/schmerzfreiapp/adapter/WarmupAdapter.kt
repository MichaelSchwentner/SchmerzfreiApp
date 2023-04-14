package com.example.schmerzfreiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.schmerzfreiapp.R
import com.example.schmerzfreiapp.data.model.Uebungen
import com.example.schmerzfreiapp.data.model.VideoData
import com.example.schmerzfreiapp.ui.uebungen.UebungenFragment
import com.example.schmerzfreiapp.ui.warmup.WarmupFragment
import com.example.schmerzfreiapp.ui.warmup.WarmupFragmentDirections

class WarmupAdapter(
    private val context: WarmupFragment,
    private val dataset: List<VideoData>
) : RecyclerView.Adapter<WarmupAdapter.ViewHolder>() {
    // IDEE EINES VIEWHOLDERS
    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val uebungsBild = view.findViewById<ImageView>(R.id.uebungsBild_image)
        val uebungsTitel = view.findViewById<TextView>(R.id.uebungsTitel_text)
    }
    // ERSTELLEN DES VIEWHOLDERS
    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.uebungsbilder_item, parent, false)
        return ViewHolder(adapterLayout)
    }


    // BEFÜLLEN DES VIEWHOLDERS
    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val uebungen = dataset[position]

        holder.uebungsBild.setImageResource(R.drawable.group_35561)
        holder.uebungsTitel.setText(uebungen.name)

        //TODO: onclick Video soll abgespielt werden
        holder.uebungsBild.setOnClickListener {
            Navigation.findNavController(holder.itemView)
                .navigate(WarmupFragmentDirections.actionWarmupFragmentToNavUebungDetail(uebungen.link))
        }

    }
    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}