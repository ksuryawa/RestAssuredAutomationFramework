FROM ksuryawa/java16-3.8.2testdep
COPY src  home/apiframework/src
COPY output  home/apiframework/output
COPY index.html  home/apiframework/index.html
COPY pom.xml	home/apiframework/pom.xml
COPY testng.xml	home/apiframework/testng.xml
WORKDIR home/apiframework
ENTRYPOINT mvn clean test