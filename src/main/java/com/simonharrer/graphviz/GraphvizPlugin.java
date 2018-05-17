package com.simonharrer.graphviz;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class GraphvizPlugin implements Plugin<Project> {

    public static final String GRAPHVIZ = "graphviz";
    public static final String DESCRIPTION = "Converts your src/main/graphviz/*.dot to build/graphviz/*.png";
    public static final String GROUP = "documentation";

    @Override
    public void apply(Project project) {
        final GraphvizTask task = project.getTasks().create(GRAPHVIZ, GraphvizTask.class);
        task.setGroup(GROUP);
        task.setDescription(DESCRIPTION);
    }
}
