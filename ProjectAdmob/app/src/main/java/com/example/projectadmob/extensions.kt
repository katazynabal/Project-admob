package com.example.projectadmob

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.appcompat.app.AlertDialog
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

fun Fragment.showTrickRewardAlertDialog(context: Context?, confirmCallback: () -> Unit) {
    context?.let {
        AlertDialog.Builder(it)
            .setMessage("Used all free tricks for today, subscribe for unliminted tricks or watch ad to unlock 5 trick slots")
            .setPositiveButton("watch Ad") { _, _ ->
                confirmCallback()
            }
            .setNegativeButton("Subscribe") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}