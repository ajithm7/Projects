package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.myapplication.databinding.FragmentTitleBinding

class Title : Fragment() {
    lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        Log.i("Ajith","On CreatView in title ")
        val binding: FragmentTitleBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(GameViewModel::class.java)
        binding.startButton.setOnClickListener { view: View ->
            var name1: String = binding.player1Name.text.toString()
            name1 = (if (name1.isEmpty()) "Player 1" else name1).toString()
            var name2 = binding.player2Name.text.toString()
            name2 = (if (name2.isEmpty()) "Player 2" else name2).toString()
            viewModel.assignName(name1, name2)
            view.findNavController().navigate(R.id.action_title2_to_gameFragment)
        }
        return binding.root
    }

}