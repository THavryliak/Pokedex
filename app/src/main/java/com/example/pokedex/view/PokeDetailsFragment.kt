package com.example.pokedex.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.pokedex.R
import com.example.pokedex.viewModel.DetailViewModel
import org.koin.android.ext.android.inject


class PokeDetailsFragment() : Fragment(R.layout.fragment_poke_details) {
    private val model: DetailViewModel by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val animDuration: Long = 1000

        val img: ImageView = view.findViewById(R.id.pokeImageDetail)
        val txt: TextView = view.findViewById(R.id.pokeNameDetail)

        model.inf.observe(viewLifecycleOwner, { pair ->
            txt.text = pair.first
            model.bindInfo(img, pair.second)
        })


        //add data binding
        val hp: TextView = view.findViewById(R.id.health)
        val attack: TextView = view.findViewById(R.id.attack)
        val defence: TextView = view.findViewById(R.id.defence)
        val speed: TextView = view.findViewById(R.id.speed)
        val exp: TextView = view.findViewById(R.id.exp)

        val hpBar: ProgressBar = view.findViewById(R.id.health_bar)
        val atckBar: ProgressBar = view.findViewById(R.id.attack_bar)
        val defBar: ProgressBar = view.findViewById(R.id.defence_bar)
        val spdBar: ProgressBar = view.findViewById(R.id.speed_bar)
        val expBar: ProgressBar = view.findViewById(R.id.exp_bar)

        model.animate(hpBar, model.setHp().first, animDuration)
        model.animate(atckBar, model.setAttack().first, animDuration)
        model.animate(defBar, model.setDefence().first, animDuration)
        model.animate(spdBar, model.setSpeed().first, animDuration)
        model.animate(expBar, model.setExperience().first, animDuration)

        hp.text = getString(R.string.hp_text, model.setHp().first, model.setHp().second)
        attack.text =
            getString(R.string.attack_text, model.setAttack().first, model.setAttack().second)
        defence.text =
            getString(R.string.defence_text, model.setDefence().first, model.setDefence().second)
        speed.text = getString(R.string.speed_text, model.setSpeed().first, model.setSpeed().second)
        exp.text = getString(
            R.string.experience_text,
            model.setExperience().first,
            model.setExperience().second
        )
    }
}