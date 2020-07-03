FROM clojure:openjdk-11-lein-slim-buster

WORKDIR /app

CMD ["lein", "run"]