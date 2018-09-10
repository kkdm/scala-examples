FROM hseeberger/scala-sbt:8u181_2.12.6_1.2.1

RUN mkdir app
COPY . /app
WORKDIR /app

CMD ["sbt", "run"]
