package com.lucas.lambda.envgenerator

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages

class EnvExtractorAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project: Project? = e.project
        if (project != null) {
            val extractor = EnvVarExtractor()
            val envVars: Set<String> = extractor.extractEnvVars(project)
            val generator = EnvFileGenerator()
            val filePath = "${project.basePath}/.env"
            generator.generateEnvFile(envVars, filePath)
            Messages.showInfoMessage("Archivo .env generado", "Éxito")
        }
    }
}
