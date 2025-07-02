package io.apicurio.codegen.maven;

import io.apicurio.hub.api.codegen.JaxRsProjectSettings;

/**
 * Extends the jax-rs project settings in order to change default values.
 * @author ewittman
 */
public class ProjectSettings extends JaxRsProjectSettings {
	
	public ProjectSettings() {
	    mavenFileStructure = false;
	    includeSpec = false;
	    codeOnly = true;
	    reactive = false;
	    cliGenCI = false;
	    groupId = "org.example";
	    artifactId = "example-api";
	    javaPackage = "org.example.api";
		useJsr303 = false;
	}

}
