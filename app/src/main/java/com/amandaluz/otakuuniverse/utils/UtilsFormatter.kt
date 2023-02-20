package com.amandaluz.otakuuniverse.utils

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.amandaluz.otakuuniverse.R
import com.amandaluz.otakuuniverse.model.OptionsAbas
import com.google.gson.Gson

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

private fun setJsonStringFormater(json: Int, context: Context): String =
    context.resources.openRawResource(json).bufferedReader().use { it.readText() }

private fun gsonFormatter(jsonString: String): OptionsAbas {
    val gson = Gson()
    return gson.fromJson(jsonString, OptionsAbas::class.java)
}

fun getGsonFormatter(json: Int, context: Context): OptionsAbas =
    gsonFormatter(setJsonStringFormater(json, context))

fun listOptionsAbas(optionsAbas: OptionsAbas) : List<String> = optionsAbas.optionsAbas
