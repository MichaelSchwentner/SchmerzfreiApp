package com.example.schmerzfreiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.schmerzfreiapp.R
import com.example.schmerzfreiapp.data.model.Uebungen

class HometwoAdapter(
    private val dataset: List<Uebungen>
) : RecyclerView.Adapter<HometwoAdapter.ViewHolder>() {
    // IDEE EINES VIEWHOLDERS
    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val bild = view.findViewById<ImageView>(R.id.imageView5)
        val backgroundiv = view.findViewById<ImageView>(R.id.backgroundImage_iv)
        val card2 = view.findViewById<CardView>(R.id.mv_card)
    }
    // ERSTELLEN DES VIEWHOLDERS
    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_item, parent, false)
        return ViewHolder(adapterLayout)
    }
    // BEFÜLLEN DES VIEWHOLDERS
    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val uebungen = dataset[position]

        holder.bild.setImageResource(uebungen.imageResource)
        holder.backgroundiv.setImageResource(uebungen.imageResource)
        //holder.text.setText(uebungen.namevideofile)

    }
    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}