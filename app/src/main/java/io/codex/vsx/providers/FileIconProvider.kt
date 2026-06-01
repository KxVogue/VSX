package io.codex.vsx.providers

import android.annotation.SuppressLint
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.codex.vsx.file.File
import io.codex.vsx.file.extension
import io.codex.vsx.models.FileIcon
import io.codex.vsx.resources.R
import io.codex.vsx.app.BaseApplication.Companion.instance as app

/**
 * Class to provide File icons
 *
 * @author Felipe Teixeira
 */
object FileIconProvider {

    private var fileIcons: List<FileIcon> = mutableListOf()

    init {
        val fileIconsJson =
            app.assets.open("files/file_icons.json").bufferedReader().use { it.readText() }
        fileIcons = Gson().fromJson(fileIconsJson, object : TypeToken<List<FileIcon>>() {})
    }

    @SuppressLint("DiscouragedApi")
    fun findFileIconResource(file: File): Int {
        val fileIcon = findFileIconByExtension(file.extension) ?: return R.drawable.ic_file
        val resId = app.resources.getIdentifier(fileIcon.drawableName, "drawable", app.packageName)
        return if (resId == 0) R.drawable.ic_file else resId
    }

    private fun findFileIconByExtension(extension: String): FileIcon? =
        fileIcons.find { it.fileExtensions.contains(extension) }
}
