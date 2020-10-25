package com.example.pokedex.ViewModel

import android.animation.ObjectAnimator
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.picasso.Picasso
import kotlin.random.Random

class DetailViewModel: ViewModel() {

    companion object{
        const val maxHealth = 500
        const val maxAttack = 300
        const val maxDefence = 400
        const val maxSpeed = 200
        const val maxExperience = 700
    }

    private val _inf = MutableLiveData<Pair<String, String>>()
    val inf: LiveData<Pair<String, String>> = _inf

    fun sendData(text: Pair<String, String>){
        _inf.value = text
    }

    private val healthPoints: Int = Random.nextInt(1, maxHealth)
    private val attackPoints: Int = Random.nextInt(1, maxAttack)
    private val defencePoints: Int = Random.nextInt(1, maxDefence)
    private val speedPoints: Int = Random.nextInt(1, maxSpeed)
    private val experiencePoints: Int = Random.nextInt(1, maxExperience)


    fun animate(bar: ProgressBar, tillValue: Int, duration: Long){
        val anim: ObjectAnimator = ObjectAnimator.ofInt(bar, "progress", 0, tillValue)
        anim.duration = duration
        anim.start()
    }

    fun bindInfo(img: ImageView, url: String){
        Picasso.get().load(url).into(img)
    }

    fun setHp(): Pair<Int, Int>{
        return Pair(healthPoints, maxHealth)
    }

    fun setAttack(): Pair<Int, Int>{
        return Pair(attackPoints, maxAttack)
    }

    fun setDefence(): Pair<Int, Int>{
        return Pair(defencePoints, maxDefence)
    }

    fun setSpeed(): Pair<Int, Int>{
        return Pair(speedPoints, maxSpeed)
    }

    fun setExperience(): Pair<Int, Int>{
        return Pair(experiencePoints, maxExperience)
    }
}