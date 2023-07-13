package com.example.myapplication.utils.navigation_utils

import com.example.myapplication.R

sealed class MainNavigationManager : NavigationManager() {

    object HomeFragment : MainNavigationManager() {
        override val needPopUp = true
        override val destinationId = R.id.blankFragment
    }

    object PageFragment : MainNavigationManager() {
        override val needPopUp = true
        override val destinationId = R.id.pageFragment
    }

}