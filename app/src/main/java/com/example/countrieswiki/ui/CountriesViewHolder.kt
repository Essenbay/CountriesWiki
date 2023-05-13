package com.example.countrieswiki.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countrieswiki.data.Country
import com.example.countrieswiki.databinding.CountryItemBinding

class CountriesViewAdapter(private var countryList: List<Country>) :
    RecyclerView.Adapter<CountriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CountryItemBinding.inflate(inflater, parent, false)
        return CountriesViewHolder(binding)
    }

    override fun getItemCount(): Int = countryList.size

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.bind(countryList[position])
    }

    fun updateData(newList: List<Country>) {
        countryList = newList
        notifyDataSetChanged()
    }
}

class CountriesViewHolder(private val binding: CountryItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(country: Country) {
        binding.countryName.text = country.name.official
    }
}