## How to build

### Using Docker and build an image on your own.

1. `git clone git@github.com:kkdm/scala-examples.git`
2. `cd scala-examples/regex-examples`
3. `docker build -t scala-regex-examples:1.0 .`
4. `docker run --rm -t scala-regex-examples:1.0`

### Using Docker and get from Docker Hub

1. `docker run keykdm/scala-regex-example:1.0` or `docker run keykdm/scala-regex-example`

