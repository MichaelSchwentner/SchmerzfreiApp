package com.example.schmerzfreiapp.adapter

import android.text.Layout.Directions
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.schmerzfreiapp.R
import com.example.schmerzfreiapp.data.model.Uebungen
import com.example.schmerzfreiapp.ui.uebungen.UebungenFragment
import com.example.schmerzfreiapp.ui.uebungen.UebungenFragmentDirections

class UebungAdapter(
    private val dataset: List<Uebungen>
) : RecyclerView.Adapter<UebungAdapter.ViewHolder>() {
    // IDEE EINES VIEWHOLDERS
    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val uebungsBild = view.findViewById<ImageView>(R.id.uebungsBild_image)
        val uebungsTitel = view.findViewById<TextView>(R.id.uebungsTitel_text)
        val card = view.findViewById<CardView>(R.id.uebungen_card)
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

        holder.uebungsBild.setImageResource(uebungen.imageResource)
        holder.uebungsTitel.setText(uebungen.namevideofile)

        holder.card.setOnClickListener {
            holder.uebungsTitel.text
            Navigation.findNavController(holder.itemView).navigate(UebungenFragmentDirections.actionNavUebungenToWarmupFragment(holder.uebungsTitel.text.toString()))

        }

    }
    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}