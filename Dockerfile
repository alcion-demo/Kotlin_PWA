FROM eclipse-temurin:17-jdk

WORKDIR /app

RUN apt-get update && apt-get install -y \
    unzip zip git curl bash vim wget \
    && rm -rf /var/lib/apt/lists/*

ENV GRADLE_VERSION=8.5
RUN wget https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip -P /tmp && \
    unzip -d /opt/gradle /tmp/gradle-${GRADLE_VERSION}-bin.zip && \
    rm /tmp/gradle-${GRADLE_VERSION}-bin.zip

ENV PATH="/opt/gradle/gradle-${GRADLE_VERSION}/bin:${PATH}" \
    LANG=C.UTF-8

COPY gradlew .
RUN chmod +x gradlew

COPY . .

EXPOSE 8080

