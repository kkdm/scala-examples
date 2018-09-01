## How to build

### Using Docker and build an image on your own.

1. `git clone git@github.com:kkdm/scala-examples.git`
2. `sbt build -t test:test .`
3. `sbt run --rm -t test:test`

### Using Docker and get from Docker Hub

1. `docker run keykdm/scala-regex-example:1.0` or `docker run keykdm/scala-regex-example`

