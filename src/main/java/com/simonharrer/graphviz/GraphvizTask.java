package com.simonharrer.graphviz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

public class GraphvizTask extends DefaultTask {

    public static final String GRAPHVIZ = "graphviz";

    @TaskAction
    public void graphviz() throws Exception {
        Project project = getProject();
        Path buildPath = project.getBuildDir().toPath();
        Path targetPath = buildPath.resolve(GRAPHVIZ);

        Path projectPath = project.getProjectDir().toPath();
        Path sourcePath = projectPath.resolve("src").resolve("main").resolve(GRAPHVIZ);
        if(!Files.exists(sourcePath) || !Files.isDirectory(sourcePath)) {
            return;
        }

        try (Stream<Path> stream = Files.find(sourcePath,
                Integer.MAX_VALUE,
                (path, attributes) -> path.getFileName().toString().endsWith(".dot"))) {
            stream.forEach(path -> {
                String sourceFilename = path.getFileName().toString();
                String targetFilename = sourceFilename.substring(0, sourceFilename.length() - 4) + ".png";

                Path sourceDirectory = path.getParent();
                Path targetDirectory = targetPath.resolve(sourcePath.relativize(sourceDirectory));
                Path targetPngPath = targetDirectory.resolve(targetFilename);

                try {
                    String message = String.format("Converting %s to %s",
                            projectPath.relativize(path).toString(),
                            projectPath.relativize(targetPngPath).toString());
                    System.out.println(message);
                    Graphviz.fromFile(path.toFile()).render(Format.PNG).toFile(targetPngPath.toFile());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
