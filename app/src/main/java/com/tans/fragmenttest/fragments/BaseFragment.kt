package com.tans.fragmenttest.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment(private val fragmentName: String) : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        println("$fragmentName: onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("$fragmentName: onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("$fragmentName: onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("$fragmentName: onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        println("$fragmentName: onStart")
    }

    override fun onResume() {
        super.onResume()
        println("$fragmentName: onResume")
    }

    override fun onPause() {
        super.onPause()
        println("$fragmentName: onPause")
    }

    override fun onStop() {
        super.onStop()
        println("$fragmentName: onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        println("$fragmentName: onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("$fragmentName: onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        println("$fragmentName: onDetach")
    }

    open fun refreshData() {
        println("$fragmentName: refreshData")
    }

}