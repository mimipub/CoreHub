plugins {
    id("java")
}

<<<<<<< HEAD
group = "org.example"
=======
group = "br.com.agibank"
>>>>>>> 6062852f840de617f98f907112590252b1b6dbba
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
<<<<<<< HEAD



=======
>>>>>>> 6062852f840de617f98f907112590252b1b6dbba
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}