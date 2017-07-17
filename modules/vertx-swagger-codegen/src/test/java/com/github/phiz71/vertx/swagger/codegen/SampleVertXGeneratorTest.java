package com.github.phiz71.vertx.swagger.codegen;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import io.swagger.codegen.SwaggerCodegen;

public class SampleVertXGeneratorTest {

    @Test
    public void generateSampleServer() {
        String[] args = new String[11];
        args[0] = "generate";
        args[1] = "-l";
        args[2] = "java-vertx";
        args[3] = "-i";
        args[4] = "petStore.json";
        args[5] = "-o";
        args[6] = "../../sample/petstore-vertx-server";
        args[7] = "--group-id";
        args[8] = "io.swagger";
        args[9] = "--artifact-id";
        args[10] = "petstore-vertx-server";
        SwaggerCodegen.main(args);
    }

    @Test
    public void generateSampleServerWithRX() {
        String[] args = new String[12];
        args[0] = "generate";
        args[1] = "-l";
        args[2] = "java-vertx";
        args[3] = "-i";
        args[4] = "petStore.json";
        args[5] = "-o";
        args[6] = "../../sample/petstore-vertx-rx-server";
        args[7] = "--group-id";
        args[8] = "io.swagger";
        args[9] = "--artifact-id";
        args[10] = "petstore-vertx-rx-server";
        args[11] = "-DrxInterface=true";
        SwaggerCodegen.main(args);
    }

    @Test
    public void testOptionalMainApiVerticleTrue() throws IOException {
        String[] args = new String[8];
        args[0] = "generate";
        args[1] = "-l";
        args[2] = "java-vertx";
        args[3] = "-i";
        args[4] = "testOptionalMainApiVerticle.json";
        args[5] = "-o";
        args[6] = "temp/test-server";
        args[7] = "-DmainVerticleGeneration=true";
        SwaggerCodegen.main(args);

        File mainApiFile = new File(
                "temp/test-server/src/main/java/io/swagger/server/api/MainApiVerticle.java");
        Assert.assertTrue(mainApiFile.exists());

        FileUtils.deleteDirectory(new File("temp"));
    }

    @Test
    public void testOptionalMainApiVerticleDefaultValue() throws IOException {
        String[] args = new String[7];
        args[0] = "generate";
        args[1] = "-l";
        args[2] = "java-vertx";
        args[3] = "-i";
        args[4] = "testOptionalMainApiVerticle.json";
        args[5] = "-o";
        args[6] = "temp/test-server";
        SwaggerCodegen.main(args);

        File mainApiFile = new File(
                "temp/test-server/src/main/java/io/swagger/server/api/MainApiVerticle.java");
        Assert.assertTrue(mainApiFile.exists());

        FileUtils.deleteDirectory(new File("temp"));
    }

    @Test
    public void testOptionalMainApiVerticleFalse() throws IOException {
        String[] args = new String[8];
        args[0] = "generate";
        args[1] = "-l";
        args[2] = "java-vertx";
        args[3] = "-i";
        args[4] = "testOptionalMainApiVerticle.json";
        args[5] = "-o";
        args[6] = "temp/test-server";
        args[7] = "-DmainVerticleGeneration=false";
        SwaggerCodegen.main(args);

        File mainApiFile = new File(
                "temp/test-server/src/main/java/io/swagger/server/api/MainApiVerticle.java");
        Assert.assertTrue(!mainApiFile.exists());

        FileUtils.deleteDirectory(new File("temp"));
    }

}
