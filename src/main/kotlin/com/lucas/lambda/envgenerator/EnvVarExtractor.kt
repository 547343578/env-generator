package com.lucas.lambda.envgenerator

import com.intellij.lang.properties.PropertiesFileType
import com.intellij.openapi.fileTypes.FileTypeManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import org.jetbrains.yaml.YAMLFileType
import java.util.regex.Pattern

class EnvVarExtractor {
    private val variablePattern = Pattern.compile("\\$\\{([A-Z_][A-Z0-9_]*)}")

    fun extractEnvVars(project: Project): Set<String> {
        val envVars = mutableSetOf<String>()

        extractFromConfigFiles(project, envVars)

        return envVars
    }

    private fun extractFromConfigFiles(project: Project, envVars: MutableSet<String>) {
        val fileExtensions = setOf("properties", "yaml", "yml")
        val fileTypeManager = FileTypeManager.getInstance()

        fileExtensions.forEach { extension ->
            val fileType = fileTypeManager.getFileTypeByExtension(extension)
            FileTypeIndex.processFiles(fileType, { virtualFile: VirtualFile ->
                if (virtualFile.name.startsWith("application") && virtualFile.extension in fileExtensions) {
                    val psiFile: PsiFile? = PsiManager.getInstance(project).findFile(virtualFile)
                    if (psiFile != null) {
                        extractVariablesFromFile(psiFile, envVars)
                    }
                }
                true
            }, GlobalSearchScope.projectScope(project))
        }
    }

    private fun extractVariablesFromFile(file: PsiFile, envVars: MutableSet<String>) {
        val content = file.text
        val matcher = variablePattern.matcher(content)
        while (matcher.find()) {
            envVars.add(matcher.group(1))
        }
    }
}
