package com.lucas.lambda.envgenerator

import java.io.FileWriter
import java.io.IOException

class EnvFileGenerator {
    fun generateEnvFile(envVars: Set<String>, filePath: String) {
        try {
            FileWriter(filePath).use { writer ->
                for (envVar in envVars) {
                    writer.write("$envVar=\n")
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
