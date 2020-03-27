package com.example.projectadmob

import android.app.Activity
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

fun Fragment.popDestinationBackStack() {
    findNavController().popBackStack()
}

fun Fragment.popDestinationBackStackTo(id: Int, inclusive: Boolean) {
    findNavController().popBackStack(id, inclusive)
}

fun Fragment.goToDestination(directions: NavDirections) {
    findNavController().safeNavigate(directions)
}

fun Activity.goToDestination(navHostId: Int, directions: NavDirections) {
    Navigation.findNavController(findViewById(navHostId))
        .safeNavigate(directions)
}

fun Activity.popDestinationBackStackTo(navHostId: Int, id: Int, inclusive: Boolean) {
    Navigation.findNavController(findViewById(navHostId))
        .popBackStack(id, inclusive)
}

fun NavController.safeNavigate(directions: NavDirections) {
    if (currentDestination?.getAction(directions.actionId) == null) {
        Log.e("NoDoGo","Unknown Destination")
        return
    } else {
        navigate(directions)
    }
}