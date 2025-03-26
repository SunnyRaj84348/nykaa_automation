FROM maven:3.8.6-jdk-11

RUN apt update && apt install -y firefox-esr \
    && apt clean && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY . .

CMD ["mvn", "clean", "test"]
