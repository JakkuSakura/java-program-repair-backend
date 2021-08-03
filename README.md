# java-program-repair-backend
An abstraction layer and backend of automated program repair in java, offering gRPC protocol

## Usage
```shell
git submodule update --init
cd astor
mvn package -DskipTests --settings mvn-settings.xml
cp target/astor-1.1.5-jar-with-dependencies.jar ../build/astor.jar
```