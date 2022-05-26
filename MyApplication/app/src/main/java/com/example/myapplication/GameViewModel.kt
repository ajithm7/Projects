package com.example.myapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random


class GameViewModel: ViewModel() {
    var scoreOne= MutableLiveData<Int>()
    var scoreTwo=MutableLiveData<Int>()
    var playerOneName=MutableLiveData<String>()
    var playerTwoName=MutableLiveData<String>()
    var winner=MutableLiveData<String>()
    var imageOne=0
    var imageTwo=0
    init{
        scoreOne.value=0
        scoreTwo.value=0
    }
    fun playing(){
         imageOne= randomNum()
        imageTwo=randomNum()
        if(imageOne>imageTwo){
            scoreOne.value=scoreOne.value?.plus(1)
        }else if(imageTwo>imageOne){
            scoreTwo.value=scoreTwo.value?.plus(1)
        }
    }
    fun randomNum():Int=Random.nextInt(1,4)
    fun assignName(name1:String,name2:String){
        playerOneName.value=name1
        playerTwoName.value=name2
    }
    fun setWinner(name:String){
        winner.value=name
        Log.i("Ajith","winner in viewModel ${winner.value}")
    }



}