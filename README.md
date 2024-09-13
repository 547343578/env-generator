# EnvVar Extractor

**Description:**

The **EnvVar Extractor** plugin is a powerful tool designed for Java developers working in IntelliJ IDEA. It automates the process of extracting environment variables from configuration files and generates a `.env` file for easier configuration management.

## Key Features

- **Automatic Extraction:** Seamlessly extracts environment variables from various configuration files such as `application*.properties`, `application*.yaml`, and `application*.yml`.
- **Avoid Duplicates:** Ensures that each environment variable is listed only once, preventing redundant entries in the `.env` file.
- **Flexible File Support:** Works with multiple types of configuration files, accommodating different project setups.
- **Easy Integration:** Integrates directly into the IntelliJ IDEA tools menu for quick access and ease of use.

## How It Works

1. **Scan Configuration Files:** The plugin scans the project's configuration files with names starting with `application` and extensions like `.properties`, `.yaml`, and `.yml`.
2. **Extract Variables:** It identifies and extracts environment variables defined in these files using the `${VAR_NAME}` syntax.
3. **Generate .env File:** Compiles a list of unique environment variables and generates a `.env` file at the root of your project.

## Benefits

- **Streamlined Configuration:** Simplifies the process of managing environment variables, saving developers time and effort.
- **Enhanced Productivity:** Provides a convenient way to maintain consistent environment variable settings across different environments.

## Installation

1. **Download and Install:** Get the plugin from the JetBrains Plugin Marketplace and install it in your IntelliJ IDEA.
2. **Access the Tool:** Find the **EnvVar Extractor** action under the Tools menu.

## Feedback

We welcome your feedback and suggestions to improve the plugin. Please feel free to leave a review or contact us with any issues or feature requests.
