package com.coderiver.home

import androidx.lifecycle.ViewModelProviders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.coderiver.R

class PeopleSquareFragment : Fragment() {

    companion object {
        fun newInstance() = PeopleSquareFragment()
    }

    private lateinit var viewModel: PeopleSquareViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.people_square_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PeopleSquareViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
