package com.amandaluz.navigation

import android.content.Context
import com.amandaluz.navigation.utils.IntentUtils

object AbasNavigation {

    fun openMangaFragment(context: Context) {
        IntentUtils.openFeatureIntent(
            context,
            "${PackageDefault.PACKAGE_FRAGMENT_DEFAULT}.MangaFragment"
        )
    }

}