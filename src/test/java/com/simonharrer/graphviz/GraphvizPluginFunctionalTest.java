package com.simonharrer.graphviz;

import java.io.IOException;
import java.nio.file.Paths;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.Test;

public class GraphvizPluginFunctionalTest {

  private static final String GRAPHVIZ = "graphviz";

  @Test
  public void testNoIssues() throws IOException {
    GradleRunner.create()
        .withProjectDir(Paths.get("examples/noIssues").toFile())
        .withPluginClasspath()
        .withArguments(GRAPHVIZ)
        .build();
  }
}
