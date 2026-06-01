package io.codex.vsx.events

import io.codex.vsx.app.Folder
import io.codex.vsx.file.File

data class OnDeleteFileEvent(val file: File, val openedFolder: File)

data class OnCreateFileEvent(val file: File, val openedFolder: File)

data class OnCreateFolderEvent(val file: File, val openedFolder: File)

data class OnRefreshFolderEvent(val openedFolder: File)

data class OnRenameFileEvent(val oldFile: File, val newFile: File, val openedFolder: File)

data class OnOpenFolderEvent(val folder: Folder)
